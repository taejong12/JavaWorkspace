<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("pageAttr","페이지속성값");
request.setAttribute("reqAttr","요청속성값");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
	<h2>액션태그</h2>
	<jsp:forward page="/06ActionTag/ForwardTarget.jsp" />
</body>
</html>