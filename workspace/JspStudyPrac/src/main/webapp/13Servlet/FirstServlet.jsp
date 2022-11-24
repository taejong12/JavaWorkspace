<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Servlet</title>
</head>
<body>
	<h2>web.xml 매핑 후 출력</h2>
	<h4><%=request.getAttribute("message") %></h4>
	
	<!-- web.xml에서 자바서블릿에 맵핑된 url 주소이므로 바로가기를 누르면
	맵핑된 자바서블릿클래스로 실행이되면서 자바갔다가 온다 -->
	<!-- 처음에는 리퀘스트에 저장된 값이 없어서 null이 나오지만
	바로가기를 누르면 맵핑된 서블릿자바클래스로 간다
	서블릿클래스(servlet.FirstServlet)에 안녕하세요를 
	저장(req.setAttribute("message", "안녕하세요.");) 해서 
	보내주기(req.getRequestDispatcher("/13Servlet/FirstServlet.jsp")
			.forward(req, resp);) 때문에 출력이 된다 -->
	<a href="./FirstServlet.do">바로가기</a>
	
	
</body>
</html>