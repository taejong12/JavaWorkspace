<%@page import="cookie.ManageCookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String loginId = ManageCookie.readCookie(request, "loginId");

String cookieCheck = "";
if (!loginId.equals("")) {
   cookieCheck = "checked";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>
<body>
<jsp:include page="../common/Top.jsp"/>

   <h2 align="center">로그인 페이지</h2>
   <span style="color:red; font-size: 1.2em;">
      <%= request.getAttribute("LoginErrMsg")== null? "":request.getAttribute("LoginErrMsg") %>
   </span>
   <%
   	if(session.getAttribute("me_id")==null){ //로그인 상태 확인
      //로그아웃 상태
   %>
   <script>
   function validateForm(form) {
       if(!form.mem_id.value){
          alert("아이디를 입력하세요.");
          return false;
       }
       if(form.mem_password.value==""){
          alert("패스워드를 입력하세요.");
          return false;
       }
    }
   </script>   
  
	<form action="../loginOut/loginOut.do" method="post" name="LoginFrm" align="center" onsubmit="return validateForm(this);"
		>
		ID : <input type="text" name="me_id" placeholder="ID 입력" value="<%= loginId %>" />
		<input type="checkbox" name="save_check" value="Y" <%= cookieCheck %> />
 		아이디 저장<br/>
		PW : <input type="password" name="me_pass" placeholder="8자 이상 입력(문자/숫자/기호 사용 가능)"/><br/>
		<br/>
		<input type="submit" value="로그인">
		<button type="button" id="join" value="회원가입" onclick="location.href='../01Join/Join.jsp'">회원가입</button>
	</form>
   <%
   }
   %>  
<jsp:include page="../common/Footer.jsp"/>   
</body>
</html>