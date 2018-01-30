/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Writer.Insert;

/**
 * [処理概要] データベースに追加する際に、追加先の情報を保持するクラス
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public class InsertedTable <T> {
    private String table = null;
    private String allColums = null;
    private String searchColumn = null;
    private T searchValue = null;

    /**
     * データベースに追加する際に、追加先の情報を保持するインスタンスを作るコンストラクタ
     * @param table 追加先のテーブル
     * @param allColums　追加先のテーブルの全てのカラム名をコンマ区切りにしてつなげた文字列
     * @param searchColumn　検索に使うカラム
     * @param searchValue 検索に使う値
     */
    public InsertedTable(final String table, final String allColums, final String searchColumn, final T searchValue){
        this.table = table;
        this.allColums = allColums;
        this.searchColumn = searchColumn;
        this.searchValue = searchValue;
    }
    public String getTable() {
        return table;
    }

    public String getAllColums() {
        return allColums;
    }

    public String getSearchColumn() {
        return searchColumn;
    }

    public T getSearchValue() {
        return searchValue;
    }
    
    
}
