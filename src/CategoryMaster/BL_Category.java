/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package CategoryMaster;

import static Constants.NUMBER.INDEX_PRIMARY_KEY;
import static Constants.TEXT.ADMIN;
import static Constants.TableConstants.CATEGORY_MASTER.C_ID;
import static Constants.TableConstants.CATEGORY_MASTER.getTableName;
import Constants.REGEX;
import Constants.TableConstants.CATEGORY_MASTER;
import AbstractClass.BusinessLogic;
import Database.Writer.DatabaseWriter;
import Database.Writer.Insert.InsertedData;
import Database.Writer.Insert.InsertedTable;
import Database.Writer.Insert.PreparedStatementForInsert;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * [処理概要]
 * 商品マスター画面における基幹処理を行う
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月19日
 * @version 1.0
 */
public class BL_Category extends BusinessLogic {
    DTO_Category dto = null;
    public BL_Category (DTO_Category dto){
        super(dto);
        this.dto = dto;
        facade();
    }

    @Override
    protected boolean callIsValidInput() {
        return isValidInput(REGEX.REGEX_CATEGORY_ID.getRegex(),INDEX_PRIMARY_KEY.getNumber(),C_ID.getColumn(),getTableName());
    }

    @Override
    protected void processNormally() {
        List<String> varcharValues = new ArrayList<>();
        varcharValues.add(dto.getCategoryId());
        varcharValues.add(dto.getCategoryName());
        varcharValues.add(ADMIN.getText());
 
        List<Integer> intValues = new ArrayList<>();
         
        List<Timestamp> timestampValues = new ArrayList<>();
        timestampValues.add(new Timestamp(new Date().getTime()));
 
        InsertedData id = new InsertedData(varcharValues, intValues, timestampValues);
        InsertedTable it =
                new InsertedTable(CATEGORY_MASTER.getTableName(), CATEGORY_MASTER.getAllColumnsWithComma(), CATEGORY_MASTER.getPrimaryKey(), dto.getCategoryId());
 
        DatabaseWriter.write(new PreparedStatementForInsert(it, id));
    }
}