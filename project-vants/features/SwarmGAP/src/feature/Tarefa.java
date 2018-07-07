package feature;

import java.util.ArrayList;
import java.util.List;

import feature.recurso.Camera;
import feature.recurso.Holofote;
import feature.recurso.VelocidadeTurbo;
import feature.recurso.decorator.RecursoDecorator;

public class Tarefa implements Comparable<Object> {
	
	private Tendencia tendencia;
	private Drone drone;
	private List<RecursoDecorator> recursos;
	
	public Tarefa(Tendencia tendencia, List<RecursoDecorator> recursos, Drone drone) {
		this.tendencia = tendencia;
		this.recursos = recursos;
		this.drone = drone;
	}
	
	public List<RecursoDecorator> getRecursos() {
		return recursos;
	}
	public void setRecursos(List<RecursoDecorator> recursos) {
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
	
	public static List<RecursoDecorator> retornaRecursos(Tendencia tendencia){
		List<RecursoDecorator> retorno = new ArrayList<RecursoDecorator>();;
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

	@Override
	public int compareTo(Object o) {
		if(tendencia.getCodigo() < ((Tarefa)o).getTendencia().getCodigo())
			return -1;
		else if(tendencia.getCodigo() > ((Tarefa)o).getTendencia().getCodigo())
			return 1;
		return 0;
	}
}
