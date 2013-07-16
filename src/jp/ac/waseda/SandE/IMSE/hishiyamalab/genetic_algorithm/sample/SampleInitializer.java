package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Gene;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_GeneInitializer;

/**
 * 初期化．遺伝子は0と1がランダムに並んだ配列となる．
 * @author ital
 *
 */
public class SampleInitializer implements I_GeneInitializer {
	private static final Random rnd = new Random();

	private I_Gene makeGene(Integer geneSize){
		List<Integer> result = new ArrayList<Integer>(geneSize);
		for ( int i = 0; i < geneSize; i++ ){
			if ( rnd.nextInt() % 2 == 0 ){
				result.add(1);
			} else {
				result.add(0);
			}
		}
		return new SampleGene(result);
	}

	@Override
	public List<I_Gene> makeInitGenes(Integer numOfGene, Integer geneSize) {
		List<I_Gene> result = new ArrayList<I_Gene>(numOfGene);
		for ( int i = 0; i < numOfGene; i++ ){
			result.add( makeGene(geneSize) );
		}
		return result;
	}

}
