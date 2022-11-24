<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!	//JSP page Scripting Elements
	//선언부(메소드)
	public int add(int num1, int num2){
		return num1+num2;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Script Elements 스크립트 요소</title>
</head>
<body>
<%	//Scriptlet 스크립트릿(java code)
	int result=add(10,30);
%>
덧셈1:<%= result%> <br>
덧셈2:<%= add(20,50) %>

</body>
</html>