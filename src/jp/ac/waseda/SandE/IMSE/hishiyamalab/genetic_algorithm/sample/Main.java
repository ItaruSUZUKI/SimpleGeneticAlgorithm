package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.sample;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.algorithm.SimpleGeneticAlgorithm;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Environment;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Gene;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_GeneInitializer;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_GeneSelector;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_SuccessorMaker;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.selector.EliteSelector;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.successor_maker.SimpleSuccessorMaker;

public class Main {
	private static void printGene(String message, I_Gene gene) {
		System.out.println(message);
		System.out.format("Score: %d\n", gene.getScore());
		System.out.print("{ ");
		System.out.format("%d", gene.get(0));
		for ( int i = 1; i < gene.getSize(); i++ ){
			System.out.format(", %d", gene.get(i));
		}
		System.out.println(" }");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		I_GeneInitializer initializer = new SampleInitializer();
		I_Environment environment = new SampleEnvironment();
		I_GeneSelector selector = new EliteSelector();
		I_SuccessorMaker successorMaker= new SimpleSuccessorMaker();
		SimpleGeneticAlgorithm simpleGA = new SimpleGeneticAlgorithm(initializer, environment, selector, successorMaker);
		I_Gene gene = simpleGA.run(SampleGene.SIZE, 100);

		printGene("答え", gene);
	}

}
