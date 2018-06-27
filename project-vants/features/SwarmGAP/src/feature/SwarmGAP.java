package br.vants.feature;

import java.util.List;

import br.vants.interfaces.Recurso;
import interfaces.Print;

public class SwarmGAP implements Print {

	private Drone drone;

	public SwarmGAP() {}
	
	public SwarmGAP(Drone drone) {
		this.drone = drone;
	}

	public void processaAnalise() {
		List<Recurso> recursosDrone = drone.getRecursos();
		
		Tarefa tarefaAExcluir = null; 
		for (Tarefa tarefa : FeaturesUtils.retornaTarefas()) {
			boolean retorno = false;
			List<Recurso> recursosTarefa = tarefa.getRecursos();
			for (Recurso recurso : recursosTarefa) {
				 retorno = recursosDrone.contains(recurso);
				 if(!retorno) {
					 break;
				 }
			}
			if(retorno) {
				drone.setVisitado(true);
				tarefaAExcluir = tarefa;
				break;
			}
		}
		if(tarefaAExcluir != null) {
			FeaturesUtils.retornaRecursos().remove(tarefaAExcluir);
		}
	}
	
	@Override
	public void print() {
		System.out.println("SwarmGAP-1");
		System.out.println("Lista de Tarefas Antes do Swarm...");
		System.out.println("teste1");
		List<Tarefa> tarefas = FeaturesUtils.retornaTarefas();
		System.out.println("teste2");
		SwarmGAP swarm = new SwarmGAP(FeaturesUtils.retornaDrone(Tendencia.TENDENCIA_MEDIA));
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa.getTendencia().getNome());
		}
		swarm.processaAnalise();
		System.out.println("Lista de Tarefas Depois do Swarm...");
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa.getTendencia().getNome());
		}
	}
	
	public static void main(String[] args) {
		SwarmGAP sw = new SwarmGAP();
		sw.print();
	}

}
