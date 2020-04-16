package org.comstudy21.controller;

import java.util.ArrayList;

import org.comstudy21.model.Member;
import org.comstudy21.resource.R;

public class ListController implements Controller, R{

	@Override
	public void service() {
		ArrayList<Member> list = dao.selectAll();
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
