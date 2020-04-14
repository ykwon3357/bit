package org.comstudy21.controller;

import java.util.Vector;

import org.comstudy21.model.Member;

public class SearchController implements Controller {

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		
		Member member = new Member(0,name,email,phone);
		
		Vector<Vector> dataVector = dao.select(member);
		
		dm.setDataVector(dataVector, columnNames);
	}

}
