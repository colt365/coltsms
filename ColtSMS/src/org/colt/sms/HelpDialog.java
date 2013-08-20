package org.colt.sms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

class HelpDialog extends JDialog {
	private static final long serialVersionUID = 7103640085047203884L;
	JLabel infoLabel;
	JButton okButton;

	public HelpDialog(Frame ownerFrame) {
		super(ownerFrame, true);
		setTitle("Help");
		infoLabel = new JLabel(
				"<html><big><center>MySMS v1.0</center></big><br><br>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;You can add SMSs "
						+ "by using <i style=\"color:blue\">File</i> "
						+ "-- <i style=\"color:blue\">Add...</i>, "
						+ "and view SMSs of the chosen time !</html>");
		infoLabel.setBorder(new EmptyBorder(new Insets(0, 10, 0, 10)));
		JPanel infoPanel = new JPanel(new BorderLayout());
		infoPanel.add(infoLabel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.CENTER);
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		add(buttonPanel, BorderLayout.SOUTH);

		setSize(250, 250);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,
				(screenSize.height - getHeight()) / 2);
		setResizable(false);
		setVisible(true);
	}
}
