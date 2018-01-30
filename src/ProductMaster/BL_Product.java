/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package ProductMaster;

import AbstractClass.BusinessLogic;

import static Constants.TableConstants.PRODUCT_MASTER.*;
import static Constants.REGEX.REGEX_PRODUCT_ID;
import static Constants.NUMBER.*;
import static Constants.TEXT.ADMIN;
import Constants.TableConstants.PRODUCT_MASTER;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

import Database.Writer.Insert.InsertedData;
import Database.Writer.Insert.InsertedTable;
import Database.Writer.DatabaseWriter;
import Database.Writer.Insert.PreparedStatementForInsert;


/**
 * [処理概要] 商品マスタ機能の処理を行う
 *
 * @author 株式会社ワールドインテック SI事業部 東京営業所　池田　裕斗
 * @since 2018年01月25日
 * @version 1.0
 */
public class BL_Product extends BusinessLogic {

    private DTO_Product dto = null;

    public BL_Product(DTO_Product dto) {
        super(dto);
        this.dto = dto;
        facade();
    }

    @Override 
    protected boolean callIsValidInput() {
        return isValidInput(REGEX_PRODUCT_ID.getRegex(), INDEX_PRODUCT_PRIMARY_KEY.getNumber(), P_ID.getColumn(), getTableName());
    }

    @Override
    protected void processNormally() {
        List<String> varcharValues = new ArrayList<>();
        List<Timestamp> timestampValues = new ArrayList<>();
        List<Integer> intValues = new ArrayList<>();
        varcharValues.add(dto.getProductId());
        varcharValues.add(dto.getCategoryId());
        varcharValues.add(dto.getProductName());
        varcharValues.add(ADMIN.getText());

        intValues.add(Integer.parseInt(dto.getBuyPrice()));
        intValues.add(Integer.parseInt(dto.getSellPrice()));

        timestampValues.add(new Timestamp(new Date().getTime()));

        InsertedData id = new InsertedData(varcharValues, intValues, timestampValues);
        InsertedTable it = new InsertedTable(PRODUCT_MASTER.getTableName(), PRODUCT_MASTER.getAllColumnsWithComma(),
                PRODUCT_MASTER.getPrimaryKey(), dto.getProductId());
        DatabaseWriter.write(new PreparedStatementForInsert(it, id));
    }
}
