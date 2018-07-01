package feature;

public enum Tendencia {
	TENDENCIA_BAIXA(1, "Baixa"),
	TENDENCIA_MEDIA(2, "Media"),
	TENDENCIA_ALTA(3, "Alta");
	
	private String nome;
	private int codigo;
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	private Tendencia(int codigo, String nome) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static Tendencia retornaTendenciaPorCodigo(int codigo) {
		for (int i = 0; i<Tendencia.values().length;i++) {
			if(Tendencia.values()[i].getCodigo() == codigo) {
				return Tendencia.values()[i];
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(Tendencia.retornaTendenciaPorCodigo(2).getNome());
	}
	
}
