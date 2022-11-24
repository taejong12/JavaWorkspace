<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 게시판</title>
</head>
<body>
<jsp:include page="../common/Top.jsp"/>



	<h1 align="center">[회원가입2]</h1>
		
	<form name="myFrm" method="post" enctype="multipart/form-data" 
	action="../controller/Join2.do" onsubmit="return validateForm(this);">
		
	키:
		<input type="number" name="in_height"/>cm
	<br/>
	체형:
		<input type="radio" name="in_style" id="slan" value="슬랜더"/> 슬랜더
		<input type="radio" name="in_style" id="aver" value="보통"/> 보통
		<input type="radio" name="in_style" id="musc" value="근육"/> 근육
		<input type="radio" name="in_style" id="plu" value="통통"/> 통통
		<input type="radio" name="in_style" id="over" value="과체중"/> 과체중
	<br/>
	
	최종학력:
		<input type="radio" name="in_edu" id="mi" value="중졸이하"/>중졸이하 
		<input type="radio" name="in_edu" id="hi" value="고졸"/>고졸 
		<input type="radio" name="in_edu" id="un" value="대졸"/>대졸 
		<input type="radio" name="in_edu" id="gr" value="대학원이상"/>대학원이상
	<br/>
	종교:	
		<input type="radio" name="in_rlg" id="cath" value="천주교" /> 천주교
		<input type="radio" name="in_rlg" id="chri" value="기독교" /> 기독교
		<input type="radio" name="in_rlg" id="budd" value="불교" /> 불교
		<input type="radio" name="in_rlg" id="Hin" value="힌두교" /> 힌두교 
		<input type="radio" name="in_rlg" id="Isl" value="이슬람교" /> 이슬람교 
		<input type="radio" name="in_rlg" id="reli" value="무교" /> 무교
		
	<br/>
	음주:
		<input type="radio" name="in_drunk" id="yes" value="O" />O 
		<input type="radio" name="in_drunk" id="no" value="X" />X 
	<br/>
    흡연:
		<input type="radio" name="in_smoke" id="o" value="O" />O 
		<input type="radio" name="in_smoke" id="x" value="X" />X <br/>
	성격
		<input type="radio" name="in_char" id="ex" value="외향적" />외향적 
		<input type="radio" name="in_char" id="in" value="내향적" />내향적
	 <br/>
	MBTI:
		<input type="radio" name="in_mbti" id="istj" value="ISTJ" />ISTJ
		<input type="radio" name="in_mbti" id="istp" value="ISTP" />ISTP
		<input type="radio" name="in_mbti" id="isfj" value="ISFJ" />ISFJ
		<input type="radio" name="in_mbti" id="isfp" value="ISFP" />ISFP
		<input type="radio" name="in_mbti" id="intj" value="INTJ" />INTJ
		<input type="radio" name="in_mbti" id="intp" value="INTP" />INTP
		<input type="radio" name="in_mbti" id="infj" value="INFJ" />INFJ
		<input type="radio" name="in_mbti" id="infp" value="INFP" />INFP
		<input type="radio" name="in_mbti" id="estj" value="ESTJ" />ESTJ
		<input type="radio" name="in_mbti" id="estp" value="ESTP" />ESTP
		<input type="radio" name="in_mbti" id="esfj" value="ESFJ" />ESFJ
		<input type="radio" name="in_mbti" id="esfp" value="ESFP" />ESFP
		<input type="radio" name="in_mbti" id="entj" value="ENTJ" />ENTJ
		<input type="radio" name="in_mbti" id="entp" value="ENTP" />ENTP
		<input type="radio" name="in_mbti" id="enfj" value="ENFJ" />ENFJ
		<input type="radio" name="in_mbti" id="enfp" value="ENFP" />ENFP
	<br/>
	취미:
		<input type="text" name="in_hobby"  />
	<br/>
	직업:
		<input type="radio" name="in_job" id="emp" value="회사원" />회사원
		<input type="radio" name="in_job" id="civil" value="공무원" />공무원
		<input type="radio" name="in_job" id="free" value="프리랜서" />프리랜서
		<input type="radio" name="in_job" id="enter" value="예체능" />예체능
		<input type="radio" name="in_job" id="serv" value="군인" />군인
		<input type="radio" name="in_job" id="educ" value="교육" />교육
		<input type="radio" name="in_job" id="med" value="의료" />의료
		<input type="radio" name="in_job" id="gold" value="금수저" />금수저	
	 	<input type="radio" name="in_job" id="njob" value="무직" />무직
 		<input type="radio" name="in_job" id="the" value="그 외" />그 외
	<br/>
	반려동물유무:
 		<input type="radio" name="in_haspet" id="po" value="유" />O
 		<input type="radio" name="in_haspet" id="px" value="무" />X
	<br/>
	사진파일 :
 	 <input type="file" name="in_opic"  />
	<br/>
	목소리파일 :	
	  	<input type="file" name="in_ovoice"  />
	<br/>
	  	<button type="submit" class="Join">회원가입</button>
	  	<button type="reset">초기화</button>						
	</form> 
	
	<script type="text/javascript">
   function validateForm(form) { //   필수 항목 입력 확인
      if (form.in_height.value == "") {    		
   			alert("키를 입력하지 않았습니다.");
   			form.in_height.focus();
   			return false;
   		}
      if (form.in_style.value == "") {    		
 			alert("체형을 입력하지 않았습니다.");
 			return false;
 		}
   		if(form.in_edu.value==""){
   			alert("학력을 입력하지 않았습니다."); 
   			return false;
   		}

   		if(form.in_rlg.value==""){
   			alert("종교를 입력하지 않았습니다.");
   			return false;
   		}
   		if(form.in_drunk.value==""){
   			alert("음주여부를 입력하지 않았습니다.");  
   			return false;
   		}
   		if(form.in_smoke.value==""){
   			alert("흡연여부를 입력하지 않았습니다.");
   			return false;
   		}
   		if(form.in_char.value==""){
   			alert("성격을 입력하지 않았습니다.");
   			return false;
   		}
   		if(form.in_mbti.value==""){
   			alert("mbti를 입력하지 않았습니다.");
   			return false;
   		}
   		if(form.in_hobby.value==""){
   			alert("취미를 입력하지 않았습니다.");
   			form.in_hobby.focus();
   			return false;
   		}
   		if(form.in_job.value==""){
   			alert("직업을 입력하지 않았습니다.");
   			return false;
   		}
   		if(form.in_haspet.value==""){
   			alert("반려동물 여부를 입력하지 않았습니다.");
   			return false;
		}
   		if(form.in_opic.value==""){
   			alert("사진을 입력하지 않았습니다.");
   			return false;
		}
   		if(form.in_ovoice.value==""){
   			alert("목소리를 입력하지 않았습니다.");
   			return false;
		}
		//키 제한
   		if(form.in_height.value>300){
   			alert("키를 다시 입력 해주세요.")
   			form.in_height.focus();
   			return false;
   		}//오버 키 제한
   		if(form.in_height.value<100){
   			alert("키를 다시 체크 해주세요.")
   			form.in_height.focus();
   			return false;
   		}
   }
</script>  

<jsp:include page="../common/Footer.jsp"/>
</body>
</html>
