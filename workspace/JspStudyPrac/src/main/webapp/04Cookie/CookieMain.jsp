<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<h2>Cookie setting</h2>
	
	<%
	Cookie cookie = new Cookie("cookies","뉴진스"); //쿠키 객체 생성
	cookie.setPath(request.getContextPath()); // 쿠키의 적용 경로 설정 (쿠키를 어디에 저장할 것인지 적용할 경로를 설정)
	cookie.setMaxAge(3600); // 쿠키의 유지 기간 설정
	response.addCookie(cookie); // 응답 헤더 쿠키를 추가
	%>
	
	<h2>쿠키 설정 후 쿠키값 확인</h2>
	
	<%
	Cookie[] cookies = request.getCookies(); // 요청 헤더에서 모든 쿠키를 얻기
	if(cookies != null){
		for(Cookie ck:cookies){
			String ckName=ck.getName();
			String ckVal=ck.getValue();
			out.println(String.format("%s : %s<br/>",ckName, ckVal));
			//out.println(ck.getPath());
			//out.println(ck.getDomain());
			//out.println(ck.getMaxAge());
		}
	}
	%>
	
	<h2>페이지 이동 후 확인</h2>
	<a href="CookieMove.jsp">페이지 이동</a>
	
</body>
</html>