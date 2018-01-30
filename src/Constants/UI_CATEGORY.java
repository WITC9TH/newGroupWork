/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

/**
 * [処理概要] 分類マスタ画面に表示する、文字列定数・処理を定義する
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月29日
 */
public enum UI_CATEGORY {
    CONFIRMATION("確認"),
    FONT_GOTHIC("MS UI Gothic"),
    CATEGORY_ID("分類ID："),
    CATEGORY_NAME("分類名："),
    INITIALIZATION("初期化"),
    GO_BACK("戻る"),
    CATEGORY_MASTER_REGISTRATION("分類マスタ登録");
    
    private final String text;
    private UI_CATEGORY(final String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
}
