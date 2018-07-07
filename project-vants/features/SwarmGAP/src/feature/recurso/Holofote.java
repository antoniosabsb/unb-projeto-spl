package feature.recurso;

import feature.recurso.decorator.Decorator;
import feature.recurso.decorator.RecursoDecorator;

public class Holofote extends Decorator{
	
	public Holofote() {}

	public Holofote(RecursoDecorator component) {
		super(component);
	}

	private void executeHolofote() {
		System.out.println("Usando Holofote.");
	}
	
	public void execute() {
		super.execute();
		executeHolofote();
	}
	
}
