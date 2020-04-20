package org.comstudy21.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.comstudy21.evt_handler.ButtonEventHandler;

public class SubButtonView extends ButtonView {
	public JPanel pane;
	public JButton allBtn;
	public JButton searchBtn;
	public JButton cancelBtn;
	@Override
	public void display() {
		pane = new JPanel();
		allBtn = new JButton("전체보기");
		searchBtn = new JButton("검색");
		cancelBtn = new JButton("취소");
		
		pane.add(allBtn);
		pane.add(searchBtn);
		pane.add(cancelBtn);
		
		add(pane);
		
		ButtonEventHandler handler = new ButtonEventHandler(this);
	    allBtn.addActionListener(handler);
		searchBtn.addActionListener(handler);;
		cancelBtn.addActionListener(handler);;

	}
}
