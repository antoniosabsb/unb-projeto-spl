package feature;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import feature.recurso.decorator.RecursoDecorator;
import interfaces.Print;

public class SwarmGAP implements Print {

	private Drone drone;
	private List<Tarefa> tarefas;

	public SwarmGAP() {}
	
	public SwarmGAP(Drone drone, List<Tarefa> tarefas) {
		this.drone = drone;
		this.tarefas = tarefas;
	}

	public FeatureDTO processaAnalise(boolean exibeLog) {
		StringBuilder log = new StringBuilder();
		Date dtInicial = Calendar.getInstance().getTime();
		log.append("\nSwarmGAP Tempo Inicial "+ FeaturesUtils.formataData(dtInicial));
		log.append("\nCapacidade Drone: "+ Tendencia.retornaTendenciaPorCodigo(drone.getRecursos().size()).getNome());
		
		log.append("\nQuantidade Tarefas Antes: "+ tarefas.size());

		List<RecursoDecorator> recursosDrone = drone.getRecursos();
		Tarefa tarefaAExcluir = null; 
		for (Tarefa tarefa : tarefas) {
			boolean retorno = false;
			List<RecursoDecorator> recursosTarefa = tarefa.getRecursos();
			for (RecursoDecorator recursoT : recursosTarefa) {
				for (RecursoDecorator recursoD : recursosDrone) {
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
		Date dtFinal = Calendar.getInstance().getTime();
		log.append("\nSwarmGAP Tempo Final "+ FeaturesUtils.formataData(dtFinal));
		log.append("\nTempo decorrido: "+ FeaturesUtils.diferencaEntreDatas(dtInicial, dtFinal));
		if(exibeLog) {
			System.out.println(log);
		}
		FeatureDTO featureDTO = new FeatureDTO();
		featureDTO.setDrone(drone);
		featureDTO.setTarefas(tarefas);
		return featureDTO;
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
