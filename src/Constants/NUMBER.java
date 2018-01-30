/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

/**
 * [処理概要]
 * 配列やリストの添え字、フォントサイズなどの数字を定数としてまとめる。
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月25日
 * @version 1.0
 */
public enum NUMBER {
    INDEX_EMPTY(0),
    INDEX_ILLEGAL_FORMAT(1),
    
    INDEX_CATEGORY_PRIMARY_KEY(1),
    INDEX_PRODUCT_PRIMARY_KEY(0),
    
    FONT_SIZE(18);
    
    private final int number;
    
    NUMBER(final int number){
        this.number = number;
    }
    
    public int getNumber(){
        return this.number;
    }
}
