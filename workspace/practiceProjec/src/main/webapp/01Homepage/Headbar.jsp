<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>머리글</title>
<style>
	.headbar_ul li a{
		text-decoration: none;
		color:black;
		float: right;
		
	}
	
	.headbar_ul li a:hover {
		color:brown;
	}
	
	h2{
		align: center;
	}
	
	.headbar_ul{
		list-style-type: none;
		margin:0;
		padding: 0;
	}
	
	.headbar_ul li{
		text-decoration: none;
		color:black;
		float: right;
		}
	
</style>
</head>
<body>
	<!-- 머리글 -->
		<!--<li>|<a href="#">회원정보수정</a></li> --> <!-- 회원정보수정, 로그아웃은 로그인하면 보이게 설정 -->
		<!-- <li>|<a href="#">로그아웃</a></li>-->
	<ul class="headbar_ul">
		<li>|<a href="../02LoginForm/LoginForm.jsp">로그인</a></li>
		<li>|<a href="#">회원가입</a></li>
		<li><a href="#">Home</a></li>
	</ul>
</body>
</html>