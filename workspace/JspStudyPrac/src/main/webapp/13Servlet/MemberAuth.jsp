<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 인증</title>
</head>
<body>
	<!--  최초의 jsp를 실행해보면  -->
	<h2>MVC 패턴 -> 회원인증</h2>
	<ol>
		<li>${authMsg}</li>
		<li><a href="./MemberAuth.mvc?id=manager&pass=1234">회원인증(admin)</a></li>
		<li><a href="./MemberAuth.mvc?id=YOO&pass=1234">회원인증(member)</a></li>
		<li><a href="./MemberAuth.mvc?id=outsider&pass=1234">회원인증(비회원)</a></li>
	</ol>
	
	<!-- 폼을 만들고 직접적으로 넘겨준다고 치면
		입력창에 디비에 있는 내용으로
		직접 넣으면 뜨게 할 수도 있다-->
	
	<form name="authFrm" method="post" action="./MemberAuth.mvc">
		<input type="text" name="id" placeholder="아이디" />
		<input type="text" name="pass" placeholder="비밀번호" />
		<input type="submit" value="인증" />
	</form>
	
	<!-- 뷰 서블릿컨트롤러 모델(DAO DTO)
		동작에 대한 처리를 해주고
		우리가 작성한 모델에 있는 기능들은 컨트롤러를 통해서
		뷰를 통해서 화면에 띄운다 
	-->

	<!-- 메일 보내기
		회원가입을 하면 등록번호를 메일로 보내준다
		휴대폰 연동을 하는 방법은 그 api는 유료이거나 인증키를 받아야 한다
		채팅 프로그램 등 추가 연동 
	-->
	
	<!-- 게시판을 만들기까지의 필요한 내용은 다 배웠다 mvc 모델 2
		모델 자바빈즈 구성
		컨트롤러단은 서블릿
		뷰는 jsp를 사용
		DTO DAO 디비랑 연결 저장
		디비만 설정해 놓으면 게시판을 만들 수 있다
		MVC 모델 2에 해당하는 게시판 작성 시작 
	-->
	
	<!-- 게시판에 글 쓰고 파일을 첨부할 수 있는 자료실 같은 게시판 -->
	
	

</body>
</html>