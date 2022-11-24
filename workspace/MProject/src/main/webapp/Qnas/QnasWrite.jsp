<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<c:if test="${sessionScope.me_id eq null}">
	<jsp:forward page="../02Login/LoginForm.jsp"/>
</c:if>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA게시판 글쓰기</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">


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

<style>
	form {
		background: white;
		border: solid 1px black;
	}
</style>

</head>
<body>
	<jsp:include page="../Common/Top.jsp"/>	
	
	<div style="background: #ffeaea; padding: 3em 20em; margin: 5% 0em;">
	<form name="writeFrm" method="post" enctype="multipart/form-data"
		action="../qnasBoard/qnasWrite.do" 
		onsubmit="if(confirm('작성완료 하시겠습니까?')==false) return false; return validateForm(this);">
		<h2>파일 첨부형 게시판 - QnA작성(Write)</h2>
		<table class="table table-bordered" style="margin:0;">
			<tr>
				<td align="center">작성자</td>
				<td>
					<input class="form-control" type="text" name="menum"  style="width:150px;"/>
				</td>
			</tr>
			
			<tr>
				<td align="center">제목</td>
				<td>
					<input class="form-control" type="text" name="name" style="width:90%;" />
				</td>
			</tr>
			<tr>
				<td align="center" style="padding: 3em 0em;">내용</td>
				<td>
					<textarea class="form-control" name="content" style="width:90%;height:100px;"></textarea>
				</td>
			</tr>
			
			<tr>
				<td align="center">첨부 파일</td>
				<td>
					<input style="width:70%;" class="form-control" type="file" name="ofile" />
				</td>
			</tr>
			
			<tr>
				<td align="center">게시판 비밀번호</td>
				<td>
					<input class="form-control" type="password" name="pass" style="width:100px;" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-outline-success" type="submit">작성완료</button>
					<button class="btn btn-outline-danger" type="reset"
						onclick="if( confirm('리셋하시겠습니까?') == false ) return false;">RESET</button>
					<button class="btn btn-outline-info" type="button"
						onclick="if( confirm('목록으로 이동하시겠습니까?') == false ) return false; location.href='../qnasBoard/qnasList.do';">
						목록 바로가기
					</button>
				</td>
			</tr>	
		</table>
	</form>
	</div>
	
<jsp:include page="../Common/Footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>