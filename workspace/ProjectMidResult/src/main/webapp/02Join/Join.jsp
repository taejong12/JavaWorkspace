<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 게시판</title>
<style>
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



.form .form-elements input {
  font-size:14px;
  width: 100%;
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
}
.form-check-inline {
	margin-top:10px;
}

}

</style>
</head>
<body>
<jsp:include page="../common/Top.jsp"/>

<script type="text/javascript">
   function validateForm(form) { //   필수 항목 입력 확인
      if (form.ME_ID.value =="") {          
            alert("아이디를 입력하지 않았습니다.");
            form.ME_ID.focus();
            return false;
         }
      if (form.ME_ID.value == "") {          
          alert("아이디를 입력하지 않았습니다.");
          form.ME_ID.focus();
          return false;
       }
         if(form.ME_PASS.value==""){
            alert("비밀번호를 입력하지 않았습니다.");
            form.ME_PASS.focus();
            return false;
         }
         if(form.ME_PASS.value!= form.ME_PASS2.value){
            alert("비밀번호가 일치하지 않았습니다.");
            form.ME_PASS.focus();
            return false;
         }
         if(form.ME_PASS2.value==""){
            alert("비밀번호 재확인을 입력하지 않았습니다.");
            form.ME_PASS2.focus();
            return false;
         }
         if(form.ME_NAME.value==""){
            alert("이름을 입력하지 않았습니다.");
            form.ME_NAME.focus();
            return false;
         }
         if(form.ME_BIRTH.value==""){
            alert("생년원일을 입력하지 않았습니다.");
            form.ME_BIRTH.focus();
            return false;
         }
         if(form.ME_BIRTH.value.length>10){
            alert("잘못된 생년월일 입니다.")
            return false;
         }
 
         if(form.ME_SEX.value==""){
            alert("성별을 입력하지 않았습니다.");
            form.ME_SEX.focus();
            return false;
         }
         if(form.ME_AGE.value==""){
            alert("나이를 입력하지 않았습니다.");
            form.ME_AGE.focus();
            return false;
         }
         if(form.ME_AGE.value<20){
            alert("미성년자입니다.")
            form.ME_AGE.focus();
            return false;
         }
         if(form.ME_PHONE.value==""){
            alert("전화번호를 입력하지 않았습니다.");
            form.ME_PHONE.focus();
            return false;
         }
         if(form.ME_EMAIL.value==""){
            alert("이메일을 입력하지 않았습니다.");
            form.ME_EMAIL.focus();
            return false;
         }
         if(form.ME_KAKAO.value==""){
            alert("카카오 아이디를 입력하지 않았습니다.");
            form.ME_KAKAO.focus();
            return false;
         }
         if(form.RE_NUM.value==""){
            alert("지역번호를 입력하지 않았습니다.");
            form.RE_NUM.focus();
            return false;
      }         

        if(form.idDuplication.value == "idUncheck"){
            alert("아이디 중복체크를 해주세요.");
            return false;
        }
   }
      
</script>
<div class="form signup" class="p-3 mb-2 bg-secondary text-white">
	<div class="form-header">
    	<h1 class="show-signup">Sign Up</h1>
  	</div>

	<form name="writeFrm" method="post" action="../controller/Join.do"
	onsubmit = "return validateForm(this);" >
		<div class="form-elements" align="center" >
			
			<div class="form-element" style="position: relative;">
				<input type="text" placeholder="아이디"  name="ME_ID" id="Idchecks" />
				<button type="button" id="idchk" name="idcheck">중복확인</button>
		      	<font id = "checkId" size = "1"></font>
	      	</div>
	      	
	      	<div class="form-element">
				<input type="password" placeholder="비밀번호"  name="ME_PASS" id="ME_PASS" class="pw" />
	      	</div>
	      	
	      	<div class="form-element">
				<input type="password" placeholder="비밀번호확인"  name="ME_PASS2" id="ME_PASS2" class="pw" />
				<font id = "checkPw" size = "2"></font>
	      	</div>
			
			<div class="form-element">
				<input type="text" placeholder="이름"  name="ME_NAME" />
			</div>
			
			<div class="form-element">
				<input type="text" placeholder="생년월일" name="ME_BIRTH" />
			</div>
			
			
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="ME_SEX" id="inlineRadio1" value="남" style="padding:0;">
			  <label class="form-check-label" for="inlineRadio1">남자</label>
			</div>
			
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="ME_SEX" id="inlineRadio2" value="여" style="padding:0;">
			  <label class="form-check-label" for="inlineRadio2">여자</label>
			</div>
			
			<div class="form-element">
				<input type="number" placeholder="나이"  name="ME_AGE" />
			</div>   
			
			<div class="form-element">
			<input type="tel" placeholder="핸드폰 번호"  name="ME_PHONE" id="Mpv"/>
			  	<button type="button" name="phonecheck" id="Mpb">확인</button>
	      		<font size = "2" id = "Mpf" ></font>
	      	</div>
			
			<div class="form-element">
			<input type="email" placeholder="이메일 주소"  name="ME_EMAIL" id="emailchkv"  />
			 	<button type="button" name="emailcheck" id="emailchk">확인</button>
	      		<font size = "2" id = "emailft" ></font>
			</div>
			
			<div class="form-element">
			 <input type="text" placeholder="카카오ID"  name="ME_KAKAO" id="kakaochkv" />
				<button type="button" name="emailcheck" id="kakaochk">확인</button>
	      		<font size = "2" id = "kakaoft" ></font>
			</div>
   
      <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; display: flex; width: 200px; justify-content: space-between;">
      지역구<select name="RE_NUM" id="renum" style="background-color:white; border-radius: 10px; ">
                  <option value="201">강남구
                  </option>
                  <option value="202">강동구
                  </option>
                  <option value="203">강북구
                  </option>
                  <option value="204">강서구
                  </option>
                  <option value="205">관악구
                  </option>
                  <option value="206">광진구
                  </option>
                  <option value="207">구로구
                  </option>
                  <option value="208">금천구
                  </option>
                  <option value="209">노원구
                  </option>
                  <option value="210">도봉구
                  </option>
                  <option value="211">동대문구
                  </option>
                  <option value="212">동작구
                  </option>
                  <option value="213">마포구
                  </option>
                  <option value="214">서대문구
                  </option>
                  <option value="215">서초구
                  </option>
                  <option value="216">성동구
                  </option>
                  <option value="217">성북구
                  </option>
                  <option value="218">송파구
                  </option>
                  <option value="219">양천구
                  </option>
                  <option value="220">영등포구
                  </option>
                  <option value="221">용산구
                  </option>
                  <option value="222">은평구
                  </option>
                  <option value="223">종로구
                  </option>
                  <option value="224">중구
                  </option>
                  <option value="225">중랑구
                  </option>         
        </select>
        </div>
			<button type="submit" id="signup" style="margin-top:10px;" src="html/Join2">계속</button>														
		</div>
	</form>
</div>                     
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
       
   <script type ="text/javascript">
        $('#idchk').click(function(){
            let userId = $('#Idchecks').val(); // input_id에 입력되는 값            
            $.ajax({
               url : "check.jsp",
               type : "post",
               data : {userId: userId},
               dataType : 'json',
               success : function(result){
                if(result == 0){
                           $("#checkId").html('사용할 수 없는 아이디입니다.');
                           $("#checkId").attr('color','#dc3545');
                           $("#btnConfirm").prop("disabled",true);
                        }else{
                           $("#checkId").html('사용할 수 있는 아이디입니다.');
                           $("#checkId").attr('color','#2fb380');
                           $("#check").val('idcheck');
                           $("#btnConfirm").prop("disabled",false);
                        } 
                  },
                  error : function(){
                     lert("서버요청실패");
                  }
            })             
        })
</script> 
   
<script type ="text/javascript">
    $('#Mpb').click(function(){
           let userPh = $('#Mpv').val(); // input_id에 입력되는 값            
        $.ajax({
            url : "phCheck.jsp",
            type : "post",
            data : {userPh: userPh},
            dataType : 'json',
            success : function(result){
                if(result == 0){
                    $("#Mpf").html('사용할 수 없는 전화번호입니다.');
                    $("#Mpf").attr('color','#dc3545');
                } else{
                    $("#Mpf").html('사용할 수 있는 전화번호입니다.');
                    $("#Mpf").attr('color','#2fb380');
                } 
            },
            error : function(){
            alert("서버요청실패");
            }
        })             
    })             
</script>

<script type ="text/javascript">
        $('#emailchk').click(function(){
        let userEmail = $('#emailchkv').val(); // input_id에 입력되는 값            
           $.ajax({
              url : "emailCheck.jsp",
              type : "post",
              data : {userEmail: userEmail},
              dataType : 'json',
              success : function(result){
                 if(result == 0){
                          $("#emailft").html('사용할 수 없는 이메일입니다.');
                          $("#emailft").attr('color','#dc3545');
                          
                          
                        } else{
                           $("#emailft").html('사용할 수 있는 이메일입니다.');
                           $("#emailft").attr('color','#2fb380');
                        } 
                 },
              error : function(){
                 alert("서버요청실패");
              }
           })             
        })             
</script>

<script type ="text/javascript">
        $('#kakaochk').click(function(){
        let userKakao = $('#kakaochkv').val(); // input_id에 입력되는 값            
           $.ajax({
              url : "kakaoCheck.jsp",
              type : "post",
              data : {userKakao: userKakao},
              dataType : 'json',
              success : function(result){
                 if(result == 0){
                          $("#kakaoft").html('사용할 수 없는 카카오ID입니다.');
                          $("#kakaoft").attr('color','#dc3545');
                          
                       
                        } else{
                           $("#kakaoft").html('사용할 수 있는 카카오ID입니다.');
                           $("#kakaoft").attr('color','#2fb380');                           
                        } 
              },
              error : function(){
                 alert("서버요청실패");
              }
           })             
        })             
</script>
<script src = "js/jquery-3.6.0.min.js"></script>
<script>
   $('.pw').keyup(function(){
       let pw1 = $("#ME_PASS").val();
        let pw2 = $("#ME_PASS2").val();
        
        if (pw1 != "" || pw2 != ""){
           if (pw1 == pw2){
               $("#checkPw").html('비밀번호 일치');
               $("#checkPw").attr('color','green');
            } else {
               $("#checkPw").html('비밀번호 불일치');
                $("#checkPw").attr('color','red');
            }
        }    
    })
    
</script>
<jsp:include page="../common/Footer.jsp"/>
</body>
</html>