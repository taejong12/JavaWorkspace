<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
        src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous">
</script>
<script>
	
	function deselect(){
		$("input:radio").prop('checked',false);
		$("input:text").prop('value',"");
	}
</script>
<title>매칭메인페이지</title>
</head>
<body>
<jsp:include page="../common/Top.jsp"/>
	<!-- 매칭 폼 -->
	<form method="get" action="/ProjectMid/matching/main.do" name=matchingFrm>
		<table align="center">
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="sex" value="남" <c:if test= "${map.get('sex')=='남'}">checked</c:if>>남자
					<input type="radio" name="sex" value="여" <c:if test= "${map.get('sex')=='여'}">checked</c:if>>여자
				</td>
			</tr>                       
			<tr>                        
				<td>연령대</td>         
				<td>
					<input type="radio" name="age" value="20" <c:if test= "${map.get('age')==20}">checked</c:if>>20대 이상
					<input type="radio" name="age" value="30" <c:if test= "${map.get('age')==30}">checked</c:if>>30대 이상
					<input type="radio" name="age" value="40" <c:if test= "${map.get('age')==40}">checked</c:if>>40대 이상
					<input type="text" name="minage" placeholder="최소나이" value=<c:if test="${not empty map.get('minage')}">${map.get('minage')}</c:if>>세 이상 
					<input type="text" name="maxage"  placeholder="최대나이" value=<c:if test="${not empty map.get('maxage')}">${map.get('maxage')}</c:if>>세 이하
				</td>
			</tr>                   
			<tr>                        
				<td>키</td>             
				<td>
					<input type="text" name="minHeight" placeholder="최소 키" value=<c:if test="${not empty map.get('minHeight')}">${map.get('minHeight')}</c:if>>cm이상 
					<input type="text" name="maxHeight" placeholder="최대 키" value=<c:if test="${not empty map.get('maxHeight')}">${map.get('maxHeight')}</c:if>>cm이하
				</td>
			</tr>                       
			<tr>                        
				<td>체형</td>           
				<td>
					<input type="radio" name="style" value="슬랜더" <c:if test= "${map.get('style')=='슬랜더'}">checked</c:if>>슬랜더
					<input type="radio" name="style" value="보통" <c:if test= "${map.get('style')=='보통'}">checked</c:if>>보통
					<input type="radio" name="style" value="근육질" <c:if test= "${map.get('style')=='근육질'}">checked</c:if>>근육질
					<input type="radio" name="style" value="통통" <c:if test= "${map.get('style')=='통통'}">checked</c:if>>통통한편
					<input type="radio" name="style" value="과체중" <c:if test= "${map.get('style')=='과체중'}">checked</c:if>>과체중
				</td>
			</tr>
			<tr>
				<td>최종학력</td>
				<td>
					<input type="radio" name="edu" value="중졸이하" <c:if test= "${map.get('edu')=='중졸이하'}">checked</c:if>>중졸이하
					<input type="radio" name="edu" value="고졸" <c:if test= "${map.get('edu')=='고졸'}">checked</c:if>>고졸
					<input type="radio" name="edu" value="대졸" <c:if test= "${map.get('edu')=='대졸'}">checked</c:if>>대졸
					<input type="radio" name="edu" value="대학원이상" <c:if test= "${map.get('edu')=='대학원이상'}">checked</c:if>>대학원이상
				</td>
			<tr>                      
			<tr>
				<td>종교</td>
				<td><input type="radio" name="rlg" value="천주교" <c:if test= "${map.get('rig')=='천주교'}">checked</c:if>>천주교
				<input type="radio" name="rlg" value="기독교" <c:if test= "${map.get('rlg')=='기독교'}">checked</c:if>>기독교
				<input type="radio" name="rlg" value="불교" <c:if test= "${map.get('rlg')=='불교'}">checked</c:if>>불교
				<input type="radio" name="rlg" value="힌두교" <c:if test= "${map.get('rlg')=='힌두교'}">checked</c:if>>힌두교
				<input type="radio" name="rlg" value="이슬람교" <c:if test= "${map.get('rlg')=='이슬람교'}">checked</c:if>>이슬람교
				<input type="radio" name="rlg" value="무교" <c:if test= "${map.get('rlg')=='무교'}">checked</c:if>>무교</td>
			</tr>                       
			<tr>
				<td>음주여부</td>
				<td><input type="radio" name="drunk" value="O" <c:if test= "${map.get('drunk')=='O'}">checked</c:if>>음주
				<input type="radio" name="drunk" value="X" <c:if test= "${map.get('drunk')=='X'}">checked</c:if>>비음주</td>
			</tr>
			<tr>
				<td>흡연여부</td>
				<td><input type="radio" name="smoke" value="O" <c:if test= "${map.get('smoke')=='O'}">checked</c:if>>흡연
				<input type="radio" name="smoke" value="X" <c:if test= "${map.get('smoke')=='X'}">checked</c:if>>비흡연</td>
			</tr>
			<tr>
				<td>외향/내향</td>
				<td><input type="radio" name="exin" value="외향적" <c:if test= "${map.get('exin')=='외향적'}">checked</c:if>>외향적
				<input type="radio" name="exin" value="내향적" <c:if test= "${map.get('exin')=='내향적'}">checked</c:if>>내향적</td>
			</tr>                       
			<tr>
				<td>MBTI</td>
				<td>
				<input type="radio" name="mbti" value="SITE" <c:if test= "${map.get('mbti')=='SITE'}">checked</c:if>>사이트 추천 MBTI궁합 
				
				<input type="radio" name="mbti" value="ISTJ" <c:if test= "${map.get('mbti')=='ISTJ'}">checked</c:if>>ISTJ
				<input type="radio" name="mbti" value="ISTP" <c:if test= "${map.get('mbti')=='ISTP'}">checked</c:if>>ISTP
				<input type="radio" name="mbti" value="ISFJ" <c:if test= "${map.get('mbti')=='ISFJ'}">checked</c:if>>ISFJ
				<input type="radio" name="mbti" value="ISFP" <c:if test= "${map.get('mbti')=='ISFP'}">checked</c:if>>ISFP
				<input type="radio" name="mbti" value="INTJ" <c:if test= "${map.get('mbti')=='INTJ'}">checked</c:if>>INTJ
				<input type="radio" name="mbti" value="INTP" <c:if test= "${map.get('mbti')=='INTP'}">checked</c:if>>INTP
				<input type="radio" name="mbti" value="INFJ" <c:if test= "${map.get('mbti')=='INFJ'}">checked</c:if>>INFJ
				<input type="radio" name="mbti" value="INFP" <c:if test= "${map.get('mbti')=='INFP'}">checked</c:if>>INFP
				<input type="radio" name="mbti" value="ESTJ" <c:if test= "${map.get('mbti')=='ESTJ'}">checked</c:if>>ESTJ
				<input type="radio" name="mbti" value="ESTP" <c:if test= "${map.get('mbti')=='ESTP'}">checked</c:if>>ESTP
				<input type="radio" name="mbti" value="ESFJ" <c:if test= "${map.get('mbti')=='ESFJ'}">checked</c:if>>ESFJ
				<input type="radio" name="mbti" value="ESFP" <c:if test= "${map.get('mbti')=='ESFP'}">checked</c:if>>ESFP
				<input type="radio" name="mbti" value="ENTJ" <c:if test= "${map.get('mbti')=='ENTJ'}">checked</c:if>>ENTJ
				<input type="radio" name="mbti" value="ENTP" <c:if test= "${map.get('mbti')=='ENTP'}">checked</c:if>>ENTP
				<input type="radio" name="mbti" value="ENFJ" <c:if test= "${map.get('mbti')=='ENFJ'}">checked</c:if>>ENFJ
				<input type="radio" name="mbti" value="ENFP" <c:if test= "${map.get('mbti')=='ENFP'}">checked</c:if>>ENFP</td>
			</tr>
			<tr>
				<td></td>
				<td><button >최신 MBTI 궁합표 기반(재미로 보세요)</button></td>
			</tr>
			<tr>
				<td></td>
				<td><img src ="../img/mbti.png"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><input type="radio" name="job" value="회사원" <c:if test= "${map.get('job')=='회사원'}">checked</c:if>>회사원
				<input type="radio" name="job" value="공무원" <c:if test= "${map.get('job')=='공무원'}">checked</c:if>>공무원
				<input type="radio" name="job" value="프리랜서" <c:if test= "${map.get('job')=='프리랜서'}">checked</c:if>>프리랜서
				<input type="radio" name="job" value="예체능" <c:if test= "${map.get('job')=='예체능'}">checked</c:if>>예체능
				<input type="radio" name="job" value="군인" <c:if test= "${map.get('job')=='군인'}">checked</c:if>>군인
				<input type="radio" name="job" value="교육" <c:if test= "${map.get('job')=='교육'}">checked</c:if>>교육
				<input type="radio" name="job" value="의료" <c:if test= "${map.get('job')=='의료'}">checked</c:if>>의료
				<input type="radio" name="job" value="금수저" <c:if test= "${map.get('job')=='금수저'}">checked</c:if>>금수저
				<input type="radio" name="job" value="무직" <c:if test= "${map.get('job')=='무직'}">checked</c:if>>무직
				<input type="radio" name="job" value="그 외" <c:if test= "${map.get('job')=='그 외'}">checked</c:if>>그 외</td>
			</tr>                       
			<tr>
				<td>반려동물유무</td>
				<td><input type="radio" name="pet" value="유" <c:if test= "${map.get('pet')=='유'}">checked</c:if>>키움
				<input type="radio" name="pet" value="무" <c:if test= "${map.get('pet')=='무'}">checked</c:if>>안키움</td>
			</tr>   
			<tr>
				<td>
					<button type="submit" id="result">검색</button>
					<button onclick = "deselect()">선택해제</button>
				</td>
			</tr>                    
		</table>
	</form>

<table align="center">
	<tr>
		<th>선택된 조건 : </th>
		<th>${map.get("sex")}</th>
		<th>
			<c:if test= "${not empty map.get('age')}">
				${map.get("age")}대 이상
			</c:if>
			<c:if test= "${not empty map.get('minage')}">
				${map.get("minage")}세 이상 ${map.get("maxage")}세 이하
			</c:if>
		</th>
		<th>
			<c:if test= "${not empty map.get('minHeight')}">
				${map.get("minHeight")}cm 이상 ${map.get("maxHeight")}cm 이하
			</c:if>
		</th>
		<th>${map.get("style")}</th>
		<th>${map.get("edu")}</th>
		<th>${map.get("rlg")}</th>
		<th>${map.get("drunk")}</th>
		<th>${map.get("smoke")}</th>
		<th>${map.get("exin")}</th>
		<th>${map.get("mbti")}</th>
		<th>${map.get("job")}</th>
		<th>${map.get("pet")}</th>
	</tr>
</table>
<table border="1" width="90%" align="center">
	<tr>
		<th>번호</th>
		<th>사진</th>
		<th>이름</th>
		<th>나이</th>
		<th>키</th>
		<th>거주지역</th>
		<th>목소리듣기</th>
	</tr>
	<c:choose>
		<c:when test="${empty boardLists }">
			<tr>
				<td colspan="6" align="center">조건에 맞는 상대가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${boardLists }" var="list" varStatus="stat">
				<tr align="center">
					<td>
						${(stat.index+1)}
					</td>
					<td> 사진 : ${list.in_npic }</td>
					<td> 이름 : ${list.me_name }</td>
					<td> 나이 : ${list.me_age }</td>
					<td> 키 : ${list.in_height }</td>
					<td> 지역 : ${list.re_name }</td>
					<td> 음성 : ${list.in_ovoice } </td>
					<td> 
						<button type="button" id="matchingInfoBtn" onclick="location.href='../matching/matchingView.do?me_num=${list.me_num}';">상세정보보기</button>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<script>
    // 'result'라는 id를 가진 버튼 클릭 시 실행.
    $("#result").click(function(){
            // json 형식으로 데이터 set
            var params = {
                      sex      : $("[name='sex']").val()
                    , age      : $("[name='age']").val()
                    , height   : $("[name='height']").val()
                    , style    : $("[name='style']").val()
                    , edu      : $("[name='edu']").val()
                    , rlg      : $("[name='rlg']").val()
                    , drunk    : $("[name='drunk']").val()
                    , smoke    : $("[name='smoke']").val()
                    , exin     : $("[name='exin']").val()
                    , mbti     : $("[name='mbti']").val()
                    , job      : $("[name='job']").val()
                    , pet      : $("[name='pet']").val()  
            }  
            // ajax 통신
            $.ajax({
                type : "GET",            // HTTP method type(GET, POST) 형식이다.
                url : "../matching/main.do",  // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,
                dataType : "json" // Json 형식의 데이터이다.
                success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                    alert(res.code);
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
        });     
</script>
<jsp:include page="../common/Footer.jsp"/>
</body>
</html>