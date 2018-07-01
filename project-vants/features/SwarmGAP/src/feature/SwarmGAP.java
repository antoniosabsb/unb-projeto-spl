package feature;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import feature.recurso.interfaces.Recurso;
import interfaces.Print;

public class SwarmGAP implements Print {

	private Drone drone;
	private List<Tarefa> tarefas;

	public SwarmGAP() {}
	
	public SwarmGAP(Drone drone, List<Tarefa> tarefas) {
		this.drone = drone;
		this.tarefas = tarefas;
	}

	public List<Tarefa> processaAnalise(boolean exibeLog) {
		StringBuilder log = new StringBuilder();
		log.append("SwarmGAP Tempo Inicial "+ new SimpleDateFormat("HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
		log.append("\nCapacidade Drone: "+ Tendencia.retornaTendenciaPorCodigo(drone.getRecursos().size()).getNome());
		
		log.append("\nQuantidade Tarefas Antes: "+ tarefas.size());

		List<Recurso> recursosDrone = drone.getRecursos();
		Tarefa tarefaAExcluir = null; 
		for (Tarefa tarefa : tarefas) {
			boolean retorno = false;
			List<Recurso> recursosTarefa = tarefa.getRecursos();
			for (Recurso recursoT : recursosTarefa) {
				for (Recurso recursoD : recursosDrone) {
					retorno = recursoD.getClass().equals(recursoT.getClass());
					if(retorno) {
						break;
					}
				}
			}
			if(retorno) {
				drone.setVisitado(true);
				tarefaAExcluir = tarefa;
				log.append("\nTarefa executada: "+ tarefa.getTendencia().getNome());
				break;
			}
		}
		if(tarefaAExcluir != null) {
			tarefas.remove(tarefaAExcluir);
		}
		log.append("\nQuantidade Tarefas Atual: "+ tarefas.size());
		log.append("\nSwarmGAP Tempo Final "+ new SimpleDateFormat("HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
		if(exibeLog) {
			System.out.println(log);
		}
		return tarefas;
	}
	
	@Override
	public void print() {
		/**
		 * if(tarefas == null) {
			tarefas = FeaturesUtils.retornaTarefas();
		}
		SwarmGAP swarm = new SwarmGAP(FeaturesUtils.retornaDrone(Tendencia.TENDENCIA_ALTA), tarefas);
		swarm.processaAnalise(true);
		 * */
	}
	
}
