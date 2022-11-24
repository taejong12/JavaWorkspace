<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core redirect</title>
</head>
<body>

	<c:set var="reqVar" value="park" scope="request" /> 
	<!-- Redirect 그쪽 방향으로 이동하는 것 저장할 일이 없음 -->
	
	<c:redirect url="/11JSTL/inc/OtherPage.jsp"> 
		<c:param name="param1" value="orange" />
		<c:param name="param2" value="lemon" />
	</c:redirect>
	
	<!-- 포워딩은 해당 화면에서 리퀘스트를 받으면 그대로 보내니까 같은 리퀘스트 영역
	리퀘스트가 받은걸 계속 다시 쓰고 있으니까 동일한 리퀘세트 영역
	리스폰스.포워드
	
	리다이렉트 리퀘스트를 하면 리스폰스를 마무리하고 고객에게 간다
	재리퀘스트를 다시한다
	
	해당 페이지에 포워딩이나 임포트
	
	리다이렉트는 화면을 이동시킨다 -->
	
</body>
</html>