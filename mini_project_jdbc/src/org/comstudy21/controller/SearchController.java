package org.comstudy21.controller;

import java.util.Vector;

public class SearchController implements Controller {

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		if((name.trim()).length()==0&&(email.trim()).length()==0&&(phone.trim()).length()==0){
			System.out.println("검색 할 내용이 없습니다!");
			return;
		}
		Vector<Vector> dataVector = null;
		if((name.trim()).length()!=0&&(email.trim()).length()!=0&&(phone.trim()).length()!=0){
			dataVector=dao.select(name,email,phone);
		}else if((name.trim()).length()!=0&&(email.trim()).length()!=0&&(phone.trim()).length()==0){
			dataVector=dao.select(name,email);
		}else if((name.trim()).length()!=0&&(email.trim()).length()==0&&(phone.trim()).length()==0){
			dataVector=dao.select(name);
		}
		
		dm.setDataVector(dataVector, columnIdentifiers);
	}

}
