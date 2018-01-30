/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

import static Constants.ERROR_MESSAGE.CANNOT_FIND_DRIVER;
import static Constants.ERROR_MESSAGE.CANNOT_FIND_PROPERTY_FILE;
import static Constants.ERROR_MESSAGE.CANNOT_READ_PROPERTY_FILE;
import static Constants.ERROR_MESSAGE.showErrorMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * [処理概要] プロパティファイルにアクセスするための定数・処理を定義する
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public enum PROPERTY {

    DRIVER_NAME("DRIVER_NAME"),
    DATABESE_AUTH_INFO("DATABASE_AUTH_INFO");

    private final String text;

    PROPERTY(final String text) {
        this.text = text;
    }

    private String getString() {
        return this.text;
    }

    private static final String FILE_PATH = "." + File.separator + "src" + File.separator + "DBLogIn.properties";

    /**
     * データベースの認証情報をプロパティファイルから読み込む
     * @return 
     */
    public static String loadAuthInfo() {
        final Properties property = new Properties();
        loadProperty(property);
        loadDriver(property);
        return property.getProperty(DATABESE_AUTH_INFO.getString());
    }

    private static void loadProperty(final Properties property) {
        try (InputStream inputStream = new FileInputStream(PROPERTY.FILE_PATH)) {
            property.load(inputStream);

        } catch (FileNotFoundException e) {
            showErrorMessage(CANNOT_FIND_PROPERTY_FILE);
            e.printStackTrace();

        } catch (IOException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_READ_PROPERTY_FILE);
            e.printStackTrace();
        }
    }

    private static void loadDriver(final Properties property) {
        try {
            Class.forName(property.getProperty(DRIVER_NAME.getString()));

        } catch (ClassNotFoundException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_FIND_DRIVER);
            e.printStackTrace();
        }
    }
}
