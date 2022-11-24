<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controller-view</title>
</head>
<body>
	<h3>컨트롤러 뷰</h3>
	${result}
	<p>URI: ${uri}</p>
	<p>요청명: ${comStr}</p>
	<ul>
		<li><a href="../13Servlet/regist.set">회원가입</a></li>
		<li><a href="../13Servlet/login.set">로그인</a></li>
		<li><a href="../13Servlet/board.set">게시판</a></li>
	</ul>
	
	<!-- jsp로 접근
	클릭하게 되면 .set으로 되어 있으니까
	서블릿 컨테이너로 들어가면 @WebServlet("*.set") 가 받고
	해당하는 값들의 리저트 값이 출력된다
	똑같은 jsp에서 다른값이 뜰 수 있다
	서블릿은 jsp보다 보안성에서 유리하다
	내부 구조랑 상관없이 내가 하고 싶은대로 uri를 짤 수 있다 -->
	 
</body>
</html>