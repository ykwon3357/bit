package org.comstudy21.evt_handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import org.comstudy21.resource.R;
import org.comstudy21.view.ListView;

public class MouseEventHandler implements MouseListener, R {
 ListView target=null;
 //mouse click이랑 release랑 유사한 기능을 하지만
 //click은 가끔 기능이 안먹을때가 있어서 release 사용추천
 @Override
 public void mouseReleased(MouseEvent e) {
	 if(e.getSource() instanceof JTable){
		 JTable table = (JTable)e.getSource();
		 table.getSelectedRow();
		 int row = table.getSelectedRow();
		 int column = table.getSelectedColumn();
		 //System.out.println(dm.getValueAt(row, column));
		 nameField.setText(dm.getValueAt(row, 1).toString());
		 emailField.setText(dm.getValueAt(row, 2).toString());
		 phoneField.setText(dm.getValueAt(row, 3).toString());
		 noLabel.setText("no: "+dm.getValueAt(row, 0).toString());
	 }
	 /*
  JTable table = target.table;

  int row = table.getSelectedRow();
  int column = table.getSelectedColumn();
  
//  System.out.print(dm.getValueAt(row, 0) +", ");
//  System.out.print(dm.getValueAt(row, 1) +", ");
//  System.out.print(dm.getValueAt(row, 2) +", ");
//  System.out.println(dm.getValueAt(row, 3));
  
  nameField.setText((String) dm.getValueAt(row, 1));
  emailField.setText((String) dm.getValueAt(row, 2));
  phoneField.setText((String) dm.getValueAt(row, 3));
  noLabel.setText(dm.getValueAt(row, 0).toString());
*/
 }

 public MouseEventHandler(ListView target) {
  this.target = target;
 }

 @Override
 public void mouseClicked(MouseEvent e) {

 }

 @Override
 public void mousePressed(MouseEvent e) {
 }

 @Override
 public void mouseEntered(MouseEvent e) {
 }

 @Override
 public void mouseExited(MouseEvent e) {
 }

}
