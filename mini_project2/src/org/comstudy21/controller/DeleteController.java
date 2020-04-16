package org.comstudy21.controller;

import org.comstudy21.model.Member;

public class DeleteController implements Controller {

	@Override
	public void service() {
		int no = Integer.parseInt(noLabel.getText().substring(3).trim());
		dao.delete(no);
	}

}
