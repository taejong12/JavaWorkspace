<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<a href="javascript:kakaoLogin();"><img
	src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png"
	style="height: 100px; width: auto;"></a>

<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.0/kakao.min.js"
	integrity="sha384-PFHeU/4gvSH8kpvhrigAPfZGBDPs372JceJq3jAXce11bVA6rMvGWzvP4fMQuBGL"
	crossorigin="anonymous"></script>

<script>

	Kakao.init('579cd0b3f1641314c536c6d2b61ff3df');
	console.log(Kakao.isInitialized());
	
	function kakaoLogin() {
		
		Kakao.Auth.authorize({
			scope: 'profile_nickname, account_email, gender, age_range, birthday',
			success: function(authObj) {
				console.log(authObj);
				Kakao.API.request({
					url: '/v2/user/me',
					success: res => {
						const kakao_account = res.kakao_account;
						console.log(kakao_account);
					}
				});
				 
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		//window.Kakao.init("579cd0b3f1641314c536c6d2b61ff3df");
		
		//function kakaoLogin() {
		//	window.Kakao.Auth.login({
		//		scope: 'profile_nickname, account_email, gender, age_range, birthday',
		//		success: function(authObj) {
		//			console.log(authObj);
		//			window.Kakao.API.request({
		//				url:'/v2/user/me',
		//				success: res => {
		//					const kakao_account = res.kakao_account;
		//					console.log(kakao_account);
		//				}
		//			});
		//		}
		//	});
	//	} 
	</script>

</head>
<body>

</body>
</html>