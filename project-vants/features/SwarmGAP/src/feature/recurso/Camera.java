package feature.recurso;

import feature.recurso.interfaces.Recurso;

public class Camera implements Recurso {

	@Override
	public void execute() {
		System.out.println("Usando Camera.");
	}

}
