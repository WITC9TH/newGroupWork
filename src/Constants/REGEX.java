/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

/**
 *[処理概要]
 *  正規表現を定数として保持する
 * @author  株式会社ワールドインテック SI事業部 東京営業所 池田裕斗
 * @since   2018年01月18日
 * @version 1.0
 */
public enum REGEX {
    REGEX_PRODUCT_ID("^[0-9]{0,4}+$"),
    REGEX_CATEGORY_ID("^[0-9]{0,3}+$");
    
    private final String regex;
    private REGEX(final String regex){
        this.regex=regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
