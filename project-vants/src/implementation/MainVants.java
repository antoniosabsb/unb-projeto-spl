package implementation;

import java.util.List;

import interfaces.Print;
import loader.PluginLoader;

public class MainVants {
	public static void main(String[] args) {
		List<Print> listaPrints = PluginLoader.load(Print.class);
		
		for (Print print : listaPrints) {
			print.print();
		}
	}

}
