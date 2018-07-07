package feature.recurso;

import feature.recurso.decorator.Decorator;
import feature.recurso.decorator.RecursoDecorator;

public class VelocidadeTurbo extends Decorator{
	
	public VelocidadeTurbo() {}

	public VelocidadeTurbo(RecursoDecorator component) {
		super(component);
	}

	public void executeVelocidadeTurbo() {
		System.out.println("Usando VelocidadeTurbo.");
	}
	
	public void execute() {
		super.execute();
		executeVelocidadeTurbo();
	}
	
}
