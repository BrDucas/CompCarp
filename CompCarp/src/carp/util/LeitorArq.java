package carp.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class LeitorArq {
	private String total = "";
	private List<String> lista = new LinkedList<>();
	private String nomeArq = "";
	private String caminho = "";

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public List<String> getLista() {
		return lista;
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void abrirArq(String delimiter) {
		FileReader f = null;
		Scanner scanner = null;

		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
			nomeArq = fc.getSelectedFile().getAbsolutePath();
			caminho = fc.getSelectedFile().getParent();
		}

		try {
			f = new FileReader(nomeArq);
			scanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		scanner.useDelimiter(delimiter);
		while (scanner.hasNext()) {
			String str = scanner.next();
			str = str.toUpperCase();
			// lista.add(str);
			total += str + " ";
		}
		corrigir(total);
		//System.out.println(total);
	}

	public void corrigir(String texto) {
		String textoCorrigido = new String();

		StringTokenizer token = new StringTokenizer(texto, " ");
		while (token.hasMoreTokens()) {
			textoCorrigido+=(token.nextToken() + " ");
		}
		String []aux = textoCorrigido.split(" ");
		lista = new LinkedList<>(Arrays.asList(aux));
	}

	public void abrirArq() {
		FileReader f = null;
		Scanner scanner = null;

		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
			nomeArq = fc.getSelectedFile().getAbsolutePath();
			caminho = fc.getSelectedFile().getParent();
		}

		try {
			f = new FileReader(nomeArq);
			scanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			str = corrigirString(str);
			if (!str.isEmpty()) {
				str = str.toUpperCase();
				str = str.replace("\n", "");
				str = str.replace("\t", "");
				lista.add(str);

			}
		}

		for (String s : lista) {
			total += s + " ";
		}
	}

	public String corrigirString(String str) {
		String subStr = "";
		String carp = "><>";
		// System.out.println(str);

		if (str.trim().startsWith(carp)) {
			return "";
		}
		int pos = str.indexOf(carp);
		if (pos == -1) {
			return str;
		}
		// System.out.println(str+" "+pos);
		for (int i = 0; i < pos; i++) {
			subStr += str.charAt(i);
		}

		// System.out.println(subStr);
		return subStr;
	}

	public List<String> lerArqPR() {

		List<String> listaPR = new LinkedList<>();

		FileReader f = null;
		Scanner scanner = null;
		String nomeArq = "palavrasReservadas.txt";

		try {
			f = new FileReader(nomeArq);
			scanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNext()) {
			String str = scanner.next();
			str = str.toUpperCase();
			listaPR.add(str);
		}
		return listaPR;
	}

	public void abrirArq(String delimiter, String nomeArq) {
		FileReader f = null;
		Scanner scanner = null;
		try {
			f = new FileReader(nomeArq);
			scanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		scanner.useDelimiter(delimiter);
		while (scanner.hasNext()) {
			String str = scanner.next();
			str = str.toUpperCase();
			total += str + " ";
			lista.add(str);
		}
	}
}
