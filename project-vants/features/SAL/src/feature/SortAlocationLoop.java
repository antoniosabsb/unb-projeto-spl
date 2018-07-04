package feature;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import interfaces.Print;

public class SortAlocationLoop implements Print {

	@Override
	public void print() {
		execute();
	}

	private void execute() {
		List<Tarefa> tarefas = FeaturesUtils.retornaTarefas();
		java.util.Collections.sort(tarefas);
		int size = tarefas.size();
		StringBuilder log = new StringBuilder();
		log.append("TOTAL TAREFAS ANTES AL: "+ size);
		log.append("SwarmGAP Tempo Inicial "+ new SimpleDateFormat("HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
		SwarmGAP swarm = null;
		for (int i=0; i< size;i++) {
			swarm = new SwarmGAP(FeaturesUtils.retornaDrone(Tendencia.TENDENCIA_ALTA),tarefas);
			tarefas = swarm.processaAnalise(false);
			if(tarefas.size()<size) {
				i--;
				size--;
			}
		}
		log.append("TOTAL TAREFAS DEPOIS AL: "+ size);
		log.append("SwarmGAP Tempo Final "+ new SimpleDateFormat("HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
		
		System.out.println(log.toString());
	}
	
}
