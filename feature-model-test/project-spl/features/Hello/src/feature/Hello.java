package feature;
import interfaces.Print;

public class Hello implements Print {

	@Override
	public void print() {
		System.out.println("Hello");
	}

}
