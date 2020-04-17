package org.comstudy21.controller;

import org.comstudy21.model.Member;

public class DeleteController implements Controller {

	@Override
	public void service() {
		int no = Integer.parseInt(noLabel.getText().substring("No: ".length()));
		dao.delete(new Member(no,null,null,null));
	}

}
