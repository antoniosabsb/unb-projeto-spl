package feature.recurso;

import feature.recurso.decorator.Decorator;
import feature.recurso.decorator.RecursoDecorator;

public class Camera extends Decorator{
	
	public Camera() {}

	public Camera(RecursoDecorator component) {
		super(component);
	}

	private void executeCamera() {
		System.out.println("Usando Camera.");
	}
	
	public void execute() {
		super.execute();
		executeCamera();
	}
	
}
