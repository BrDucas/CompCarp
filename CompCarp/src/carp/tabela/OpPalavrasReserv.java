package carp.tabela;

import carp.util.LeitorArq;

import java.util.*;

public class OpPalavrasReserv {

	private LinkedList<TabelaPalavrasReserv> tprList = new LinkedList<>();
	private List<String> lista;

	public OpPalavrasReserv() {
		// System.out.println("Entrou");
		LeitorArq la = new LeitorArq();
		lista = la.lerArqPR();
		TabelaPalavrasReserv tpr = new TabelaPalavrasReserv();
		for (String nome : lista) {
			tpr.setNome(nome.toUpperCase());
			tprList.add(tpr);
		}
	}

	public LinkedList<TabelaPalavrasReserv> getTpr() {
		return tprList;
	}

	public void setTpr(LinkedList<TabelaPalavrasReserv> tpr) {
		this.tprList = tpr;
	}

	public boolean buscaTpr(String s1) {
		// System.out.println(tprList);
		for (int i = 0; i < lista.size(); i++) {
			if (s1.equals(lista.get(i).trim())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "OpPalavrasReserv [tprList=" + tprList + "]";
	}
}
