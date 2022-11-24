<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 영역 forward</title>
</head>
<body>
	<h2>forward request area</h2>
	<% 
	Person rObj = (Person)(request.getAttribute("rObject"));
	request.setCharacterEncoding("UTF-8");
	%>
	<ul>
		<li>문자열:<%=request.getAttribute("rString") %> </li>
		<li>객체:<%=rObj.getName() %>, <%=rObj.getAge() %>  </li>
		<li><%=request.getParameter("com") %></li>
		<li><%=request.getParameter("fill") %></li>
	</ul>
	
	<h2>이동 후 session 속성 값</h2>
	<%
	ArrayList<String> lists = (ArrayList<String>)session.getAttribute("lists");
	for(String list:lists){
		out.print(list+"<br/>");
	}
	%>

</body>
</html>