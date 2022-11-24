<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>java beans</title>
</head>
<body>
	<h2>폼값 전달</h2>
	<form method="get" action="UseBeanAction.jsp">
		<label>이름</label>
		<input type="text" name="name" /><br/>
		<label>나이</label>
		<input type="text" name="age" /><br/>
		<input type="submit" value="전송">
	</form>
</body>
</html>