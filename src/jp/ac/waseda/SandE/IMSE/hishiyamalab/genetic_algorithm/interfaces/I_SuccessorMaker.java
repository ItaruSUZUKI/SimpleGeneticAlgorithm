package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

import java.util.List;

/**
 * SuccessorMakerから返された次世代の遺伝子の元になる遺伝子から，次世代の遺伝子群を返すクラス
 * @author ital
 *
 */
public interface I_SuccessorMaker {
	List<I_Gene> makeSuccessors(Integer size, List<I_Gene> geneList);
}
