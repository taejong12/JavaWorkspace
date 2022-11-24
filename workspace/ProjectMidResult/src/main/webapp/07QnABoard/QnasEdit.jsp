<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 게시판 수정</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

<style>

	form {
		background: white;
		border: solid 1px black;
	}
		
	.star-rating {
		border: none;
		display:flex;
		flex-direction: row-reverse;
		font-size:1.5em;
		justify-content:space-around;
		padding:0 .2em;
		text-align:center;
		width:5em;
		margin-left: 10px;
	}
	
	.star-rating input {
	  display:none;
	}
	
	.star-rating label {
	  color:#ccc;
	  cursor:pointer;
	}
	
	.star-rating :checked ~ label {
	  color:#f90;
	}
	
	.star-rating label:hover,
	.star-rating label:hover ~ label {
	  color:#fc0;
	}


	.star-rating1 {
		display:flex;
		flex-direction: row-reverse;
		font-size:1.5em;
		justify-content:center;
		padding:0 .2em;
		text-align:center;
		width:5em;
		
	}
	
	.star-rating1 input {
		display:none;
	}
	
	.star-rating1 label {
		color:#f90;
	}
	
	
</style>

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

	<div style="background: #ffeaea; padding: 3em 20em; margin: 5% 0em;">
	<form name="writeFrm" method="post"
		enctype="multipart/form-data"
		action="../qnasBoard/qnasEdit.do" 
		onsubmit="if(confirm('수정완료 하시겠습니까?')==false) return false; return validateForm(this);">
		<input type="hidden" name="num" value="${ dto.num }" />
		<input type="hidden" name="prevOfile" value="${ dto.ofile }" />
		<input type="hidden" name="prevNfile" value="${ dto.nfile }" />
		<input type="hidden" name="pass" value="${dto.pass }"/>
		<h2>리뷰 수정하기(Edit)</h2>
		<table class="table table-bordered" style="margin:0;">
			<tr>
				<td align="center">작성자</td>
				<td> 
					${dto.writer }
				</td>
			</tr>
			
			
			
			<tr>
				<td align="center">제목</td>
				<td>
					<input class="form-control" type="text" name="name" style="width:90%;" value="${ dto.name }" />
				</td>
			</tr>
			
			<tr>
				<td align="center" style="padding: 3em 0em;">내용</td>
				<td>
					<textarea class="form-control" name="content" style="width:90%;height:100px;">${ dto.content }</textarea>
				</td>
			</tr>
			
			<tr>
				<td align="center">첨부파일</td>
				<td>
					<input class="form-control" type="file" name="ofile" style="width:70%;" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-outline-success" type="submit">수정 완료</button>
					<button class="btn btn-outline-danger" type="reset"
					onclick="if( confirm('리셋하시겠습니까?') == false ) return false;">RESET</button>
					<button class="btn btn-outline-info" type="button" onclick="if( confirm('목록으로 이동하시겠습니까?') == false ) return false; location.href='../qnasBoard/qnasList.do';">
						목록 바로가기
					</button>	
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../common/Footer.jsp"/>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>