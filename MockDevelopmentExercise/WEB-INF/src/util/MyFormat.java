/* プログラム名:MyFormat.java
 * プログラムの説明:価格表示フォーマット設定用
 * 作成者:近藤　佳吾
 * 作成日時:2022/05/16
 */
package util;

import java.text.NumberFormat;

public class MyFormat {

	public String moneyFormat(int price) {

		// フォーマット作成用NumberFormat
		NumberFormat nf = NumberFormat.getNumberInstance();

		nf.setGroupingUsed(true);// グルーピング
		nf.setMaximumFractionDigits(0);// 数値の小数部分で許可される最大桁数
		nf.setMinimumFractionDigits(0);// 数値の小数部分で許可される最低桁数
		return "\\" + nf.format(price);
	}
}
