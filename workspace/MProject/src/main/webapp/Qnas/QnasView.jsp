<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판 상세보기</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	

</head>
<body>
	<jsp:include page="../Common/Top.jsp"/>
	
	<div style="background: #ffeaea; padding: 3em 20em; margin: 5% 0em;">
		<div style="background: white; border: solid 1px black;">
			<h2>QnA 게시판 상세보기</h2>
			<table class="table table-bordered" style="margin:0;">
				<colgroup>
					<col width="15%" /> <col width="35%" /> 
					<col width="15%" /> <col width="*" /> 
				</colgroup>
				
				<tr>
					<td align="center">번호</td> <td>${ dto.num }</td>
					<td align="center">작성자</td> <td>${ dto.menum }</td>
				</tr>
				
				<tr>
					<td align="center">작성일</td> <td colspan="3">${ dto.postdate }</td>
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
					<td colspan="3" style="text-align: center;" >
						<c:if test="${ not empty dto.ofile }">
							<img src="../Storage/${dto.nfile}" onerror="this.style.display='none';" style="width: 100%; height: 100%; overflow: auto;"/>
						</c:if>
					</td>
				</tr>
				<tr>
					<td align="center">다운로드</td>
					<td colspan="3">
						<a href="../qnas/qnasdownload.do?ofile=${dto.ofile }&nfile=${dto.nfile}&idx=${dto.num}">
							[다운로드]
						</a>
					</td>
				</tr>
				
				
				<tr>
					<td colspan="4" align="center">
					
						<button type="button" class="btn btn-outline-success"
							onclick="location.href='../qnasBoard/qnasPass.do?mode=edit&num=${ param.num }';">
							수정하기
						</button>
						<button type="button" class="btn btn-outline-danger"
							onclick="location.href='../qnasBoard/qnasPass.do?mode=delete&num=${ param.num }';">
							삭제하기
						</button>
						<button type="button" class="btn btn-outline-info"
							 onclick="if( confirm('목록으로 이동하시겠습니까?') == false ) return false; location.href='../qnasBoard/qnasList.do';">
							목록 바로가기
						</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
		
		
		
		
	<div class="comment">
               
                <c:forEach var="comment" items="${list }">
                <div class="getComment">
                    <div class="getWriter">
                    	<c:if test="${comment.re_level > 0 }">
							<img src="images/level.gif" width="${comment.re_level*10 }">
							<img src="images/re.gif">
						</c:if>
						👤${comment.nickname }
					</div>
                    <br>
    				<div style="margin-left: ${comment.re_level*15 }px; ">
	                    <div class="getTxt">${comment.c_content }</div>
	                    <div class="createDate">${comment.c_regdate }</div>
                	</div>
	                    <input type="button" value="답글" onclick="re(${comment.c_idx})">
	                    <c:if test="${comment.id == id }">
							<input type="button" value="삭제" onclick="location.href='reDelete.do?c_idx=${comment.c_idx }&pageNum=${pageNum }&b_idx=${board.b_idx }'">
						</c:if>
	
	               		<div class="hiddenText" id="a${comment.c_idx }">
	                        <form action="reWrite.do?pageNum=${pageNum }" method="post" name="frm1" id="frm1">
	                        	<input type="hidden" name="nickname" value="${nickname }">
								<input type="hidden" name="id" value="${id }">
								<input type="hidden" name="b_idx" value="${board.b_idx }">
								<input type="hidden" name="c_idx" value="${comment.c_idx }">
								<input type="hidden" name="ref" value="${comment.ref }">
								<input type="hidden" name="re_level" value="${comment.re_level }">
								<input type="hidden" name="re_step" value="${comment.re_step }">
	                        	<img src="images/re.gif">
								<div><span class="left"><label for="name">👤${nickname }</label></span></div>
	                            <div> <textarea name="c_content" id="c_content" maxlength="2000" style="height:100px;" required="required"
	                                placeholder="댓글을 입력해주세요"></textarea></div>
	
	                            <div><input type="submit" value="등록" id="submitBtn"></div>
	                        </form>
	                    </div>
                     
                </div>
                </c:forEach>
            


                <div class="inputtxt">
                    <form action="reWrite.do?pageNum=${pageNum }" method="post" name="frm2">
          				<input type="hidden" name="nickname" value="${nickname }">
						<input type="hidden" name="id" value="${id }">
						<input type="hidden" name="b_idx" value="${board.b_idx }">
						<input type="hidden" name="c_idx" value="${c_idx }">
						<input type="hidden" name="ref" value="${ref }">
						<input type="hidden" name="re_level" value="${re_level }">
						<input type="hidden" name="re_step" value="${re_step }">
						
                        <div>
                            <span class="left"><label for="name">👤${nickname }</label></span>
                   
                        </div>
                        <div class="inputComment">
                            <textarea name="c_content" id="c_content" maxlength="2000" style="height:100px;"
                                placeholder="댓글을 입력해주세요"></textarea>
                        </div>
                        <div class="btnFix"><input type="submit" value="등록" id="submitBtn"></div>

                    </form>
                </div>
            </div>
            
	<jsp:include page="../Common/Footer.jsp"/>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>