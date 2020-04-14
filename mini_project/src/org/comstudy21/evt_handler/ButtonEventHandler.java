package org.comstudy21.evt_handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.comstudy21.view.ButtonView;

import static org.comstudy21.resource.R.*;

public class ButtonEventHandler implements ActionListener{
	ButtonView target;
	
	public ButtonEventHandler(ButtonView buttonView) {
		this.target = buttonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			
			//맵으로 바꾸기
			//키: target.allBtn 
			//밸류: listController.service(); 
			if(btn == target.allBtn){
				System.out.println("전체보기 기능");
				listController.service();
				
			}
			if(btn == target.insertBtn){
				System.out.println("추가 기능");
				insertController.service();
				//추가 후 목록 보기
				listController.service();
			}
			if(btn == target.searchBtn){
				System.out.println("검색 기능");
				searchController.service();
			}
			if(btn == target.deleteBtn){
				System.out.println("삭제 기능");
				deleteController.service();
				listController.service();
			}
			if(btn == target.cancelBtn){
				System.out.println("취소 기능");
				nameField.setText("");
				emailField.setText("");
				phoneField.setText("");
				
			}
		}
		
	}
	

}
