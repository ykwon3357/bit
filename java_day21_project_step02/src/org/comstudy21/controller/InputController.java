package org.comstudy21.controller;

import javax.swing.JOptionPane;

import org.comstudy21.model.Member;
import org.json.JSONObject;

public class InputController implements Controller {
	public InputController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		Member dto = new Member(0,name,email,phone);
		if(name.equals("")||email.equals("")||phone.equals("")){
			JOptionPane.showMessageDialog(null, "모든 칸을 채워주세요!");
			return;
		}
		dao.insert(dto);

	}

}
