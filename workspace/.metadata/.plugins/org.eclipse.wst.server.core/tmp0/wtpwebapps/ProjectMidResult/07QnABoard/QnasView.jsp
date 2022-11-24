<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판 상세보기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script type="text/javascript">
	var b = "a";
	function re(id){
		var content2 = document.getElementById(b);
		content2.style.display = 'none';
		var a = "a"+id;
		var content = document.getElementById(a);
		content.style.display = 'block';
		b=a;
	}
	function del(){
		const del = confirm("해당 게시글을 삭제하시겠습니까?");
		if(del){
			location.href='delete.do?num='+${dto.num}+'&pageNum='+${pageNum};
		}
	}
</script>
<style type="text/css">
.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 1em;
	justify-content: center;
	padding: 0 .2em;
	text-align: center;
	width: 5em;
}

.star-rating input {
	display: none;
}

.star-rating label {
	color: #f90;
}
.com1{
	width: 830px;
}
.com1 > div{
	margin : 5px 10px;
}
.hiddenText {
	display: none;
	margin-left: 20px;
}
a{
	text-decoration: none;
	color:block;
}
</style>

</head>
<body >
	<jsp:include page="../common/Top.jsp" />


	<div style="background: #ffeaea; padding: 3em 20em; margin-top: 5%;">
		<div style="background: white; border: solid 1px black;">
			<h2>QnA 게시판 상세보기</h2>
			<table class="table table-bordered" style="margin: 0;">
				<colgroup>
					<col width="15%" />
					<col width="35%" />
					<col width="15%" />
					<col width="*" />
				</colgroup>

				<tr>
					<td align="center">번호</td>
					<td>${dto.num}</td>
					<td align="center">작성자</td>
					<td>${dto.writer}</td>
				</tr>

				<tr>
					<td align="center">작성일</td>
					<td>${dto.postdate}</td>
				</tr>

				<tr>
					<td align="center">제목</td>
					<td colspan="3" style="overflow: auto; word-break: break-all">${dto.name}</td>
				</tr>
				<tr>
					<td align="center" style="padding: 3em 0em;">내용</td>
					<td style="padding: 3em 1em; overflow: auto; word-break: break-all"
						colspan="3" height="100">${ dto.content }</td>
				</tr>
				<tr>
					<td align="center" style="padding: 10em 0em;">첨부파일</td>
					<td colspan="3" style="text-align: center;"><c:if
							test="${ not empty dto.ofile }">
				${dto.ofile }
				<a
								href="../qnas/qnasdownload.do?ofile=${dto.ofile }&nfile=${dto.nfile}&idx=${dto.num}">
								[다운로드] </a>
						</c:if></td>
				</tr>

				<!-- 패스두하기 -->
				<tr>
					<td colspan="4" align="center" style="margin-top: 50px;"><c:if
							test="${sessionScope.me_num eq dto.me_num}">
				<button class="btn btn-outline-success" type="button"
								onclick="location.href='../qnasBoard/qnasPass.do?mode=edit&num=${dto.num}';">
								수정하기</button>
							<button class="btn btn-outline-danger" type="button"
								onclick="location.href='../qnasBoard/qnasPass.do?mode=delete&num=${dto.num}';">
								삭제하기</button>
						</c:if>
						<button class="btn btn-outline-info" type="button"
							onclick="if( confirm('목록으로 이동하시겠습니까?') == false ) return false; location.href='../qnasBoard/qnasList.do';">
							목록 바로가기</button></td>
				</tr>
			</table>
		</div>
	</div>
	
	
    <div id="a"></div>
	<div id="b"></div>
    <div class="comment" style="background: #ffeaea; padding: 0em 20em;" >  
    		<div class="inputtxt">
                    <form action="../qnasBoard/reWrite.do" method="post" name="frm2">
                  <input type="hidden" name="qna_num" value="${dto.num}">
                  <input type="hidden" name="me_num" value="${sessionScope.me_num}">
                      <input type="hidden" name="writer" value="${sessionScope.me_name}">
                  <input type="hidden" name="comm_num" value="${comm_num}">
                  <input type="hidden" name="regroup" value="${regroup}">
                  <input type="hidden" name="reglevel" value="${reglevel}">
                  <input type="hidden" name="regorder" value="${regorder}">
                  <input type="hidden" name="pageNum" value="${pageNum}">
                  	<div class="com1" style="border: 1px solid; background-color: white; border-radius: 10px;">
                        
                        <div>
                        
                            <span class="left"><label for="name">👤${sessionScope.me_name}</label></span>
                   
                        </div>
                        <div class="inputComment">
                            <textarea name="content" id="content" maxlength="2000" style="height:100px; width: 800px;" required ="required"
                                placeholder="댓글을 입력해주세요"></textarea>
                        </div>
                        <div class="btnFix">
                        비밀번호
                        <input type="text" name="pass"/>
                        <input type="submit" value="등록" id="submitBtn"></div>
                    </div>
                    </form>                                                        
                </div>       
            <c:forEach var="commLists" items="${commLists}">
                <div class="getComment">
                    <div class="getWriter">
                       
                  
                   
                <div style="margin-left: ${commLists.reglevel*15}px; border: 1px solid; background-color: white; border-radius: 10px; margin-top: 10px;" >
                <c:if test="${commLists.reglevel>0}">
                       <img src="../img/level.jpg" width="${commLists.reglevel*5}px">
                        <img src="../img/re.png" width="10px" height="10px">
                  </c:if>
                👤${commLists.writer}
                   <br>
                       <div style="margin-left: 10px;" class="getTxt">${commLists.content}</div>
                       <div style="margin-left: 10px;" class="createDate">${commLists.comm_regdate}</div>
                   
                   
                           <input type="button" value="답글" onclick="re(${commLists.comm_num})">                       
                     <c:if test="${sessionScope.me_num == commLists.me_num}">
                     	   <input type="button" value="삭제" onclick="location.href='reDelete.do?comm_num=${commLists.comm_num}&qna_num=${dto.num}&pageNum=${pageNum}'">
                     </c:if>
                  <hr>
                  
   					<div class="hiddenText" id="a${commLists.comm_num}">
                       <form action="../qnasBoard/reWrite.do" method="post" name="frm1" id="frm1">
                       
                              <input type="hidden" name="writer" value="${sessionScope.me_name}">
                        <input type="hidden" name="me_num" value="${sessionScope.me_num}">
                        <input type="hidden" name="qna_num" value="${dto.num}">
                        <input type="hidden" name="comm_num" value="${commLists.comm_num}">
                        <input type="hidden" name="regroup" value="${commLists.regroup}">
                        <input type="hidden" name="reglevel" value="${commLists.reglevel}">
                        <input type="hidden" name="regorder" value="${commLists.regorder}">
                        <input type="hidden" name="pageNum" value="${pageNum}">      
                        
                        <div class="com1" style="border: 1px solid; background-color: white; border-radius: 10px;">
                        <div>
               
                        <span class="left"><label for="name">👤${sessionScope.me_name}</label></span></div>
                               <div> <textarea name="content" id="content" maxlength="2000" style="height:100px; width: 800px;" required="required"
                                   placeholder="댓글을 입력해주세요"></textarea></div>
   
                           <div>
                           비밀번호
                        	<input type="text" name="pass"/>
                           <input type="submit" value="등록" id="submitBtn"></div>
                           </div>
                       </form>
                </div>
                    </div>
                     </div>
                </div>
                </c:forEach>
            		
				    
            </div>
             
             	<jsp:include page="../common/Footer.jsp" />
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>      

</body>
</html>