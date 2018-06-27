package br.vants.feature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.vants.interfaces.Recurso;
import interfaces.Print;

public class FeaturesUtils {
	
	public static List<Tarefa> retornaTarefas() {
		List<Tarefa>tarefas = null;
		if(tarefas == null){
			tarefas = new ArrayList<>();
			tarefas.add(new Tarefa(Tendencia.TENDENCIA_BAIXA,FeaturesUtils.retornaRecursos(Tendencia.TENDENCIA_BAIXA), null));
			tarefas.add(new Tarefa(Tendencia.TENDENCIA_MEDIA,FeaturesUtils.retornaRecursos(Tendencia.TENDENCIA_MEDIA), null));
			tarefas.add(new Tarefa(Tendencia.TENDENCIA_ALTA, FeaturesUtils.retornaRecursos(Tendencia.TENDENCIA_ALTA), null));
		}
		return tarefas;
	}
	
	public static Drone retornaDrone(Tendencia tendencia){
		Drone drone = new Drone();
		drone.setRecursos(FeaturesUtils.retornaRecursos(tendencia));
		return drone;
	}
	
	public static void main(String[] args) {
		FeaturesUtils.retornaRecursos(Tendencia.TENDENCIA_BAIXA).get(0).execute();
	}
	
	public static List<Recurso> retornaRecursos(){
		System.out.println("aqui1");
		List<Recurso> recursos = new ArrayList<>(1);
		//C:\Desenvolvimento\workspaces\projeto-spl\project-vants\src\br\vants\recurso
		//C:\Desenvolvimento\workspaces\projeto-spl\project-vants\features\SwarmGAP\src\br\vants\recurso\Camera.java
		File dir = new File(System.getProperty("user.dir")+"\\src\\br\\vants\\recurso\\");
		System.out.println("aqui2");
		System.out.println("aqui: "+dir);
		System.out.println(dir.listRoots());
		if(dir.isDirectory()){
			for(File obj : dir.listFiles()){
				String [] lista = obj.toString().replace("\\",";").split(";");
				String nomeClasse = lista[lista.length-1];
				nomeClasse = nomeClasse.substring(0, nomeClasse.length()-5);
				System.out.println("aqui3");
				try {
					recursos.add((Recurso) Class.forName("br.vants.recurso."+nomeClasse).newInstance());
				} catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
					e.printStackTrace();
				}
			}
		}
		return recursos;
	}
	
	public static List<Recurso> retornaRecursos(Tendencia tendencia){
		List<Recurso> recursos = new ArrayList<Recurso>();;
		switch (tendencia) {
		case TENDENCIA_BAIXA:
			recursos.add(retornaRecursos().get(0));
			break;
		case TENDENCIA_MEDIA:
			recursos.add(retornaRecursos().get(0));
			recursos.add(retornaRecursos().get(1));
			break;
		case TENDENCIA_ALTA:
			recursos.add(retornaRecursos().get(0));
			recursos.add(retornaRecursos().get(1));
			recursos.add(retornaRecursos().get(2));
			break;
		default:
			break;
		}
		return recursos;
	}

}
