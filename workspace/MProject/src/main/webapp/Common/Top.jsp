<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <html>  
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 	    
		
		  
		
	<style>
		
 	a{text-decoration: none;}
	
	#btn1,#btn2,#btn3,#btn4,#btn5 {
  		margin-top: 20px;
  	 	width: 140px;
  		height: 45px;
	  	font-family: 'Roboto', sans-serif;
	  	font-size: 11px;
	  	text-transform: uppercase;
	  	letter-spacing: 2.5px;
	  	font-weight: bold;
	  	color: black;
	  	background: linear-gradient(60deg,#FFB6C1,#FFC6C3);
	  	border: 1px #fff;
	  	border-radius: 45px;
	  	box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
	  	transition: all 0.3s ease 0s;
	  	cursor: pointer;
	  	outline: none;
  	}
  	
	#btn1:hover, #btn2:hover, #btn3:hover, #btn4:hover, #btn5:hover {
	  	background: linear-gradient(60deg,#FF69B4,#D7567F);
	  	box-shadow: 0px 15px 20px rgba(246, 59, 167, 0.6);
	  	color: white;
	  	transform: translateY(-7px);
	}
	
	.gr { 
		font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
		font-size: larger;
		font-weight:  100;
		letter-spacing: 2px;
		text-align: center;
		color: #f35626;
		background-image: -webkit-linear-gradient(92deg, #f35626, #feab3a);
		-webkit-background-clip: text;
		-webkit-text-fill-color: transparent;
		-webkit-animation: hue 5s infinite linear;
		position:relative; 
	}
	
	.gr:after {
		background: none;
	  	content: attr(data-text);
		left: 0;
		position: absolute;
		text-shadow: 2px 1px 3px pink;
		top: 0;
		z-index: -1;
		text-align:initial;
	}
	
	
	@-webkit-keyframes hue {
	  from {
	    -webkit-filter: hue-rotate(0deg);
		}
	  to {
	    -webkit-filter: hue-rotate(-360deg);
		}
	}
	
	#nav {
		position: relative;
		top: 0;
		right: 0;
		left: 0;
		width: 60%;
		display: table;
		margin-top: 50px;
		transform: translateY(-50%);
	}

	#nav a {
		position:relative;
		width: 20%;
		display: table-cell;
		text-align: center;
		color: gray;
		font-size:1.2em;
		text-decoration: none;
		font-family: Verdana, Geneva, Tahoma, sans-serif;
		font-weight: bold;
		padding: 10px 20px;
		transition: 0.2s ease color;
	}

	#nav a:before,
	#nav a:after {
	  content: "";
	  position: absolute;
	  border-radius: 50%;
	  transform: scale(0);
	  transition: 0.2s ease transform;
	  
	}

	#nav a:before {
	  top: 0;
	  left: 10px;
	  width: 6px;
	  height: 6px;
	}
	
	#nav a:after {
	  top: 5px;
	  left: 18px;
	  width: 4px;
	  height: 4px;
	}

	#nav a:nth-child(1):before {
	  background-color: yellow;
	}
	
	#nav a:nth-child(1):after {
	  background-color: red;
	}
	
	#nav a:nth-child(2):before {
	  background-color: #00e2ff;
	}

	#nav a:nth-child(2):after {
	  background-color: #89ff00;
	}
	
	#nav a:nth-child(3):before {
	  background-color: skyblue;
	}
	
	#nav a:nth-child(3):after {
	  background-color: blue;
	}

	#nav a:nth-child(4):before {
	  background-color: palevioletred;
	}
	
	#nav a:nth-child(4):after {
	  background-color: palevioletred;
	}
	
	#nav a:nth-child(5):before {
	  background-color: gray;
	}
	
	#nav a:nth-child(5):after {
	  background-color: black;
	}


	#indicator {
  		position: absolute;
  		left: 0;
 		bottom: 0;
  		width: 20%;
  		height: 3px;
  		background-color: #fff;
  		border-radius: 5px;
  		transition: 0.2s ease left;
	}

	#nav a:hover {
		color: pink;
	}
	
	#nav a:hover:before,
	#nav a:hover:after {
	  transform: scale(1);
	}

	#nav a:nth-child(1):hover ~ #indicator {
	  background: linear-gradient(130deg, yellow, red);
	}

	#nav a:nth-child(2):hover ~ #indicator {
	  left: 20%;
	  background: linear-gradient(130deg, #00e2ff, #89ff00);
	}

	#nav a:nth-child(3):hover ~ #indicator {
	  left: 40%;
	  background: linear-gradient(130deg, skyblue, blue);
	}

	#nav a:nth-child(4):hover ~ #indicator {
	  left: 60%;
	  background: linear-gradient(130deg, purple, palevioletred);
	}
	
	#nav a:nth-child(5):hover ~ #indicator {
	  left: 80%;
	  background: linear-gradient(130deg, white, black);
	}

	#navback {
		background-color: Azure; 
		overflow: hidden; 
		z-index: -1; 
		margin-top: 100px;
	}
	
	
	
	#nav #indicator:checked, #nav #indicator:active {
   		background: linear-gradient(130deg, yellow, red);
   	}


 </style> 
</head>

<header>
  
    <div class="container text-center">
	  <div class="row">
	    <div class="col" style="padding-top: 70px;"  align="center">
	    	<!-- 로고 -->
	    	<a href="../reviewBoard/ReviewMainPage.do"><img src="../Img/MProjectLogo.png" alt="로고없음" style="width: 200px; height: auto;" /></a>
	    </div>
	    
	    <div class="col" style="padding-top: 100px; padding-bottom: 50px;">
	    	<h1>
	    		<a href="../reviewBoard/ReviewMainPage.do" class="gr" data-text="PreciousQualityTime">PreciousQualityTime</a>
	    	</h1>
	    </div>
	    
	    <div class="col" style="padding-top: 50px;"  >
	    	<%
			if(session.getAttribute("me_id") != null){
			%>
				<div style="font-family: 'Roboto', sans-serif; font-weight: bold;">
					<%= session.getAttribute("me_name") %> 회원님
				</div>
				
				<div align="center">
					<button type="button" class="btn btn-danger" id="btn3" onclick="location.href='../Loginout/Logout.do';">로그아웃</button>
					<button type="button" class="btn btn-danger" id="btn5" onclick="location.href='../MainPage/MyPage.jsp';">내정보페이지</button>
				</div>
			<%
			} else {
			%>
				<div align="center">
					<button type="button" class="btn btn-outline-danger" id="btn1" onclick="location.href='../02Login/LoginForm.jsp';">로그인</button>
					<button type="button" class="btn btn-danger" id="btn2" onclick="location.href='../01Join/Join.jsp';">회원가입</button>
				</div>
			<%
			}
			%>
	    </div>
	  </div>
	</div>
	
	

	
	<div id="navback" align="center">
	    <div id="nav">
	        <a href="../InfoBoard/InfoPage.jsp">소개</a>
	        <a href="../InfoBoard/InfoPage.jsp">가이드</a>
	        <a href="../matching/main.do">매칭</a>
	        <a href="../reviewBoard/reviewList.do">게시판</a>
	        <a href="../qnasBoard/qnasList.do">1:1문의</a>      
	    	<div id="indicator"></div>
	    </div>
	</div>
  
    
  </header>
  

<body>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	
	<script>
	
		var div2 = document.getElementsByClassName("div2");

      	function handleClick(event) {
	        console.log(event.target);
	        // console.log(this);
	        // 콘솔창을 보면 둘다 동일한 값이 나온다
	
	        console.log(event.target.classList);
	
	        if (event.target.classList[1] === "clicked") {
	        	event.target.classList.remove("clicked");
	        } else {
	        	for (var i = 0; i < div2.length; i++) {
	            	div2[i].classList.remove("clicked");
	          	}
	
	          	event.target.classList.add("clicked");
	        }
   		}

      	function init() {
        	for (var i = 0; i < div2.length; i++) {
          		div2[i].addEventListener("click", handleClick);
        	}
      	}

      init();
      
	</script>
	
	<script type ="text/javascript">
     	$('#Logout').click(function(){
    	  	let userId = $('#Idchecks').val(); // input_id에 입력되는 값            
            $.ajax({
               	url : "MainPage.jsp",
               	type : "post",
               	data : {userId: userId},
               	dataType : 'json',
               	success : function(result){
                 	if(result == 0){
                      	$("#checkId").html('사용할 수 없는 아이디입니다.');
                      	$("#checkId").attr('color','#dc3545');
                   	} else{
                      	$("#checkId").html('사용할 수 있는 아이디입니다.');
                      	$("#checkId").attr('color','#2fb380');
                   	} 
               	},
               	error : function(){
                  	alert("서버요청실패");
               }
            });             
        });
	</script>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>

</html>