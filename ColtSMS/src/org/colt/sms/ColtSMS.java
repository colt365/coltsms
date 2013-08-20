package org.colt.sms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class ColtSMS extends JApplet {
	private static final long serialVersionUID = 6339370274731617254L;
	static final String TITLE = "MySMS";
	static Boolean runAsApplet = true;
	static JFrame mainFrame;
	JMenuBar menuBar;
	DateTree dateTree;
	MsgTable msgTable;
	JTextArea smsContent;

	public ColtSMS() {
		// look and feel
		// try {
		// UIManager
		// .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		// SwingUtilities.updateComponentTreeUI(this);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// menuBar
		menuBar = new JMenuBar();

		JMenu tempMenu;
		JMenuItem tempItem;
		// File menu
		tempMenu = new JMenu("File");

		tempMenu.add(tempItem = new JMenuItem("Add...", KeyEvent.VK_A));
		tempItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Add data
			}
		});
		if (!runAsApplet) {
			tempMenu.addSeparator();
			tempMenu.add(tempItem = new JMenuItem("Exit", KeyEvent.VK_E));
			tempItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.dispose();
				}
			});
		}
		menuBar.add(tempMenu);
		// End of File menu

		// Help menu
		tempMenu = new JMenu("Help");

		tempMenu.add(tempItem = new JMenuItem("Help", KeyEvent.VK_H));
		tempItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HelpDialog(mainFrame);
			}
		});
		tempMenu.add(tempItem = new JMenuItem("About", KeyEvent.VK_A));
		tempItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutDialog(mainFrame);
			}
		});
		menuBar.add(tempMenu);
		// End of Help menu

		setJMenuBar(menuBar);
		// End of menuBar

		// mainPanel
		JSplitPane mainPanel = new JSplitPane();
		mainPanel.setDividerSize(5);
		mainPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

		// dateTree
		dateTree = new DateTree();
		JScrollPane datePanel = new JScrollPane(dateTree);
		datePanel.setMinimumSize(new Dimension(100, 200));
		datePanel.setPreferredSize(new Dimension(150, 300));
		mainPanel.setLeftComponent(datePanel);
		// End of dateTree

		// msgPanel
		JSplitPane msgPanel = new JSplitPane();
		msgPanel.setDividerSize(3);
		msgPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		// msgTable
		msgTable = new MsgTable();
		JScrollPane listPanel = new JScrollPane(msgTable);
		listPanel.setMinimumSize(new Dimension(400, 200));
		msgPanel.setTopComponent(listPanel);
		// End of msgTable
		// smsContent
		smsContent = new JTextArea();
		smsContent.setEditable(false);
		smsContent.setLineWrap(true);
		JScrollPane contentPanel = new JScrollPane(smsContent);
		contentPanel.setMinimumSize(new Dimension(0, 100));
		msgPanel.setBottomComponent(contentPanel);
		// End of smsContent
		mainPanel.setRightComponent(msgPanel);
		// End of msgPanel

		setContentPane(mainPanel);
		// End of mainPanel
	}

	@Override
	public void init() {
		setMinimumSize(new Dimension(600, 400));
		setSize(new Dimension(800, 600));
	}

	public static void main(String[] args) {

		JFrame.setDefaultLookAndFeelDecorated(true);

		ColtSMS.runAsApplet = false;
		ColtSMS mainPanel = new ColtSMS();
		mainFrame = new JFrame(TITLE);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setMinimumSize(new Dimension(600, 400));
		mainFrame.setSize(new Dimension(800, 600));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation((screenSize.width - mainFrame.getWidth()) / 2,
				(screenSize.height - mainFrame.getHeight()) / 2);
		mainFrame.setContentPane(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
}