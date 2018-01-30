/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package ProductMaster;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static Constants.UI_PRODUCT.*;
import static Constants.NUMBER.FONT_SIZE;
import Constants.TableConstants.CATEGORY_MASTER;
import Database.Reader.Reader;
import Database.Reader.SqlHolder;
import Database.Reader.Select.Select;
import Menu.UI_Menu;


/**
 * [処理概要]商品マスタ登録のユーザーインターフェースを生成します。
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 鶴田雄基
 * @since 2018年01月18日
 * @version 1.0
 */
public class UI_Product extends JPanel {

    private static JPanel productPanel = new JPanel();
    private JTextField productIDText;
    private JTextField productNameText;
    private JTextField buyPriceText;
    private JTextField sellPriceText;
    private JComboBox categoryIDCmb;

    public UI_Product() {
        setLayout(null);

        productPanel.setBounds(0, 0, 684, 441);
        productPanel.setLayout(null);

        JButton checkBtn = new JButton(CONFIRMATION.getText());
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<JTextField> inputList = Arrays.asList(
                        productIDText, productNameText,
                        buyPriceText, sellPriceText);

                DTO_Product vrbDto = new DTO_Product(
                        productIDText.getText(),
                        categoryIDCmb.getSelectedItem().toString(),
                        productNameText.getText(),
                        buyPriceText.getText(),
                        sellPriceText.getText(),
                        inputList);
                
                BL_Product vrbBl = new BL_Product(vrbDto);
            }
        });
        checkBtn.setBounds(217, 370, 91, 21);
        productPanel.add(checkBtn);

        JLabel productTopLabel = new JLabel(PRODUCT_MASTER_REGISTRATION.getText());
        productTopLabel.setSize(new Dimension(72, 19));
        productTopLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
        productTopLabel.setAlignmentY(0.0f);
        productTopLabel.setAlignmentX(0.5f);
        productTopLabel.setBounds(285, 33, 80, 47);
        productTopLabel.setSize(productTopLabel.getPreferredSize());
        productPanel.add(productTopLabel);

        JLabel productIDLabel = new JLabel(PRODUCT_ID.getText());
        productIDLabel.setSize(new Dimension(72, 19));
        productIDLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, 18));
        productIDLabel.setAlignmentY(0.0f);
        productIDLabel.setAlignmentX(0.5f);
        productIDLabel.setBounds(217, 116, 76, 19);
        productIDLabel.setSize(productIDLabel.getPreferredSize());
        productPanel.add(productIDLabel);

        JLabel categoryIDLabel = new JLabel(CATEGORY_ID.getText());
        categoryIDLabel.setSize(new Dimension(72, 19));
        categoryIDLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
        categoryIDLabel.setAlignmentY(0.0f);
        categoryIDLabel.setAlignmentX(0.5f);
        categoryIDLabel.setBounds(217, 161, 76, 19);
        categoryIDLabel.setSize(categoryIDLabel.getPreferredSize());
        productPanel.add(categoryIDLabel);

        JLabel productNameLabel = new JLabel(PRODUCT_NAME.getText());
        productNameLabel.setSize(new Dimension(72, 19));
        productNameLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
        productNameLabel.setAlignmentY(0.0f);
        productNameLabel.setAlignmentX(0.5f);
        productNameLabel.setBounds(217, 209, 76, 19);
        productNameLabel.setSize(productNameLabel.getPreferredSize());
        productPanel.add(productNameLabel);

        JLabel inputPriceLabel = new JLabel(BUYING_PRICE.getText());
        inputPriceLabel.setSize(new Dimension(72, 19));
        inputPriceLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
        inputPriceLabel.setAlignmentY(0.0f);
        inputPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPriceLabel.setBounds(217, 257, 76, 19);
        inputPriceLabel.setSize(inputPriceLabel.getPreferredSize());
        productPanel.add(inputPriceLabel);

        JLabel outputPriceLabel = new JLabel(SELLING_PRICE.getText());
        outputPriceLabel.setSize(new Dimension(72, 19));
        outputPriceLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
        outputPriceLabel.setAlignmentY(0.0f);
        outputPriceLabel.setAlignmentX(0.5f);
        outputPriceLabel.setBounds(217, 305, 76, 19);
        outputPriceLabel.setSize(outputPriceLabel.getPreferredSize());
        productPanel.add(outputPriceLabel);

        productIDText = new JTextField();
        productIDText.setColumns(10);
        productIDText.setBounds(392, 118, 96, 19);
        productPanel.add(productIDText);

        productNameText = new JTextField();
        productNameText.setColumns(10);
        productNameText.setBounds(392, 209, 96, 19);
        productPanel.add(productNameText);

        buyPriceText = new JTextField();
        buyPriceText.setColumns(10);
        buyPriceText.setBounds(392, 259, 96, 19);
        buyPriceText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!isInteger(buyPriceText.getText())) {
                    buyPriceText.setText(null);
                }
            }
        });
        productPanel.add(buyPriceText);

        sellPriceText = new JTextField();
        sellPriceText.setColumns(10);
        sellPriceText.setBounds(392, 307, 96, 19);
        sellPriceText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!isInteger(sellPriceText.getText())) {
                    sellPriceText.setText(null);
                }
            }
        });
        productPanel.add(sellPriceText);

        categoryIDCmb = new JComboBox();
        SqlHolder sh1 = new Select(CATEGORY_MASTER.C_ID.getColumn(), CATEGORY_MASTER.getTableName());
        List<String> id = Reader.read(String.class, sh1);
        String[] array = new String[id.size()];

        categoryIDCmb.setModel(new DefaultComboBoxModel(id.toArray(array)));
        categoryIDCmb.setBounds(392, 163, 96, 19);
        productPanel.add(categoryIDCmb);

        JButton initializeBtn = new JButton(INITIALIZATION.getText());
        initializeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                productIDText.setText(null);
                categoryIDCmb.setSelectedIndex(0);
                productNameText.setText(null);
                buyPriceText.setText(null);
                sellPriceText.setText(null);
            }
        });
        initializeBtn.setBounds(397, 370, 91, 21);
        productPanel.add(initializeBtn);

        JButton backToMenuBtn = new JButton(GO_BACK.getText());
        backToMenuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UI_Menu.getMenuPanel().setVisible(true);
                productPanel.setVisible(false);
            }
        });
        backToMenuBtn.setBounds(397, 401, 91, 21);
        productPanel.add(backToMenuBtn);

    }

    public boolean isInteger(String str) {
        try {
            if (Integer.parseInt(buyPriceText.getText()) < 1) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public JPanel getProductPanel() {
        return productPanel;
    }

}
