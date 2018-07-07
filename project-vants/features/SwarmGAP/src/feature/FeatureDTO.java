package feature;

import java.util.List;

public class FeatureDTO {
	private List<Tarefa> tarefas;
	private Drone drone;
	private StringBuilder log;
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	public Drone getDrone() {
		return drone;
	}
	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	public StringBuilder getLog() {
		return log;
	}
	public void setLog(StringBuilder log) {
		this.log = log;
	}

}
