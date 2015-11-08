package carp.pilha;

import java.util.Stack;

public class Pilha {
	private Stack<String> pilha = new Stack<>();

	public Pilha() {
		this.pilha.push("$");
	}

	public Stack<String> getPilha() {
		return pilha;
	}

	public void setPilha(Stack<String> pilha) {
		this.pilha = pilha;
	}

	@Override
	public String toString() {
		return "Pilha [pilha=" + pilha + "]";
	}

}
