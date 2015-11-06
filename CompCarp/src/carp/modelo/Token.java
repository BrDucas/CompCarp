package carp.modelo;

public class Token {
    
    private String valorToken; 
    private String tipoToken; //TK_alguma coisa

    public Token(String tipoToken, String valorToken) {
        this.valorToken = valorToken;
        this.tipoToken = tipoToken;        
    }

    public String getValorToken() {
        return valorToken;
    }

    public void setValorToken(String valorToken) {
        this.valorToken = valorToken;
    }    
    
    public String getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(String tipoToken) {
        this.tipoToken = tipoToken;
    }

	@Override
	public String toString() {
		return valorToken + " " + tipoToken+"\n";
	}
    
}
