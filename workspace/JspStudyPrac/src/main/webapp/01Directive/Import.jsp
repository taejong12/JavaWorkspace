<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지시어 import</title>
<style>
	body{
	background: yellow;
	color:blue;
	font-size: 2em;}
</style>
</head>
<body>
<%
	Date today=new Date();
	SimpleDateFormat dateFm=new SimpleDateFormat("yyyy-MM-dd");
	String todayS = dateFm.format(today);
	out.println("오늘 날짜:"+todayS);
	//out.println("오늘 날짜:"+dateFm.format(today));
%>

</body>
</html>