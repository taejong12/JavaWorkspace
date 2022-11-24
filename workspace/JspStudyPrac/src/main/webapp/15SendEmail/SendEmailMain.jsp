<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SMTP email send</title>
</head>
<body>
	<h2>이메일 전송</h2>
	<form method="post" action="SendProcess.jsp">
		<table border="1">
			<tr>
				<td>
					보내는 이:<input type="text" name="from" value="" />
				</td>
			</tr>
			
			<tr>
				<td>
					받는 이:<input type="text" name="to" value="" />
				</td>
			</tr>
			
			<tr>
				<td>
					제목:<input type="text" name="subject" value="" />
				</td>
			</tr>
			
			<tr>
				<td>
					형식:
					<input type="radio" name="format" value="text" checked />TEXT
					<input type="radio" name="format" value="html" />HTML
				</td>
			</tr>
			
			<tr>
				<td>
					<textarea name="content" cols="60" rows="10"></textarea>
				</td>
			</tr>
			
			<tr>
				<td>
					<button type="submit">전 송</button>	
				</td>
			</tr>
		</table>
	</form>
</body>
</html>