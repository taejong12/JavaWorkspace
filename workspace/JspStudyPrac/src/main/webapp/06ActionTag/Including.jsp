<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String incP1="./Out/IncludePage1.jsp";
String incP2="./Out/IncludePage2.jsp";

pageContext.setAttribute("pageAttr","페이지속성");
request.setAttribute("reqAttr","요청속성");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 동작</title>
</head>
<body>
	<h2>지시어 directive</h2>
	<%@ include file="./Out/IncludePage1.jsp" %>
	<%-- <%@ include file="<%=incP1 %>" %> --%>
	<p>외부 파일 변수: 
	<%=var1 %></p>
	
	<h2>액션태그 action tag</h2>
	<jsp:include page="./Out/IncludePage2.jsp" />
	<jsp:include page="<%=incP2 %>" />
	<jsp:include page="<%=incP1 %>" />
	<p>외부 파일 변수: <%-- =var2 --%></p>
	

</body>
</html>