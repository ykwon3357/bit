package org.comstudy21.evt_handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import org.comstudy21.resource.R;

public class MouseEventHandler implements MouseListener,R{

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() instanceof JTable){
			JTable table = (JTable)e.getSource();
			int row = table.getSelectedRow();
			
			//System.out.println("row=> "+row);
			nameField.setText(dm.getValueAt(row, 1).toString());
			emailField.setText(dm.getValueAt(row, 2).toString());
			phoneField.setText(dm.getValueAt(row, 3).toString());
			noLabel.setText("NO: "+dm.getValueAt(row, 0));
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	

}
