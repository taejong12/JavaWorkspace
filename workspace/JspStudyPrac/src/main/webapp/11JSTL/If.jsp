<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core if</title>
</head>
<body>
	<!-- 변수 선언 -->
	<c:set var="number" value="100" />
	<c:set var="string" value="JSP" />
	
	
	<!--<c:if test="${ string eq 'Java' }">
		문자열은 Java입니다.<br/>
	</c:if>
	<c:if test="${ string eq 'JSP' }">
		문자열은 JSP입니다.<br/>
	</c:if>-->
	

	
	<c:if test="${ number mod 2 eq 0 }" var="result" scope="request">
		${ number }는 짝수입니다. <br/>
	</c:if>
	result : ${ result } <br />
	
	<c:if test="${ string eq 'Java' }" var="result2">
		 문자열은 Java입니다.<br/>
	</c:if>
	<c:if test="${ not result2 }" >
		'Java'가 아닙니다. <br/>
	</c:if>
	
	<c:if test="100" var="result3">
		EL이 아닌 정수를 지정하면 false
	</c:if>
	result3 : ${ result3 } <br />
	<c:if test="tRuE" var="result4">
		대소문자 구분 없이 "tRuE"인 경우 true <br />
 	</c:if>
 	result4 : ${ result4 } <br />
 	<c:if test=" ${ true } " var="result5">
 		EL 양쪽에 빈 공백이 있는 경우 false <br />
 	</c:if>
 	result5 : ${ result5 } <br />
	
</body>
</html>

<!-- 변수 선언하는건 조건절에서 활용하기 위해서

프리픽스:if 변수 3가지 
해당영역
조건절에서 나온 결과값

3개의 속성값 
트루가 되면 태그 사이에 있는 값이 result에 저장한다 그 영역이 request

출력은 따로 적어야 한다

false면 저장하지 않고 넘어간다

바 값이 존재하면 해당하는 값을 바 값에 저장하고
바 값이 존재하지 않으면 그대로 출력한다



 변수 3가지 
 test=조건절
 조건절을 쓸 때는 EL 구문 안에 적어야 한다
 일반적인 true false를 적어도 되지만 고정값이기도 하고 가능은 하지만 일반적으로 안쓴다
 
 해당하는 test 값이 트루면 var 값에 저장
 false면 false가 저장된다
 
 EL이 아닌 정수를 지정하면 false
 
 EL 양쪽에 " " 사이에 빈 공백이 있는 경우 false -->
 