/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

import javax.swing.JOptionPane;
import static Constants.ERROR_MESSAGE.*;



/**
 * [処理概要] 定数として保持するエラーメッセージを表示する。
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public enum ERROR_MESSAGE {

    ERROR("エラー"),
    
    CANNOT_FIND_PROPERTY_FILE("プロパティファイルが見つかりませんでした"),
    CANNOT_FIND_DRIVER("ドライバーが見つかりませんでした"),
    
    CANNOT_READ_PROPERTY_FILE("プロパティファイルが読み込めませんでした"),
    CANNOT_READ_DATABASE("データベースからデータが読み込めませんでした"),
    CANNOT_ESTABLISH_CONNECTION("データベースへの接続が確立できませんでした"),    
    ABNORMAL_CONNECTION_ENDING("データベースへの接続が正常に終了しませんでした"),
    
    ILLEGAL_VALUE_TYPE("このプログラムで対応していないデータの種類を、データベースから読み込もうとしています"),
    CANNOT_SET_AUTO_COMMIT_FALSE("自動的にデータベースが更新されてしまう設定(autoCommit)をOFFにできませんでした"),
    
    CANNOT_LOAD_SQL("SQL文が読み込めませんでした"),
    CANNOT_SET_VALUES_TO_SQL("SQL文に値がセットできませんでした"),
    CANNOT_UPDATE_DATABASE("データベースが更新できませんでした"),
    ERROR_IS_NULL("エラー:入力されていない項目があります"),
    ERROR_WRONG_INPUT("エラー:入力内容に誤りがあります"),
    ERROR_ALREADY_EXISTS("エラー:入力したIDは既に登録済みです"),
    PASS_ENUM_ONLY("このメソッドの引数には、列挙型以外渡さないでください");
    
    
    private final String message;

    ERROR_MESSAGE(final String message) {
        this.message = message;
    }

    /**
     * ENUMの値を返す
     * @return 
     */
    public String getString() {
        return this.message;
    }

    /**
     * 引数として受け取った列挙型をエラーメッセージとして表示する
     * @param errorMessage 
     */
    public static void showErrorMessage(final ERROR_MESSAGE msg) {
        JOptionPane.showMessageDialog(null, msg.getString(), ERROR.getString(), JOptionPane.ERROR_MESSAGE);
    }
}
