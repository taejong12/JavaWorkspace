<%@page import="connectPool.Connect"%>
<%@page import="connectPool.ConnectPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>test</h2>
<%
	Connect connect = new Connect();
	connect.close();
%>

<%
	ConnectPool pool = new ConnectPool();
	pool.close();
%>
</body>
</html>