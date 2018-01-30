/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants.TableConstants;

/**
 * [処理概要]
 * 商品マスタテーブルに関する定数と処理を定義する
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public enum PRODUCT_MASTER implements TABLES {
    P_ID,
    C_ID,
    P_NAME,
    BUY_PRICE,
    SELL_PRICE,
    CREATE_DATE,
    CREATE_USER;
 
    public static String getTableName(){
        return TABLES.getTableName(PRODUCT_MASTER.class);
    }
    
    public static String getPrimaryKey() {
        return P_ID.getColumn();
    }
    
    public static String getForeingKey() {
        return C_ID.getColumn();
    }
    
    public static String getAllColumnsWithComma(){
        return TABLES.getAllColumnsWithComma(PRODUCT_MASTER.class);
    }
    
    public String getColumn() {
        return this.name();
    }
}
