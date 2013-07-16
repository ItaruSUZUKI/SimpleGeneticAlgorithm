package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.simple_genetic_algorithm;

import java.util.List;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.I_Environment;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.I_Gene;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.I_GeneInitializer;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.I_GeneticAlgorithm;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.I_SuccessorMaker;

public class SimpleGeneticAlgorithm implements I_GeneticAlgorithm {
	private I_GeneInitializer initer ;
	private I_SuccessorMaker maker;
	private I_Environment environment;

	@Override
	public void setInitializer(I_GeneInitializer initializer) {
		this.initer = initializer;
	}

	@Override
	public I_GeneInitializer getInitializer() {
		return this.initer;
	}

	@Override
	public void setSuccessorMaker(I_SuccessorMaker maker) {
		this.maker = maker;
	}

	@Override
	public I_SuccessorMaker getSuccessorMaker() {
		return this.maker;
	}

	@Override
	public void setEnvironment(I_Environment env) {
		this.environment = env;
	}

	@Override
	public I_Environment getEnvironment() {
		return this.environment;
	}

	@Override
	public List<I_Gene> run(Integer numberOfGeneration) {
		List<I_Gene> initGenes = this.initer.makeInitGenes();
		return null;
	}

}
