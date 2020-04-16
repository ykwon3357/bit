package org.comstudy21.controller;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.comstudy21.model.Member;


public class UpdateController implements Controller {

	@Override
	public void service() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("수정할 no 입력: ");
//		int no = sc.nextInt();
//		System.out.print("새 이름 입력: ");
//		String name = sc.next();
//		System.out.print("새 이메일 입력: ");
//		String email = sc.next();
//		System.out.print("새 전화번호 입력: ");
//		String phone = sc.next();
		int no = Integer.parseInt(JOptionPane.showInputDialog("수정할 no 입력: "));
		String name = JOptionPane.showInputDialog("새 이름 입력: ");
		String email = JOptionPane.showInputDialog("새 이메일 입력: ");
		String phone = JOptionPane.showInputDialog("새 전화번호 입력: ");
		dao.update(new Member(no,name,email,phone));
	}

	

}
