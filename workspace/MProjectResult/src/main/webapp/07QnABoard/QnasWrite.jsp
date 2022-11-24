<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA게시판 글쓰기</title>
	
<script type="text/javascript">
	function validateForm(form) { //	필수 항목 입력 확인
		if (form.menum.value == "") {
			alert("작성자를 입력하세요.");
			form.menum.focus();
			return false;
		}
		if(form.name.value == "") {
			alert("제목을 입력하세요.");
			form.name.focus();
			return false;
		}
		if(form.content.value == "") {
			alert("내용을 입력하세요.");
			form.content.focus();
			return false;
		}
		if(form.pass.value == "") {
			alert("비밀번호를 입력하세요.");
			form.pass.focus();
			return false;
		}
		
	}

</script>

</head>
<body>
<jsp:include page="../common/Top.jsp"/>
	<h2>파일 첨부형 게시판 - QnA작성(Write)</h2>
	<form name="writeFrm" method="post" enctype="multipart/form-data"
		action="../qnasBoard/qnasWrite.do" onsubmit="return validateForm(this);">
		${sessionScope.me_num }
		${sessionScope.me_name }
		<input type="hidden" name="me_num" value="${sessionScope.me_num }"/>
		<input type="hidden" name="me_name" value="${sessionScope.me_name }"/>
		<table>
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" style="width:150px;" />
				</td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="name" style="width:90%;" />
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" style="width:90%;height:100px;"></textarea>
				</td>
			</tr>
			
			<tr>
				<td>첨부 파일</td>
				<td>
					<input type="file" name="ofile" />
				</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pass" style="width:100px;" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성완료</button>
					<button type="reset">RESET</button>
					<button type="button" onclick="location.href='../qnasBoard/qnasList.do';">
						목록 바로가기
					</button>
				</td>
			</tr>	
		</table>
	</form>
	<jsp:include page="../common/Footer.jsp"/>
</body>
</html>