<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core catch</title>
</head>
<body>

	<%
	int num1=200;
	%>
	<c:catch var="eMsg">
		<%
		int res = num1/0;
		%>
	</c:catch>
	예외: ${eMsg}<br/>
	
	<c:set var="num2" value="400"/>
	<c:catch var="eMsg">
		${"일"+num2}
	</c:catch>
	예외: ${eMsg}
	
</body>
</html>
el은 예외에 관대한 언어
자바에 걸어주는게 좋다
실제로는 잘 안 쓴다 왜냐하면 자바에서 예외처리를 하기 때문에



