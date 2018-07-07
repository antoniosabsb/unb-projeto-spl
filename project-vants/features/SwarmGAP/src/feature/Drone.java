package feature;

import java.util.ArrayList;
import java.util.List;

import feature.recurso.Camera;
import feature.recurso.Holofote;
import feature.recurso.VelocidadeTurbo;
import feature.recurso.decorator.Recurso;
import feature.recurso.decorator.RecursoDecorator;

public class Drone {
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
	}
}
