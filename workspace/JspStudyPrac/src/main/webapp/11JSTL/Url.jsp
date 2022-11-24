<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core url</title>
</head>
<body>

	<!-- 화면이동할 때 파라미터 넣어줄 수 있음  -->
	<!--  
	주소값을 가져다가 외부에서 활용
	주소값을 url value에 넣는다
	set은 파라미터를 넘길 수 없다
	-->
	
	<h4>url로 태그 링크</h4>
	<c:url var="url" value="/11JSTL/inc/OtherPage.jsp">
		<c:param name="param1" value="수박" />
		<c:param name="param2" value="당근" />		
	</c:url>
	
	<!-- 우리가 설정해 놓은 url 주소를 이용해서 바로 링크를 걸 수 있다 -->
	<a href="${url}">other page</a>
	
	<!-- url 변수가 저장되어 있고 파라미터도 전달이 된다  -->

</body>
</html>