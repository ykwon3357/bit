package org.comstudy21.controller;

import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ListController implements Controller {

	public ListController() {

	}

	@Override
	public void service() {
		Vector<Vector> dataList = dao.selectAll();

		if (dataList != null) {
//			while (dm.getRowCount() > 0) {
//				dm.removeRow(0);
//			}
//
//			for (Vector rowData : dataList) {
//				dm.addRow(rowData);
//			}
			dm.setDataVector(dataList, columnNames);
		} else {
			System.out.println("출력 할 데이터가 없습니다!");
		}
		
		dm.addTableModelListener(new TableModelListener(){
			
			@Override
			public void tableChanged(TableModelEvent e){
//				System.out.println("tableChanged...");
			}
		});

	}

	public void test() {
		// Vector rowData = new Vector<>();
		// rowData.add(0);
		// rowData.add("test");
		// rowData.add("test@a.com");
		// rowData.add("010-1111-1111");

		while (dm.getRowCount() > 0) {
			dm.removeRow(0);
		}
		// dm.addRow(rowData);
	}

}
