package org.comstudy21.controller;

import java.util.ArrayList;
import java.util.Vector;

import org.comstudy21.model.Member;

public class SearchController implements Controller {

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		
		Member member = new Member(0,name,email,phone);
		
		ArrayList<Member> list = dao.select(member);
		Object record[] = new Object[4];
		while (dm.getRowCount() > 0) {
			dm.removeRow(0);
		}
		
		for(int i=0;i<list.size();i++){
			Member mem = list.get(i);
			record[0] = mem.getNo();
			record[1] = mem.getName();
			record[2] = mem.getEmail();
			record[3] = mem.getPhone();
			dm.addRow(record);
		}

	}

}
