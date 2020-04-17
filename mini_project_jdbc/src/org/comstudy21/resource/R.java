package org.comstudy21.resource;

import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.comstudy21.controller.DeleteController;
import org.comstudy21.controller.InsertController;
import org.comstudy21.controller.ListController;
import org.comstudy21.controller.SearchController;
import org.comstudy21.controller.UpdateController;
import org.comstudy21.model.Dao;

public interface R {
	DefaultTableModel dm = new DefaultTableModel(10,4);
	Vector<String> columnIdentifiers = new Vector<>();
	
	JTextField nameField = new JTextField(12);
	JTextField emailField = new JTextField(12);
	JTextField phoneField = new JTextField(12);
	JLabel noLabel =new JLabel("NO: ");
	
	//hashMap으로 바꿔보기
	ListController listController = new ListController();
	InsertController insertController = new InsertController();
	SearchController searchController = new SearchController();
	UpdateController updateController = new UpdateController();
	DeleteController deleteController = new DeleteController();
	
	//싱글톤으로 바꾸기
	Dao dao = new Dao();
	Map mapper = new Map(100);

}
