<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<table border="1" width="90%">
		<tr>
			<th>매칭현황</th>
		</tr>
		<c:choose>
			<c:when test="${empty matchLists }">
				<tr>
					<td colspan="6" align="center">매칭 상대가 없습니다.</td>
				</tr>
			</c:when>
			
			<c:otherwise>
				매칭신청목록
				<c:forEach items="${matchLists }" var="list" varStatus="stat">
				<c:when test="${not empty list.ma_from_num empty list.ma_sfrom_num }">
					<tr align="center">
						<td>
							${(stat.index+1)}
						</td>
						<td> 신청자 : ${list.ma_from_num }</td>
						<td> 대상자 : ${list.ma_to_num }</td>
						<td> 어필문구 : ${list.ma_message }</td>
					
						<td> 
							<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_from_num}';">신청자 정보보기</button>
							<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_to_num}';">대상자 정보보기</button>
						</td>
						<td>
							<form action="/ProjectMid/matching/MyMatching.do" method="post">
								<input type="hidden" name="ma_from_num" value="${list.ma_from_num}"/>
								<input type="hidden" name="ma_to_num" value="${list.ma_to_num}"/>
								<button type="submit">매칭취소</button>
							</form>
							
							<form action="/ProjectMid/matching/myMatchingSuc.do" method="get">
								<input type="hidden" name="ma_from_num" value="${list.ma_from_num}"/>
								<input type="hidden" name="ma_to_num" value="${list.ma_to_num}"/>
								<button type="submit">매칭수락</button>
							</form>
						</td>
					</tr>
					</c:when>
					매칭수락현황
					<c:otherwise>
					<tr align="center">
						<td>
							${(stat.index+1)}
						</td>
						<td> 신청자 : ${list.ma_sfrom_num }</td>
						<td> 대상자 : ${list.ma_sto_num }</td>
					
						<td> 
							<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_sfrom_num}';">신청자 정보보기</button>
							<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_sto_num}';">대상자 정보보기</button>
						</td>
						<td>
							<form action="/ProjectMid/matching/myMatchingSuc.do" method="post">
								<input type="hidden" name="ma_sfrom_num" value="${list.ma_sfrom_num}"/>
								<input type="hidden" name="ma_sto_num" value="${list.ma_sto_num}"/>
								<button type="submit">매칭취소</button>
							</form>
						</td>
					</tr>
					</c:otherwise>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<table border="1" width="90%">
		<tr>
			<th>찜목록</th>
		</tr>
		<c:choose>
			<c:when test="${empty jjimLists }">
				<tr>
					<td colspan="6" align="center">찜한 상대가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${jjimLists }" var="list" varStatus="stat">
					<tr align="center">
						<td>
							${(stat.index+1)}
						</td>
						<td> 이름 : ${list.me_name }</td>
						<td> 나이 : ${list.me_age }</td>
						<td> 키 : ${list.in_height }</td>
						<td> 지역 : ${list.re_name }</td>
						<td> 목소리 들어보기 </td>
						<td> 
							<button type="button" id="goMatchingBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.me_num}';">상대 상세정보보기</button>
						</td>
						<td> 
							<button type="button" id="jjimDeleteBtn" onclick="location.href='../matching/matchingJJIM.do?jjim_from_num=${sessionScope.me_num}';">찜목록 삭제하기</button>
						</td>
						<td>
							<form action="/ProjectMid/matching/matchingJJIM.do" method="post">
								<input type="hidden" name="jjim_from_num" value="${sessionScope.me_num}"/>
								<input type="hidden" name="jjim_to_num" value="${list.me_num}"/>
								<button type="submit">찜목록 삭제하기</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>