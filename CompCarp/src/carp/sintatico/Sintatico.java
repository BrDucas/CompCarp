package carp.sintatico;

import java.util.List;
import java.util.Stack;

import carp.modelo.Token;

public class Sintatico {
	private Stack<String> pilha = new Stack<>();
	
	public Sintatico() {
		this.pilha.push("$");
	}

	public Stack<String> getPilha() {
		return pilha;
	}

	public void setPilha(Stack<String> pilha) {
		this.pilha = pilha;
	}

	public void abrirTokens(List<Token> list) {
		System.out.println(list);
	}
}
