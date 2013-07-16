package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm;

import java.util.List;

public interface I_GeneticAlgorithm {
	void setInitializer(I_GeneInitializer initializer);
	I_GeneInitializer getInitializer();
	
	void setSuccessorMaker(I_SuccessorMaker maker);
	I_SuccessorMaker getSuccessorMaker();
	
	void setEnvironment(I_Environment env);
	I_Environment getEnvironment();
	
	List<I_Gene> run(Integer numberOfGeneration);
}
