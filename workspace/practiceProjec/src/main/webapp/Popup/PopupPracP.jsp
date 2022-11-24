<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script >
function setCookie(name, value, expiredays) {
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + expiredays);
	document.cookie=name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}
</script>
<body>
<h2>이미지</h2>
</body>
</html>