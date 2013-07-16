package jp.ac.waseda.SandE.IMSE.hishiyamalab.genetic_algorithm.interfaces;

/**
 * 遺伝子を表すインタフェース．遺伝子は整数の配列として表現される．
 *
 *
 * @author ital
 *
 */
public interface I_Gene extends Comparable<I_Gene> {
	/**
	 * 遺伝子の長さを返す
	 * @return 遺伝子の長さ
	 */
	Integer getSize();
	/**
	 * 遺伝子の値を返す
	 * @param position 取得したい遺伝子の位置
	 * @return 遺伝子の値
	 */
	Integer get(Integer position);

	/**
	 * 環境によって計算された適応度を設定する
	 * @param score 遺伝子の適応度
	 */
	void setScore(Integer score);
	/**
	 * 遺伝子の適応度を取得する
	 * @return 遺伝子の適応度
	 */
	Integer getScore();

	/**
	 * この遺伝子を元にして新たな遺伝子を作るメソッド．
	 * 値を書き換えるのではなく，新たな遺伝子インスタンスを作るべき
	 * @return 新たな遺伝子
	 */
	I_Gene mutate();

	/**
	 * 2つの遺伝子を交叉させて新たな遺伝子を作るメソッド
	 * 値を書き換えるのではなく，新たな遺伝子インスタンスを作るべき
	 * @param gene 交叉のためのもう一方の遺伝子
	 * @return 新たな遺伝子
	 */
	I_Gene cross(I_Gene gene);
}
