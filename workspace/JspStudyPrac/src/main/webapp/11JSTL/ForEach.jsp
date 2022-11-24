<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="common.Person"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core foreach</title>
</head>
<body>
	<h4>일반 for문</h4>
	<c:forEach begin="1" end="3" step="1" var="i"> <!-- 시작값 끝값 증감값 변수명 -->
		<p>반복 ${i}</p>
	</c:forEach>
	
	<h4>반복문 속성</h4>
	<table border="1">
	<!-- 시작 끝 증감 1씩 증가하는게 디폴트 변수명 i  varStatus="loop" 반복문 저장-->
	<c:forEach begin="3" end="7" var="i" varStatus="loop"> 
		<tr>
			<td>count:${loop.count}</td> <!-- count : 현재 몇번째 루프인지 값입니다. 1부터 시작합니다. -->
			<td>index:${loop.index}</td> <!-- index : 0부터 시작하는 루프의 인덱스 입니다. -->
			<td>current:${loop.current}</td> <!-- current : 현재 아이템입니다. var 속성의 값과 같습니다. -->
			<td>first:${loop.first}</td> <!-- first : 현재가 첫번째 루프이면 참입니다. -->
			<td>last:${loop.last}</td> <!-- last : 현재가 마지막 루프이면 참입니다. -->
			<td>i:${i}</td>
		</tr>
	</c:forEach>	
	</table>
	
	<h4>1~100까지 정수 중 홀수의 합</h4>
	sum:${sum=0 }
	<table border="1">
		<tr>
			<td>
				<c:forEach begin="1" end="100" step="1" var="i" varStatus="loop">
					<c:if test="${i mod 2 eq 1}" > <!-- i mod 2 ne 0 -->
						i:${i}
						sum:${ sum=sum+i } <br/>
					</c:if>
				</c:forEach>
			</td>
		</tr>
	</table>
	
	<h4>1~100까지 정수 중 홀수의 합</h4>
	<c:set var="sum" value="0" />
	<c:forEach begin="1" end="100" step="1" var="j" varStatus="loop">
		<c:if test="${j mod 2 eq 1}" > <!-- j mod 2 ne 0 -->
			<c:set var="sum" value = "${sum+j}" />
		</c:if>
	</c:forEach>
	1~100까지 홀수의 합은 ${sum}입니다.
			
	<h4>enhanced for문</h4>
	<%
	String[] rainbow={"red","orange","yellow","green","blue","navy","purple"};
	%>			
	<c:forEach items="<%=rainbow %>" var="color"> // items=값 var=변수
		표현식으로 값을 넣고 반복문 찍기
		<span style="color:${color};">${color}</span><br/>
	</c:forEach>
	
	<h4>enhanced for문 반복문 속성</h4>
	<table border="1">
	<!-- 시작 끝 증감 1씩 증가하는게 디폴트 varStatus="loop" 반복문 저장-->
	<c:forEach  items="<%=rainbow %>" var="color" varStatus="loop"> 
		<tr>
			<td>count:${loop.count}</td> <!-- count : 현재 몇번째 루프인지 값입니다. 1부터 시작합니다. -->
			<td>index:${loop.index}</td> <!-- index : 0부터 시작하는 루프의 인덱스 입니다. -->
			<td>current:${loop.current}</td> <!-- current : 현재 아이템입니다. var 속성의 값과 같습니다. -->
			<td>first:${loop.first}</td> <!-- first : 현재가 첫번째 루프이면 참입니다. -->
			<td>last:${loop.last}</td> <!-- last : 현재가 마지막 루프이면 참입니다. -->
		</tr>
	</c:forEach>	
	</table>

	<h2>List</h2>
	<%
	LinkedList<Person> llist = new LinkedList<>();
	llist.add(new Person("이성계", 60));
	llist.add(new Person("이방원", 45));
	llist.add(new Person("이방덕", 50));	
	%>
	<c:set var="lists" value="<%=llist %>" />
	<c:forEach items="${lists}" var="list">
		<p>이름:${list.name} || 나이:${list.age}</p>
	</c:forEach>
	
	<h4>Map</h4>
	<%
	Map<String, Person> maps = new HashMap<>();
	maps.put("1st", new Person("동동일", 60));
	maps.put("2st", new Person("동동이", 58));
	maps.put("3st", new Person("동동삼", 54));
	%>
	
	<c:set var="maps" value="<%= maps %>" />
	<!-- map에 엔트리 값이 들어간다
		map.value=person객체
	 -->
	<c:forEach items="${ maps }" var="map">
		<li>Key => ${ map.key } <br />
			Value => 이름 : ${ map.value.name }, 나이 : ${ map.value.age }
		</li>
	</c:forEach>
	
	
</body>
</html>