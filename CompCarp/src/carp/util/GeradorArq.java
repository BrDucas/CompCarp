package carp.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import carp.modelo.Token;

public class GeradorArq {
	private File f;

	public GeradorArq(String caminho) {
		System.out.println(caminho);
		this.f = new File(caminho+"\\Tokens.txt");
	}

	public void Gravar(List<Token> lista_tk) {
		String conteudo = "";
		try {
			f.delete();
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			for (Token token : lista_tk) {
				conteudo = token.toString();
				fw.write(conteudo);
			}
			System.out.println("Arquivo de Tokens gerado");
			conteudo = "";
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
