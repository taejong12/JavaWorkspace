<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 게시판</title>
</head>
<body>
	<h2>게시판 상세보기</h2>
	
	<table border="1" width="90%">
		<colgroup>
			<col width="15%" /> <col width="35%" /> 
			<col width="15%" /> <col width="*" /> 
		</colgroup>
		
		<tr>
			<td>번호</td> <td>${ dto.idx }</td>
			<td>작성자</td> <td>${ dto.name }</td>
		</tr>
		
		<tr>
			<td>작성일</td> <td>${ dto.postdate }</td>
			<td>조회수</td> <td>${ dto.visitcount }</td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td colspan="3">${ dto.title }</td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td colspan="3" height="100">${ dto.content }</td>
		</tr>
		
		<tr>
			<td>첨부파일</td>
			<td>
				<c:if test="${ not empty dto.ofile }">
				${ dto.ofile }
				<a href="../m2board/download.do?ofile=${dto.ofile}&nfile=${dto.nfile}&idx=${dto.idx}">
					[다운로드]
				</a>
				
				<!-- ajax -->
				<button type="button" id="downbtn">다운로드</button>
				</c:if>
			</td>
			<td>다운로드수</td>
			
			<!-- id 추가 -->
			<td id="dcount">${ dto.downcount }</td>
			<!-- 방식 필요한 사항 바닐라스크립트(순수한 자바스크립트)
				쓰기 편하게 제이쿼리로 사용 -->
				
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="button"
				onclick="location.href='../m2board/pass.do?mode=edit&idx=${ param.idx }';">
					수정하기
				</button>
				<button type="button"
				onclick="location.href='../m2board/pass.do?mode=delete&idx=${ param.idx }';">
					삭제하기
				</button>
				<button type="button" onclick="location.href='../m2board/list.do';">
					목록 바로가기
				</button>
			</td>
		</tr>
		
	</table>

<!-- 
	가장 기본은 타입과 
	url(주소값) 파일 경로가 아닌 컨트롤러를 설정 서블릿이면 서블릿 url주소(jsp면 jsp url주소) 방식이 post get
	async 동기(false)인지 비동기(true)인지
	data 데이터를 url주소로 줄거를 작성
	dataType 넘어오는 데이터타입을 정해줘야 한다 내가 받을 결과값 타입
	데이터를 읽어오기 시작하면 json
	넘어오는 타입을 정해준다
	success 성공하면 success만 고려
	success 외에 error나면 error쪽 처리
	지금은 다운로드 카운트만 받아오면 된다
	들어오는 값이 복잡하면 해당하는 파람(data.parm)을 받아야 한다
	태그 안에 있는 값이 우리가 받아오는 값
 -->
 
 <!-- jquery 사용 -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script>
	$('#downbtn').on("click", (e) => {
		e.preventDefault()
		console.log('btn click')
		$.ajax({
			type:'post',
			async:false,
			url:'/JspStudyPrac/m2board/download.do',
			dataType:'text',
			data:{idx: '${dto.idx}'},
			success: function(data, textStatus) {
				console.log(data);
				$('#dcount').text(data);
			},
			error:function (data, textStatus) {
				console.log('error');
			}
		})
	
	})
	
</script>




</body>
</html>