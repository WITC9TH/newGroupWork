/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

/**
 *
 * [処理概要] 画面で使うフォント関連の定数・処理を定義する
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月29日
 */
public enum FONT {
    UI_GOTHIC("MS UI Gothic");
    final String font;
    private FONT(final String font){
        this.font = font;
    }
    public String getFont(){
        return this.font;
    }
}
