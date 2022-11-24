<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grade</title>
</head>
<body>
	<h4>국, 영, 수 점수를 입력하면 평균을 내어 학점 출력</h4>
	<form>
		<filedset>
			<legend>학점평가</legend>
			<label>국어</label>
			<input type="number" name="kor" min="0" max="100" />점 <br />
			<label>영어</label>
			<input type="number" name="eng" min="0" max="100" />점 <br />
			<label>수학</label>
			<input type="number" name="math" min="0" max="100" />점 <br />
			<input type="submit" value="학점 구하기" />
		</filedset>
	</form>
	
	<!--if(값이 있는지){
		set avg=(세개의 점수의 평균값)
		choose
		90 A
		80 B
		70 C
		60 D
		나머지 F
		
	}-->
		
		<!--<c:set var="avg" value="${(param.kor+param.eng+param.math)/3}"></c:set>
		
		<c:choose>
			<c:when test="${ avg ge 90 }">
			${ avg }는 A입니다.
			</c:when>
			<c:when test="${ avg ge 80 }">
			${ avg }는 B입니다.
			</c:when>
			<c:when test="${ avg ge 70 }">
			${ avg }는 C입니다.
			</c:when>
			<c:when test="${ avg ge 60 }">
			${ avg }는 D입니다.
			</c:when>
			<c:otherwise>
			${ avg }는 F입니다.
			</c:otherwise>
		</c:choose>-->
		
	param은 name 값을 불러온다
		
	<!--  모든 과목의 점수가 입력되었는지 확인 -->	
	<c:if test="${ not (empty param.kor or empty param.eng or empty param.math) }">
		<!-- 평균 계산 -->
		<c:set var="avg" value="${(param.kor+param.eng+param.math)/3}" />
		평균 점수 : ${avg }점 || 학점 :
		<!-- 학점 출력 -->
		<c:choose>
			<c:when test="${ avg >= 90 }">A 학점</c:when>
			<c:when test="${ avg >= 80 }">B 학점</c:when>
			<c:when test="${ avg ge 70 }">C 학점</c:when>
			<c:when test="${ avg ge 60 }">D 학점</c:when>
			<c:otherwise>F 학점</c:otherwise>
		</c:choose>
	</c:if>

	
</body>
</html>