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


	<h1 align="center">[회원가입]</h1>

	<form name="writeFrm" method="post" action="../controller/Join.do"
	onsubmit = "return validateForm(this);" align="center">
	
<!-- 합치고 난 후 수정 	아이디 중복확인 a잡스에 실행 -->

		아이디 : <input type="text" placeholder="아이디"  name="ME_ID" id="Idchecks" />		
		    <input type="button"  value="중복확인" id="idchk" name="idcheck"/>
		    <input type="hidden" id="check" name="idDuplication" value="idUncheck">
      		<font id = "checkId" size = "2"></font><br /><br />
      		
		비밀번호 : <input type="password" placeholder="비밀번호"  name="ME_PASS" id="ME_PASS" class="pw" /><br/><br/>
		비밀번호 재확인 : <input type="password" placeholder="비밀번호"  name="ME_PASS2" id="ME_PASS2" class="pw" />
			<font id = "checkPw" size = "2"></font><br /><br />
		이름 : <input type="text" placeholder="이름"  name="ME_NAME" /><br /><br />
		
		생년월일 : <input type="date" id="date" placeholder="yyyy-mm-dd" name="ME_BIRTH" /><br /><br />
		
		성별 : <input type="radio" placeholder="성별"  name="ME_SEX" value="남" checked/>남자		
		   <input type="radio" placeholder="성별"  name="ME_SEX" value="여"/>여자<br /><br />
		   
		나이 : <input type="number" placeholder="나이"  name="ME_AGE" /><br /><br />
		
		핸드폰 번호 : <input type="tel" placeholder="xxx-xxxx-xxxx"  name="ME_PHONE" id="Mpv"
		required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"  maxlength="13"/>
		  	<input type="button"  value="확인" name="phonecheck" id="Mpb" />
		  	<input type="hidden" id="phcheck" name="phDuplication" value="phUncheck" >
      		<font size = "2" id = "Mpf" ></font><br /><br />
		
		이메일 : <input type="email" placeholder="xxxx@xxxx.xxx"  name="ME_EMAIL" id="emailchkv"  />
		 	<input type="button"  value="확인" name="emailcheck" id="emailchk"  />
		 	<input type="hidden" id="emcheck" name="emDuplication" value="emUncheck" >
      		<font size = "2" id = "emailft" ></font><br /><br />
		
		카카오ID : <input type="text" placeholder="카카오ID"  name="ME_KAKAO" id="kakaochkv" />
			<input type="button"  value="확인" name="kakaocheck" id="kakaochk" />
			<input type="hidden" id="kacheck" name="koDuplication" value="kaUncheck">
      		<font size = "2" id = "kakaoft" ></font><br /><br />
		
		지역번호 : 		
		<select name="RE_NUM">
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
        </select><br/><br/>
		          
		<button type="submit" id="btnConfirm">다음페이지로</button>
		<button type="reset">초기화</button>							
	</form>
	
<script type="text/javascript">

	//전화번호 총 변환
function autoHypenTel(str) {
        str = str.replace(/[^0-9]/g, '');
        var tmp = '';

        if (str.substring(0, 2) == 02) {
          // 서울 전화번호일 경우 10자리까지만 나타나고 그 이상의 자리수는 자동삭제
          if (str.length < 3) {
            return str;
          } else if (str.length < 6) {
            tmp += str.substr(0, 2);
            tmp += '-';
            tmp += str.substr(2);
            return tmp;
          } else if (str.length < 10) {
            tmp += str.substr(0, 2);
            tmp += '-';
            tmp += str.substr(2, 3);
            tmp += '-';
            tmp += str.substr(5);
            return tmp;
          } else {
            tmp += str.substr(0, 2);
            tmp += '-';
            tmp += str.substr(2, 4);
            tmp += '-';
            tmp += str.substr(6, 4);
            return tmp;
          }
        } else {
          // 핸드폰 및 다른 지역 전화번호 일 경우
          if (str.length < 4) {
            return str;
          } else if (str.length < 7) {
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3);
            return tmp;
          } else if (str.length < 11) {
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 3);
            tmp += '-';
            tmp += str.substr(6);
            return tmp;
          } else {
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 4);
            tmp += '-';
            tmp += str.substr(7);
            return tmp;
          }
        }

        return str;
      }
    	$('#Mpv').keyup(function (event) {
  		  event = event || window.event;
  		  var _val = this.value.trim();
  		  this.value = autoHypenTel(_val);
  		});



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
		//미성년자 체크
   		if(form.ME_AGE.value<20){
   			alert("미성년자입니다. 나이를 다시 체크 해주세요.")
   			form.ME_AGE.focus();
   			return false;
   		}//오버 나이 체크
   		if(form.ME_AGE.value>90){
   			alert("나이를 다시 체크 해주세요.")
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
		//아이디 중복체크 + ajax
        if(form.idDuplication.value == "idUncheck"){
            alert("아이디 중복체크를 해주세요.");
            return false;
        }
		//핸드폰 번호 중복체크 + ajax
        if(form.phDuplication.value == "phUncheck"){
            alert("핸드폰 번호 중복체크를 해주세요.");
            return false;
        }
        //이메일 중복체크 + ajax
        if(form.emDuplication.value == "emUncheck"){
            alert("이메일 중복체크를 해주세요.");
            return false;
        }
        //카카오 아이디 중복체크 + ajax
        if(form.koDuplication.value == "kaUncheck"){
            alert("카카오 아이디 중복체크를 해주세요.");
            return false;
        }
        //생년월일 미성년자 체크
   		if(2022-Number(form.ME_BIRTH.value.substr(0,4))<20){
   			alert("미성년자 입니다. 생년월일을 다시 체크 해주세요.")
   			return false;
   		}	
   }        
</script>
	
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
                    $("#btnConfirm").prop("disabled",true);
                } else{
                    $("#Mpf").html('사용할 수 있는 전화번호입니다.');
                    $("#Mpf").attr('color','#2fb380');
                    $("#phcheck").val('phcheck');
                    $("#btnConfirm").prop("disabled",false);
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
                          $("#btnConfirm").prop("disabled",true);
                          
                        } else{
                           $("#emailft").html('사용할 수 있는 이메일입니다.');
                           $("#emailft").attr('color','#2fb380');
                           $("#emcheck").val('emcheck');
                           $("#btnConfirm").prop("disabled",false);
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
                          $("#btnConfirm").prop("disabled",true);
                       
                        } else{
                           $("#kakaoft").html('사용할 수 있는 카카오ID입니다.');
                           $("#kakaoft").attr('color','#2fb380'); 
                           $("#kacheck").val('kacheck');
                           $("#btnConfirm").prop("disabled",false);
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
