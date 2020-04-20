package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.comstudy21.util.jdbcUtil;

public class DaoUser {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	String SQL_SELECT_ALL = "SELECT * FROM USER";
	String SQL_SELECT5 = "SELECT * FROM USER WHERE SID=?";
	String SQL_SELECT6 = "SELECT * FROM USER WHERE SNAME=? AND SBIRTH=?";
	String SQL_SELECT7 = "SELECT * FROM USER WHERE SID=? AND SNAME=? AND SBIRTH=?";
	String SQL_SELECT1 = "SELECT * FROM USER WHERE SID=? AND SPW=?";
	String SQL_SELECT = "SELECT * FROM USER WHERE NO=?";
	String SQL_SELECT2 = "SELECT * FROM USER WHERE NAME LIKE '%'||?||'%'";
	String SQL_SELECT3 = "SELECT * FROM USER WHERE NAME LIKE '%'||?||'%' or EMAIL LIKE '%'||?||'%'";
	String SQL_SELECT4 = "SELECT * FROM USER WHERE NAME LIKE '%'||?||'%' AND EMAIL LIKE '%'||?||'%' AND PHONE LIKE '%'||?||'%'";
	String SQL_INSERT = "INSERT INTO USER(SID,SPW,SNAME,SBIRTH,SPHONE) VALUES (?,?,?,?,?)";
	String SQL_UPDATE = "UPDATE USER SET NAME=?, EMAIL=?, PHONE=? WHERE NO=?";
	String SQL_DELETE = "DELETE FROM USER WHERE NO=?";

	public DaoUser() {

	}

	public void setConnection(Connection connection) {
		this.conn = connection;
	}

	public boolean LogInList_Chk(String sID, String sPW) {
		conn = jdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL_SELECT1);
			pstmt.setString(1, sID);
			pstmt.setString(2, sPW);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (sID.equals(rs.getString("sid")) && sPW.equals(rs.getString("spw"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean RepetiteID(String sid) // 아이디 중복 확인
	{
		conn = jdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL_SELECT5);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (sid.equals(rs.getString("sid"))) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public String FindIdValue(String sname, String sbirth) {
		String sid = "";
		
		conn = jdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL_SELECT6);
			pstmt.setString(1, sname);
			pstmt.setString(2, sbirth);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (sname.equals(rs.getString("sname")) && sbirth.equals(rs.getString("sbirth"))) {
					return rs.getString("sid");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return sid;
	}
	
	public String FindPwValue(String sId, String sname, String sbirth) {
		String spw = "";
		conn = jdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL_SELECT7);
			pstmt.setString(1, sId);
			pstmt.setString(2, sname);
			pstmt.setString(3, sbirth);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (sId.equals(rs.getString("sId")) &&sname.equals(rs.getString("sname")) && sbirth.equals(rs.getString("sbirth"))) {
					return rs.getString("spw");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return spw;
	}

	public Vector<Vector> selectAll() {
		conn = jdbcUtil.getConnection();
		Vector<Vector> vector = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_ALL);
			vector = new Vector<Vector>();
			while (rs.next()) {
				Vector v = new Vector<>();
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sid"));
				v.add(rs.getString("spw"));
				v.add(rs.getString("sName"));
				v.add(rs.getString("sBirth"));
				v.add(rs.getString("sPhone"));
				vector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vector;
	}

	public Vector<Vector> select(int snum) {
		conn = jdbcUtil.getConnection();
		Vector<Vector> vector = null;
		try {
			pstmt = conn.prepareStatement(SQL_SELECT);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();
			vector = new Vector<>();
			while (rs.next()) {
				Vector v = new Vector<>();
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sid"));
				v.add(rs.getString("spw"));
				v.add(rs.getString("sName"));
				v.add(rs.getString("sBirth"));
				v.add(rs.getString("sPhone"));
				vector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vector;
	}

	public Vector<Vector> select(String sName) {
		conn = jdbcUtil.getConnection();
		Vector<Vector> vector = null;
		try {
			pstmt = conn.prepareStatement(SQL_SELECT2);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			vector = new Vector<>();
			while (rs.next()) {
				Vector v = new Vector<>();
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sid"));
				v.add(rs.getString("spw"));
				v.add(rs.getString("sName"));
				v.add(rs.getString("sBirth"));
				v.add(rs.getString("sPhone"));
				vector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vector;
	}

	public Vector<Vector> select(String sName, String sPhone) {
		conn = jdbcUtil.getConnection();
		Vector<Vector> vector = null;

		try {
			pstmt = conn.prepareStatement(SQL_SELECT3);
			pstmt.setString(1, sName);
			pstmt.setString(2, sPhone);
			rs = pstmt.executeQuery();
			vector = new Vector<>();
			while (rs.next()) {
				Vector v = new Vector<>();
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sid"));
				v.add(rs.getString("spw"));
				v.add(rs.getString("sName"));
				v.add(rs.getString("sBirth"));
				v.add(rs.getString("sPhone"));
				vector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vector;
	}

	public Vector<Vector> select(String sid, String sName, String sPhone) {
		conn = jdbcUtil.getConnection();
		Vector<Vector> vector = null;

		try {
			pstmt = conn.prepareStatement(SQL_SELECT4);
			pstmt.setString(1, sid);
			pstmt.setString(2, sName);
			pstmt.setString(3, sPhone);
			rs = pstmt.executeQuery();
			vector = new Vector<>();
			while (rs.next()) {
				Vector v = new Vector<>();
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sid"));
				v.add(rs.getString("spw"));
				v.add(rs.getString("sName"));
				v.add(rs.getString("sBirth"));
				v.add(rs.getString("sPhone"));
				vector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vector;
	}

	public void insert(User dto) {
		conn = jdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, dto.getSid());
			pstmt.setString(2, dto.getSpw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getPhone());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("입력 성공!");
			} else {
				System.out.println("입력 실패!");
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

	public void update(Member dto) {
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setInt(4, dto.getNo());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				// System.out.println("수정 완료!");
			} else {
				// System.out.println("수정 실패!");
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

	public void delete(Member dto) {
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, dto.getNo());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				// System.out.println("삭제 완료!");
			} else {
				// System.out.println("삭제 실패!");
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

}
