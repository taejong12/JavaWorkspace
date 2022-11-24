<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일주일간 팝업 띄우지 않기 쿠키</title>

	<script>
		$(document).ready(function(){
			cookiedata = document.cookie;
			if(cookiedata.indexOf("ncookie=done") < 0) {
				document.getElementById('popup').style.display = "block"; // 팝업창 아이디

			} else {
				document.getElementById('popup').style.display = "none"; // 팝업창 아이디
			}
		});
		
		function setCookie(name, value, expiredays) {
			var todayDate = new Date();
			todayDate.setDate(todayDate.getDate()+expiredays);
			document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() +";"
		}
		
		function closeWin() {
			document.getElementById('popup').style.display = "none"; // 팝업창 아이디
		}
		
		function todaycloseWin() {
			setCookie( "ncookie", "done", 1); // 저장될 쿠키명, 쿠키 value값, 기간( ex.1은 하루, 7은 일주일)
			document.getElementById('popup').style.display = "none"; // 팝업창 아이디
		} 
	</script>

</head>
<body>
<h2>일주일간 팝업 띄우지 않기 쿠키</h2>
	<div id="popup" style="position:absolute; left:50%; top:120px; margin-left:-500px; z-index:1000; display:none;">
		<h2>이미지</h2>
		<a href="#" onclick="todaycloseWin();" alt="오늘 하루 열지 않기">오늘 하루 열지 않기</a>
		<a href="#" onclick="closeWin();" alt="닫기">닫기</a>
	</div>
</body>
</html>