<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/Top.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매칭상대정보페이지</title>
<style>
#tablea {
	padding-left: 1000px;
	width: 700px;
	left: 450px;
	white-space: pre;
	background-color: white;
	border: 1px solid black;
	font-size: 12px;
	font-weight: normal;
	position: relative;
	text-align: center;
	
}


#a1 {
	padding-left: 20px;
	width: 800px;
	left: 4px;
	margin-left: 120px;
}

#imga {
	margin-left: 590px;
	border-bottom: 3px solid #f4728a;
	width: 700px;
	left: 1000000px;
}

#tablea th, #tablea tr {
	padding: 10px;
	background-color: #fbc9cb;
	border: 1px solid white;
}

.imgn {
	width: 100px;
	height: 40px;
	object-fit: cover;
}

form {
	text-align: center;
	position: relative;

}
</style>
</head>
<body>
	<br />
	<script>
		function back() {
			history.back();
		}
	</script>
	<div class="h2_bottom_bg"></div>
	<div id="imga">
		<img alt="" src="../img/timg.png" width="330px" />
	</div>
	<div>
		<div id="a1">
			<table id="tablea">
				<tr>
					<th class="imgn"><img src="../Storage/${ dto.in_npic }"
		   				style="  width:250px" ; /></th>
				</tr>
				<tr>
					<th>성별 : ${ dto.me_sex } / 상대 이름 : ${ dto.me_name }</th> 
				</tr>
				<tr>
					<th>나이 : ${ dto.me_age } / 거주지역 : ${ dto.re_name } </th>
				</tr>
				<tr>
					<th>키 : ${ dto.in_height }  / 체형 : ${ dto.in_style }</th>
				</tr>
				<tr>
					<th>학력 : ${ dto.in_edu }  / 종교 :${ dto.in_rlg }</th>
				</tr>
		
				<tr>
					<th>음주여부 :${ dto.in_drunk } / 흡연여부 : ${ dto.in_smoke }</th>

				</tr>
				<tr>
					<th>외향/내향 : ${ dto.in_char } / MBTI : ${ dto.in_mbti }</th>
				</tr>
				<tr>
					<th>취미 : ${ dto.in_hobby }  / 직업 : ${ dto.in_job }</th>
				</tr>
				<tr>
					<th>반려동물 유무 : ${ dto.in_haspet }</th>
				</tr>
				<tr>
					<th> 목소리 들어보기 > <br /><br/> <audio controls>
						<source src="../Storage/${ dto.in_nvoice }"  />
						</audio></th>
				</tr>
			</table>
			<br>
		</div>
		<form action="/ProjectMid/matching/matchingJJIM.do" method="get">
			<input type="hidden" name="jjim_from_num"
				value="${sessionScope.me_num}" /> <input type="hidden"
				name="jjim_to_num" value="${dto.me_num}" /> <input type="hidden"
				name="jjim_to_name" value="${dto.me_name }" /> <input type="hidden"
				name="jjim_to_age" value="${dto.me_age }" />
			<button type="submit" id="b1"
				style="background-color: #ff6984; color: white; border: none; border-color: black;">찜하기</button>
		</form>
		<form action="">
			<input type="button" value="목록으로 돌아가기" onclick="back()"
				style="background-color: #ff6984; color: white; border-color: black; border: none;" />
		</form>
		<form action="/ProjectMid/matching/myMatching.do" method="get">
			당신을 어필할 한 줄 메시지를 입력해주세요. <br /> <input type="text"
				style="border-color: #e2427e" name="ma_message" /> <input
				type="hidden" name="ma_from_num" value="${sessionScope.me_num}" />
			<input type="hidden" name="ma_from_name"
				value="${sessionScope.me_name}" /> <input type="hidden"
				name="ma_to_num" value="${dto.me_num}" /> <input type="hidden"
				name="ma_to_name" value="${dto.me_name }" /> <input type="hidden"
				name="ma_from_kakao" value="${sessionScope.me_kakao}" /> <input
				type="hidden" name="ma_from_email" value="${sessionScope.me_email}" />
			<input type="hidden" name="ma_from_phone"
				value="${sessionScope.me_phone}" /> <input type="hidden"
				name="ma_to_kakao" value="${dto.me_kakao }" /> <input type="hidden"
				name="ma_to_email" value="${dto.me_email }" /> <input type="hidden"
				name="ma_to_phone" value="${dto.me_phone }" />

			<button type="submit" id="b2"
				style="background-color: #ff6984; color: white; border-color: black; border: none;">매칭신청버튼</button>
		</form>
	</div>

	<jsp:include page="../common/Footer.jsp" />
</body>
</html>