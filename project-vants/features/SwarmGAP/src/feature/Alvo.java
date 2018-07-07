package feature;

import java.util.Observable;

public class Alvo extends Observable implements Veiculo{
	
	private String acao = "";

	@Override
	public void frente() {
		acao = "frente";
		System.out.println("Alvo segue em frente.");
		this.mudaEstado();
	}

	@Override
	public void direita() {
		acao = "direita";
		System.out.println("Alvo vira à direita.");
		this.mudaEstado();
	}

	@Override
	public void esquerda() {
		acao = "esquerda";
		System.out.println("Alvo vira à esquerda.");
		this.mudaEstado();
	}

	@Override
	public void para() {
		acao = "para";		
		System.out.println("Alvo para.");
		this.mudaEstado();
	}
	
	public void mudaEstado() {
		setChanged();
		notifyObservers(acao);
	}

}
