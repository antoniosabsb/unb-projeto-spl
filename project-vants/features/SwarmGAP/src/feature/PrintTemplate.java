package feature;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import interfaces.Print;

public abstract class PrintTemplate implements Print{
	
	protected static boolean ehExecutavel;

	@Override
	public void print() {
		executeTemplateMethod();
	}
	
	public abstract void executeTemplateMethod();
	
	public FeatureDTO processaStategy(List<Tarefa> tarefas, List<Drone> drones, String nomeClasse) {
		FeatureDTO processaDTO = null;
		boolean ehLAL = nomeClasse.startsWith("Limit");
		int size = tarefas.size();
		StringBuilder log = new StringBuilder();
		log.append("\n"+nomeClasse);
		log.append("\nTOTAL TAREFAS ANTES: "+ size);
		Date dtInicial = Calendar.getInstance().getTime();
		log.append("\nTempo Inicial "+ FeaturesUtils.formataData(dtInicial));
		SwarmGAP swarm = null;
		for (int i=0; i< size;i++) {
			for (Drone drone : drones) {
				if(ehLAL && drone.isVisitado())
					continue;
				swarm = new SwarmGAP(drone,tarefas);
				processaDTO = swarm.processaAnalise(false);
				if(processaDTO.getTarefas().size() < size) {
					tarefas = processaDTO.getTarefas();
					drone = processaDTO.getDrone();
					i--;
					size--;
				}
			}
		}
		Date dtFinal = Calendar.getInstance().getTime();
		log.append("\nTempo Final "+ FeaturesUtils.formataData(dtFinal));
		log.append("\nTempo decorrido: "+ FeaturesUtils.diferencaEntreDatas(dtInicial, dtFinal)+"ms");
		processaDTO.setLog(log);
		return processaDTO;
	}

}
