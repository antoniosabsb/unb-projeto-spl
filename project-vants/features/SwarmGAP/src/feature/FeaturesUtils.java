package br.vants.feature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.vants.interfaces.Recurso;

public class FeaturesUtils {
	public static List<Recurso> recursos = new ArrayList<>(1);
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		System.out.println();
		File dir = new File(System.getProperty("user.dir")+"\\src\\br\\vants\\recurso\\");
		if(dir.isDirectory()){
			for(File obj : dir.listFiles()){
				String [] lista = obj.toString().replace("\\",";").split(";");
				String nomeClasse = lista[lista.length-1];
				nomeClasse = nomeClasse.substring(0, nomeClasse.length()-5);
					recursos.add((Recurso) Class.forName("br.vants.recurso."+nomeClasse).newInstance());
			}
		}
		for (Recurso recurso : recursos) {
			recurso.execute();
		}
	}
}
