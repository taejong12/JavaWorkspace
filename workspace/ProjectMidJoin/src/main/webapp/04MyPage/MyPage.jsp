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
<jsp:include page="../common/Top.jsp"/>

<!-- 매칭현황 테이블 -->
	<table border="1" width="50%" align="center"> 
		<tr>
			<th>매칭현황</th>
		</tr>
		<c:forEach items="${matchLists }" var="list" varStatus="stat">
		<c:choose>
			<c:when test="${empty matchLists }">
				<tr>
					<td colspan="6" align="center">현재 매칭중이 아닙니다.</td>
				</tr>
			</c:when>
			<c:when test="${list.ma_sfrom_num eq sessionScope.me_num or list.ma_sto_num eq sessionScope.me_num}">
						<tr align="center">
							<td>
								${(stat.index+1)}
							</td>
								
								<td> ${list.ma_sfrom_name }님과 ${list.ma_sto_name }은 서로 매칭중입니다.</td>
								
							
								<td> 
									<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_sfrom_num}';">신청자 정보보기</button>
									<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_sto_num}';">대상자 정보보기</button>
									신청자 연락처 = 카카오톡 아이디: ${list.ma_from_kakao }, 이메일: ${list.ma_from_email }, 전화번호: ${list.ma_from_phone }
									대상자 연락처 = 카카오톡 아이디: ${list.ma_to_kakao }, 이메일: ${list.ma_to_email }, 전화번호: ${list.ma_to_phone }
								</td>
								<td>
									<form action="/ProjectMid/matching/myMatchingSuc.do" method="post">
										<input type="hidden" name="ma_sfrom_num" value="${list.ma_sfrom_num}"/>
										<input type="hidden" name="ma_sto_num" value="${list.ma_sto_num}"/>
										<button type="submit">매칭취소</button>
									</form>
								</td>
							</tr>
			</c:when>
			<c:when test="${list.ma_to_num eq sessionScope.me_num }">
				
						<tr align="center">
							<td>
								${(stat.index+1)}
							</td>
							<td> 신청자번호 : ${list.ma_from_num }</td>
							<td> 신청자명 : ${list.ma_from_name }</td>
							<td> 대상자번호 : ${list.ma_to_num }</td>
							<td> 대상자명 : ${list.ma_to_name }</td>
							<td> 어필문구 : ${list.ma_message }</td>
						
							<td> 
								<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_from_num}';">신청자 정보보기</button>
								<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_to_num}';">대상자 정보보기</button>
							</td>
							<td>
								<form action="/ProjectMid/matching/myMatching.do" method="post">
									<input type="hidden" name="ma_from_num" value="${list.ma_from_num}"/>
									<input type="hidden" name="ma_to_num" value="${list.ma_to_num}"/>
									<button type="submit">매칭거절</button>
								</form>
								
								<form action="/ProjectMid/matching/myMatchingSuc.do" method="get">
									<input type="hidden" name="ma_sfrom_num" value="${list.ma_from_num}"/>
									<input type="hidden" name="ma_sfrom_name" value="${list.ma_from_name}"/>
									<input type="hidden" name="ma_sto_num" value="${list.ma_to_num}"/>
									<input type="hidden" name="ma_sto_name" value="${list.ma_to_name}"/>
									<button type="submit">매칭수락</button>
								</form>
							</td>
						</tr>
			</c:when>
			
			<c:when test="${list.ma_from_num eq sessionScope.me_num}">
				
						<tr align="center">
							<td>
								${(stat.index+1)}
							</td>
							<td> 신청자번호 : ${list.ma_from_num }</td>
							<td> 신청자명 : ${list.ma_from_name }</td>
							<td> 대상자번호 : ${list.ma_to_num }</td>
							<td> 대상자명 : ${list.ma_to_name }</td>
							<td> 어필문구 : ${list.ma_message }</td>
						
							<td> 
								<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_from_num}';">신청자 정보보기</button>
								<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.ma_to_num}';">대상자 정보보기</button>
							</td>
							<td>
								<form action="/ProjectMid/matching/myMatching.do" method="post">
									<input type="hidden" name="ma_from_num" value="${list.ma_from_num}"/>
									<input type="hidden" name="ma_to_num" value="${list.ma_to_num}"/>
									<button type="submit">매칭취소</button>
								</form>
							</td>
						</tr>
				
			</c:when>
			
			<c:otherwise>
						<tr align="center">
							<td>
								${(stat.index+1)}
							</td>
								<td> 신청자번호 : ${list.ma_sfrom_num }</td>
								<td> 신청자명 : ${list.ma_sfrom_name }</td>
								<td> 대상자번호 : ${list.ma_sto_num }</td>
								<td> 대상자명 : ${list.ma_sto_name }</td>
							
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
		</c:choose>
		</c:forEach>
	</table>
	<!-- 찜목록 테이블 -->
	<table border="1" width="50%" align="center">
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
				<c:forEach items="${jjimLists}" var="list" varStatus="stat">
					<tr align="center">
						<td>
							${(stat.index+1)}
						</td>
						<td> 상대번호 : ${list.jjim_to_num }</td>
						<td> 상대이름 : ${list.jjim_to_name }</td>
						<td> 나이 : ${list.jjim_to_age }</td>
						<td> 
							<button type="button" id="goMatchingBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.jjim_to_num}';">상대 상세정보보기</button>
						</td>
						<td>
							<form action="/ProjectMid/matching/matchingJJIM.do" method="post">
								<input type="hidden" name="jjim_from_num" value="${sessionScope.me_num}"/>
								<input type="hidden" name="jjim_to_num" value="${list.jjim_to_num}"/>
								<button type="submit">찜목록 삭제하기</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
   <form method="get" action="../controller/VRevise.do" align="center">
	 	<table>
			<tr align="center">
				<td>				
					<button type="submit">회원정보 수정하기</button>								
				</td>
			</tr>
		</table>
   </form>

<jsp:include page="../common/Footer.jsp"/>
</body>
</html>