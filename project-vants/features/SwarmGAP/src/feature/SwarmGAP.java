package feature;

import java.util.ArrayList;
import java.util.List;

import interfaces.Print;

public class SwarmGAP implements Print {

	List<Tarefa> tarefas;
	
	public void processaAnalise(Drone drone) {
		drone.getRecursos();
	}
	
	public SwarmGAP() {
		if(tarefas == null) {
			tarefas = new ArrayList<>();
			
			tarefas.add(new Tarefa(Tendencia.TENDENCIA_BAIXA,Tarefa.retornaRecursos(Tendencia.TENDENCIA_BAIXA), null));
			tarefas.add(new Tarefa(Tendencia.TENDENCIA_MEDIA,Tarefa.retornaRecursos(Tendencia.TENDENCIA_MEDIA), null));
			tarefas.add(new Tarefa(Tendencia.TENDENCIA_ALTA, Tarefa.retornaRecursos(Tendencia.TENDENCIA_ALTA), null));
		}
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
	}

}
