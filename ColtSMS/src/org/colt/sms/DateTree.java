package org.colt.sms;

import javax.swing.JTree;

public class DateTree extends JTree {

	private static final long serialVersionUID = -8861258468014813275L;

	public DateTree() {

		setRootVisible(false);
		setShowsRootHandles(false);
		putClientProperty("JTree.lineStyle", "Horizontal");
		setToggleClickCount(1);

	}
}
