package org.comstudy21.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import org.comstudy21.util.jdbcUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class Dao {
	public static Connection con = jdbcUtil.getConnection();
	public static Statement stmt = null;
	public static ResultSet rs =null;
	public static String selectSql = "SELECT * FROM MEMBERS";
	public static PreparedStatement pstmt;
	public static String insertSql = "INSERT INTO MEMBERS(name, email, phone) VALUES(?,?,?)";
	public static String deleteSql = "DELETE FROM MEMBERS WHERE NO=?";
	public static String updateSql = "UPDATE MEMBERS SET name=?, email=?,phone=? WHERE no=?";
	
	public static void setCon(Connection con) {
		Dao.con = con;
	}
	
	public static ArrayList<Member> selectAll() {
		setCon(jdbcUtil.getConnection());
		ArrayList<Member> list = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectSql);
			
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
	
	public static void insert(String name, String email, String phone) {
		setCon(jdbcUtil.getConnection());
		try {
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
//				System.out.println("입력 성공!");
			} else {
//				System.out.println("입력 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}  
	
	public ArrayList<Member> select(Member member) {
		ArrayList<Member> list=selectAll();
		ArrayList<Member> newlist = new ArrayList<Member>();
		for (int i = 0; i < list.size(); i++) {
			Member mem = list.get(i);
			if((member.getName().length()!=0&&mem.getName().indexOf(member.getName())!=-1)
				||(member.getEmail().length()!=0&&mem.getEmail().indexOf(member.getEmail())!=-1)
				||(member.getPhone().length()!=0&&mem.getPhone().indexOf(member.getPhone())!=-1)){
				newlist.add(mem);
				}
		}

		return newlist;
	}
	public void delete(int no) {
		setCon(jdbcUtil.getConnection());
		try {
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				//System.out.println("삭제 완료!");
			}else{
				//System.out.println("삭제 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null) pstmt.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Member member) {
		setCon(jdbcUtil.getConnection());
		try {
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setInt(4, member.getNo());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
//				System.out.println("수정 완료!");
			} else {
//				System.out.println("수정 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



}
