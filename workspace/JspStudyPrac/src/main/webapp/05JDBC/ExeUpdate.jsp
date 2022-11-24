<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.PreparedStatement" %>    
<%@ page import="java.sql.Connection" %>      
<%@ page import="common.JDBConnect" %>    
<%@ page import="common.JDBConnPool" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가 수정 삭제</title>
</head>
<body>
	<h2>회원 추가</h2>
	<%
	//JDBConnect jdbc = new JDBConnect();
	JDBConnPool jdbcp = new JDBConnPool();
	
	String id="test3";
	String pw="9999";
	String name="시험대상1";
	
	String sql="insert into member values(?,?,?,sysdate)";
	// PreparedStatement psmt = jdbc.con.prepareStatement(sql);
	PreparedStatement psmt1 = jdbcp.con.prepareStatement(sql);
	// psmt.setString(1,id);
	// psmt.setString(2,pw);
	// psmt.setString(3,name);
	psmt1.setString(1,id);
	psmt1.setString(2,pw);
	psmt1.setString(3,name);
	
	//int res = psmt.executeUpdate();
	int res = psmt1.executeUpdate();
	out.println(res+"행 입력");
	
	//jdbc.close();
	jdbcp.close();
	
	%>

</body>
</html>