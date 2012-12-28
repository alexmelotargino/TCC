package br.com.tcc;

public class RankUsuario {

	//get and set do projeto
	    private String usuario;
	    private String capital;
	    private int bandeira;
	 
	    public RankUsuario(String usuario, String capital, int bandeira) {
	        super();
	        this.usuario = usuario;
	        this.capital = capital;
	        this.bandeira = bandeira;
	    }
	 
	    public String getUsuario() {
	        return usuario;
	    }
	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }
	    public String getCapital() {
	        return capital;
	    }
	    public void setCapital(String capital) {
	        this.capital = capital;
	    }
	    public int getBandeira() {
	        return bandeira;
	    }
	    public void setBandeira(int bandeira) {
	        this.bandeira = bandeira;
	    }
	    



}
