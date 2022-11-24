package common;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;

public class JDBConnect {
public Connection con;
public Statement stmt; //작성할때부터
public PreparedStatement psmt;
public ResultSet rs;

//인자를 안받고 직접 메소드 안에서 넣음
	public JDBConnect() {
		try {
			//jdbc driver load
			Class.forName("oracle.jdbc.OracleDriver");
			//db connect
			String url="jdbc:oracle:thin:@localhost:1521:xe"; //서버 url = 호스트이름, 포트, 호스아이디
			String id ="project";
			String pw ="1234";
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("DB 연결 성공(기본)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//인자값을 따로 입력받아서 할 때.
	public JDBConnect(String driver,String url, String id, String pw) {
		try {
			//jdbc driver load
			Class.forName(driver);
			//db connect
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("DB 연결 성공(인자)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//web.xml(배포설명자)DD 에 아예 넣어놓은 파라미터로 커넥트
	public JDBConnect(ServletContext application) {
		try {
			//jdbc driver load
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);
			//db connect
			String url=application.getInitParameter("OracleUrl");
			String id =application.getInitParameter("OracleId");
			String pw =application.getInitParameter("OraclePw");
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("DB 연결 성공(초기화 매개변수)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
			System.out.println("DB 연결 해제");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
