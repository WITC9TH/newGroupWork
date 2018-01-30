/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */

package CategoryMaster;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Menu.UI_Menu;

import static Constants.UI_CATEGORY.*;
import static Constants.NUMBER.FONT_SIZE;

/**
 * [処理概要]分類マスタ登録のユーザーインターフェースを生成します。
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 鶴田雄基
 * @since 2018年01月18日
 * @version 1.0
 */

public class UI_Category extends JPanel {

	private static JPanel categoryPanel = new JPanel();
	private JTextField categoryIDText;
	private JTextField categoryNameText;

	public UI_Category() {
		setLayout(null);

		categoryPanel.setBounds(0, 0, 684, 441);
		categoryPanel.setLayout(null);

		JButton checkBtn = new JButton(CONFIRMATION.getText());
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> inputList = Arrays.asList(
						categoryIDText, categoryNameText);

				DTO_Category vrbDto = new DTO_Category(
                                    categoryIDText.getText(), categoryNameText.getText(),
                                    inputList);

                            BL_Category vrbBl = new BL_Category(vrbDto);
			}
		});
		checkBtn.setBounds(217, 309, 91, 21);
		categoryPanel.add(checkBtn);

		JLabel categoryTopLabel = new JLabel(CATEGORY_MASTER_REGISTRATION.getText());
		categoryTopLabel.setSize(new Dimension(72, 19));
		categoryTopLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN,FONT_SIZE.getNumber()));
		categoryTopLabel.setAlignmentY(0.0f);
		categoryTopLabel.setAlignmentX(0.5f);
		categoryTopLabel.setBounds(285, 33, 80, 47);
		categoryTopLabel.setSize(categoryTopLabel.getPreferredSize());
		categoryPanel.add(categoryTopLabel);

		JLabel categoryIDLabel = new JLabel(CATEGORY_ID.getText());
		categoryIDLabel.setSize(new Dimension(72, 19));
		categoryIDLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		categoryIDLabel.setAlignmentY(0.0f);
		categoryIDLabel.setAlignmentX(0.5f);
		categoryIDLabel.setBounds(217, 116, 76, 19);
		categoryIDLabel.setSize(categoryIDLabel.getPreferredSize());
		categoryPanel.add(categoryIDLabel);

		JLabel categoryNameLabel = new JLabel(CATEGORY_NAME.getText());
		categoryNameLabel.setSize(new Dimension(72, 19));
		categoryNameLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
		categoryNameLabel.setAlignmentY(0.0f);
		categoryNameLabel.setAlignmentX(0.5f);
		categoryNameLabel.setBounds(217, 161, 76, 19);
		categoryNameLabel.setSize(categoryNameLabel.getPreferredSize());
		categoryPanel.add(categoryNameLabel);

		categoryIDText = new JTextField();
		categoryIDText.setColumns(10);
		categoryIDText.setBounds(392, 118, 96, 19);
		categoryPanel.add(categoryIDText);

		categoryNameText = new JTextField();
		categoryNameText.setColumns(10);
		categoryNameText.setBounds(392, 163, 96, 19);
		categoryPanel.add(categoryNameText);

		JButton initializeBtn = new JButton(INITIALIZATION.getText());
		initializeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoryIDText.setText(null);
				categoryNameText.setText(null);
			}
		});
		initializeBtn.setBounds(397, 309, 91, 21);
		categoryPanel.add(initializeBtn);

		JButton returnToMenuBtn = new JButton(GO_BACK.getText());
		returnToMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI_Menu.getMenuPanel().setVisible(true);
				categoryPanel.setVisible(false);
			}
		});
		returnToMenuBtn.setBounds(397, 355, 91, 21);
		categoryPanel.add(returnToMenuBtn);

	}

	public JPanel getCategoryPanel() {
		return categoryPanel;
	}
}