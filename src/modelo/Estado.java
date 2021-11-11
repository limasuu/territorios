package modelo;

public class Estado {
	
	private String nome;
	private String pais;
	private String sigla;
	private String capital;
	private double area;
		
	public Estado(String nome, String pais, String sigla, String capital, double area) {
		
		this.nome = nome;
		this.pais = pais;
		this.sigla = sigla;
		this.capital = capital;
		this.area = area;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
}
