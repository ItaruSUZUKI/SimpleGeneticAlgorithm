package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

/**
 * 遺伝的アルゴリズムを表現するクラス
 *
 * 初期化，適応度計算，次世代作成のためのクラスを設定した上で，
 * 遺伝子長と遺伝子群の大きさを渡して遺伝的アルゴリズムを開始する．
 *
 * @author ital
 *
 */
public interface I_GeneticAlgorithm {
	void setInitializer(I_GeneInitializer initializer);
	I_GeneInitializer getInitializer();

	void setSuccessorMaker(I_SuccessorMaker maker);
	I_SuccessorMaker getSuccessorMaker();

	void setGeneSelector(I_GeneSelector selector);
	I_GeneSelector getGeneSelector();

	I_Gene run(Integer geneSize, Integer numberOfGeneration);
}
