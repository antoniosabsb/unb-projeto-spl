package feature;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import feature.recurso.interfaces.Recurso;

public class FeaturesUtils {
	
	public static List<Tarefa> retornaTarefas(int qtdRepeticao) {
		List<Tarefa>tarefas = null;
		if(tarefas == null){
			tarefas = new ArrayList<>();
			for (int i = 0; i < qtdRepeticao; i++) {
				tarefas.add(new Tarefa(Tendencia.TENDENCIA_ALTA, FeaturesUtils.retornaRecursos(Tendencia.TENDENCIA_ALTA), null));
				tarefas.add(new Tarefa(Tendencia.TENDENCIA_MEDIA,FeaturesUtils.retornaRecursos(Tendencia.TENDENCIA_MEDIA), null));
				tarefas.add(new Tarefa(Tendencia.TENDENCIA_BAIXA,FeaturesUtils.retornaRecursos(Tendencia.TENDENCIA_BAIXA), null));
			}
		}
		return tarefas;
	}
	
	public static List<Drone> retornaDrones() {
		List<Drone>drones = null;
		if(drones == null){
			drones = new ArrayList<>();
			drones.add(retornaDrone(Tendencia.TENDENCIA_BAIXA));
			drones.add(retornaDrone(Tendencia.TENDENCIA_MEDIA ));
			drones.add(retornaDrone(Tendencia.TENDENCIA_ALTA));
		}
		return drones;
	}
	
	public static Drone retornaDrone(Tendencia tendencia){
		Drone drone = new Drone();
		drone.setRecursos(FeaturesUtils.retornaRecursos(tendencia));
		return drone;
	}
	
	public static List<Recurso> retornaRecursos(){
		List<Recurso> recursos = new ArrayList<>(1);
		File dir = new File(System.getProperty("user.dir")+"/src/recurso/");
		if(!dir.isDirectory()){
			dir = new File(System.getProperty("user.dir")+"/features/SwarmGAP/src/feature/recurso/");
		}
		if(dir.isDirectory()){
			for(File obj : dir.listFiles()){
				String [] lista = obj.toString().split("/");
				String nomeClasse = lista[lista.length-1];
				if(nomeClasse.startsWith("inter")){
					continue;
				}
				nomeClasse = nomeClasse.substring(0, nomeClasse.length()-5);
				try {
					recursos.add((Recurso) Class.forName("feature.recurso."+nomeClasse).newInstance());
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
	
	public static String formataData(Date data) {
		return new SimpleDateFormat("HH:mm:ss:SSS").format(data);
	}
	
	public static long diferencaEntreDatas(Date dtInicial, Date dtFinal) {
		return dtFinal.getTime() - dtInicial.getTime();
	}
	
	public static void main(String[] args) {
		
	}

}
