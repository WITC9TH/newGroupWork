/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Reader.Select;

import Database.Reader.SqlHolder;

/**
 * [処理概要]
 * WHERE句付きでSELECT文を実行する際にSQL文を保持するクラス
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public class SelectWhere extends SqlHolder {
    private String conditionColumn = null;
    private String conditionValue = null;
    
    /**
     * WHERE句付きでSELECT文を実行する際にSQL文を保持するインスタンスのコンストラクタ
     * @param column　欲しいデータがあるコラム
     * @param table   欲しいデータがあるテーブル
     * @param conditionColumn　検索条件に使うカラム。WHERE句の左辺
     * @param conditionValue   検索条件に使う値。WHERE句の右辺
     */
    public SelectWhere(final String column, final String table, 
                            final String conditionColumn, final String conditionValue){
        super(column, table);
        this.conditionColumn = conditionColumn;
        this.conditionValue = conditionValue;
        setSql(composeSqlStatement());
    }
    
    @Override
    protected String composeSqlStatement() { 
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(getColumn());
        sql.append(" FROM ");
        sql.append(getTable());
        sql.append(" WHERE ");
        sql.append(this.conditionColumn);
        sql.append(" = '");
        sql.append(this.conditionValue);
        sql.append("'");
        return sql.toString();
    }
}
