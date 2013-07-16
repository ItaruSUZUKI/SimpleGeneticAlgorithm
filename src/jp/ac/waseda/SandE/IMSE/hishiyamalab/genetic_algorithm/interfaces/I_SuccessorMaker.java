package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

import java.util.List;

public interface I_SuccessorMaker {
	List<I_Gene> makeSuccessors(Integer size, List<I_Gene> geneList);
}
