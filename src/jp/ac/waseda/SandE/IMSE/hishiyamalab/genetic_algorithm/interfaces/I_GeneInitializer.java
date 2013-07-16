package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

import java.util.List;

/**
 * 一番初めの遺伝子群を作成するためのクラス
 *
 * @author ital
 *
 */
public interface I_GeneInitializer {
	List<I_Gene> makeInitGenes(Integer numOfGene, Integer geneSize);
}
