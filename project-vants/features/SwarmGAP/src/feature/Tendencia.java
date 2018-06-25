package feature;

public enum Tendencia {
	TENDENCIA_BAIXA("Baixa"),
	TENDENCIA_MEDIA("Media"),
	TENDENCIA_ALTA("Alta");
	
	private String nome;
	
	

	private Tendencia(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
