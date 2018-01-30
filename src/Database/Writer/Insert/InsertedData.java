/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Writer.Insert;

import java.sql.Timestamp;
import java.util.List;

/**
 * [処理概要]データベースに追加するデータを保持するクラス
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public class InsertedData {
    private List<String> varcharValues = null;
    private List<Integer> intValues = null;
    private List<Timestamp> timestampValues = null;

    /**
     * データベースに挿入するデータを保持するインスタンスを作るコンストラクタ
     * @param varcharValues　挿入するデータのうち、varchar型として保存される値
     * @param intValues　挿入するデータのうち、Int型として保存される値
     * @param timestampValues 挿入するデータのうち、Timestamp型として保存される値
     */
    public InsertedData (final List<String> varcharValues, final List<Integer> intValues, final List<Timestamp> timestampValues){
        this.varcharValues = varcharValues;
        this.intValues = intValues;
        this.timestampValues = timestampValues;
    }
    
    public List<String> getVarcharValues() {
        return varcharValues;
    }

    public List<Integer> getIntValues() {
        return intValues;
    }

    public List<Timestamp> getTimestampValues() {
        return timestampValues;
    }
}
