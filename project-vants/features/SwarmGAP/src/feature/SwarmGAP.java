package feature;

import java.util.ArrayList;
import java.util.List;

import feature.recurso.interfaces.Recurso;
import interfaces.Print;

public class SwarmGAP implements Print {

	private List<Tarefa> tarefas;
	private Drone drone;
	
	public SwarmGAP() {
		
	}
	
	public void processaAnalise() {
		List<Recurso> recursosDrone = getDrone().getRecursos();
		
		Tarefa tarefaAExcluir = null; 
		for (Tarefa tarefa : getTarefas()) {
			boolean retorno = false;
			List<Recurso> recursosTarefa = tarefa.getRecursos();
			for (Recurso recurso : recursosTarefa) {
				 retorno = recursosDrone.contains(recurso);
				 if(!retorno) {
					 break;
				 }
			}
			if(retorno) {
				getDrone().setVisitado(true);
				tarefaAExcluir = tarefa;
				break;
			}
		}
		if(tarefaAExcluir != null) {
			getTarefas().remove(tarefaAExcluir);
		}
	}
	
	public SwarmGAP(Drone drone, List<Tarefa> tarefas) {
		setDrone(drone);
		setTarefas(tarefas);
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public void print() {
		System.out.println("SwarmGAP-1");
		System.out.println("Lista de Tarefas Antes do Swarm...");
		List<Tarefa>tarefas = new ArrayList<>();
		
		tarefas.add(new Tarefa(Tendencia.TENDENCIA_BAIXA,Tarefa.retornaRecursos(Tendencia.TENDENCIA_BAIXA), null));
		tarefas.add(new Tarefa(Tendencia.TENDENCIA_MEDIA,Tarefa.retornaRecursos(Tendencia.TENDENCIA_MEDIA), null));
		tarefas.add(new Tarefa(Tendencia.TENDENCIA_ALTA, Tarefa.retornaRecursos(Tendencia.TENDENCIA_ALTA), null));
		Drone drone = new Drone();
		drone.setRecursos(tarefas.get(2).getRecursos());
		SwarmGAP swarm = new SwarmGAP(drone, tarefas);
		for (Tarefa tarefa : swarm.getTarefas()) {
			System.out.println(tarefa.getTendencia().getNome());
		}
		swarm.processaAnalise();
		System.out.println("Lista de Tarefas Depois do Swarm...");
		for (Tarefa tarefa : swarm.getTarefas()) {
			System.out.println(tarefa.getTendencia().getNome());
		}
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public static void main(String[] args) {
		
	}
}
