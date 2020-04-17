package org.comstudy21.controller;

import java.util.Vector;

import org.comstudy21.resource.R;

public class ListController implements Controller, R{

	@Override
	public void service() {
		Vector<Vector> dataVector = dao.selectAll();
		dm.setDataVector(dataVector, columnIdentifiers);
	}

}
