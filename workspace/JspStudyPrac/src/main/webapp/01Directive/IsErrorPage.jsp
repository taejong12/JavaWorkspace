<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<body>
	<h2>서비스 중 일시적인 오류가 발생했습니다.</h2>
	<p>
		오류 : <%= exception.getClass().getName()%> <br> 
		오류 메시지 : <%= exception.getMessage() %> <!-- 앞에 꺽새 뒤에 등호가 들어가면 대입문처럼 나온다 -->
	</p>
</body>
</html>