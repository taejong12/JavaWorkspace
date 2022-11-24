<%@page import="utils.PagingUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO" %>
<%@ page import="board.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
	BoardDAO dao = new BoardDAO(application);

	String findCol = request.getParameter("findCol");
	String findWord = request.getParameter("findWord");
	Map<String, Object> param = new HashMap<String, Object>();
	if(findWord != null){
		param.put("findCol",findCol);
		param.put("findWord", findWord);
		// select 조건이 형태
	}

	int totalCount = dao.selectCount(param); //게시물 카운트
	
	//int pageSize=10;
	//int pageBlock=5;
	//
	
	int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
	int pageBlock = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
	
	int totalPage= (int)Math.ceil((double)totalCount/pageSize); // 전체페이지 개수
	
	int pageNum=1; // 현재 페이지 넘버
	
	//페이지 넘버값을 상세보기 등 페이지 넘버를 가져갔다가 다시 가져와야한다 페이지상태 유지를 위해서
	String pageTemp = request.getParameter("pageNum");
	if(pageTemp!=null && !pageTemp.equals("")){
		pageNum=Integer.parseInt(pageTemp);
	}
	
	int start = (pageNum-1)*pageSize+1; // 현재페이지-1*페이지사이즈(이전페이지끝번호)+1
	int end = pageNum*pageSize; //현재페이지*페이지사이즈
	param.put("start",start);
	param.put("end",end);
	
	List<BoardDTO> boardLists = dao.selectListPage(param);
	dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	a{
		text-decoration:none;
		color:black;
	}
	a:hover {
		color:brown;
		
	}
</style>
</head>
<body>
	<jsp:include page="../Common/Top.jsp" />
	<h2 align="center">
		<a href="List.jsp">목록 보기</a>
	</h2>
	<h4>현재 <%=totalPage %>페이지 중 <%=pageNum %>페이지</h4>
	<!-- 검색 -->
	<form method="get">
		<table border="1" width="90%" align="center">
			<tr>
				<td align="center">
					<select name="findCol">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="findWord"/>
					<input type="submit" name="검색"/>
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 목록 -->
	<table border="1" width="90%" align="center" >
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
	<%
	if(boardLists.isEmpty()){ // 게시물이 없는 경우
	%>
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
		</tr>
	<%
	
	} else{ // 게시물이 있는 경우
		int vNum=0;
		int count=0;
		for(BoardDTO dto:boardLists){
			vNum=totalCount-(((pageNum-1)*pageSize)+count++);
	%>
			<tr align="center">
				<td align="i"><%=vNum %></td>
				<td align="left">
					<a href="View.jsp?num=<%=dto.getNum() %>"><%=dto.getTitle() %>
				</td>
				<td align="center"><%=dto.getId() %></td>
				<td align="center"><%=dto.getVisitcount() %></td>
				<td align="center"><%=dto.getPostdate() %></td>
			</tr>
	<%
		}
	}
	%>
	</table>
	
	<br/>
	
	<table border="1" width="90%" align="center">
		<tr align="center">
			<td>
				<%=PagingUtil.pagingStr(totalCount, pageSize, pageBlock,
						pageNum, request.getRequestURI()) %>
			</td>
		</tr>
	</table>
	
	<br/>
	
	<div align="center">
		<button type="button" onclick="location.href='Write.jsp';">글쓰기</button>
	</div>

</body>
</html>