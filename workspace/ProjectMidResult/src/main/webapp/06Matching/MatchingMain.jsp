<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.me_id eq null}">
	<jsp:forward page="../03LogInOut/LoginForm.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {
	font-family: "Raleway";
}

.form {
	position: relative;
	top: 0;
	left: 0;
	margin-top: 56px;
}

.form .form-elements {
	margin-top: 15px;
	width: 650px;
	margin: 0 auto;
}

.form .form-elements input {
	font-size: 14px;
	width: 30px;
	height: 30px;
	margin-top: 5px;
	margin: 0 auto;
	border-radius: 10px;
	box-sizing: border-box;
	border: none;
	background: #ffeaea;
}

.form .form-elements button {
	font-size: 14px;
	font-weight: 600;
	border-radius: 10px;
	background: #f1575b;
	color: #f5f5f5;
	cursor: pointer;
	border: none;
	outline: none;
	display: inline-block;
}

.form-element {
	margin-top:10px;
	display: flex;
	justify-content: space-between;
}

.form-check-inline {
	margin-top: 10px;
}

div>div {
	display: inline-block;
}

.form .form-elements input[type=text] {
	text-align: center;
	font-size: 14px;
	width: 100px;
	height: 30px;
	margin-top: 10px;
	margin: 0 auto;
	padding: 2px 10px;
	border-radius: 10px;
	box-sizing: border-box;
	border: none;
	background: #ffeaea;
}
.flex-container {
  display: flex;
  background-color: #ffeaea;
  height: 40px;
  border: none;
  border-radius: 10px;
  justify-content: flex-start;
  align-items: center;
}

.flex-container > div:not(:first-child) {
  background-color: #fff;
  margin-left: 0.5px;
}
.carousel slide{
text-align: center;
}


.carousel-inner{
border:5px solid pink;
border-radius:10px;
background-color:#ffeaea;
text-align: center;
width: 400px;
}
.carousel-item{

}

.carousel-item > img{
border:3px solid black;
width: 150px; 
height: 300px;
}
#matchingInfoBtn {
	font-size: 14px;
	font-weight: 600;
	border-radius: 10px;
	background: #f1575b;
	color: #f5f5f5;
	cursor: pointer;
	border: none;
	outline: none;
	display: inline-block;
}


</style>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"
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
	<jsp:include page="../common/Top.jsp" />
	<!-- 매칭 폼 -->
	<div class="form signup" class="p-3 mb-2 bg-secondary text-white" >
		<form method="get" action="/ProjectMid/matching/main.do"
			name=matchingFrm>
			<div class="form-elements" align="center">
				<div style="display: flex; justify-content: space-between; align-items: center;">
					성별
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio1"
							style="padding: 0;" type="radio" name="sex" value="남"
							<c:if test= "${map.get('sex')=='남'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio1">남자</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio2" type="radio"
							name="sex" value="여" style="padding: 0;"
							<c:if test= "${map.get('sex')=='여'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio2">여자</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					연령대
					<div>
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio3"
							style="padding: 0;" type="radio" name="age" value="20"
							<c:if test= "${map.get('age')==20}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio3">20대 이상</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio4"
							style="padding: 0;" type="radio" name="age" value="30"
							<c:if test= "${map.get('age')==30}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio4">30대 이상</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio5"
							style="padding: 0;" type="radio" name="age" value="40"
							<c:if test= "${map.get('age')==40}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio5">40대 이상</label>
					</div>
					</div>
					</div>
					<hr>
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
					<input type="text" name="minage" placeholder="최소나이"
						value=<c:if test="${not empty map.get('minage')}">${map.get('minage')}</c:if>>세
					이상 <input type="text" name="maxage" placeholder="최대나이"
						value=<c:if test="${not empty map.get('maxage')}">${map.get('maxage')}</c:if>>세
					이하
					</div>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					키
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
						<input type="text" name="minHeight" placeholder="최소 키"
							value=<c:if test="${not empty map.get('minHeight')}">${map.get('minHeight')}</c:if>>cm이상
						<input type="text" name="maxHeight" placeholder="최대 키"
							value=<c:if test="${not empty map.get('maxHeight')}">${map.get('maxHeight')}</c:if>>cm이하
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					체형
					<div  style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-between;"> 
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio6"
							style="padding: 0;" type="radio" name="style" value="슬랜더"
							<c:if test= "${map.get('style')=='슬랜더'}">checked</c:if>>
						<label class="form-check-label" for="inlineRadio6">슬랜더</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio7"
							style="padding: 0;" type="radio" name="style" value="보통"
							<c:if test= "${map.get('style')=='보통'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio7">보통</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio8"
							style="padding: 0;" type="radio" name="style" value="근육질"
							<c:if test= "${map.get('style')=='근육질'}">checked</c:if>>
						<label class="form-check-label" for="inlineRadio8">근육질</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio9"
							style="padding: 0;" type="radio" name="style" value="통통"
							<c:if test= "${map.get('style')=='통통'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio9">통통한편</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio10"
							style="padding: 0;" type="radio" name="style" value="과체중"
							<c:if test= "${map.get('style')=='과체중'}">checked</c:if>>
						<label class="form-check-label" for="inlineRadio10">과체중</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					<div>최종학력</div>
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio11"
							style="padding: 0;" type="radio" name="edu" value="중졸이하"
							<c:if test= "${map.get('edu')=='중졸이하'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio11">중졸이하</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio12"
							style="padding: 0;" type="radio" name="edu" value="고졸"
							<c:if test= "${map.get('edu')=='고졸'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio12">고졸</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio13"
							style="padding: 0;" type="radio" name="edu" value="대졸"
							<c:if test= "${map.get('edu')=='대졸'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio13">대졸</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio14"
							style="padding: 0;" type="radio" name="edu" value="대학원이상"
							<c:if test= "${map.get('edu')=='대학원이상'}">checked</c:if>>
						<label class="form-check-label" for="inlineRadio14">대학원이상</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					종교
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around; flex-wrap: wrap;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio15"
							style="padding: 0;" type="radio" name="rlg" value="천주교"
							<c:if test= "${map.get('rig')=='천주교'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio15">천주교</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio16"
							style="padding: 0;" type="radio" name="rlg" value="기독교"
							<c:if test= "${map.get('rlg')=='기독교'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio16">기독교</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio17"
							style="padding: 0;" type="radio" name="rlg" value="불교"
							<c:if test= "${map.get('rlg')=='불교'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio17">불교</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio18"
							style="padding: 0;" type="radio" name="rlg" value="힌두교"
							<c:if test= "${map.get('rlg')=='힌두교'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio18">힌두교</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio19"
							style="padding: 0;" type="radio" name="rlg" value="이슬람교"
							<c:if test= "${map.get('rlg')=='이슬람교'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio19">이슬람교</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio20"
							style="padding: 0;" type="radio" name="rlg" value="무교"
							<c:if test= "${map.get('rlg')=='무교'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio20">무교</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					음주여부
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio21"
							style="padding: 0;" type="radio" name="drunk" value="O"
							<c:if test= "${map.get('drunk')=='O'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio21">음주</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio22"
							style="padding: 0;" type="radio" name="drunk" value="X"
							<c:if test= "${map.get('drunk')=='X'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio22">비음주</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					흡연여부
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio23"
							style="padding: 0;" type="radio" name="smoke" value="O"
							<c:if test= "${map.get('smoke')=='O'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio23">흡연</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio24"
							style="padding: 0;" type="radio" name="smoke" value="X"
							<c:if test= "${map.get('smoke')=='X'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio24">비흡연</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					외향/내향
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio25"
							style="padding: 0;" type="radio" name="exin" value="외향적"
							<c:if test= "${map.get('exin')=='외향적'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio25">외향적</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio26"
							style="padding: 0;" type="radio" name="exin" value="내향적"
							<c:if test= "${map.get('exin')=='내향적'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio26">내향적</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					MBTI
					<div style="display: flex; width: 450px; flex-direction: column;">
						<div style="display: flex; width: 100%; justify-content: space-between;">
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio27"
									style="padding: 0;" type="radio" name="mbti" value="SITE"
									<c:if test= "${map.get('mbti')=='SITE'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio27">사이트
									추천 MBTI궁합</label>
							</div>
						</div>
						<hr>
						<div
							style="display: flex; width: 100%; justify-content: space-between; flex-wrap: wrap;">
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio28"
									style="padding: 0;" type="radio" name="mbti" value="ISTJ"
									<c:if test= "${map.get('mbti')=='ISTJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio28">ISTJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio29"
									style="padding: 0;" type="radio" name="mbti" value="ISTP"
									<c:if test= "${map.get('mbti')=='ISTP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio29">ISTP</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio30"
									style="padding: 0;" type="radio" name="mbti" value="ISFJ"
									<c:if test= "${map.get('mbti')=='ISFJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio30">ISFJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio31"
									style="padding: 0;" type="radio" name="mbti" value="ISFP"
									<c:if test= "${map.get('mbti')=='ISFP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio31">ISFP</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio32"
									style="padding: 0;" type="radio" name="mbti" value="INTJ"
									<c:if test= "${map.get('mbti')=='INTJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio32">INTJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio33"
									style="padding: 0;" type="radio" name="mbti" value="INTP"
									<c:if test= "${map.get('mbti')=='INTP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio33">INTP</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio34"
									style="padding: 0;" type="radio" name="mbti" value="INFJ"
									<c:if test= "${map.get('mbti')=='INFJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio34">INFJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio35"
									style="padding: 0;" type="radio" name="mbti" value="INFP"
									<c:if test= "${map.get('mbti')=='INFP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio35">INFP</label>
							</div>
						</div>
						<hr>
						<div
							style="display: flex; width: 100%; justify-content: space-between; flex-wrap: wrap;">
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio36"
									style="padding: 0;" type="radio" name="mbti" value="ESTJ"
									<c:if test= "${map.get('mbti')=='ESTJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio36">ESTJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio37"
									style="padding: 0;" type="radio" name="mbti" value="ESTP"
									<c:if test= "${map.get('mbti')=='ESTP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio37">ESTP</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio38"
									style="padding: 0;" type="radio" name="mbti" value="ESFJ"
									<c:if test= "${map.get('mbti')=='ESFJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio38">ESFJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio39"
									style="padding: 0;" type="radio" name="mbti" value="ESFP"
									<c:if test= "${map.get('mbti')=='ESFP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio39">ESFP</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio40"
									style="padding: 0;" type="radio" name="mbti" value="ENTJ"
									<c:if test= "${map.get('mbti')=='ENTJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio40">ENTJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio41"
									style="padding: 0;" type="radio" name="mbti" value="ENTP"
									<c:if test= "${map.get('mbti')=='ENTP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio41">ENTP</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio42"
									style="padding: 0;" type="radio" name="mbti" value="ENFJ"
									<c:if test= "${map.get('mbti')=='ENFJ'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio42">ENFJ</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio43"
									style="padding: 0;" type="radio" name="mbti" value="ENFP"
									<c:if test= "${map.get('mbti')=='ENFP'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio43">ENFP</label>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div>
					<div>
						<button type="button" id="btn_toggle">최신 MBTI 궁합표 보기(재미로 보세요)</button>
					</div>
					<div id="Toggle" style="display: none;">
						<img style="display: block;" src="../img/mbti.png">
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					직업
					<div style="display: flex; width: 450px; flex-direction: column;">
						<div
							style="display: flex; width: 100%; justify-content: space-between;">
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio44"
									style="padding: 0;" type="radio" name="job" value="회사원"
									<c:if test= "${map.get('job')=='회사원'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio44">회사원</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio45"
									style="padding: 0;" type="radio" name="job" value="공무원"
									<c:if test= "${map.get('job')=='공무원'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio45">공무원</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio46"
									style="padding: 0;" type="radio" name="job" value="프리랜서"
									<c:if test= "${map.get('job')=='프리랜서'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio46">프리랜서</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio47"
									style="padding: 0;" type="radio" name="job" value="예체능"
									<c:if test= "${map.get('job')=='예체능'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio47">예체능</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio48"
									style="padding: 0;" type="radio" name="job" value="군인"
									<c:if test= "${map.get('job')=='군인'}">checked</c:if>> <label
									class="form-check-label" for="inlineRadio48">군인</label>
							</div>
						</div>
						<hr>
						<div
							style="display: flex; width: 100%; justify-content: space-between;">
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio49"
									style="padding: 0;" type="radio" name="job" value="교육"
									<c:if test= "${map.get('job')=='교육'}">checked</c:if>> <label
									class="form-check-label" for="inlineRadio49">교육</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio50"
									style="padding: 0;" type="radio" name="job" value="의료"
									<c:if test= "${map.get('job')=='의료'}">checked</c:if>> <label
									class="form-check-label" for="inlineRadio50">의료</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio51"
									style="padding: 0;" type="radio" name="job" value="금수저"
									<c:if test= "${map.get('job')=='금수저'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio51">금수저</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio52"
									style="padding: 0;" type="radio" name="job" value="무직"
									<c:if test= "${map.get('job')=='무직'}">checked</c:if>> <label
									class="form-check-label" for="inlineRadio52">무직</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" id="inlineRadio53"
									style="padding: 0;" type="radio" name="job" value="그 외"
									<c:if test= "${map.get('job')=='그 외'}">checked</c:if>>
								<label class="form-check-label" for="inlineRadio53">그 외</label>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div style="display: flex; justify-content: space-between; align-items: center;">
					반려동물유무
					<div style="display: flex; width: 450px; flex-direction: column;">
					<div style="display: flex; width: 100%; justify-content: space-around;">
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio54"
							style="padding: 0;" type="radio" name="pet" value="유"
							<c:if test= "${map.get('pet')=='유'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio54">키움</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" id="inlineRadio55"
							style="padding: 0;" type="radio" name="pet" value="무"
							<c:if test= "${map.get('pet')=='무'}">checked</c:if>> <label
							class="form-check-label" for="inlineRadio55">안키움</label>
					</div>
					</div>
					</div>
				</div>
				<hr>
				<br>
				<div>
					<button type="submit" id="result">검색</button>
					<button onclick="deselect()">선택해제</button>
				</div>
				<br>
			</div>
		</form>
	</div>
	<br>

	<section style="margin-left: 10%; margin-right: 10%">
		<div class="flex-container" style="margin-left:10%; margin: auto; display: flex; align-items: center; ">
		선택된 조건:
		<div style="display: flex; width: 450px; flex-direction: column;">
		<div style="display: flex; width: 100%; justify-content: space-between; flex-wrap: wrap;">
			<div>
				${map.get("sex")}
				</div>
			<div>
				<c:if test="${not empty map.get('age')}">
				${map.get("age")}대 이상
			</c:if>
				<c:if test="${not empty map.get('minage')}">
				${map.get("minage")}세 이상 ${map.get("maxage")}세 이하
			</c:if>
			</div>
			<div>
				<c:if test="${not empty map.get('minHeight')}">
				${map.get("minHeight")}cm 이상 ${map.get("maxHeight")}cm 이하
			</c:if>
			</div>
			<div>
				${map.get("style")}
			</div>
			<div>${map.get("edu")}</div>
			<div>${map.get("rlg")}</div>
			<div>${map.get("drunk")}</div>
			<div>${map.get("smoke")}</div>
			<div>${map.get("exin")}</div>
			<div>${map.get("mbti")}</div>
			<div>${map.get("job")}</div>
			<div>${map.get("pet")}</div>
		</div>
		</div>
		</div>
	<br>
	</section>
	<section style="margin: auto; width: 400px">
			<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				<div class="carousel-inner">
			
			<c:choose>
				<c:when test="${empty boardLists }">
						<div>
							<h5 align="center">조건에 맞는 상대가 없습니다.</h5>
						</div>
				</c:when>
				<c:otherwise>
					<div class="carousel-item active" data-bs-interval="20000">
						<img style="display: block; margin: 0px auto;" src="../img/MProjectLogo.png">
					</div>
				
					<c:forEach items="${boardLists }" var="list" varStatus="stat">
								<div class="carousel-item" data-bs-interval="20000">
								<p>${(stat.index+1)}</p>
								<img src="../Storage/${list.in_npic }" />
									<div style="display: flex; flex-direction: column; background-color: rgba(0, 0, 0, 0.1); margin: 5% 20%;">
									<br><br>
									<h4>이름 : ${list.me_name }</h4>
									<p>나이 : ${list.me_age }</p>
									<p>키 : ${list.in_height }</p>
									<p>지역 : ${list.re_name }</p>
									</div>
							
									<button type="button"
										id="matchingInfoBtn"
										onclick="location.href='../matching/matchingView.do?me_num=${list.me_num}';">상세정보보기</button>
									<br><br>
								</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<button style="background-color: black; opacity: 0.3;" class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button style="background-color: black; opacity: 0.3;" class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
				</div>
			</div>
	</section>
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
	<script type="text/javascript">
$(function (){
	$("#btn_toggle").click(function (){
  	$("#Toggle").toggle();
  });
});
</script>
	<jsp:include page="../common/Footer.jsp" />
</body>
</html>