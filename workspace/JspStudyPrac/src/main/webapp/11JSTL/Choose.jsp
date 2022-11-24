<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core choose/when/otherwise</title>
</head>
<body>
	<!-- 변수 선언 -->
	<c:set var="number" value="99" />
	
	<!-- 조건을 넣고 조건에 만족하면 출력하고
	조건이 맞는게 없으면 otherwise 출력-->
	
	<h4>choose</h4>
	<c:choose>
		<c:when test="${ number mod 2 eq 0 }">
			${ number }는 짝수입니다.
		</c:when>
		<c:otherwise>
			${ number }는 홀수입니다.
		</c:otherwise>
	</c:choose>
</body>
</html>


