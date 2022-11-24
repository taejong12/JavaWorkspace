package connectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectPool {

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public ConnectPool() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource source=(DataSource)ctx.lookup("dbcp_my_oracle_project");
			
			con=source.getConnection();
			System.out.println("DBCP connect success");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBCP connect fail");
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
			System.out.println("DBCP connection 반납");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
