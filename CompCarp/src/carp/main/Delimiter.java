package carp.main;

public class Delimiter {
	int index;
	char c;
	
	public Delimiter(int index, char c) {
		super();
		this.index = index;
		this.c = c;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Delimiter [index=" + index + ", c=" + c + "]";
	}
	
}	
