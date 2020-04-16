package org.comstudy21.dbselect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.comstudy21.util.jdbcUtil;

public class DbSelectEx {
	
	public static void main(String[] args) {
		Connection con = jdbcUtil.getConnection();
		// statement : 서술하다
		Statement stmt = null;
		ResultSet rs =null;
		String sql = "SELECT * FROM MEMBERS";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				System.out.printf("%d | %s | %s | %s\n",no,name,email,phone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				//닫을 땐 역순으로
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
