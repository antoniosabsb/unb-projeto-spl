package feature.recurso;

import feature.recurso.interfaces.Recurso;

public class VelocidadeTurbo implements Recurso {

	@Override
	public void execute() {
		System.out.println("Usando velocidade turbo.");
	}

}
