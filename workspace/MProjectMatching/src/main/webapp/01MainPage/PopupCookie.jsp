<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String chk=request.getParameter("inactive");

if(chk!=null && chk.equals("1")){
	Cookie cookie=new Cookie("PopupMode","off");
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(168*60*60); //자동으로 꺼지지 않게 시간 부여
	response.addCookie(cookie);
	out.println("쿠키:일주일 동안 안 열기");
}
%>