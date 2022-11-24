package connectPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
	
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public Connect() {
		try {
			// jdbc driver load
			Class.forName("oracle.jdbc.OracleDriver");
			// db connect
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "project";
			String pw = "1234";
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 성공(기본)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();
			System.out.println("DB 연결 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}

