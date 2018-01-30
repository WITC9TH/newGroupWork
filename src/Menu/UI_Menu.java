/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */

package Menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CategoryMaster.UI_Category;
import ProductMaster.UI_Product;

import static Constants.UI_MENU.*;
import static Constants.NUMBER.FONT_SIZE;

/**
 * [処理概要]メニュー画面のユーザーインターフェースを生成します。
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 鶴田雄基
 * @since 2018年01月18日
 * @version 1.0
 */

public class UI_Menu {

	private JFrame frame;
	private static JPanel menuPanel = new JPanel();
	private JPanel productPanel = new JPanel();
	private JPanel categoryPanel = new JPanel();
        private JPanel loginPanel = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Menu window = new UI_Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UI_Menu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setSize(new Dimension(700, 480));
		frame.getContentPane().setLayout(null);

		menuPanel.setBounds(0, 0, 684, 441);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);

		UI_Product productVrb = new UI_Product();
		productPanel = productVrb.getProductPanel();
		frame.getContentPane().add(productPanel);
		productPanel.setVisible(false);

		UI_Category categoryVrb = new UI_Category();
		categoryPanel = categoryVrb.getCategoryPanel();
		frame.getContentPane().add(categoryPanel);
		categoryPanel.setVisible(false);
                
		JLabel menuTopLabel = new JLabel(STORAGE_MANAGEMENT.getText());
		menuTopLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
		menuTopLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		menuTopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuTopLabel.setBounds(288, 28, 80, 47);
		menuTopLabel.setSize(menuTopLabel.getPreferredSize());
		menuPanel.add(menuTopLabel);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT.getText());
		String strToday = sdf.format(cal.getTime());

		JLabel todayLabel = new JLabel(strToday);
		todayLabel.setSize(new Dimension(72, 19));
		todayLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
		todayLabel.setAlignmentY(0.0f);
		todayLabel.setAlignmentX(0.5f);
		todayLabel.setBounds(491, 56, 72, 19);
		todayLabel.setSize(todayLabel.getPreferredSize());
		menuPanel.add(todayLabel);

		JLabel masterLabel = new JLabel(MASTER_FUNCTION.getText());
		masterLabel.setSize(new Dimension(72, 19));
		masterLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
		masterLabel.setAlignmentY(0.0f);
		masterLabel.setAlignmentX(0.5f);
		masterLabel.setBounds(48, 74, 72, 19);
		masterLabel.setSize(masterLabel.getPreferredSize());
		menuPanel.add(masterLabel);

		JLabel transactionLabel = new JLabel(TRANSACTION_FUNCTION.getText());
		transactionLabel.setSize(new Dimension(72, 19));
		transactionLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
		transactionLabel.setAlignmentY(0.0f);
		transactionLabel.setAlignmentX(0.5f);
		transactionLabel.setBounds(48, 193, 72, 19);
		transactionLabel.setSize(transactionLabel.getPreferredSize());
		menuPanel.add(transactionLabel);

		JLabel systemLabel = new JLabel(END_SYSTEM.getText());
		systemLabel.setSize(new Dimension(72, 19));
		systemLabel.setFont(new Font(FONT_GOTHIC.getText(), Font.PLAIN, FONT_SIZE.getNumber()));
		systemLabel.setAlignmentY(0.0f);
		systemLabel.setAlignmentX(0.5f);
		systemLabel.setBounds(48, 312, 72, 19);
		systemLabel.setSize(systemLabel.getPreferredSize());
		menuPanel.add(systemLabel);

		JButton userRegistrationButton = new JButton(USER_REGISTRATION.getText());
		userRegistrationButton.setBounds(80, 103, 230, 35);
		menuPanel.add(userRegistrationButton);

		JButton categoryButton = new JButton(CATEGOR_MASTER_REGISTRATION.getText());
		categoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				categoryPanel.setVisible(true);
			}
		});
		categoryButton.setBounds(80, 148, 230, 35);
		menuPanel.add(categoryButton);

		JButton productButton = new JButton(PRODUCT_MASTER_REGISTRATION.getText());
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				productPanel.setVisible(true);
			}
		});
		productButton.setBounds(386, 103, 230, 35);
		menuPanel.add(productButton);

		JButton loginButton = new JButton(LOGIN.getText());
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            menuPanel.setVisible(false);
                            loginPanel.setVisible(true);
			}
		});
		loginButton.setBounds(80, 222, 230, 35);
		menuPanel.add(loginButton);

		JButton inputBuyDataButton = new JButton(BUY_DATA_INPUT.getText());
		inputBuyDataButton.setBounds(386, 222, 230, 35);
		menuPanel.add(inputBuyDataButton);

		JButton inputSellDataButton = new JButton(SELL_DATA_INPUT.getText());
		inputSellDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inputSellDataButton.setBounds(80, 267, 230, 35);
		menuPanel.add(inputSellDataButton);

		JButton checkStockButton = new JButton(CHECK_INDIVIDUAL_ITEM.getText());
		checkStockButton.setBounds(386, 267, 230, 35);
		menuPanel.add(checkStockButton);

		JButton exitButton = new JButton(END_SYSTEM.getText());
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(80, 341, 230, 35);
		menuPanel.add(exitButton);
		frame.setBounds(100, 100, 700, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static JPanel getMenuPanel() {
		return menuPanel;
	}

	public static void setMenuPanel(JPanel menuPanel) {
		UI_Menu.menuPanel = menuPanel;
	}

	public JPanel getProductPanel() {
		return productPanel;
	}

	public void setProductPanel(JPanel productPanel) {
		this.productPanel = productPanel;
	}

	public JPanel getCategoryPanel() {
		return categoryPanel;
	}

	public void setCategoryPanel(JPanel categoryPanel) {
		this.categoryPanel = categoryPanel;
	}

}
