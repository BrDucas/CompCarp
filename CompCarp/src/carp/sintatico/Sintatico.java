package carp.sintatico;

import java.util.List;

import carp.modelo.Token;
import carp.pilha.Pilha;

public class Sintatico {
	Pilha p = new Pilha();
	
	public void abrirTokens(List<Token> list){
		System.out.println(list);
	}
}
