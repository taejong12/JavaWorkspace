<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 response</title>
</head>
<body>
	<h2>로그인 폼</h2>
	<%
	//메인 로그인 //메인에서 로그인 쪽에 서브밑 했을 때 로그인하고 패스워드가 넘어가는데 해당하는 처리를 해서 다시 넘어온다 그 때 여기에서 처리한다
	//로그인 이후에 화면까지
	String loginErr=request.getParameter("logErr"); 
	if(loginErr!=null) 
		out.print("로그인 실패");
	%>
	<form action="./ResponseLogin.jsp" method="post">
		ID : <input type="text" name="userId"/><br/>
		PW : <input type="text" name="userPW"/><br/>
		<input type="submit" value="로그인">
	</form>
	
	<h2> HTTP 응답 헤더 설정 </h2>
	<form action="./ResponseHeader.jsp" method="post">
		Date format:<input type="text" name="date" value="2021-10-25 09:00" /><br/>
		Number format:<input type="text" name="number" value="1004"/><br/>
		String format:<input type="text" name="string" value="고길동"/><br/>
		<input type="submit" value="설정/출력"/>
	</form>
</body>
</html>