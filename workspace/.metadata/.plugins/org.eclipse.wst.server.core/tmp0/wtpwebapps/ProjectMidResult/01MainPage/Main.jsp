<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<style type="text/css">
.main {
	max-width: 100%;
	max-height: 100%;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	margin: auto;
	overflow: auto;
	position: fixed;
}

.btn {
	position: absolute;
	top: 60%;
	left: 60%;
	width: 150px;
	height: 50px;
	font-size: 14px;
	font-weight: 600;
	border-radius: 10px;
	background: #f1575b;
	color: #f5f5f5;
	cursor: pointer;
	border: none;
	outline: none;
	display: inline-block;
}
</style>
</head>
<body>
	<img class="main" src="../img/main.png">
	<button class="btn" type="button"
		onclick="location.href='../reviewBoard/ReviewMainPage.do';">클릭</button>
	<button type="button" style="display: none;"></button>
</body>
</html>