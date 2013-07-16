package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.selector;

import java.util.ArrayList;
import java.util.List;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Environment;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Gene;
import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_GeneSelector;

/**
 * 適応度の高い順に2つの遺伝子を選択するエリート選択を表すクラス
 * @author ital
 *
 */
public class EliteSelector implements I_GeneSelector {
	private I_Environment environment;
	private I_Gene top;
	private I_Gene second;


	@Override
	public void setEnvironment(I_Environment env) {
		this.environment = env;
	}

	@Override
	public I_Environment getEnvironment() {
		return this.environment;
	}

	private void scoringGene(List<I_Gene> geneList){
		for ( I_Gene gene : geneList ){
			gene.setScore( this.environment.score(gene) );
		}
	}

	private void setTop2(I_Gene gene0, I_Gene gene1){
		if ( gene0.getScore() > gene1.getScore() ){
			this.top    = gene0;
			this.second = gene1;
		} else {
			this.top    = gene1;
			this.second = gene0;
		}
	}

	private void newTop(I_Gene gene) {
		this.second = this.top;
		this.top    = gene;
	}

	private void newSecond(I_Gene gene){
		this.second = gene;
	}

	private Boolean biggerThanTop(I_Gene gene){
		return gene.getScore() >= this.top.getScore();
	}

	private Boolean biggerThanSecond(I_Gene gene){
		return gene.getScore() >= this.second.getScore();
	}

	private void update(I_Gene gene){
		if ( biggerThanTop(gene) ){
			this.newTop(gene);
		} else if ( biggerThanSecond(gene) ){
			this.newSecond(gene);
		}
	}

	private void selectTop2(List<I_Gene> geneList){
		setTop2( geneList.get(0), geneList.get(1) );
		for ( int i = 2; i < geneList.size(); i++ ){
			this.update(geneList.get(i));
		}
	}

	private List<I_Gene> getTop2(){
		List<I_Gene> result = new ArrayList<I_Gene>(2);
		result.add(this.top);  result.add(this.second);
		return result;
	}


	@Override
	public List<I_Gene> selectGene(List<I_Gene> geneList) {
		scoringGene(geneList);
		selectTop2(geneList);
		return getTop2();
	}

}
