package org.comstudy21.dbselect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.comstudy21.util.jdbcUtil;

public class DbUpdateEx {
	public static Connection conn = null;
	public static PreparedStatement pstmt;
	public static String sql;
	static {
		sql = "UPDATE MEMBERS SET name=?, email=?,phone=? WHERE no=?";
	}
	public static void setConn(Connection conn) {
		DbUpdateEx.conn = conn;
	}

	public static void update(Member member) {
		String name = "NewName";
		String email = "new@shop.com";
		String phone = "010-100-0000";
		int no = 41;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setInt(4, member.getNo());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("수정 완료!");
			} else {
				System.out.println("수정 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		DbSelectEx2.setCon(jdbcUtil.getConnection());
		DbSelectEx2.main(null);
		System.out.println("------------------------");
		
		System.out.print("수정할 no 입력: ");
		int no = sc.nextInt();
		System.out.print("새 이름 입력: ");
		String name = sc.next();
		System.out.print("새 이메일 입력: ");
		String email = sc.next();
		System.out.print("새 전화번호 입력: ");
		String phone = sc.next();
		
		
		setConn(jdbcUtil.getConnection());
		update(new Member(no,name,email,phone));
		
		//IoC - 제어의 역전
		DbSelectEx2.setCon(jdbcUtil.getConnection());
		DbSelectEx2.main(null);
		
	}

}
