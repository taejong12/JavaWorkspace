<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판 상세보기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
<style>
	.hiddenText {
		display: none;
		margin-left: 20px;
	}
	a{
		text-decoration: none;
		color:block;
	}
</style>
<script type="text/javascript">
	var b = "a";
	function re(id){
		var content2 = document.getElementById(b);
		content2.style.display = "none";
		var a = "a"+id;
		var content = document.getElementById(a);
		content.style.display = "block";
		b=a;
	}
	function del(){
		const del = confirm("해당 게시글을 삭제하시겠습니까?");
		if(del){
			location.href='delete.do?num='+${dto.num}+'&pageNum='+${pageNum};
		}
	}
</script>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="../common/Top.jsp"/>
	
	<h2>QnA 게시판 상세보기</h2>
	
	<table class="table table-hover table-striped">
		<tr>
			<th style="width: 50px;">제목</th>
			<th colspan="3" style="text-align: left;color: #555;">${ dto.name }</th>
			<th>내용</th>
			<td colspan="3" height="100">${ dto.content }</td>
			<th>첨부파일</th>
			<td>
				<c:if test="${ not empty dto.ofile }">
				${dto.ofile }
				<a href="../qnas/qnasdownload.do?ofile=${dto.ofile }&nfile=${dto.nfile}&idx=${dto.num}">
				[다운로드]
				</a>
				</c:if>
			</td>
			<th style="width: 50px;">작성일</th> 
			<th style="width: 130px;color: #555;" colspan=3>${ dto.postdate }</th>
			<th style="width: 50px;">작성자</th> 
			<th style="width: 130px;color: #555;" colspan=3>${ dto.writer } </th>
		</tr>
		
		

	<!-- 패스두하기 -->
		<tr>
			<td colspan="4" align="center">
			<c:if test="${dto.me_num == sessionScope.me_num }">>
				<button type="button"
				onclick="location.href='../qnasBoard/qnasPass.do?mode=edit&num=${dto.num}';">
					수정하기
				</button>
				<button type="button"
				onclick="location.href='../qnasBoard/qnasPass.do?mode=delete&num=${dto.num}';">
					삭제하기
				</button>
			</c:if>
				<button type="button" onclick="location.href='../qnasBoard/qnasList.do';">
					목록 바로가기
				</button>
			</td>
		</tr>		
	</table>
	
	
    <div id="a"></div>
	<div id="b"></div>
    <div class="comment">        
            <c:forEach var="commLists" items="${commLists}">
                <div class="getComment">
                    <div class="getWriter">
                       <c:if test="${commLists.reglevel>0}">
                       <img src="../img/level.jpg" width="${commLists.reglevel*20}px">
                        <img src="../img/re.png" width="10px" height="10px">
                  </c:if>
                  👤${commLists.writer}
                   <br>
                <div style="margin-left: ${commLists.reglevel*15}px; ">
                       <div class="getTxt">${commLists.content}</div>
                       <div class="createDate">${commLists.comm_regdate}</div>
                   
                   
                           <input type="button" value="답글" onclick="re(${commLists.comm_num})">
                     <c:if test="${dto.me_num == commLists.me_num}">
                     	   <input type="button" value="삭제" onclick="location.href='reDelete.do?comm_num=${commLists.comm_num}&qna_num=${dto.num}&pageNum=${pageNum}'">
                     </c:if>
                  
                  
   					<div class="hiddenText" id="a${commLists.comm_num}">
                       <form action="../qnasBoard/reWrite.do" method="post" name="frm1" id="frm1">
                       
                              <input type="hidden" name="writer" value="${sessionScope.me_name}">
                        <input type="hidden" name="me_num" value="${dto.me_num}">
                        <input type="hidden" name="qna_num" value="${dto.num}">
                        <input type="hidden" name="comm_num" value="${commLists.comm_num}">
                        <input type="hidden" name="regroup" value="${commLists.regroup}">
                        <input type="hidden" name="reglevel" value="${commLists.reglevel}">
                        <input type="hidden" name="regorder" value="${commLists.regorder}">
                        <input type="hidden" name="pageNum" value="${pageNum}">      
                        <div>
               
                        <span class="left"><label for="name">👤${sessionScope.me_name}</label></span></div>
                               <div> <textarea name="content" id="content" maxlength="2000" style="height:100px;" required="required"
                                   placeholder="댓글을 입력해주세요"></textarea></div>
   
                           <div>
                           비밀번호
                        	<input type="text" name="pass"/>
                           <input type="submit" value="등록" id="submitBtn"></div>
                       </form>
                </div>
                    </div>
                     </div>
                </div>
                </c:forEach>
            		
				<div class="inputtxt">
                    <form action="../qnasBoard/reWrite.do" method="post" name="frm2">
                  <input type="hidden" name="qna_num" value="${dto.num}">
                  <input type="hidden" name="me_num" value="${dto.me_num}">
                      <input type="hidden" name="writer" value="${sessionScope.me_name}">
                  <input type="hidden" name="comm_num" value="${comm_num}">
                  <input type="hidden" name="regroup" value="${regroup}">
                  <input type="hidden" name="reglevel" value="${reglevel}">
                  <input type="hidden" name="regorder" value="${regorder}">
                  <input type="hidden" name="pageNum" value="${pageNum}">
                  
                        <div>
                        
                            <span class="left"><label for="name">👤${sessionScope.me_name}</label></span>
                   
                        </div>
                        <div class="inputComment">
                            <textarea name="content" id="content" maxlength="2000" style="height:100px;" required ="required"
                                placeholder="댓글을 입력해주세요"></textarea>
                        </div>
                        <div class="btnFix">
                        비밀번호
                        <input type="text" name="pass"/>
                        <input type="submit" value="등록" id="submitBtn"></div>
                    </form>                                                        
                </div>               
            </div>
                   

</body>
</html>