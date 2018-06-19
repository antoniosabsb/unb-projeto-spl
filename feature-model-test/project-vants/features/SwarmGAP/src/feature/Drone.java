package feature;

import java.util.ArrayList;
import java.util.List;

import feature.recurso.interfaces.Recurso;

public class Drone {
	private boolean visitado;
	List<Recurso> recursos;
	public List<Recurso> getRecursos() {
		if(recursos == null) {
			recursos = new ArrayList<Recurso>(1);
		}
		return recursos;
	}
	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	public boolean isVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	

}
