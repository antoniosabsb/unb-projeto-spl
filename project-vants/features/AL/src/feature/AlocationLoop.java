package feature;

import java.util.List;

public class AlocationLoop extends PrintTemplate {
	
	public void executeTemplateMethod() {
		
		List<Tarefa> tarefas = FeaturesUtils.retornaTarefas();
		List<Drone> drones = FeaturesUtils.retornaDrones();
		
		FeatureDTO dto = processaStategy(tarefas, drones, AlocationLoop.class.getName());
		
		System.out.println(dto.getLog().toString());
	}
	
	public static void main(String[] args) {
	}

}
