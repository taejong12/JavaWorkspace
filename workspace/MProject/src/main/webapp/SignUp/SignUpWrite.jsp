<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 작성</title>

<style>
	a{text-decoration: none; color:black;}
</style>

<script>
	var JoinForm__submitDone = false;
	
	function JoinForm__submit(form) {
		
		if(JoinForm__submitDone){
			alert('처리중입니다.');
			return;
		}
		
		form.ME_ID.value = form.ME_ID.value.trim();
		
		if(form.ME_ID.value.length == 0){
			alert('로그인 아이디를 입력해주세요.');
			form.ME_ID.focus();
			return;
		}
		
		form.ME_PASS.value = form.ME_PASS.value.trim();
		
		if(form.ME_PASS.value.length == 0){
			alert('비밀번호를 입력해주세요.');
			form.ME_PASS.focus();
			return;
		}
		
		form.ME_PASS_confirm.value = form.ME_PASS_confirm.value.trim();
		
		if(form.ME_PASS_confirm.value.length == 0){
			alert('비밀번호 확인을 입력해주세요.');
			form.ME_PASS_confirm.focus();
			return;
		}
		
		if(form.ME_PASS.value != form.ME_PASS_confirm.value){
			alert('비밀번호가 일치하지 않습니다.');
			form.ME_PASS_confirm.focus();
			return;
		}
		
		form.ME_NAME.value = form.ME_NAME.value.trim();
		
		if(form.ME_NAME.value.length == 0){
			alert('이름을 입력해주세요.');
			form.ME_NAME.focus();
			return;
		}
		
		form.ME_BIRTH.value = form.ME_BIRTH.value.trim();
		
		if(form.ME_BIRTH.value.length == 0){
			alert('생년월일을 입력해주세요.');
			form.ME_BIRTH.focus();
			return;
		}
		
		form.ME_AGE.value = form.ME_AGE.value.trim();
		
		if(form.ME_AGE.value.length == 0){
			alert('나이를 입력해주세요.');
			form.ME_AGE.focus();
			return;
		}
		
		form.ME_PHONE.value = form.ME_PHONE.value.trim();
		
		if(form.ME_PHONE.value.length == 0){
			alert('전화번호를 입력해주세요.');
			form.ME_PHONE.focus();
			return;
		}
		
		form.ME_EMAIL.value = form.ME_EMAIL.value.trim();
		
		if(form.ME_EMAIL.value.length == 0){
			alert('이메일을 입력해주세요.');
			form.ME_EMAIL.focus();
			return;
		}
		
		form.ME_KAKAO.value = form.ME_KAKAO.value.trim();
		
		if(form.ME_KAKAO.value.length == 0){
			alert('카카오톡 아이디를 입력해주세요.');
			form.ME_KAKAO.focus();
			return;
		}
	
		form.submit();
		JoinForm__submitDone=true;
}
	
</script>

</head>
<body>
	<h2>회원가입</h2>

	<form name="writeFrm" method="post" action="../signUp/SignUpWrite.do"
		onsubmit="JoinForm__submit(this); return false;">
		
		<div>
			로그인 아이디:<input type="text" placeholder="로그인 아이디"  name="ME_ID"  />
		</div><br/>
		
		<div>
			비밀번호:<input type="password" placeholder="비밀번호"  name="ME_PASS" />
		</div><br />
		
		<div>
			비밀번호 확인:<input type="password" placeholder="비밀번호 확인"  name="ME_PASS_confirm" />
		</div><br />
		
		<div>
			이름:<input type="text" placeholder="이름"  name="ME_NAME" />
		</div><br />
		
		<div>
			생년월일:<input type="text" placeholder="생년월일" name="ME_BIRTH" />
		</div><br />	
		
		<div>
			성별:<input type="radio" name="ME_SEX" checked/>남자		
		   		<input type="radio" name="ME_SEX" />여자
		</div><br />
		
		<div>
			나이:<input type="number" placeholder="나이"  name="ME_AGE" />
		</div><br />
		
		<div>
			핸드폰 번호:<input type="tel" placeholder="핸드폰 번호"  name="ME_PHONE"/>
		</div><br />	
			
		<div>
			이메일:<input type="email" placeholder="이메일 주소"  name="ME_EMAIL"  />
		</div><br />
		
		<div>
			카카오ID:<input type="text" placeholder="카카오ID"  name="ME_KAKAO" />
		</div><br />
		
		<!-- <div>
			지역번호:<input type="number" placeholder="지역번호"  name="RE_NUM" />
		</div><br />
		 -->
		
		<div>
			<button type="submit">회원가입</button>
			<button type="reset">다시시작</button>
			<button type="button">
				<a href="/MProject/SignUp/SignUpMain.jsp">취소</a>
			</button>						
		</div>           
	</form>
</body>
</html>
