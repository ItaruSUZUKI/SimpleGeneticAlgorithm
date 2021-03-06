package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.algorithm;

import java.util.List;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Environment;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Gene;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_GeneInitializer;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_GeneSelector;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_GeneticAlgorithm;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_SuccessorMaker;

/**
 * 最も単純な遺伝的アルゴリズムの実装
 *
 * @author ital
 *
 */
public class SimpleGeneticAlgorithm implements I_GeneticAlgorithm {
	private I_GeneInitializer initializer;
	private I_SuccessorMaker  successorMaker;
	private I_GeneSelector    selector;

	/*
	 * このへんのアクセサは使っていない
	 */
	@Override
	public void setInitializer(I_GeneInitializer initializer) {
		this.initializer = initializer;
	}
	@Override
	public I_GeneInitializer getInitializer() {
		return this.initializer;
	}
	@Override
	public void setSuccessorMaker(I_SuccessorMaker maker) {
		this.successorMaker = maker;
	}
	@Override
	public I_SuccessorMaker getSuccessorMaker() {
		return this.successorMaker;
	}
	@Override
	public void setGeneSelector(I_GeneSelector selector) {
		this.selector = selector;
	}
	@Override
	public I_GeneSelector getGeneSelector() {
		return this.selector;
	}

	/**
	 * 必要なクラスをコンストラクタによってすべて初期化
	 * @param initializer 遺伝子を初期化するオブジェクト
	 * @param environment 遺伝子の適応度を計算するオブジェクト
	 * @param selector    次世代に残すべき遺伝子を残すべきオブジェクト
	 * @param successorMaker 次世代の遺伝子群を残すオブジェクト
	 */
	public SimpleGeneticAlgorithm(
			I_GeneInitializer initializer,
			I_Environment environment,
			I_GeneSelector selector,
			I_SuccessorMaker successorMaker
			){
		this.initializer    = initializer;
		this.selector       = selector;
		this.selector.setEnvironment(environment);
		this.successorMaker = successorMaker;
	}

	/*
	 * 遺伝子を表示するためのメソッド
	 */
	private void printGene(String message, I_Gene gene) {
		System.out.println(message);
		System.out.format("Score: %d\n", gene.getScore());
		System.out.print("{ ");
		System.out.format("%d", gene.get(0));
		for ( int i = 1; i < gene.getSize(); i++ ){
			System.out.format(", %d", gene.get(i));
		}
		System.out.println(" }");
	}

	/*
	 * 中間結果を表示するためのメソッド
	 */
	private void printInterimResult( Integer generation, I_Gene top, I_Gene snd ){
		System.out.format("第%d世代\n", generation);
		printGene("トップの遺伝子", top );
		printGene("2位の遺伝子", snd);
		System.out.println();
	}

	/**
	 * 遺伝的アルゴリズムを実行するメソッド
	 */
	@Override
	public I_Gene run(Integer geneSize, Integer numberOfGeneration) {
		List<I_Gene> geneList;
		List<I_Gene> rankedGeneList;

		// 遺伝子を初期化
		geneList = this.initializer.makeInitGenes(numberOfGeneration, geneSize);

		// 初期状態を表示
		for ( I_Gene gene : geneList ){
			printGene("はじめの遺伝子", gene);
		}
		System.out.println();

		// 処理のループを開始
		for ( int generation = 0; ; generation++ ){
			// 最も適応した遺伝子を選択
			rankedGeneList = this.selector.selectGene(geneList);

			// 世代数が規定以上ならここで終了
			if ( generation == numberOfGeneration ) break;

			// 中間結果を出力
			printInterimResult(generation, rankedGeneList.get(0), rankedGeneList.get(1));

			// 次世代を作る
			geneList = this.successorMaker.makeSuccessors(geneSize, rankedGeneList);
		}
		// 最終的な結果を返す
		return rankedGeneList.get(0);
	}




}
