package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces.I_Gene;

public class SampleGene implements I_Gene {

	public static final Integer SIZE = 20;
	private static final Random rnd = new Random();

	private List<Integer> geneList;
	private Integer score;

	public SampleGene(List<Integer> gene){
		this.geneList = gene;
	}

	@Override
	public int compareTo(I_Gene o) {
		return this.getScore() - o.getScore();
	}

	@Override
	public Integer getSize() {
		return SampleGene.SIZE;
	}

	@Override
	public Integer get(Integer position) {
		if ( position < 0 || SIZE <= position ) return 0;
		return this.geneList.get(position);
	}

	@Override
	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public Integer getScore() {
		return this.score;
	}

	@Override
	public I_Gene mutate() {
		Integer pos = rnd.nextInt(SIZE);
		List<Integer> newGene = new ArrayList<Integer>(SIZE);
		for ( int i = 0; i < SIZE; i++ ){
			if ( i == pos ){
				newGene.add( Math.abs( this.geneList.get(i) -1 ) );
			} else {
				newGene.add(this.geneList.get(i));
			}
		}
		return new SampleGene(newGene);
	}

	@Override
	public I_Gene cross(I_Gene gene) {
		List<Integer> newGene = new ArrayList<Integer>(SIZE);
		for ( int i = 0; i < SIZE; i++ ){
			Boolean test = rnd.nextInt() % 2 == 0;
			if ( test ){
				newGene.add( this.geneList.get(i) );
			} else {
				newGene.add( gene.get(i) );
			}
		}
		return new SampleGene(newGene);
	}

}
