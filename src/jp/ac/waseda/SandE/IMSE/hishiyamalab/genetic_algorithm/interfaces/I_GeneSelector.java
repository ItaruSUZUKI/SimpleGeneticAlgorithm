package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

import java.util.List;

public interface I_GeneSelector {
	void setEnvironment(I_Environment env);
	I_Environment getEnvironment();
	List<I_Gene> selectGene(List<I_Gene> geneList);
}
