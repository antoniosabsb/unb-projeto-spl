package util;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import feature.recurso.interfaces.Recurso;

public class GeraObjetos {
	
	public static List<Recurso> retornaLista(int quantidade){
		//lista as classes do pacote "com.google", incluindo os subpacotes
		Reflections r = new Reflections("recurso", new SubTypesScanner(false), ClasspathHelper.forClassLoader()
		    );
		Set<Class<?>> classes = r.getSubTypesOf(Object.class);

		//exibe a lista classes
		for (Class<?> c : classes) {
		    System.out.println(c.getName());
		}
		return null;
	}
	
	public static void main(String[] args) {
		GeraObjetos.retornaLista(10);
	}
}
