<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core forTokens</title>
</head>
<body>

<!--  
스트링 토그나이저 클래스
this
is
a
test
구분들을 반복으로 찍는다
설정이 없으면 공백을 기준으로 구분해줌
delim 구분자를 말함
delim 기준으로 쪼개줌
구분자를 기준으로 토크나이저 기준으로 쪼개주고 토크나이저 객체로 받아줌
스트링 일반문자열을 쪼개서 별도의 하나하나의 토큰으로 만들어준다
반복문으로 하나하나의 토큰을 불러올 수 있다
문법 <c:forTokens items="" delims=""></c:forTokens>
forTokens은 반복문하고 합쳐져 있다
 -->
 	<%-- StringTokenizer 클래스 --%>
	<%
	String rainbow="red,orange,yellow,green,blue,navy,purple";
	%>			
	<c:forTokens items="<%=rainbow %>" delims="," var="color"> 
		<span style="color:${color};">${color}</span>
	</c:forTokens>
	


</body>
</html>