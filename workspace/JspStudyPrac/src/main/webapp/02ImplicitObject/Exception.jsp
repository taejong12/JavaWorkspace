<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 exception</title>
</head>
<body>
<%
int status = response.getStatus();

if(status==404){ // not found
	out.print("404 에러 발생");
	out.print("<br/>파일 경로 확인하세요");
} else if(status == 405){ // method not allowed
	out.print("405 에러 발생");
	out.print("<br/>요청 방식(method)을 확인하세요");
} else if(status == 500){ // Internal server error
	out.print("500 에러 발생");
	out.print("<br/>소스 코드의 오류를 확인하세요");
}
%>

</body>
</html>