package feature;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import interfaces.Print;

public class AlocationLoop implements Print {

	private List<Tarefa> tarefas;
	private List<Drone> drones;
	private int QTD_REPETICAO = 10;
	
	@Override
	public void print() {
		execute();
	}

	private void execute() {
		
		setTarefas(FeaturesUtils.retornaTarefas(QTD_REPETICAO));
		setDrones(FeaturesUtils.retornaDrones());
		int size = getTarefas().size();
		StringBuilder log = new StringBuilder();
		log.append("\nTOTAL TAREFAS ANTES AL: "+ size);
		Date dtInicial = Calendar.getInstance().getTime();
		log.append("\nAlocationLoop Tempo Inicial "+ FeaturesUtils.formataData(dtInicial));
		SwarmGAP swarm = null;
		for (int i=0; i< size;i++) {
			for (Drone drone : getDrones()) {
				swarm = new SwarmGAP(drone,getTarefas());
				FeatureDTO processa = swarm.processaAnalise(false);
				if(processa.getTarefas().size() < size) {
					setTarefas(processa.getTarefas());
					drone = processa.getDrone();
					i--;
					size--;
				}
			}
		}
		Date dtFinal = Calendar.getInstance().getTime();
		log.append("\nAlocationLoop Tempo Final "+ FeaturesUtils.formataData(dtFinal));
		log.append("\nTempo decorrido: "+ FeaturesUtils.diferencaEntreDatas(dtInicial, dtFinal));
		
		System.out.println(log.toString());
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}

}
