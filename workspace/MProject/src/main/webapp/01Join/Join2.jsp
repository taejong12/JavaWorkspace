<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 게시판</title>
<style type="text/css">
body {
  font-family:"Raleway";
}

.form {
  position:relative;
  top:0;
  left:0;
  margin-top:56px;
}


.form .form-header {
  height:30px;
  display:flex;
  align-items:center;
  text-align:center;
}

.form .form-header .show-signup {
  width:calc(100%);
  color:#f1575b;
  font-size:20px;
  font-weight:700;
  cursor:pointer;
}


.form .form-elements {
  margin-top:15px;
  width:650px;
  margin: 0 auto;
}



.form .form-elements .input {
  font-size:14px;
  width: 50%;
  height: 30px;
  margin-top: 5px;
  margin:0 auto;
  padding : 2px 10px;
  border-radius:10px;
  box-sizing:border-box;
  border:none;
  background:#ffeaea;
}

#idchk, #Mpb, #emailchk, #kakaochk {
	line-height:30px;
	margin-left:590px;
	margin-top:5px;
	padding:0;
	width : 60px;
	font-size:12px;
	border-radius: 5px;
}
.form .form-elements button {
  
  font-size:14px;
  font-weight:600;
  border-radius:10px;
  background:#f1575b;
  color:#f5f5f5;
  cursor:pointer;
  border:none;
  outline:none;
}
.form-element {
	margin-top:10px;
	display: flex;
	justify-content: space-between;
	

}
.form-check-inline {
	margin-top:10px;
}
#Join1{
	display:none;
}

</style>
</head>
<body>
<jsp:include page="../Common/Top.jsp"/>


    <div class="form signup" class="p-3 mb-2 bg-secondary text-white">
		<div class="form-header">
	    	<h1 class="show-signup" align="center">Sign Up</h1>
	    </div>
  	
		<form name="myFrm" method="post" enctype="multipart/form-data" 
			action="../controller/Join2.do" onsubmit="return validateForm(this);" >
			
			<div align="center" class="form-elements">
				
				<div class="form-element">
					<div class="form-element" style="width:300px;justify-content: center;"> 
						<input class="input" type="number" name="in_height" placeholder="키" style="margin:0; "/>cm
					</div>
						
					<div>
						체형:
						<input type="radio" name="in_style" id="slan" value="슬랜더"/> 슬랜더				
						<input type="radio" name="in_style" id="aver" value="보통"/> 보통				
						<input type="radio" name="in_style" id="musc" value="근육"/> 근육				
						<input type="radio" name="in_style" id="plu" value="통통"/> 통통
						<input type="radio" name="in_style" id="over" value="과체중"/> 과체중				
					</div>
		
				</div>
				
				<hr />
				
				<div class="form-element">
					<div>
						최종학력:
						<input type="radio" name="in_edu" id="mi" value="중졸이하"/>중졸이하 
						<input type="radio" name="in_edu" id="hi" value="고졸"/>고졸 
						<input type="radio" name="in_edu" id="un" value="대졸"/>대졸 
						<input type="radio" name="in_edu" id="gr" value="대학원이상"/>대학원이상				
					</div>
				</div>
				
				<hr/>
				
				<div class="form-element">
					<div>
						종교:	
						<input type="radio" name="in_rlg" id="cath" value="천주교" /> 천주교
						<input type="radio" name="in_rlg" id="chri" value="기독교" /> 기독교
						<input type="radio" name="in_rlg" id="budd" value="불교" /> 불교
						<input type="radio" name="in_rlg" id="Hin" value="힌두교" /> 힌두교 
						<input type="radio" name="in_rlg" id="Isl" value="이슬람교" /> 이슬람교 
						<input type="radio" name="in_rlg" id="reli" value="무교" /> 무교				
					</div>
				</div>	
				
				<hr/>
				
				<div class="form-element" style="justify-content: center;">
					<div style="display: flex; width: 200px; justify-content: space-evenly;">
						음주:
						<input type="radio" name="in_drunk" id="yes" value="O" />O 
						<input type="radio" name="in_drunk" id="no" value="X" />X 		
					</div>			
				</div>
				
				
				<hr/>
				
			    <div class="form-element" style="justify-content: center;">
			    	<div style="display: flex; width: 200px; justify-content: space-evenly;">
			    		<div>
							흡연:
							<input type="radio" name="in_smoke" id="o" value="O" />O 
							<input type="radio" name="in_smoke" id="x" value="X" />X <br/>
						</div>
					</div>
				</div>
				
				<hr>
				
				<div class="form-element" style="justify-content: center;">
					<div style="display: flex; width: 200px; justify-content: space-evenly;">
						<div>
							성격:
							<input type="radio" name="in_char" id="ex" value="외향적" />외향적 
							<input type="radio" name="in_char" id="in" value="내향적" />내향적
						</div>
					</div>
				</div>
				
				<hr/>
				
				<div class="form-element">MBTI:
					<div style="display: flex; width: 450px; flex-direction: column;">
						<div style="display: flex; width: 100%; justify-content: space-between;">
							<div>
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
							</div>	
						</div>
					</div>
				</div>
				
				<hr/>
				
				<div class="form-element">
					취미:
					<input type="text" name="in_hobby"  />
				</div>
				
				<hr/>
				
				<div class="form-element">
					<div>
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
					</div>
				</div>
				
				<hr/>
				
				<div class="form-element" style="justify-content: center;">
					<div style="display: flex; width: 200px; justify-content: space-evenly;">
						<div>
					 		반려동물유무:
					 		<input type="radio" name="in_haspet" id="po" value="유" />O
					 		<input type="radio" name="in_haspet" id="px" value="무" />X		
						</div>			
					</div>
				</div>
				
				<hr/>
				
				<div class="form-element">
					사진파일 :
			 		<input type="file" name="in_opic"  />
				</div>
				
				<hr/>
				
				<div class="form-element">
				  	목소리파일 :	
		  			<input type="file" name="in_ovoice"  />
				</div>
				
				<hr/>
				
			  	<button type="submit" class="Join">회원가입 완료</button>
			  	<button type="reset" >초기화</button>						
			</div>
		</form>
	</div>
	
<script type="text/javascript">
   	function validateForm(form) { //   필수 항목 입력 확인
	    if(form.in_height.value == "") {    		
	   		alert("키를 입력하지 않았습니다.");
	   		form.in_height.focus();
	   		return false;
	   	}
   
	    if(form.in_style.value == "") {    		
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
   	}
</script>
 
<jsp:include page="../Common/Footer.jsp"/>
</body>
</html>