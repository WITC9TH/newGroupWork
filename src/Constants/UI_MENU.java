/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

/**
 * [処理概要] メニュー画面に表示する、文字列定数・処理を定義する
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月29日
 */
public enum UI_MENU {
    STORAGE_MANAGEMENT("在庫管理"),
    DATE_FORMAT("yyyy/MM/dd"),
    MASTER_FUNCTION("マスタ機能"),
    TRANSACTION_FUNCTION("トランザクション機能"),
    END_SYSTEM("システム終了"),
    USER_REGISTRATION("ユーザー登録"),
    CATEGOR_MASTER_REGISTRATION("分類マスタ登録"),
    PRODUCT_MASTER_REGISTRATION("商品マスタ登録"),
    LOGIN("ログイン"),
    BUY_DATA_INPUT("仕入れデータ入力"),
    SELL_DATA_INPUT("売上データ入力"),
    CHECK_INDIVIDUAL_ITEM("在庫確認(商品別)"),
    FONT_GOTHIC("MS UI Gothic");
    
    
    private final String text;
    private UI_MENU(final String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
}
