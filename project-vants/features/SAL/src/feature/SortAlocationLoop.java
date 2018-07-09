package feature;

import java.util.List;

public class SortAlocationLoop extends PrintTemplate {
	
	public void executeTemplateMethod() {
		if(ehExecutavel) {ehExecutavel = false;return;}
		List<Tarefa> tarefas = FeaturesUtils.retornaTarefas();
		List<Drone> drones = FeaturesUtils.retornaDrones();
		java.util.Collections.sort(tarefas);
		
		FeatureDTO dto = processaStategy(tarefas, drones, SortAlocationLoop.class.getName());
		
		System.out.println(dto.getLog().toString());
	}

	public static void main(String[] args) {
	}
}
