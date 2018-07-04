package feature;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import interfaces.Print;

public class AlocationLoop implements Print {

	@Override
	public void print() {
		execute();
	}

	private void execute() {
		List<Tarefa> tarefas = FeaturesUtils.retornaTarefas();
		int size = tarefas.size();
		System.out.println("TOTAL TAREFAS ANTES AL: "+ size);
		System.out.println("SwarmGAP Tempo Inicial "+ new SimpleDateFormat("HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
		SwarmGAP swarm = null;
		for (int i=0; i< size;i++) {
			swarm = new SwarmGAP(FeaturesUtils.retornaDrone(Tendencia.TENDENCIA_ALTA),tarefas);
			tarefas = swarm.processaAnalise(false);
			if(tarefas.size()<size) {
				i--;
				size--;
			}
		}
		System.out.println("TOTAL TAREFAS DEPOIS AL: "+ size);
		System.out.println("SwarmGAP Tempo Final "+ new SimpleDateFormat("HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
	}

}
