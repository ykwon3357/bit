package org.comstudy21.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
	public static Connection getConnection() {

		try {
			Class.forName("org.h2.Driver");//h2 jar - org.h2패키지 - driver클래스 우클릭 copy qulified name 후 .class 지우기
			String url = "jdbc:h2:tcp://localhost/~/test";
			String user = "sa";
			String password = "";
			Connection con = DriverManager.getConnection(url, user, password);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 커넥션 실패!");
			e.printStackTrace();
		}
		return null;
	}

	
	public static Connection getConnection(String driver, String url, String user, String password) {

		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 커넥션 실패!");
			e.printStackTrace();
		}
		return null;
	}

}
