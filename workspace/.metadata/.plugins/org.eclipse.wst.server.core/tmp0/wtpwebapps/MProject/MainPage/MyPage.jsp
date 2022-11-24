<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>

</head>
<body>
<jsp:include page="../Common/Top.jsp"/>

<section>
	<table border="1" width="100%">
		<tr align="center">
			<td width="50%"  rowspan="3">
				<div>[매칭 현황]</div>
				<div>
					매칭 성사(상대정보 링크 달아야 됨)  (채팅기능)
					//매칭이 진행중입니다. (상대정보 링크 달아야 됨) 
					// 매칭 중이 아닙니다. (상대정보 링크 달아야 됨) 
					//xxx 님이 매칭을 신청하셨습니다.
					“ 한 줄 메시지“ [수락][거절]
				</div>
			</td>
		</tr>
		<tr align="center">
			<td><h4>[찜하기 목록]</h4></td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${empty pickList}">
					<td align="center">등록된 목록이 없습니다.</td>
				</c:when>
				<c:otherwise>
					<c:forEach items="${pickList}" var="list" varStatus="stat">
					<tr align="center">
						<td align="left">
							<a href="">${picklist}</a>
						</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</section>

<section>
	<table border="1" width="100%">
		<tr align="center">
			<td>
				<h4>개인 정보 수정</h4>
			</td>
		</tr>
		<tr align="center">
			<button type="button" class="btn btn-danger" id="btn4" onclick="location.href='../MainPage/MyPage.jsp';">회원정보수정</button>
			<td>
				비밀번호 확인 : <input type="password" name="user_Pw" /><button type="button" onclick="">확인</button>
			</td>
		</tr>
	</table>
</section>

<jsp:include page="../Common/Footer.jsp"/>

</body>
</html>