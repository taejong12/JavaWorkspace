<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/TagLib.tld" %>
<%@ page import="utils.ELUtils" %>
<%
ELUtils util = new ELUtils(); // 객체 생성
pageContext.setAttribute("util", util); // page 영역에 저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 메서드 호출</title>
</head>
<body>
	<h3>1.영역에 저장한 객체의 메서드 호출하기</h3>
	001225-3000000 => ${ util.getGender("001225-3000000") } <br/>
	001225-2000000 => ${ util.getGender("001225-2000000") }
	
	<h3>2.클래스명을 통해 정적 메서드 호출하기</h3>
	${ ELUtils.showGugudan(7) }
	
	<h3>3.TLD 파일 등록 후 정적 메서드 호출하기</h3>
	<ul>
		<!-- 프리픽스 앞쪽 선언 prefix:메서드 -->
		<li>mytag:isNumber("100") => ${ mytag:isNumber("100") }</li>
		<li>mytag:isNumber("이백") => ${ mytag:isNumber("이백") }</li>
	</ul>
</body>
</html>