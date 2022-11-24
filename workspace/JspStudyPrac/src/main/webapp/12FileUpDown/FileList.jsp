<%@page import="java.net.URLEncoder"%>
<%@page import="fileUpDown.MyFileDTO"%>
<%@page import="java.util.List"%>
<%@page import="fileUpDown.MyFileDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File List</title>
</head>
<body>
	<h2>파일 목록 보기</h2>
	<a href="FileUploadMain.jsp">파일 등록</a>
	<%
		MyFileDAO dao = new MyFileDAO();
		List<MyFileDTO> fileLists = dao.myFileList();
		dao.close();
	%>
	
	<table border="1">
		<tr>
			<td>No</td>
			<td>작성자</td>
			<td>제목</td>
			<td>카테고리</td>
			<td>원본 파일명</td>
			<td>저장된 파일명</td>
			<td>작성일</td>
			<td></td>
		</tr>
		
	<% for (MyFileDTO f:fileLists){ %>	
	
		<tr>
			<td><%= f.getIdx() %></td>
			<td><%= f.getName() %></td>
			<td><%= f.getTitle() %></td>
			<td><%= f.getCate() %></td>
			<td><%= f.getOfile() %></td>
			<td><%= f.getNfile() %></td>
			<td><%= f.getRegdate() %></td>
			<td><a href="Download.jsp?oName=<%= URLEncoder.encode(f.getOfile(), "UTF-8") %> 
				&nName=<%= URLEncoder.encode(f.getNfile(),"UTF-8") %>">[다운로드]</a></td> 
				<!-- ofile과 nfile 이름을 비교 -->
		</tr>
		
	<% } %>
	
	</table>
	
	
	
	
</body>
</html>