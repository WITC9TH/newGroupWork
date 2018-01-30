/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants.TableConstants;

import static Constants.ERROR_MESSAGE.PASS_ENUM_ONLY;
import java.lang.reflect.Field;

/**
 * [処理概要] テーブル関連の列挙型に共通する処理を定義する
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public interface TABLES {

    static <T> String getTableName(final Class<T> clazz) {
        String tableName = null;

        if (clazz.isEnum()) {
            tableName = clazz.getSimpleName();
        } else {
            throwIllegalArgumentException();
        }

        return tableName;
    }

    static <T> String getAllColumnsWithComma(final Class<T> clazz) {
        StringBuilder sb = new StringBuilder();

        if (clazz.isEnum()) {
            Field[] fields = clazz.getFields();
            int commaNum = fields.length - 1;

            try {
                for (int i = 0; i < commaNum; i++) {
                    Field field = fields[i];
                    sb.append(field.get(field));
                    sb.append(",");
                }
                sb.append(fields[commaNum].get(fields[commaNum]));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    static void throwIllegalArgumentException() {
        try {
            throw new IllegalArgumentException(PASS_ENUM_ONLY.getString());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
