<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Servlet View</title>
</head>
<body>
	<!-- 주소를 직접 입력하면 get 방식 출력
	method를 post 했을 때 post 방식 출력 -->
	<h2>servlet post로 호출</h2>
	<form method="post" action="../13Servlet/ServletView.do">
		<input type="submit" value="post 호출" />
	</form>
</body>
</html>