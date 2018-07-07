package feature.recurso.decorator;

public class Recurso extends RecursoDecorator{
	
	@Override
	public void execute() {
		System.out.println("Recurso do Drone");
	}

}
