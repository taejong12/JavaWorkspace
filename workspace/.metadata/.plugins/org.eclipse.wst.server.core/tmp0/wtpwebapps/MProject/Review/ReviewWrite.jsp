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
<title>리뷰게시판 글쓰기</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

	
<script type="text/javascript">
	function validateForm(form) { //	필수 항목 입력 확인
		if(form.RV_POSTNAME.value == "") {
			alert("작성자를 입력하세요.");
			form.RV_POSTNAME.focus();
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
	
	
</style>
</head>
<body>
	<jsp:include page="../Common/Top.jsp"/>
	
	<div style="background: #ffeaea; padding: 3em 20em; margin: 5% 0em;">
		<form name="writeFrm" method="post" enctype="multipart/form-data"
			action="../reviewBoard/reviewWrite.do" 
			onsubmit="if(confirm('작성완료 하시겠습니까?')==false) return false; return validateForm(this); ">
			
			<h2>파일 첨부형 게시판 - 리뷰작성(Write)</h2>
			
			<table class="table table-bordered" style="margin:0;">
				<tr>
					<td align="center">작성자</td>
					<td>
						<input class="form-control" type="text" name="RV_POSTNAME" style="width:150px;" />
		
					</td>
				</tr>
				
				<tr>
					<td align="center">제목</td>
					<td>
						<input class="form-control"  type="text" name="name" style="width:90%;" />
					</td>
				</tr>
				
				<tr>
					<td align="center">평점</td>
					
					<td class="star-rating">
						<input id="5-stars" type="radio" name="star" value="5" checked/>
						<label for="5-stars" class="star">&#9733;</label>
						<input id="4-stars" type="radio" name="star" value="4" />
						<label for="4-stars" class="star">&#9733;</label>
						<input id="3-stars" type="radio" name="star" value="3" />
						<label for="3-stars" class="star">&#9733;</label>
						<input id="2-stars" type="radio" name="star" value="2" />
						<label for="2-stars" class="star">&#9733;</label>
						<input id="1-stars" type="radio" name="star" value="1" />
						<label for="1-stars" class="star">&#9733;</label>
					</td>
				</tr>
				
				<tr>
					<td align="center" style="padding: 3em 0em;">내용</td>
					<td>
						<textarea name="content" class="form-control"  style="width:90%;height:100px;"></textarea>
					</td>
				</tr>
				
				<tr>
					<td align="center">첨부 파일</td>
					<td>
						<input style="width:70%;" class="form-control" type="file" id="formFile" name="ofile" />
					</td>
				</tr>
				
				<tr>
					<td align="center">게시판 비밀번호</td>
					<td>
						<input class="form-control"  type="password" name="pass" style="width:100px;" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					
						<button class="btn btn-outline-success" type="submit">작성완료</button>
						<button class="btn btn-outline-danger" type="reset" 
							onclick="if( confirm('리셋하시겠습니까?') == false ) return false;">RESET</button>
						
						<button class="btn btn-outline-info" type="button" 
							onclick="if( confirm('목록으로 이동하시겠습니까?') == false ) return false; location.href='../reviewBoard/reviewList.do';">
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