package org.comstudy21.controller;


public class InsertController implements Controller {

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		
		dao.insert(name,email,phone);
	}

}
