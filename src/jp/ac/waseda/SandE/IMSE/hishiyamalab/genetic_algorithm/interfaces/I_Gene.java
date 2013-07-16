package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

public interface I_Gene extends Comparable<I_Gene> {
	Integer getSize();
	Integer get(Integer position);

	void setScore(Integer score);
	Integer getScore();

	I_Gene mutate();

	I_Gene cross(I_Gene gene);
}
