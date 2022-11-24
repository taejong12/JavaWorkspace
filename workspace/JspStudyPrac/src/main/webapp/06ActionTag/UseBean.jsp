<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBeans action tag</title>
</head>
<body>
	<h2>자바빈즈</h2>
	<jsp:useBean id="person" class="common.Person" scope="request" />
	<jsp:setProperty name="person" property="name" value="나희도" />
	<jsp:setProperty name="person" property="age" value="19" />
	
	<ul>
		<li><jsp:getProperty name="person" property="name"/></li>
		<li><jsp:getProperty name="person" property="age"/></li>
	</ul>
	
	Person person = new Person();
	request.setAttribute("person", person);
	Person person = (Person)request.getAttribute("person");
	if(person != null){
		person.age
	}
	
	
</body>
</html>