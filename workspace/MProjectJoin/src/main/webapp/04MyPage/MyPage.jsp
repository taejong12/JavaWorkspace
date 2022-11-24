<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<style>
/* 굵게 */
@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@300;400&display=swap');

.My{
width:100%;
background-color :pink;
border-radius: 4px;
border: 1px solid yellow;
color: white;
text-align: center;
}
.Pic{
position:absolute;
border-radius: 4px;
border: 1px solid white;
width: 200px;
height: 300px;
}
#Ok{
color:green; 
background-color : orange;
font-family: 'Dongle', sans-serif;
}
#Proceeding{
color:blue;
background-color : yellow;
font-family: 'Dongle', sans-serif;
}
#No{
color:red;
background-color : 	#F0E68C;
font-family: 'Dongle', sans-serif;
}

/* 얇게 */
/* ============================ */
@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap');
#Receiving{
color:white;
background-color : pink;
font-family: 'Dongle', sans-serif;
}
#Choice{
color:white;
background-color : pink;
font-family: 'Dongle', sans-serif;
}
.image{
position: absolute;
margin-left:140px;
}
</style>


<body>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<jsp:include page="../common/Top.jsp"/>

<!-- 매칭현황 테이블 -->
	<table border="1" width="50%" align="center" class="My"> 
		<tr>
			<th>매칭현황</th>
		</tr>
		<c:forEach items="${matchLists }" var="list" varStatus="stat">
		<c:choose>
			<c:when test="${empty matchLists }">
				<tr>
					<td colspan="6" align="center">현재 매칭중이 아닙니다.</td>
				</tr>
				<tr class="image">
					<td ><img src="../img/슬픈개구리.png" width="100px" height="100px" alt="개굴"></td>
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
									
								</td>
								<td>
									<form action="/ProjectMid/matching/myMatchingSuc.do" method="post">
										<input type="hidden" name="ma_sfrom_num" value="${list.ma_sfrom_num}"/>
										<input type="hidden" name="ma_sto_num" value="${list.ma_sto_num}"/>
										<button type="submit">매칭취소</button>
									</form>
								</td>
							</tr>
					<tr class="image">
						<td ><img src="../img/사랑사진1.jpg" width="100px" height="100px" alt="개굴"></td>
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
					<tr class="image">
						<td ><img src="../img/사랑사진1.jpg" width="100px" height="100px" alt="개굴"></td>
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
					<tr class="image">
						<td ><img src="../img/사랑사진1.jpg" width="100px" height="100px" alt="개굴"></td>
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
						<tr class="image">
							<td ><img src="../img/사랑사진1.jpg" width="100px" height="100px" alt="개굴"></td>
						</tr>	
					
				</c:otherwise>	
		</c:choose>
		</c:forEach>
	</table>
	<!-- 찜목록 테이블 -->
	<table border="1" width="50%" align="center" >
		<tr class="My">
			<th>찜목록</th>
		</tr>
		<c:choose>
			<c:when test="${empty jjimLists }">
				<tr>
					<td colspan="6" align="center">찜한 상대가 없습니다.</td>									
				</tr>
				<tr class="image">
					<td ><img src="../img/슬픈개구리.png" width="100px" height="100px" alt="개굴"></td>
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
	
<jsp:include page="../common/Footer.jsp"/>

</body>
</html>