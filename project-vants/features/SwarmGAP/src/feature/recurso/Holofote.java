package feature.recurso;

import feature.recurso.interfaces.Recurso;

public class Holofote implements Recurso {

	@Override
	public void execute() {
		System.out.println("Usando holofote.");
	}

}
