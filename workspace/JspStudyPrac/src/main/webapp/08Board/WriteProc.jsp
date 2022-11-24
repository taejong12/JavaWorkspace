<%@page import="utils.AlertFunc"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
	BoardDTO dto = new BoardDTO();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setId(session.getAttribute("UserId").toString());
	
	BoardDAO dao = new BoardDAO(application);
	int res = dao.insertWrite(dto);
	dao.close();
	
	if(res==1){
		response.sendRedirect("List.jsp");
	}else{
		AlertFunc.alertBack("글쓰기가 입력되지 않았습니다.", out);
	}
	
%>
    
    
DB
전달 제목 내용
DB insert
성공 목록이동
실패 경고창을 띄우고 뒤로 이동(글쓰기)
