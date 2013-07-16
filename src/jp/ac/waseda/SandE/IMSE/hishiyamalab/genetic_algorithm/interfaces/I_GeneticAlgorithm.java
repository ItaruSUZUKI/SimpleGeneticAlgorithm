package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

public interface I_GeneticAlgorithm {
	void setInitializer(I_GeneInitializer initializer);
	I_GeneInitializer getInitializer();

	void setSuccessorMaker(I_SuccessorMaker maker);
	I_SuccessorMaker getSuccessorMaker();

	void setGeneSelector(I_GeneSelector selector);
	I_GeneSelector getGeneSelector();

	I_Gene run(Integer geneSize, Integer numberOfGeneration);
}
