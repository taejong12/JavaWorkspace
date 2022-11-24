<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 이동</title>
</head>
<body>
<h2>이동 후 page 영역</h2>
	<%
	Object pInt = pageContext.getAttribute("pInteger");
	Object pStr = pageContext.getAttribute("pString");
	Object pObj = pageContext.getAttribute("pObject");
	%>
	<ul>
		<li>숫자:<%=(pInt==null)? "값이 없음": pInt %></li>
		<li>문자열:<%=(pStr==null)? "값이 없음" : pStr %></li>
		<li>객체:<%=(pObj==null)? "값이 없음": pObj %></li>
	</ul>
</body>
</html>