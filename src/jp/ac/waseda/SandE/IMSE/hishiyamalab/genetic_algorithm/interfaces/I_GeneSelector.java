package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

import java.util.List;

/**
 * 遺伝子の組から，次世代に残すべき遺伝子を選んで返すクラスのためのインタフェース
 *
 * @author ital
 *
 */
public interface I_GeneSelector {
	/**
	 * 適応度を計算するために環境を設定する
	 * @param env 環境
	 */
	void setEnvironment(I_Environment env);
	/**
	 * 適応度を計算するために設定された環境を返す
	 * @return
	 */
	I_Environment getEnvironment();
	/**
	 * 次世代に残すべき遺伝子を返すメソッド．少なくとも2つ以上の遺伝子が返されるべき．
	 * @param geneList
	 * @return
	 */
	List<I_Gene> selectGene(List<I_Gene> geneList);
}
