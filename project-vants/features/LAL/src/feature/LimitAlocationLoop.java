package feature;

import java.util.List;

public class LimitAlocationLoop extends PrintTemplate {

	public void executeTemplateMethod() {
		List<Tarefa> tarefas = FeaturesUtils.retornaTarefas();
		List<Drone> drones = FeaturesUtils.retornaDrones();
		java.util.Collections.sort(tarefas);
		
		FeatureDTO dto = processaStategy(tarefas, drones, LimitAlocationLoop.class.getName());
		
		System.out.println(dto.getLog().toString());
		ehExecutavel = true;
	}
	
	public static void main(String[] args) {
	}
}
