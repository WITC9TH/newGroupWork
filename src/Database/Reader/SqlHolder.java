/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Reader;

/**
 * [処理概要] データベースの検索を行う際に必要なSQL文を保持するクラスの抽象クラス
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public abstract class SqlHolder {

    private String sql = null;
    private String column = null;
    private String table = null;

    protected SqlHolder(final String column, final String table) {
        this.column = column;
        this.table = table;
    }

    public String getSql() {
        return this.sql;
    }

    public String getColumn() {
        return this.column;
    }

    public String getTable() {
        return this.table;
    }

    protected void setSql(final String sql) {
        this.sql = sql;
    }

    /**
     * 実行したいSQL文を返す
     * @return 
     */
    protected abstract String composeSqlStatement();
}
