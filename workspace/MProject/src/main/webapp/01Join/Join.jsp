<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 게시판</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		
<style>
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
	  	cursor:default;
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
	
		
</style>

</head>

<body>
	<jsp:include page="../Common/Top.jsp"/>
	
	
	<div class="form signup" class="p-3 mb-2 bg-secondary text-white">
		<div class="form-header">
	    	<h1 class="show-signup">Sign Up</h1>
	  	</div>

		<form name="writeFrm" method="post" action="../controller/Join.do"
			onsubmit = "return validateForm(this);">
			<div class="form-elements" align="center" >
				<div class="form-element" >
					<input type="text" placeholder="아이디"  name="ME_ID" id="Idchecks" />		
				    <button type="button" id="idchk" name="idcheck">중복확인</button>
		      		<font id = "checkId" size = "2"></font>
				</div>
				
				<div class="form-element">
					<input type="password" placeholder="비밀번호"  name="ME_PASS" id="ME_PASS" class="pw" />
				</div>
				
				<div class="form-element">
					<input type="password" placeholder="비밀번호"  name="ME_PASS2" id="ME_PASS2" class="pw" />
					<font id = "checkPw" size = "2"></font>
				</div>	
					
				<div class="form-element">
					<input type="text" placeholder="이름"  name="ME_NAME" />
				</div>
					
				<div class="form-element">
					<input type="date" id="date" placeholder="yyyy-mm-dd" name="ME_BIRTH" />
				</div>
				
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="ME_SEX" id="inlineRadio1" value="남" style="padding:0;" checked/>
					<label class="form-check-label" for="inlineRadio1">남자</label>	
						
				</div>	
				
				<div class="form-check form-check-inline">
				   	<input class="form-check-input" type="radio" name="ME_SEX"  id="inlineRadio2" value="여" style="padding:0;" />
				   	<label class="form-check-label" for="inlineRadio2">여자</label>
				</div>	 
				
				<div class="form-element">
					<input type="number" placeholder="나이" name="ME_AGE" />
				</div> 
					
				<div class="form-element">
					<input type="tel" placeholder="xxx-xxxx-xxxx"  name="ME_PHONE" id="Mpv"
						required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}" maxlength="13" />
				  	<button type="button" name="phonecheck" id="Mpb">확인</button>
				  	<input type="hidden" id="phcheck" name="phDuplication" value="phUncheck" >
		      		<font size = "2" id = "Mpf" ></font>
				</div>	
					
				<div class="form-element">
					<input type="email" placeholder="xxxx@xxxx.xxx"  name="ME_EMAIL" id="emailchkv"  />
				 	<button type="button" name="emailcheck" id="emailchk">확인</button>
				 	<input type="hidden" id="emcheck" name="emDuplication" value="emUncheck" >
		      		<font size = "2" id = "emailft" ></font>
				</div>	
					
				<div class="form-element">
					<input type="text" placeholder="카카오ID"  name="ME_KAKAO" id="kakaochkv" />
					<button type="button" name="emailcheck" id="kakaochk">확인</button>
					<input type="hidden" id="kacheck" name="koDuplication" value="kaUncheck">
		      		<font size = "2" id = "kakaoft" ></font>
				</div>	
				
				<div class="form-element" style="background-color:#ffeaea; border-radius: 10px; display: flex; width: 200px; justify-content: space-between;">
			      	지역번호
			      	<select name="RE_NUM" id="renum" style="background-color:white; border-radius: 10px; ">
			            <option value="201">강남구</option>
			            <option value="202">강동구</option>
			           	<option value="203">강북구</option>
			            <option value="204">강서구</option>
			            <option value="205">관악구</option>
			            <option value="206">광진구</option>
			            <option value="207">구로구</option>
			            <option value="208">금천구</option>
			            <option value="209">노원구</option>
			            <option value="210">도봉구</option>
			            <option value="211">동대문구</option>
			            <option value="212">동작구</option>
			            <option value="213">마포구</option>
			            <option value="214">서대문구</option>
		                <option value="215">서초구</option>
		                <option value="216">성동구</option>
		                <option value="217">성북구</option>
		                <option value="218">송파구</option>
		                <option value="219">양천구</option>
		                <option value="220">영등포구</option>
		                <option value="221">용산구</option>
		                <option value="222">은평구</option>
		                <option value="223">종로구</option>
		                <option value="224">중구</option>
		                <option value="225">중랑구</option>         
			        </select>
				</div>          
				          
				<button type="submit" id="btnConfirm" style="margin-top:10px;">다음페이지</button>							
				<button type="reset">초기화</button>							
			</div>
		</form>
	</div>	
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
	    
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
		    if(form.ME_ID.value == "") {    		
	   			alert("아이디를 입력하지 않습니다.");
	   			form.ME_ID.focus();
	   			return false;
		   	}
		   
		    if(form.ME_ID.value == "") {    		
	 			alert("아이디를 입력하지 않습니다.");
	 			form.ME_ID.focus();
	 			return false;
		 	}
	      
	   		if(form.ME_PASS.value==""){
   				alert("비밀번호를 입력하지 않습니다.");
	   			form.ME_PASS.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_PASS.value!= form.ME_PASS2.value){
	   			alert("비밀번호가 일치하지 않습니다.");
	   			form.ME_PASS.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_PASS2.value==""){
	   			alert("비밀번호 재확인을 입력하지 않습니다.");
	   			form.ME_PASS2.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_NAME.value==""){
	   			alert("이름을 입력하지 않습니다.");
	   			form.ME_NAME.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_BIRTH.value==""){
	   			alert("생년원일을 입력하지 않습니다.");
	   			form.ME_BIRTH.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_SEX.value==""){
	   			alert("성별을 입력하지 않습니다.");
	   			form.ME_SEX.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_AGE.value==""){
	   			alert("나이를 입력하지 않습니다.");
	   			form.ME_AGE.focus();
	   			return false;
	   		}
	   		
	   		//미성년자 체크
	   		if(form.ME_AGE.value<20){
	   			alert("미성년자입니다. 나이를 다시 체크 해주세요.")
	   			form.ME_AGE.focus();
	   			return false;
	   		}
	   		
			//오버 나이 체크
	   		if(form.ME_AGE.value>90){
	   			alert("나이를 다시 체크 해주세요.")
	   			form.ME_AGE.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_PHONE.value==""){
	   			alert("전화번호를 입력하지 않습니다.");
	   			form.ME_PHONE.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_EMAIL.value==""){
	   			alert("이메일을 입력하지 않습니다.");
	   			form.ME_EMAIL.focus();
	   			return false;
	   		}
	   		
	   		if(form.ME_KAKAO.value==""){
	   			alert("카카오 아이디를 입력하지 않습니다.");
	   			form.ME_KAKAO.focus();
	   			return false;
	   		}
	   		
	   		if(form.RE_NUM.value==""){
	   			alert("지역번호를 입력하지 않습니다.");
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
	
	<script>  	
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
	               	} else{
	                    $("#checkId").html('사용할 수 있는 아이디입니다.');
	                    $("#checkId").attr('color','#2fb380');
	                    $("#check").val('idcheck');
	                    $("#btnConfirm").prop("disabled",false);
	                } 
               	},
               	error : function(){
                  	lert("서버요청실패");
               	}
            });             
        }); 	
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
	                    $("#btnConfirm").prop("disabled",false);
	                } 
	            },
	            error : function(){
	            alert("서버요청실패");
	            }
	        });             
	    });             
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
           	});            
        });           
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
	           	});             
	        });             
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
	    
	    });
	    
	</script>
	
	<jsp:include page="../Common/Footer.jsp"/>
</body>
</html>
