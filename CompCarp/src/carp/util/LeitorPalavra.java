package carp.util;

public class LeitorPalavra {
	private String subString = "";
	private int inicial = 0;
	
	public int getInicial() {
		return inicial;
	}

	public void setInicial(int inicial) {
		this.inicial = inicial;
	}

	public String getSubString() {
		return subString;
	}

	public void setSubString(String subString) {
		this.subString = subString;
	}
	
	public  void ler(String str, char c, int pos){
		int i = 0;
		//System.out.println(str);
		subString="";
		for(i = pos; str.charAt(i)!=c; i++){
			subString+=str.charAt(i);
		}
		inicial = i;
	}
}
