package org.comstudy21.dbselect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.comstudy21.util.jdbcUtil;

public class DbDeleteEx {
	public static Connection conn = jdbcUtil.getConnection();
	public static PreparedStatement pstmt = null;
	public static String sql = "DELETE FROM MEMBERS WHERE NO=?";

	public static void delete(int no) {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("삭제 완료!");
			}else{
				System.out.println("삭제 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		DbSelectEx2.main(null);
		
		System.out.print("삭제 할 no 입력: ");
		int no = DbUpdateEx.sc.nextInt();
		
		delete(no);
		
		//DbSelectEx2에서 con을 public static으로 해놨기 때문에 다시 객체생성해도 초기화안됨
		//따라서 setcon으로 다시 연결해줌
		DbSelectEx2.setCon(jdbcUtil.getConnection());
		DbSelectEx2.main(null);
		
	}

}
