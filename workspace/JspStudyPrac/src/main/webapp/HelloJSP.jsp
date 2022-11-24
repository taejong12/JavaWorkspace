<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- Page 지시어 -->>
<%
	String str1="JSP";
	String str2="Hello";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h2>안녕하세요. Java servlet page</h2>
	<p>
		<%out.println(str2+str1+" study!!"); %>
	</p>
	
	
</body>
</html>