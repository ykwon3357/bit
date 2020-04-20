package org.comstudy21.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class InputView extends View {
	
	@Override
	public void display() {
		JPanel pane = new JPanel(new GridLayout(7,1));
		JPanel pane2 = new JPanel(new GridLayout(1,1));
		JPanel pane3 = new JPanel(new GridLayout(1,1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		ButtonGroup g = new ButtonGroup();
		JRadioButton male = new JRadioButton("남");
		JRadioButton female = new JRadioButton("여");
		String[] grade = {"gold","silver","bronze"};
		JComboBox<String> grade2 = new JComboBox<>(grade);
		JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		
		p1.add(new JLabel("성     명:   "));
		p1.add(nameField);
		p2.add(new JLabel("이 메 일:  "));
		p2.add(emailField);
		p3.add(new JLabel("전화번호:"));
		p3.add(phoneField);
		p4.add(noLabel);
		
		g.add(male);
		g.add(female);
		
		pane.add(p4);
		pane.add(p1);
		pane.add(p2);
		pane.add(p3);
		pane2.add(male);
		pane2.add(female);
		pane.add(pane2);
		pane.add(grade2);
		pane3.add(slider);
		//pane.add(pane3);
		
		
		add(pane);
	}

}
