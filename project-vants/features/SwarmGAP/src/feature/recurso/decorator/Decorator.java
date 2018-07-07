package feature.recurso.decorator;

public class Decorator extends RecursoDecorator {
	private RecursoDecorator component;
	
	public Decorator() {}
	
	public Decorator(RecursoDecorator component) {
		this.component = component;
	}

	@Override
	public void execute() {
		component.execute();
	}

}
