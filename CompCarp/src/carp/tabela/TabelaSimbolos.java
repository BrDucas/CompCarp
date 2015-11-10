package carp.tabela;

import carp.modelo.Token;
import java.util.*;

public class TabelaSimbolos {

	private HashMap<String, Token> ts;

	public TabelaSimbolos() {
		setTs(new HashMap<String, Token>());
	}

	public HashMap<String, Token> getTs() {
		return ts;
	}

	public void setTs(HashMap<String, Token> ts) {
		this.ts = ts;
	}
	
	public void insert(String str, Token t){
		if(!busca(str)){//se não encontrar o simbolo, insere
			ts.put(str, t);
		}
	}
	
	public boolean busca(String key){
		String delimitadores = " ;:\t\n+*/-=(){}";
		if(ts.containsKey(key) || delimitadores.contains(key)){
			return true;
		}
		return false;//não existe ainda
	}

	@Override
	public String toString() {
		return ""+ts;
	}
}
