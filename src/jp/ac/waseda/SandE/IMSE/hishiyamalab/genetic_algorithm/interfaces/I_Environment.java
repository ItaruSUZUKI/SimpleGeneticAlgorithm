package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

/**
 * 環境を表すインタフェース．遺伝子の適応度を計算して返す．
 *
 * @author ital
 *
 */
public interface I_Environment {
	Integer score(I_Gene gene);
}
