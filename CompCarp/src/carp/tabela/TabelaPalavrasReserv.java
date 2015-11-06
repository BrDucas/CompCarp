package carp.tabela;

public class TabelaPalavrasReserv {

	private String nome;

	@Override
	public String toString() {
		return "TabelaPalavrasReserv [nome=" + nome + "]";
	}

	public TabelaPalavrasReserv() {
		this.nome = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
