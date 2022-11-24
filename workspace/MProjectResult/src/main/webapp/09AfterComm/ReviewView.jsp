	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 게시판 상세보기</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	
	<style>
	.star-rating {
		display:flex;
		flex-direction: row-reverse;
		font-size:1em;
		justify-content:center;
		padding:0 .2em;
		text-align:center;
		width:5em;
	  
	}
	
	.star-rating input {
		display:none;
	}
	
	.star-rating label {
		color:#f90;
	}
	</style>
	
</head>

<body>
	<jsp:include page="../common/Top.jsp"/>
	
  	
  	<div style="background: #ffeaea; padding: 3em 20em; margin: 5% 0em;">
		<div style="background: white; border: solid 1px black;">
			<h2>리뷰 게시판 상세보기</h2>
			<table class="table table-bordered" style="margin:0;">
				<colgroup>
					<col width="15%" /> <col width="35%" /> 
					<col width="15%" /> <col width="*" /> 
				</colgroup>
				
				<tr>
					<td align="center">번호</td> <td>${dto.num}</td>
					<td align="center">작성자</td> <td>${dto.RV_POSTNAME}</td>
				</tr>
				
				<tr>
					<td align="center">작성일</td> <td>${ dto.postdate }</td>
					<td align="center">평점</td> 
					<td>
						<c:if test="${dto.star==1}">
							<div class="star-rating">
								<input type="radio" id="5-stars" name="rating" value="1" />
	  							<label for="5-stars" class="star">&#9733;</label>
							</div>
								</c:if>
						<c:if test="${dto.star==2}">
							<div class="star-rating">
								<input type="radio" id="5-stars" name="rating" value="1" />
	  							<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="rating" value="2" />
	  							<label for="4-stars" class="star">&#9733;</label>
							</div>
						</c:if>
						<c:if test="${dto.star==3}">
						<div class="star-rating">
								<input type="radio" id="5-stars" name="rating" value="1" />
	  							<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="rating" value="2" />
	  							<label for="4-stars" class="star">&#9733;</label>			
								<input type="radio" id="3-stars" name="rating" value="3" />
	  							<label for="3-stars" class="star">&#9733;</label>
							</div>
						</c:if>		
						<c:if test="${dto.star==4}">
						<div class="star-rating">
								<input type="radio" id="5-stars" name="rating" value="1" />
	  							<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="rating" value="2" />
	  							<label for="4-stars" class="star">&#9733;</label>			
								<input type="radio" id="3-stars" name="rating" value="3" />
	  							<label for="3-stars" class="star">&#9733;</label>
								<input type="radio" id="2-stars" name="rating" value="4" />
	  							<label for="2-stars" class="star">&#9733;</label>
							</div>
						</c:if>
						<c:if test="${dto.star==5}">
							<div class="star-rating">
								<input type="radio" id="5-stars" name="rating" value="1" />
	  							<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="rating" value="2" />
	  							<label for="4-stars" class="star">&#9733;</label>			
								<input type="radio" id="3-stars" name="rating" value="3" />
	  							<label for="3-stars" class="star">&#9733;</label>
								<input type="radio" id="2-stars" name="rating" value="4" />
	  							<label for="2-stars" class="star">&#9733;</label>
								<input type="radio" id="1-stars" name="rating" value="5" />
	  							<label for="1-stars" class="star">&#9733;</label>
							</div>
						</c:if>
					</td>
				</tr>
				
				<tr>
					<td align="center">제목</td>
					<td colspan="3" style="overflow: auto;  word-break: break-all">${ dto.name }</td>
				</tr>
				
				<tr>
					<td align="center" style="padding: 3em 0em;">내용</td>
					<td style="padding: 3em 1em; overflow: auto;  word-break: break-all" colspan="3" height="100" >${ dto.content }</td>
				</tr>
				
				<tr>
					<td align="center" style="padding: 10em 0em;">첨부파일</td>
					<td colspan="3" style="text-align: center;">
						<c:if test="${not empty dto.ofile}">
							<img src="../Storage/${dto.nfile}" onerror="this.style.display='none';" style="width: 100%; height: 100%; overflow: auto;"/>
						</c:if>
					</td>	
				</tr>
				
				<tr>
				
					<td colspan="4" align="center" style="margin-top: 50px;">
					<c:if test="${sessionScope.me_num eq dto.menum}">
						<button class="btn btn-outline-success" type="button"
							onclick="location.href='../reviewBoard/reviewPass.do?mode=edit&num=${ param.num }';">
							수정하기
						</button>
						<button class="btn btn-outline-danger" type="button"
							onclick="location.href='../reviewBoard/reviewPass.do?mode=delete&num=${ param.num }';">
							삭제하기
						</button>
					</c:if>
						<button class="btn btn-outline-info" type="button" 
							onclick="if( confirm('목록으로 이동하시겠습니까?') == false ) return false; location.href='../reviewBoard/reviewList.do';">
							목록 바로가기
						</button>
					</td>
				</tr>	
			</table>
		</div>
  	</div>
	
<jsp:include page="../common/Footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>