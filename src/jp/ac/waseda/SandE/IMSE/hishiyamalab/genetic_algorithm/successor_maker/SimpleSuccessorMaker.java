package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.successor_maker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Gene;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_SuccessorMaker;

public class SimpleSuccessorMaker implements I_SuccessorMaker {
	private static final Random rnd = new Random();

	/**
	 * 上位2つの遺伝子を残す．
	 * 残りの部分には2つの遺伝子を交叉した結果を入れる．
	 * そして，上位2つの遺伝子以外から1つ選んで突然変異させる．
	 */
	@Override
	public List<I_Gene> makeSuccessors(Integer size, List<I_Gene> geneList) {
		List<I_Gene> result = new ArrayList<I_Gene>(geneList.size());
		I_Gene top = geneList.get(0);
		I_Gene snd = geneList.get(1);

		result.add(top);  result.add(snd);
		for ( int i = 2; i < size; i++ ){
			result.add( top.cross(snd) );
		}

		Integer mutateTarget = rnd.nextInt(size - 2) + 2;
		result.set(mutateTarget, result.get(mutateTarget).mutate());

		return result;
	}
}
