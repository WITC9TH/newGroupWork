/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package AbstractClass;

import static Constants.ERROR_MESSAGE.ERROR_ALREADY_EXISTS;
import static Constants.ERROR_MESSAGE.ERROR_IS_NULL;
import static Constants.ERROR_MESSAGE.ERROR_WRONG_INPUT;
import static Constants.ERROR_MESSAGE.showErrorMessage;
import Constants.ERROR_MESSAGE;
import Database.Reader.Reader;
import Database.Reader.Select.Select;
import java.awt.Color;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * [処理概要] 各ビジネスロジックに共通する処理を提供する
 *
 * @author 株式会社ワールドインテック SI事業部 東京営業所 池田　裕斗
 * @since 2018年01月18日
 * @version 1.0
 */
public abstract class BusinessLogic {

    protected List<JTextField> allJTextField;

    protected BusinessLogic(DTO dto) {
        this.allJTextField = dto.getAllJTextField();
    }

    /**
     * 入力が正だったら、通常処理を行う。どんな入力が正か、何が通常クラスであるかは、具象クラスで定める
     */
    protected void facade() {
        if (callIsValidInput()) {
            processNormally();
        }
    }

    /**
     * 入力の正・不正を判定するisValidInputに引数を渡す
     * ①正規表現②正規表現で判定する入力欄が、0始まりで数えて画面の上から何番目か③重複チェックに使う、データベースのカラム④重複チェックに使うテーブル名
     * の4点があれば、入力の正・不正は判定できる。が、抽象クラスの段階では渡し値の具体的な値は分からない
     * よって具象クラスでこのcallIsValidInputの中でisValidInputを呼び出し、具体的な値を渡す
     * @return 
     */
    protected abstract boolean callIsValidInput();
    
    /**
     * 入力が正だった際に、正常処理を行う
     */
    protected abstract void    processNormally();

    /**
     * 入力の正・不正を判定する
     * ①正規表現②正規表現で判定する入力欄が、0始まりで数えて画面の上から何番目か③重複チェックする際に使う、データベースのカラム④テーブル名
     * の4点があれば、入力の正・不正は判定できる。が、抽象クラスの段階では渡し値の具体的な値は分からない
     * よって具象クラスのcallIsValidInputの中でこのisValidInputを呼び出し、具体的な値を渡す
     * @param regex　正規表現
     * @param index　正規表現で判定する入力欄が、0始まりで数えて画面の上から何番目か
     * @param column　重複チェックする際に使う、データベースのカラム
     * @param table　重複チェックに使うテーブル名
     * @return 
     */
    protected boolean isValidInput(final String regex, final int index,
            final String column, final String table) {

        boolean isValidInput = true;
        List<String> idList = Reader.read(String.class, new Select(column, table));
        for (int i = 0; i < this.allJTextField.size(); i++) {
            JTextField jTextField = this.allJTextField.get(i);

            if (jTextField.getText().isEmpty()) {
                processInvalidInput(ERROR_IS_NULL, jTextField);
                isValidInput = false;
            }

            if (i == index) {
                boolean isIndexInput = isValidIndexValue(regex, idList, jTextField); 
                if(isValidInput){
                    isValidInput = isIndexInput;
                }
            }
        }
        return isValidInput;
    }

    private void processInvalidInput(final ERROR_MESSAGE msg, final JTextField jTextField) {
        showErrorMessage(msg);
        paintLineBorder(jTextField);
    }

    public void paintLineBorder(JTextField jTextField) {
        jTextField.setBorder(new LineBorder(Color.RED));
    }

    private boolean isValidIndexValue(final String regex, final List<String> idList, final JTextField jTextField) {
        boolean isValidIndexValue = true;

        if (!isMatch(regex, jTextField)) {
            processInvalidInput(ERROR_WRONG_INPUT, jTextField);
            isValidIndexValue = false;
        }

        if (idList.contains(jTextField.getText())) {
            processInvalidInput(ERROR_ALREADY_EXISTS, jTextField);
            isValidIndexValue = false;
        }
        
        return isValidIndexValue;
    }

    private boolean isMatch(final String regex, final JTextField target) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target.getText());
        return (matcher.find());
    }

}
