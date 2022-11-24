<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
	
</body>
</html>