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
	<h2>비밀번호 검증(Pass)</h2>
	
	<!-- /reviewBoard/reviewPass.do url패턴으로 post 방식으로 접근  -->
	<form name="writeFrm" method="post" action="../qnasBoard/qnasPass.do"
		onsubmit="return validateForm(this);">
		
		<!-- 내장객체에 저장된 num 값 불러오기(${ param.num }) -->
		<input type="hidden" name="num" value="${ param.num }" />
		
		<!-- 내장객체에 저장된 mode 값 불러오기(${ param.mode }) -->
		<input type="hidden" name="mode" value="${ param.mode }" />
		<div style="margin:auto; width: 500px;">
		<h5 style="display: inline;">비밀번호</h5>
		<input type="password" name="pass" style="width:100px;" class="form-element" />
		</div>
		<div style="margin:auto; width: 500px;">

			<button class="btn btn-light" type="submit">검증하기</button>
			<button class="btn btn-light" type="reset">RESET</button>
			<button class="btn btn-light" type="button" onclick="location.href='../qnasBoard/qnasList.do';">
						목록 바로가기
			</button>
		
		</div>
	</form>
	<jsp:include page="../common/Footer.jsp"/>
</body>
</html>