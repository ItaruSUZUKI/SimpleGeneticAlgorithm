package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

import java.util.List;

public interface I_GeneInitializer {
	List<I_Gene> makeInitGenes(Integer numOfGene, Integer geneSize);
}
