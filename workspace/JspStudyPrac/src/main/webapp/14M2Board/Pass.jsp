<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 게시판</title>

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
	<h2>비밀번호 검증(Pass)</h2>
	
	<!-- /m2board/pass.do url패턴으로 post 방식으로 접근  -->
	<form name="writeFrm" method="post" action="../m2board/pass.do"
		onsubmit="return validateForm(this);">
		
		<!-- 내장객체에 저장된 idx 값 불러오기(${ param.idx }) -->
		<input type="hidden" name="idx" value="${ param.idx }" />
		
		<!-- 내장객체에 저장된 mode 값 불러오기(${ param.mode }) -->
		<input type="hidden" name="mode" value="${ param.mode }" />
		<table border="1" width="90%">
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pass" style="width:100px;" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">검증하기</button>
					<button type="reset">RESET</button>
					<button type="button" onclick="location.href='../m2board/list.do';">
						목록 바로가기
					</button>
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>

