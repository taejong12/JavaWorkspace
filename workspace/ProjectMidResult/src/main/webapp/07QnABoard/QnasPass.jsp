<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 비밀번호 인증</title>
<style type="text/css">
div{borad}
<style type="text/css">

.body {
		font-family: 'Lora', serif;
	}
	
	.form {
	  position:relative;
	  top:0;
	  left:0;
	}
	
	
	.form .form-header {
	  
	  display:flex;
	  align-items:center;
	  text-align:center;
	}
	
	.form .form-header .show-signup {
	  width:calc(100%);
	  color:#f1575b;
	  font-size:1.5em;
	  font-weight:700;
	  cursor: default;
	}
	
	

	.form .form-elements input {
	
	  font-size:14px;
	  width: 30%;
	  height: 50px;
	  margin-top: 5px;
	  margin:0 auto;
	  padding : 2px 10px;
	  border-radius:10px;
	  box-sizing:border-box;
	  border:none;
	  background:#ffeaea;
	  
	}
	
	
	.form .form-elements button {
	  
	  font-size: 1.5em;
	  font-weight:600;
	  border-radius:10px;
	  background:#f1575b;
	  color:#f5f5f5;
	  border:none;
	  outline:none;
	  width: 30%;
	  padding: 1%;
	  
	}
	
	.form .form-elements input {
	
	  font-size:14px;
	  width: 30%;
	  height: 50px;
	  margin-top: 5px;
	  margin:0 auto;
	  padding : 2px 10px;
	  border-radius:10px;
	  box-sizing:border-box;
	  border:none;
	  background:#ffeaea;
	  
	}


</style>
<script type="text/javascript">
	function validateForm(form) {
		if(form.pass.value=="") {
			if(form.pass.value =="") {
				alert("비밀번호를 입력하세요.");
				form.pass.focus();
				return false;
			}
		}
	}
</script>


</head>
<body>
	<jsp:include page="../common/Top.jsp"/>
	<div style="padding: 3em 20em; margin: 5% 0em;">
	
		<div class="form signup" class="p-3 mb-2 bg-secondary text-white">
			<div class="form-header" style="margin: 5% 0em;" >
		    	<h1 class="show-signup">비밀번호 검증</h1>
		  	</div>
		  	
			<!-- /reviewBoard/reviewPass.do url패턴으로 post 방식으로 접근  -->
			<form name="writeFrm" method="post" action="../qnasBoard/qnasPass.do"
				onsubmit="return validateForm(this);">
				
				<!-- 내장객체에 저장된 num 값 불러오기(${ param.num }) -->
				<input type="hidden" name="num" value="${ param.num }" />
				
				<!-- 내장객체에 저장된 mode 값 불러오기(${ param.mode }) -->
				<input type="hidden" name="mode" value="${ param.mode }" />
				
				<div class="form-elements" align="center" >	
					
					<div class="form-element" align="center" style="margin-bottom: 1.5%; text-align: center;" >
						<input value="<%= session.getAttribute("me_name") %>" style="text-align: center; font-size: 1.3em; font-weight: bold;"  disabled*/>
					</div>
					
					<div class="form-element" align="center" >
						<input type="password" placeholder="비밀번호" name="pass" />
					</div>
						
					<div class="form-element" align="center" style="margin-top: 5%;" >
						<button class="button1" type="submit">검증하기</button>
					</div>
					
					<div class="form-element" align="center" style="margin: 1% 0em;">
						<button class="button1" type="reset"
							onclick="if( confirm('리셋하시겠습니까?') == false ) return false;">초기화</button>
					</div>		
					
					<div class="form-element" align="center" style="margin-bottom: 5%;">
						<button class="button1" type="button" 
							onclick="if( confirm('목록으로 이동하시겠습니까?') == false ) return false; location.href='../qnasBoard/qnasList.do';">
							목록 바로가기
						</button>
					</div>			
					
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../common/Footer.jsp"/>
</body>
</html>