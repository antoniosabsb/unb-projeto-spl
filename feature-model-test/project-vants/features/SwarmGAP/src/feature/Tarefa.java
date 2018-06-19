package feature;

public class Tarefa {
	
	public Tarefa(Tendencia tendencia, Drone drone) {
		this.tendencia = tendencia;
		this.drone = drone;
	}
	private Tendencia tendencia;
	private Drone drone;
	public Tendencia getTendencia() {
		return tendencia;
	}
	public void setTendencia(Tendencia tendencia) {
		this.tendencia = tendencia;
	}
	public Drone getDrone() {
		return drone;
	}
	public void setDrone(Drone drone) {
		this.drone = drone;
	} 
}
