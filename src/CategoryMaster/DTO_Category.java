/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package CategoryMaster;

import AbstractClass.DTO;
import java.util.List;
import javax.swing.JTextField;

/**
 * [処理概要]
 * 分類マスタ画面で入力されたデータを保持する
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月21日
 * @version 1.0
 */
public class DTO_Category extends DTO {
    private String categoryId   = null;
    private String categoryName = null;
    
    public DTO_Category(final String categoryId, 
            final String categoryName,final List<JTextField>jTextFieldList){
        super(jTextFieldList);
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
