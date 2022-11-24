<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 게시판 수정</title>

	<script type="text/javascript">
		function validateForm(form) {
			if(form.menum.value == "") {
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
		}	
	</script>

</head>
<body>
<jsp:include page="../common/Top.jsp"/>

	<h2>리뷰 수정하기(Edit)</h2>
	<form name="writeFrm" method="post"
		enctype="multipart/form-data"
		action="../qnasBoard/qnasEdit.do" onsubmit="return validateForm(this);">
		<input type="hidden" name="num" value="${ dto.num }" />
		<input type="hidden" name="prevOfile" value="${ dto.ofile }" />
		<input type="hidden" name="prevNfile" value="${ dto.nfile }" />
		<input type="hidden" name="pass" value="${dto.pass }"/>
		<table border="1" width="90%">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="name" style="width:90%;" value="${ dto.name }" />
				</td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" style="width:90%;height:100px;">${ dto.content }</textarea>
				</td>
			</tr>
			
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="ofile" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit">수정 완료</button>
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