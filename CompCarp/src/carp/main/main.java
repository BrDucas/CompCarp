package carp.main;


import carp.util.GeradorArq;
import carp.util.LeitorArq;

public class main {
	public static void main(String[] args) {
		LeitorArq l = new LeitorArq();
		l.abrirArq();
		// System.out.println(l.getTotal());
		AnaLex analisador = new AnaLex();
		analisador.start(l.getTotal());
		// System.out.println(analisador.getListaId());
		String caminho = l.getCaminho();
		GeradorArq ga = new GeradorArq(caminho);
		System.out.println(analisador.getLt().getLista_tk());
		ga.Gravar(analisador.getLt().getLista_tk());
	}
}
