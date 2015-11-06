package carp.modelo;

import java.util.LinkedList;
import java.util.List;
import carp.util.LeitorArq;

public class ListaTokens {
	List<Token> Lista_tk;

	public ListaTokens() {
		Lista_tk = new LinkedList<>();
	}

	public void geraListaDefault() {
		LeitorArq la = new LeitorArq();
		la.abrirArq("\n", "Documento.txt");

		String s[];
		for (int i = 0; i < la.getLista().size() - 1; i++) {
			s = la.getLista().get(i).split(" ");
			String str1 = s[0];
			String str2 = s[1];
			Token t = new Token(str2, str1);
			Lista_tk.add(t);
		}
	}

	@Override
	public String toString() {
		return "" + Lista_tk;
	}

	public List<Token> getLista_tk() {
		return Lista_tk;
	}

	public void setLista_tk(List<Token> lista_tk) {
		Lista_tk = lista_tk;
	}

	public String busca(String str) {
		geraListaDefault();
		// System.out.println(Lista_tk);
		for (Token token : Lista_tk) {
			if (str.equals(token.getTipoToken().trim())) {
				return token.getValorToken();
			}
		}
		return Identificador(str);
	}

	public String Identificador(String key) {
		// System.out.println(key);
		switch (check(key)) {
		case "Numero":
			return "TK_NUMERO";
		case "Operador":
			return "TK_OPERADOR";
		case "String":
			return "TK_STRING";
		case "Tipo":
			return "TK_TIPO_VARIAVEL "; // para reconhecer tipos e quem
												// são eles
		case "Att":
			return "TK_ATRIBUICAO";
		default:
			return "TK_IDENTIFICADOR";
		}
	}

	public String check(String key) {
		if (key.matches("[0-9]*\\.?[0-9]+")) {
			//System.out.println("real");
			return "Numero";
		}
		if (key.equals("+") || key.equals("-") || key.equals("*") || key.equals("/") || key.equals("=")) {
			return "Operador";
		}
		if (key.charAt(0) == '"' && key.charAt(key.length() - 1) == '"') {
			return "String";
		}
		if (key.equals("INT") || key.equals("BOOLEAN") || key.equals("REAL") || key.equals("CHAR")
				|| key.equals("STRING")) {
			return "Tipo";
		}

		if (key.equals(":=")) {
			return "Att";
		}
		return "";
	}

	public void Add(Token t) {
		Lista_tk.add(t);
	}
}
