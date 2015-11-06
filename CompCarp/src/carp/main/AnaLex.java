package carp.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import carp.modelo.ListaTokens;
import carp.modelo.Token;
import carp.tabela.OpPalavrasReserv;
import carp.tabela.TabelaSimbolos;
import carp.util.GeradorTokens;

public class AnaLex {
	private boolean lendoString;
	private String delimitadores;
	private int posicaoAtual;
	private LinkedList<String> listaId;
	private OpPalavrasReserv opr;
	private ListaTokens lt;
	private GeradorTokens gt;
	private TabelaSimbolos ts;
	private ArrayList<Delimiter> del;
	private List<String> delimit;

	public ListaTokens getLt() {
		return lt;
	}

	public void setLt(ListaTokens lt) {
		this.lt = lt;
	}

	public AnaLex() {
		lendoString = false;
		delimitadores = " ;:\t\n+*/-=(){}";
		posicaoAtual = 0;
		listaId = new LinkedList<String>();
		opr = new OpPalavrasReserv();
		lt = new ListaTokens();
		gt = new GeradorTokens();
		ts = new TabelaSimbolos();
		del = new ArrayList<>();
		delimit = new LinkedList<>();
	}

	public List<String> getDelimit() {
		return delimit;
	}

	public void setDelimit(List<String> delimit) {
		this.delimit = delimit;
	}

	public void start(String sTotal) {
		String subString = "";

		int size = sTotal.length();
		int i = 0;

		while (posicaoAtual < size - 1) {
			for (i = posicaoAtual; !buscaDel(sTotal.charAt(i)); i++) {
				subString += sTotal.charAt(i);
				if ((sTotal.charAt(i) == '"') && (lendoString == false)) {
					lendoString = true;
				} else if ((sTotal.charAt(i) == '"') && (lendoString == true)) {
					lendoString = false;
				}
			}

			posicaoAtual = i + 1;

			while (buscaDel(sTotal.charAt(posicaoAtual))) {
				if ((posicaoAtual + 1) == size) {
					break;
				}
				posicaoAtual++;
			}

			listaId.add(subString);

			// System.out.println(delimit);
			for (int cont = 0; cont < delimit.size(); cont++) {
				if (!delimit.get(cont).equals(" ")) {
					if (delimit.get(cont).equals(":") && delimit.get(cont + 1).equals("=")) {
						listaId.add(":=");
						delimit.set(cont + 1, " ");
					} else {
						listaId.add(delimit.get(cont));
					}
				}
			}
			delimit.clear();
			subString = "";
		}
		addDelimitadores();
		verificaListaId();
		defineNomeProgram();
	}

	// nome programa = primeiro identificador encontrado
	public void defineNomeProgram() {
		for (int i = 0; i < lt.getLista_tk().size(); i++) {
			// System.out.println(lt.getLista_tk().get(i).getValorToken());
			if (lt.getLista_tk().get(i).getValorToken().equals("TK_IDENTIFICADOR")) {
				lt.getLista_tk().get(i).setValorToken("TK_NOME_PROGRAM");
				return;
			}
		}
	}

	public void addDelimitadores() {
		for (int i = 0; i < del.size(); i++) {
			listaId.add(del.get(i).getIndex(), del.get(i).getC() + "");
		}
	}

	public boolean buscaDel(char c) {

		String aux = Character.toString(c);
		if (delimitadores.contains(aux) && (lendoString == false)) {// encontra
			delimit.add(aux);
			return true;
		}
		return false;
	}

	public boolean isOp(String key) {
		if (key.equals("+") || key.equals("-") || key.equals("*") || key.equals("/") || key.equals(":=")
				|| key.equals("=") || key.equals("\"") || key.equals("(") || key.equals(")") || key.equals("\\")
				|| key.equals(";") || key.matches("[0-9]*\\.?[0-9]+")) {
			return true;
		}
		// System.out.println("Operador inválido" + key);
		return false;
	}

	public boolean verificaAlfabeto(String str) {
		boolean d = true;
		char[] c = str.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (!(str.charAt(0) == '"') && !(str.charAt(str.length() - 1) == '"')) {
				if (!Character.isDigit(c[i]) && !Character.isLetter(c[i]) && !isOp(str)) {
					d = false;
					break;
				}
			}
		}

		return d;
	}

	// checa, gera tokens e insere na lista
	public void verificaListaId() {
		for (int i = 0; i < listaId.size(); i++) {
			if (!verificaAlfabeto(listaId.get(i))) {
				System.out.println("Erro na palavra: " + listaId.get(i));
			}
		}

		for (int i = 0; i < listaId.size(); i++) {
			Token aux = new Token("", "");
			boolean b = true;
			if (!opr.buscaTpr(listaId.get(i))) {// busca
												// palavra
												// reservada
				b = false;
			}

			aux = gt.geraToken(listaId.get(i), b);
			if (!b) {
				ts.insert(listaId.get(i), aux);// insere na tabela de simbolos
			}

			lt.Add(aux);// insere na lista de tokens
		}
		// System.out.println(ts);
	}

	public LinkedList<String> getListaId() {
		return listaId;
	}

	public void setListaId(LinkedList<String> listaId) {
		this.listaId = listaId;
	}
}
