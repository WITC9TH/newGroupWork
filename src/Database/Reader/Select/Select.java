/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Reader.Select;

import Database.Reader.SqlHolder;

/**
 * [処理概要]
 * WHERE句がないSELECT文を実行する際に、SQL文を保持するクラス
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public class Select extends SqlHolder{
    /**
     * WHERE句がないSELECT文を実行する際に、SQL文を保持するインスタンスを作るコンストラクタ
     * @param column 欲しいデータがあるカラム
     * @param table 欲しいデータがあるテーブル
     */
    public Select(final String column, final String table) {
        super(column,table);
        setSql(composeSqlStatement());
    }

    @Override
    protected String composeSqlStatement() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(getColumn());
        sql.append(" FROM ");
        sql.append(getTable());
        return sql.toString();
    }
}
