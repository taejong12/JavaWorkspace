<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");	
	
%>    
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<style type="text/css">
		@import url('https://fonts.googleapis.com/css2?family=Song+Myung&display=swap');
   
    <%
    	if(name=="소개") {
    %>
    	
   		#indicator:checked {
   			background: linear-gradient(130deg, yellow, red);
   		}
   		
    <%
    	} 
    %>
    	
		
		html, body{height: 100%;}
		#h2 {font-family: 'Song Myung', serif;margin-top: 100px;letter-spacing:8px;}
		#h22{
			font-family: 'Song Myung', serif;
			margin-top: 20px;
			margin-left: 10px;
		}
		#title{margin-top: 270px;}
		#p{font-size: 100px;color: black;}
		#t{color: #6495ED;font-size: 55px;}
		.part{height: 100%;width: 100%;}
		.one{background: linear-gradient(50deg, white, pink);
			width: 900px;height: 700px; 
			text-align: center;
			margin-top: 100px;
		}
		#h2{
			animation: fadein 3.5s;
			-webkit-animation: fadein 3.5s;
		}
		@keyframes fadein {
			from {opacity: 0;}		
			to {opacity: 1;}
		}
		
		.par{background: linear-gradient(50deg, white, pink);}
		#zero{display: inline-block; 
			font-family: 'Song Myung', serif; font-size: 25px; 
		}
		#zero1{font-weight: bold;}
		#zero2{color: #6E6ED7;}
		#tit{font-size: 50px;color:#FF6E6E;letter-spacing:8px; }
		#sunset{margin: 150px 200px 180px 120px;
			width: 600px; height: 500px;
			border: 3px solid; border-radius: 50%; border-color: white; }
		
		#comment3{position: absolute;}
		.two{background: linear-gradient(50deg, white, pink);}
		#chapter2{
			display: inline-block;
			margin-top: 80px;
			margin-left: 150px;
			top:0;
			font-family: 'Song Myung', serif;
		}
		.graph{
			margin: 100px 50px 70px 5px; 
			height: 700px; width:800px; 
			border: 5px solid #282828;
			border-radius: 10px;
			position: relative;
		}
		ul>li{
			font-size: 15px;
			font-weight: bold;
		}
		#comment3{margin-right: 60px;}
		.chap2{letter-spacing:10px; font-size: 30px;}
		.chap22{;font-size: 23px; margin-top: 80px;}
		.a{background: #FF9696;}
		.b{background: #F08080;}
		.c{background: #F56E6E;}
		.d{background: #F06464;}
		
		span:nth-of-type(1){ height:71.2%; left: 50px;}
		span:nth-of-type(2){ height:63.1%; left: 260px;}
		span:nth-of-type(3){ height:60.8%; left: 450px;}
		span:nth-of-type(4){ height:59.6%; left: 640px;}
		
		#chapter2 span{
			font-size: 25px;
			line-height: 2em;
			color: black;
			text-align: center;
			border-radius: 15px;
			display: inline-block;
			position: absolute;
			bottom: 0;
		}
		
		#a1{font-weight: bold; color:#3232FF; font-size: 50px;}
		
		#part3{display: inline-block;}	
		.three{background: linear-gradient(50deg, white, pink);}
		#couplepic{
			margin: 50px 200px 180px 120px;
			width: 700px; height: 500px;
			border: 3px solid; border-radius: 50%; border-color: #FFFF8C; 
		}
		#list{text-align:center; margin-top: 150px;}
		#h3{font-family: 'Song Myung', serif; font-size: 40px;}
		#p1 {font-family: 'Song Myung', serif;font-size: 25px;}
		
		
		.four{background: linear-gradient(50deg, white, pink);}
		.last{display: inline-block; margin-right: 145px; margin-left: 145px; margin-bottom: 40px;}
		#stress,#type,#delete{
			margin-top: 50px;
			width:330px;
			height: 300px;
			border: 3px solid white;
			border-radius: 15%;	
		}
		
		#lastd{text-align: center;}
		#lasth2,#lasta{font-family: 'Song Myung', serif;}
		#lasth2{font-size: 30px;text-align: center;}
		#lasta{font-size: 17px;}
	</style>

	<title>Insert title here</title>
	
</head>

	<body>
		<jsp:include page="../Common/Top.jsp"/> 
		
		<div class="list">
			<div class="parent row">
				<div class="part one" id="one">
					<div id="title">
					<h2 id="h2">
						<a id="p">P</a><a id="t">recious</a>       
						<a id="p">Q</a><a id="t">uality</a> 
						<a id="p">T</a><a id="t">ime</a>
					</h2>
					</div>
				</div>
				
				<div class="part par" id="zero">
					<img src="./pic/sunset.jpg" id="sunset">
					<div id="zero">
						<div id="zero1">
						<h2 id="tit">PQT란...</h2> <br/>
						귀중하고 소중한 시간을 가치있게 보내자는 뜻으로 <br/><br/>
						서로를 만나 같이를 가치있게 보내자는 의미를 담아 제공하는 페이지입니다. 
						<br/><br/><br/>
						<p id="zero2">이 페이지는 비혼주의자들을 위한 검증된 싱글 남녀를 위한 1:1 매칭 서비스를 진행하고 있습니다.</p>
						</div>
					</div>
					
				</div>
				
				<div class="part two">
					<div class="graph" id="chapter2">
						<h1 id="h22">비혼 선호도 조사</h1>
						<ul>
							<li>경제적 어려움(71.2%)</li>
							<li>양육비 부담(63.1%)</li>
							<li>주거비 부담(60.8%)</li>
							<li>결혼비용 부담(59.6%)</li>
						</ul>
						<span class="a" data-val="71.2">71.2%</span>
						<span class="b" data-val="63.1">63.1%</span>
						<span class="c" data-val="60.8">60.8%</span>
						<span class="d" data-val="59.6">59.6%</span>
					</div>
					<div id="chapter2" class="service">
						<div id="comment3">
						<h2 class="chap2">왜 <a id="a1">비혼주의자</a>들을 위한 PQT인가?</h2>
						<p class="chap22">
						왼쪽 자료를 보시면 아시다시피<br/>
						현재 비혼주의가 많아지는 이유를 알 수가 있습니다.<br/>
						본인의 삶, 자녀육성에 대한 부담, 금전적 문제, 폭등하는 집 값<br/> 
						환경적 사회적 원인들 뿐만 아니라 <br/>
						2020년 조사결과,<br/>
						53%의 20, 30대의 비혼을 원하는 사람들이 점점 늘어나는 것을 알 수가 있다.
						</p>
						</div>
					</div>
				</div>
				<div class="part three" id="part3">
					<img id="couplepic" src="./pic/couple2.jpg">
						<div class="intro" id="part3">
							<div id="list">
								<h2 id="h3">그런 고객분들을 위해 PQT가 준비했습니다!</h2>
								</br></br></br>
								<p id="p1">
									1. 결혼 생각을 가지지 않는 사람들끼리 편하게 만날 수 있습니다.</br></br>
									2. 본인의 삶을 충분히 챙기며 만남을 이어갈 수 있습니다.</br></br>
									3. PQT는 뛰어난 성사율, 실시간으로 검증이 된 사람들을 토대로 진행이 됩니다.</br></br>
								</p>
							</div>
						</div>					
				</div>
				
				<div class="part four">
					<div>
						<div class="last">
							<img src="./pic/stress.jpg" id="stress"><br/><br/>
							<h3 id="lasth2">신상 노출 "NO"</h3>
							<br/>
							<div id="lastd">
							<a id="lasta">
								저희 PQT는 신상 노출이 되지않습니다 !<br/>
								또한 가입이 되지않는 사람을<br/>
								매칭하며 만남까지 가지는 것은 불가합니다.<br/>
		
								프라이버시를 가장 중요하게 생각하기 때문에<br/>
								무작위로 신상이 노출되지 않습니다.<br/>
							</a>
							</div>
						</div>
						
						<div class="last">
							<img src="./pic/type.jpg" id="type"><br/><br/>
							<h3 id="lasth2">회원 차별 매칭 "NO"</h3>
							<div id="lastd">
							<a id="lasta">
								저희 PQT는 사회적으로<br/>
								차별화된 매칭 페이지가 아닙니다.<br/>
								<br/>
								남성회원 및 여성회원 모두<br/>
								소중한 저희 회원이며 , 서로가 원하는<br/>
								이상형에 맞춤 필터를 제공하는 소개팅입니다.<br/>
							</a>
							</div>
						</div>
						
						<div class="last">
							<img src="./pic/delete.jpg" id="delete"><br/><br/>
							<h3 id="lasth2">비매너 회원 즉시 "제명"</h3>
							<div id="lastd">
							<a id="lasta">
								PQT는 신뢰와 매너를 가장 중요시합니다.<br/>
								<br/>
								저희 PQT는 회원 차별없이<br/>
								비매너 언행과 행동이 확인 된 회원 및 <br/>
								매칭에 의사가 없거나 or 장난으로 가입하신 회원은<br/>
								블랙리스트로 제명이 됩니다.<br/>
							</a>
							</div>
						</div>
					</div>
					<div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../Common/Footer.jsp"/>
	</body>
</html>