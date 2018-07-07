package feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import feature.recurso.Camera;
import feature.recurso.Holofote;
import feature.recurso.VelocidadeTurbo;
import feature.recurso.decorator.Recurso;
import feature.recurso.decorator.RecursoDecorator;

public class Drone implements Observer, Veiculo {
	private boolean visitado;
	List<RecursoDecorator> recursos;
	public List<RecursoDecorator> getRecursos() {
		if(recursos == null) {
			recursos = new ArrayList<RecursoDecorator>(1);
		}
		return recursos;
	}
	public void setRecursos(List<RecursoDecorator> recursos) {
		this.recursos = recursos;
	}
	public boolean isVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	

	public static void main(String[] args) {
		Recurso recurso1 = new Recurso();
		RecursoDecorator recurso2 = new Camera(recurso1);
		RecursoDecorator recurso3 = new Holofote(recurso2);
		RecursoDecorator recurso4 = new VelocidadeTurbo(recurso3);
		recurso4.execute();
		
		System.out.println("\nTESTE PADRÃO Observer");
		//Observador
		Drone drone = new Drone();
		//Observado
		Alvo alvo = new Alvo();
		//Adicionar o Observador ao Observado
		alvo.addObserver(drone);
		
		alvo.frente();
		alvo.direita();
		alvo.esquerda();
		alvo.para();
	}
	
	@Override
	public void frente() {
		System.out.println("Drone segue em frente.");
	}
	@Override
	public void direita() {
		System.out.println("Drone vira à direita.");		
	}
	@Override
	public void esquerda() {
		System.out.println("Drone vira à esquerda.");		
	}
	@Override
	public void para() {
		System.out.println("Drone para.");		
	}
	@Override
	public void update(Observable o, Object arg) {
		Alvo alvo = (Alvo)o;
		String acao = String.valueOf(arg);
		if(acao.equals("frente")) {
			this.frente();
		}else if(acao.equals("direita")) {
			this.direita();
		}else if(acao.equals("esquerda")) {
			this.esquerda();
		}else if(acao.equals("para")) {
			this.para();
		}
	}
}
