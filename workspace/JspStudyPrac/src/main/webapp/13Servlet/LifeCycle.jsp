<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Life cycle</title>
</head>
<body>
	<script>
		function getAction(frm) {
			frm.method = 'get';
			frm.submit();
		}
		
		function postAction(frm) {
			frm.method = 'post';
			frm.submit();
		}
		
	</script>
	
	<h2>서블릿 수명주기(Life Cycle) 메서드</h2>
	<form action = "./LifeCycle.do">
		<input type="button" value="Get 방식 요청하기" onclick="getAction(this.form);" />
		<input type="button" value="Post 방식 요청하기" onclick="postAction(this.form);" />	
	</form>
</body>
</html>




