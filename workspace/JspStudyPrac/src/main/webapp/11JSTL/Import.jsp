<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core import</title>
</head>
<body>
	<!-- request 영역에 같은 변수 값 불러오기-->
	<c:set var="reqVar" value="lee" scope="request" /> 
	
	<!-- import 임포트는 외부에서 나한테 포함시키는 것 -->
	<c:import url="/11JSTL/inc/OtherPage.jsp" var="contents"> 
		<c:param name="param1" value="JSP" />
		<c:param name="param2" value="JAVA" />
	</c:import>
	${contents}
	<c:import url="/11JSTL/inc/OtherPage.jsp"> 
		<c:param name="param1" value="ultra" />
		<c:param name="param2" value="super" />
	</c:import>
	
	<!-- 외부 페이지를 삽입하려고 하는거임 -->
	<iframe src="./inc/OuterPage.jsp" style="width:100%;height:600px;">
	</iframe>
</body>
</html>