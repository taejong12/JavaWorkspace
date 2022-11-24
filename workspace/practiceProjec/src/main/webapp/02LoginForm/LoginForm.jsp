<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<style>
	a{
		text-decoration: none;
		color:black;
	}
	
	a:hover {
		color:brown;
	}
	
	span{
		color: red;
		font-size: 1.2em;
	}
</style>
</head>
<body>
<h2><a href="../01Homepage/Homepage.jsp">홈페이지</a></h2>
<!-- 로그인폼 -->
	<h2>로그인 페이지</h2>
	<span>
		
	</span>
	<form action="#" method="post" name="LoginForm">
		<fieldset>
			아이디: <input type="text" name="user_id" placeholder="Id"/> <br />
			패스워드: <input type="password" name="user_pw" placeholder="Pw" /><br />
			<input type="submit" value="로그인"/>
		</fieldset>
	</form>
</body>
</html>