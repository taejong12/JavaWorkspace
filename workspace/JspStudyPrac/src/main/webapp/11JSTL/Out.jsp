<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core out</title>
</head>
<body>
	<c:set var="iTag">
		i 태그는 <i>기울임</i>을 표현합니다.
	</c:set>
	
	<h4>기본 사용</h4>
	<!-- 태그로 처리되지 않았다 -->
	<c:out value="${ iTag }" />
	
	<!-- ${ iTag } -->

	<!-- 기본적으로 escapeXml 이라는 값이 true로 처리가 되고, 
	이 속성은 <, > 와 같은 값들을 &lt;, &gt; 등으로 변경하여 화면에 뿌려주게 된다.
	하지만, 태그를 원하는 대로 뿌려줘야 할 경우도 존재하니 이럴 경우 escapeXml="false" 처리를 해주면 된다.
	&lt;(오른쪽으로 열린 부등호), &gt; 왼쪽으로 열린 부등호
	-->
	<h4>escapeXml 속성</h4>
	<c:out value="${ iTag }" escapeXml="false" />
	
	<h4>default 속성</h4>
	
	<!-- 네임에 적어서 넘겨주면 그 값이 나오고 값이 없으면 디폴트값 설정 되어있는 값이 들어간다 -->
	<c:out value="${ param.name }" default="이름 없음" />
	
	<!-- "" null이 아니라 그냥 빈값이다
	아무것도 넣지 않았지만 할당이 되어있는 상태 -->
	<c:out value="" default="빈 문자열도 값입니다." />
	
	<!-- jsp 작성할 때 주의사항
	여러가지 언어가 섞여있다 한개의 페이지로 만들 때 실행되는 순서가 있어서 주의해야 한다 -->
	
</body>
</html>