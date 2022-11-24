<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Annotation mapping</title>
</head>
<body>
	<h3>annotation 매핑</h3>
	
	<!-- el은 null 값이 들어오면 출력 안한다-->
	<h4>${message}</h4>
	
	<!-- web.xml이 아닌 다른곳(@WebServlet("/13Serblet/AnnoMapping.do"))에서 
	받기 위해  request.getContextPath() 찍어줬다  -->
	<a href="<%= request.getContextPath() %>/13Servlet/AnnoMapping.do">바로가기</a>
	<!--
		request.getContextPath() 작성 이유
		오류상에 대비를 위해서
		내부적으로 링크를 탈수 있지만
		url 앞 쪽에 있는
		해당하는 주소값을 프로젝트 주소까지 제대로 인식을 못할 수 있어서 작성
	-->
	
	
	
</body>
</html>