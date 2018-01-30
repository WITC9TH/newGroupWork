/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package ProductMaster;

import AbstractClass.DTO;
import java.util.List;
import javax.swing.JTextField;

/**
 * [処理概要] 商品マスタ画面で入力されたデータを保持する
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月21日
 * @version 1.0
 */
public class DTO_Product extends DTO {
    private String productId = null;
    private String categoryId = null;
    private String productName = null;
    private String buyPrice = null;
    private String sellPrice = null;

   public DTO_Product(final String productId,final String categoryId, final String productName, 
                        final String buyPrice, final String sellPrice, final List<JTextField> jTextFieldArray) {
        super(jTextFieldArray);
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

}
