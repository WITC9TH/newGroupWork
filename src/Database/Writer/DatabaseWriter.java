/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Writer;

import static Constants.ERROR_MESSAGE.CANNOT_UPDATE_DATABASE;
import static Constants.INFORMATIONAL_MESSAGE.UPDATED_SUCCESSFULLY;
import Constants.ERROR_MESSAGE;
import Constants.INFORMATIONAL_MESSAGE;
import Database.DatabaseUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * [処理概要]
 * データベースへの書き込みを行うクラス
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public class DatabaseWriter {
    /**
     * データベースへの書き込みを行う
     * @param psh PreparedStatementHolder型のインスタンス
     */
    public static void write(final PreparedStatementHolder psh) {
        PreparedStatement pstmt = psh.getPreparedStatement();
        try {
            if (pstmt.executeUpdate() < 0) {
                throw new SQLException();
            }
            pstmt.getConnection().commit();
            INFORMATIONAL_MESSAGE.showInformationalMessage(UPDATED_SUCCESSFULLY.getString());
        } catch (SQLException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_UPDATE_DATABASE);
            e.printStackTrace();
        } finally {
            DatabaseUtil.close(pstmt);
        }
    }
}
