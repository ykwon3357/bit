package org.comstudy21.controller;

import org.comstudy21.model.Member;

public class UpdateController implements Controller {

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		int no = Integer.parseInt(noLabel.getText().substring("No: ".length()));
		dao.update(new Member(no,name,email,phone));
		

	}

}
