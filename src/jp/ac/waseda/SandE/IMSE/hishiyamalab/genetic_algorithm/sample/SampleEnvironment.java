package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.sample;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Environment;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Gene;

/**
 * 遺伝子が適応すべき環境は，20の数字のうちの幾つかを選んで，その和を499に近づけるというものである．
 * 遺伝子の長さは20で，その遺伝子座はそれぞれの数字に対応している．
 * 遺伝子が0なら数字は選択されず，1なら選択される．
 * 適応度は，目標と遺伝子が表す数字の集合の和との差が小さいほど大きくなる．
 *
 *
 * @author ital
 *
 */
public class SampleEnvironment implements I_Environment {
	public static final int[] NUMBERS = {
		 31,  41,  59,  26,  53,
		 58,  97,  93,  23,  84,
		-62, -64, -33, -83, -27,
		-95,  -2, -88, -41, -97
	};
	public static final int TARGET = 499;

	@Override
	public Integer score(I_Gene gene) {
		Integer score = 0;
		for ( int i = 0; i < gene.getSize(); i++ ){
			score += gene.get(i) * NUMBERS[i];
		}
		return TARGET - Math.abs( TARGET - score );
	}

}
