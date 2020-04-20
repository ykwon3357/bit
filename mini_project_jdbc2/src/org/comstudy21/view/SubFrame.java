package org.comstudy21.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubFrame extends JFrame {
	JPanel content = null;
	
	public SubFrame() {
		content = (JPanel)getContentPane();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ListView listView = new ListView();
		TitleView titleView = new TitleView();
		SubButtonView subButtonView = new SubButtonView();
		InputView inputView = new InputView();
		
		add(BorderLayout.NORTH, titleView);
		add(listView);
		add(BorderLayout.SOUTH, subButtonView);
		add(BorderLayout.WEST, inputView);
		
		setSize(750, 560);
		setVisible(true);
	}
	
	
}
