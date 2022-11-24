<%@page import="cookie.ManageCookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String loginId = ManageCookie.readCookie(request, "loginId");

String cookieCheck = "";
if (!loginId.equals("")) {
   cookieCheck = "checked";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
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

#chkbox {
	display:inline-block;
	width:15px;
	
}
.cb {
	text-align: right;
	vertical-align: middle;
}
.chk-text {
	margin :0;
	padding : 0;
	display: inline-block;
}
</style>
</head>
<body>
<jsp:include page="../common/Top.jsp"/>
   <span style="color:red; font-size: 1.2em;">
      <%= request.getAttribute("LoginErrMsg")== null? "":request.getAttribute("LoginErrMsg") %>
   </span>
   <%
   if(session.getAttribute("me_id")==null){ //로그인 상태 확인
      //로그아웃 상태
   %>
   
   <script>
   function validateForm(form) {
       if(!form.me_id.value){
          alert("아이디를 입력하세요.");
          return false;
       }
       if(form.me_pass.value==""){
          alert("패스워드를 입력하세요.");
          return false;
       }
    }
   </script>   

<div class="form signup" class="p-3 mb-2 bg-secondary text-white">
	<div class="form-header">
    	<h1 class="show-signup">Sign in</h1>
  	</div>

	<form name="loginFrm" method="post" action="../loginOut/loginOut.do"
	onsubmit = "return validateForm(this);" >
		
		<div class="form-elements" align="center" >
			
			<div class="form-element" style="position: relative;">
				<input type="text" name="me_id" placeholder="ID 입력" id="Idchecks"value="<%= loginId %>" />
				<div class="cb">
					<input id="chkbox" type="checkbox" name="save_check" value="Y<%= cookieCheck %>"
						style="height:15px;"/>
					<p class="chk-text">아이디저장</p>
				
				</div>
				
			</div>
	      	<div class="form-element">
		      	<input type="password" name="me_pass" class="pw" placeholder="8자 이상 입력(문자/숫자/기호 사용 가능)"/><br/>
				<br/>
				<button type="submit" id="signup" style="margin-top:10px;">로그인</button>
			</div>											
		</div>
	</form>
	</div>
	<%
   }
	%>
	<jsp:include page="../common/Footer.jsp"/>
</body>
</html>
