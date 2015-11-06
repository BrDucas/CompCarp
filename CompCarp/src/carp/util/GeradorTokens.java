package carp.util;

import carp.modelo.ListaTokens;
import carp.modelo.Token;

public class GeradorTokens {

	public Token geraToken(String str, boolean pr) {
		Token t;
		ListaTokens lt = new ListaTokens();
		String tipo = lt.busca(str);
		t = new Token(str, tipo);
		return t;
	}
}
