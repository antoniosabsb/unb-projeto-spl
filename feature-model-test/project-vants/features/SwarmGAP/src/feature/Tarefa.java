package feature;

import java.util.ArrayList;
import java.util.List;

import feature.recurso.Camera;
import feature.recurso.Holofote;
import feature.recurso.VelocidadeTurbo;
import feature.recurso.interfaces.Recurso;

public class Tarefa {
	
	private Tendencia tendencia;
	private Drone drone;
	private List<Recurso> recursos;
	
	public Tarefa(Tendencia tendencia, List<Recurso> recursos, Drone drone) {
		this.tendencia = tendencia;
		this.recursos = recursos;
		this.drone = drone;
	}
	
	public List<Recurso> getRecursos() {
		return recursos;
	}
	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	public Tendencia getTendencia() {
		return tendencia;
	}
	public void setTendencia(Tendencia tendencia) {
		this.tendencia = tendencia;
	}
	public Drone getDrone() {
		return drone;
	}
	public void setDrone(Drone drone) {
		this.drone = drone;
	} 
	
	public static List<Recurso> retornaRecursos(Tendencia tendencia){
		List<Recurso> retorno = new ArrayList<Recurso>();;
		switch (tendencia) {
		case TENDENCIA_BAIXA:
			retorno.add(new Camera());
			break;
		case TENDENCIA_MEDIA:
			retorno.add(new Camera());
			retorno.add(new Holofote());
			break;
		case TENDENCIA_ALTA:
			retorno.add(new Camera());
			retorno.add(new Holofote());
			retorno.add(new VelocidadeTurbo());
			break;
		default:
			break;
		}
		return retorno;
	}
}
