/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

import javax.swing.JOptionPane;

/**
 * [処理概要]
 * ユーザーに向けたメッセージを表示する
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public enum INFORMATIONAL_MESSAGE {
    INFORMATION("情報"),
    UPDATED_SUCCESSFULLY("データベースは正常に更新されました");
    
    private final String message;
    
    private INFORMATIONAL_MESSAGE(final String message){
        this.message = message;
    }
    
    public String getString(){
        return this.message;
    }
    
    /**
     * 処理の正常終了などの、プログラムの進行に関する情報を表示する
     * @param infomationalMessage 
     */
    public static void showInformationalMessage(final String infomationalMessage){
        JOptionPane.showMessageDialog(null, infomationalMessage, INFORMATION.getString(), JOptionPane.INFORMATION_MESSAGE);
    }
}
