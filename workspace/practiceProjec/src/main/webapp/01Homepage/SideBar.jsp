<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이드바</title>

<style>
	.sidebar_ul{
		position: relative;
		background-color: #FFDAB9;
		width: 150px;
		list-style-type: none;
		margin:0;
		padding:0;
		border: solid 1px black;	
	}
	
	.sidebar_ul li a{
		display: block;
		color: #000000;
		padding: 8px;
		text-decoration: none;
		font-weight: bold;
	}
	
	.sidebar_ul li a:hover{
		background-color: #CD853F;
		color: white;
	}
	
	.sidebar_ul li{
		border-bottom: solid 1px black;
	}
	
	.sidebar_ul li:last-child{
		border-bottom: none;
	}
</style>

</head>
<body>
	<ul class="sidebar_ul">
		<li><a href="Search.jsp">검색</a></li>
		<li><a href="#">자료실</a></li>
	</ul>
	<!-- 검색 동작하는 페이지 만들기 -->
</body>
</html>