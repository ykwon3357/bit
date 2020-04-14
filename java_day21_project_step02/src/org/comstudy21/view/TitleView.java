package org.comstudy21.view;

import java.awt.Font;

import javax.swing.JLabel;

public class TitleView extends View {
	public TitleView() {
		init();
	}

	@Override
	public void init() {
		JLabel title = new JLabel("::: Customer Management System :::");
		title.setFont(new Font("궁서체", Font.BOLD, 28));
		this.add(title);
	}

	@Override
	public void start() {

	}

}
