package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm;

import java.util.List;

public interface I_SuccessorMaker {
	void setMutator(I_Mutator mutator);
	I_Mutator getMutator();
	
	List<I_Gene> makeSuccessors(I_Gene... geneList);
	List<I_Gene> makeSuccessors(List<I_Gene> geneList);
}
