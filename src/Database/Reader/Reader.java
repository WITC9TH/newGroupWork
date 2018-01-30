/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Reader;


import static Constants.ERROR_MESSAGE.CANNOT_READ_DATABASE;
import static Constants.ERROR_MESSAGE.ILLEGAL_VALUE_TYPE;
import Constants.ERROR_MESSAGE;
import Database.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * [処理概要] SQL文を受け取り、データベースの検索を行う
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public class Reader {

    /**
     * 第一引数にT型のクラスインスタンス、第二引数にSqlHolderのインスタンスを持つ
     * T型には検索結果の値の型を指定する
     * 第二引数は検索条件をフィールドとして持つ
     * @param <T>       ある一つのクラスを型引数に持つ。このシステムにおいては、String型・int型・Timestamp型のどれか。実行時に決まる
     * @param clazz     Tがどんなクラスなのかに関するデータ
     * @param holder    実行したい検索を行うSQLを保持するインスタンス　
     * @return          検索結果を返す
     */
    public static <T> List<T> read(final Class<T> clazz, final SqlHolder holder) {

        List<T> list = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DatabaseUtil.getConnectionInstance();
            ps = con.prepareStatement(holder.getSql());
            rs = ps.executeQuery();
            list = retrieveItem(rs, clazz, holder.getColumn());

        } catch (SQLException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_READ_DATABASE);
            e.printStackTrace();
        }

        return list;
    }

    private static <T> List<T> retrieveItem(
            final ResultSet rs, final Class<T> clazz, final String column) throws SQLException {
        List<T> list = new ArrayList<>();
        if (clazz == String.class) {
            while (rs.next()) {
                list.add(clazz.cast(rs.getString(column)));
            }

        } else if (clazz == Integer.class) {
            while (rs.next()) {
                list.add(clazz.cast(rs.getInt(column)));
            }

        } else if (clazz == Timestamp.class) {
            while (rs.next()) {
                list.add(clazz.cast(rs.getTimestamp(column)));
            }

        } else {
            try {
                throw new IllegalArgumentException(ILLEGAL_VALUE_TYPE.getString());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
