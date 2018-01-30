/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Writer;

import static Constants.ERROR_MESSAGE.CANNOT_SET_AUTO_COMMIT_FALSE;
import static Constants.ERROR_MESSAGE.showErrorMessage;
import Database.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * [処理概要]データベースへの書き込み関連の操作を行う際に、PreparedStatementを保持するクラス
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public abstract class PreparedStatementHolder {
    private PreparedStatement preparedStatement = null;
    private Connection con = null;
    
    protected void setPreparedStatement(final PreparedStatement preparedStatement){
        this.preparedStatement = preparedStatement;
    }
    
    public PreparedStatement getPreparedStatement(){
        return this.preparedStatement;
    }
    
    protected Connection getConnection(){
        this.con = DatabaseUtil.getConnectionInstance();
        try{
            con.setAutoCommit(false);
        }catch(SQLException e){
            showErrorMessage(CANNOT_SET_AUTO_COMMIT_FALSE);
            e.printStackTrace();
        }   
        return con;
    }
    
    /**
     * PreparedStatementを返す
     * @return 
     */
    protected abstract PreparedStatement composePreparedStatement();
    
    /**
     * SQL文を返す
     * @return 
     */
    protected abstract String composeSqlStatement();
}
