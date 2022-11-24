<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL formatting</title>
</head>
<body>
	<c:set var="number1" value="12345" />
	콤마 O : <fmt:formatNumber value="${ number1 }" /><br/>

	<!-- groupingUsed="false 콤마가 없어진다 -->
	콤마 X : <fmt:formatNumber value="${ number1 }" groupingUsed="false" /><br/> 
	
	<fmt:formatNumber value="${number1 }" type="currency" var="printNum1" 
						currencySymbol="$"/>
	통화기호 : ${ printNum1 } <br/>
	
	<fmt:formatNumber value="0.03" type="percent" var="printNum2" />
	퍼센트 : ${ printNum2 } <br />
	
	<!--
		pattern 
		패턴 조건 0이 들어가는 조건, #이 들어가는 조건, 2가지 조건
	 	
	 	#은 아무 데이터가 없으면 빈자리
	 	
	 	0은 아무 데이터가 없으면 0이 들어간다
	 	
	 	자리값이랑 들어가는 값을 조절할 수 있다
	 	
	 	뒷에서 숫자가 잘리면 반올림된다
	 -->
	 
	 <!-- 
		 formatNumber 숫자를 표시하는 양식
		 parseNumber 숫자가 아닌 것이 있을 때 숫자로 바꾸는 것 
	 --> 
	 
	<fmt:formatNumber value="132465446.456" pattern="#,#00.000#" /> <br/> 

	<c:set var="number2" value="6,789.01" /> 
	
	<!-- 패턴을 기준으로 해서 숫자만 뽑아낸다 -->
	<fmt:parseNumber value="${ number2 }" pattern="00,000.00" var="printNum3" />
	소수점 : ${ printNum3 } <br/>
	
	<fmt:parseNumber value="${ number2 }" integerOnly="true" var="printNum4" />
	정수부분 : ${ printNum4 } <br/>
	
	
	<c:set var="today" value="<%= new java.util.Date() %>" />
	
	<h4>날짜 포맷</h4>
	full : <fmt:formatDate value="${ today }" type="date" dateStyle="full"/> <br/>
	short : <fmt:formatDate value="${ today }" type="date" dateStyle="short"/> <br/>
	long : <fmt:formatDate value="${ today }" type="date" dateStyle="long"/> <br/>
	default : <fmt:formatDate value="${ today }" type="date" dateStyle="default"/> <br/>
	
	<h4>시간 포맷</h4>
	full : <fmt:formatDate value="${ today }" type="time" dateStyle="full"/> <br/>
	short : <fmt:formatDate value="${ today }" type="time" dateStyle="short"/> <br/>
	long : <fmt:formatDate value="${ today }" type="time" dateStyle="long"/> <br/>
	default : <fmt:formatDate value="${ today }" type="time" dateStyle="default"/> <br/>
	
	
	<h4>날짜/시간 표시</h4>
	<fmt:formatDate value="${ today }" type="both" dateStyle="full" timeStyle="full"/>
	<br/>
	<fmt:formatDate value="${ today }" type="both" pattern="yyy-MM-dd hh:mm:ss"/>
	
	<h4>타임존 설정</h4>
	<fmt:timeZone value="GMT">
		<fmt:formatDate value="${ today }" type="both" dateStyle="full" timeStyle="full"/>
		<br/>
	</fmt:timeZone>
	
	<fmt:timeZone value="America/Chicago">
		<fmt:formatDate value="${ today }" type="both" dateStyle="full" timeStyle="full"/>
	</fmt:timeZone>

	<!-- 
		타입이 날짜, 시간, 둘다 있다
		타임존은 지역
	 -->
	 
	<h4>locale 설정</h4>
	
	한글로 설정 : <fmt:setLocale value="ko_kr" />
	<fmt:formatNumber value="10000" type="currency" /> /
	<fmt:formatDate value="${ today }"/> <br/> 
	
	일어로 설정 : <fmt:setLocale value="ja_JP" />
	<fmt:formatNumber value="10000" type="currency" /> /
	<fmt:formatDate value="${ today }"/> <br/> 
	
	영어로 설정 : <fmt:setLocale value="en_US" />
	<fmt:formatNumber value="10000" type="currency" /> /
	<fmt:formatDate value="${ today }"/> <br/> 
	
	<!-- 
		requestEncoding : 인코딩 타입을 정의
		bundle, message : 메시지 처리
		parseDate : formatDate 반대 개념.
	-->
	
	
	
	
	
	
	
	
</body>
</html>