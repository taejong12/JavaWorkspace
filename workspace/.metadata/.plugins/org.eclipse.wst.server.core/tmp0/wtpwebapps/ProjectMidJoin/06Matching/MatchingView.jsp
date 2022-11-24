<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매칭상대정보페이지</title>

</head>
<body>
<jsp:include page="../common/Top.jsp"/>
<script>
	function back(){
		history.back();
	}
</script>
	<h2>매칭상대 정보 페이지</h2>
	사진 : ${dto.in_npic }
	성별 : ${dto.me_sex }
	상대 이름 : ${dto.me_name }
	나이 : ${dto.me_age }
	거주지역 : ${dto.re_name }
	
	키 : ${dto.in_height }
	체형 : ${dto.in_style }
	학력 : ${dto.in_edu }
	종교 :${dto.in_rlg }
	음주여부 : ${dto.in_drunk }
	흡연여부 : ${dto.in_smoke }
	외향/내향 : ${dto.in_char }
	MBTI : ${dto.in_mbti }
	취미 : ${dto.in_hobby }
	직업 : ${dto.in_job }
	반려동물 유무 : ${dto.in_haspet }
	
	목소리 들어보기 > ${dto.in_ovoice } 
	
	<br/>
	
찜하기 버튼
	<form action="/ProjectMid/matching/matchingJJIM.do" method="get">
		<input type="hidden" name="jjim_from_num" value="${sessionScope.me_num}"/>
		<input type="hidden" name="jjim_to_num" value="${dto.me_num}"/>
		<input type="hidden" name="jjim_to_name" value="${dto.me_name }"/>
		<input type="hidden" name="jjim_to_age" value="${dto.me_age }"/>
		<button type="submit">찜하기</button>
	</form>

목록으로 돌아가기 버튼
	<form action="">
		<input type="button" value="목록으로 돌아가기" onclick="back()"/>
	</form>
매칭신청
	<form action="/ProjectMid/matching/myMatching.do" method="get">
		당신을 어필할 한 줄 메시지를 입력해주세요. <br/>
		<input type="text" name="ma_message"/>
		<input type="hidden" name="ma_from_num" value="${sessionScope.me_num}"/>
		<input type="hidden" name="ma_from_name" value="${sessionScope.me_name}"/>
		<input type="hidden" name="ma_to_num" value="${dto.me_num}"/>
		<input type="hidden" name="ma_to_name" value="${dto.me_name }"/>
		
		<input type="hidden" name="ma_from_kakao" value="${sessionScope.me_kakao}"/>
		<input type="hidden" name="ma_from_email" value="${sessionScope.me_email}"/>
		<input type="hidden" name="ma_from_phone" value="${sessionScope.me_phone}"/>
		
		<input type="hidden" name="ma_to_kakao" value="${dto.me_kakao }"/>
		<input type="hidden" name="ma_to_email" value="${dto.me_email }"/>
		<input type="hidden" name="ma_to_phone" value="${dto.me_phone }"/>
		
		<button type="submit">매칭신청버튼</button>
	</form>
	<jsp:include page="../common/Footer.jsp"/>
</body>
</html>