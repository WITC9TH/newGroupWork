/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database;

import Constants.ERROR_MESSAGE;
import static Constants.ERROR_MESSAGE.ABNORMAL_CONNECTION_ENDING;
import static Constants.ERROR_MESSAGE.CANNOT_ESTABLISH_CONNECTION;
import Constants.PROPERTY;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * [処理概要]
 * 全てのデータベースアクセスに共通する処理を提供する
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public class DatabaseUtil {
    private volatile static Connection con = null;

    private DatabaseUtil() {
    }

    /**
     * データベースへの接続を返す
     * @return 
     */
    public static Connection getConnectionInstance() {
        if (DatabaseUtil.con == null) {
            synchronized (DatabaseUtil.class) {
                if (DatabaseUtil.con == null) {
                    DatabaseUtil.con = setUpConnection();
                }
            }
        }
        return DatabaseUtil.con;
    }

    private static Connection setUpConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(PROPERTY.loadAuthInfo());
        } catch (SQLException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_ESTABLISH_CONNECTION);
            e.printStackTrace();
        }

        return con;
    }

    /**
     * AutoCloseable型のインスタンスを可変長引数として受け取り、接続を切断する
     * @param acArray 
     */
    public static void close(AutoCloseable... acArray) {
        for (AutoCloseable ac : acArray) {
            if (ac != null) {
                try {
                    ac.close();
                } catch (Exception e) {
                    ERROR_MESSAGE.showErrorMessage(ABNORMAL_CONNECTION_ENDING);
                    e.printStackTrace();
                }
            }
        }
    }
}
