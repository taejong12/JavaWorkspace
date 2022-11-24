<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num1=100;
pageContext.setAttribute("num2",97);
pageContext.setAttribute("num3","3");
pageContext.setAttribute("num4","23");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연산자</title>
</head>
<body>
	<h3>변수 선언 및 할당</h3>
	스크립틀릿 선언 ${num1}<br/>
	영역 저장 ${num2}<br/>
	변수 할당 즉시 출력 ${num1=10}<br/>
	변수 할당 이후 출력 ${num1=20;''} =>> ${num1}<br/>
	num1=${num1},num2=${num2},num3=${num3},num4=${num4}
	
	<h3>산술연산자</h3>
	num1+num2=${num1+num2}<br/>
	num1+"34"=${num1+"34"}<br/>
	num2+"이십"=\${num2+"이십"}<br/>
	"삼십"+"이십"=\${"삼십"+"이십"}<br/>
	num1-num2=${num1-num2}<br/>
	num1*num2=${num1*num2}<br/>
	num4/num3=${num4/num3},${num4 div num3}<br/>
	num4%num3=${num4%num3},${num4 mod num3}<br/>
	
	<h3>비교연산자</h3>
	num4>num3 ${num4 gt num3}, ${num4 > num3}<br/>
	num4<num3 ${num4 lt num3}<br/>
	num4>=num3 ${num4 ge num3}<br/>
	num4<=num3 ${num4 le num3}<br/>
	num4==num3 ${num4 eq num3}<br/>
	num4!=num3 ${num4 ne num3}<br/>
	
	<h3>논리 연산자</h3>
	num3 <= num4 && num3 == num4 ${num3 le num4 and num3 eq num4}<br/>
	num3 >= num4 || num3 != num4 ${num3 ge num4 or num3 ne num4}<br/>
		
</body>
</html>