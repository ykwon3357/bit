package org.comstudy21.dbselect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.util.jdbcUtil;

public class DbSelectEx2 {
	public static Connection con = jdbcUtil.getConnection();
	// statement : 서술하다
	public static Statement stmt = null;
	public static ResultSet rs =null;
	public static String sql = "SELECT * FROM MEMBERS";
	
	public static void setCon(Connection con) {
		DbSelectEx2.con = con;
	}
	//Dao로 가정한다.
	public static ArrayList<Member> selectAll() {
		ArrayList<Member> list = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			list= new ArrayList<Member>();
			while(rs.next()){
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				//System.out.printf("%d | %s | %s | %s\n",no,name,email,phone);
				Member newMem = new Member(no, name, email, phone);
				list.add(newMem);
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
		//중요: 결과를 리턴한다.
		return list;
	}
	
	//Controller 로 가정
	public static void main(String[] args) {
		ArrayList<Member> list = selectAll();
		for(Member mem : list){
			System.out.println(mem);
		}
	}

}
