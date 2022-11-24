<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--     팝업설정 -->
 <%
    String popupMode="on"; // 팝업창 띄우기 
 
    Cookie[] cookie = request.getCookies(); // 쿠키 생성
    if(cookie!=null){
       for(Cookie ck:cookie){
          String ckName=ck.getName();
          if(ckName.equals("PopupMode")){
             popupMode = ck.getValue();
          }
       }
    }
    %>   
<!--     팝업 설정  -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Home Page</title>
<script type="text/javascript">
//마우스 하트
//<![CDATA[
var colours=new Array('#f00', '#f06', '#f0f', '#f6f', '#f39', '#f9c'); // colours of the hearts
var minisize=16; // smallest size of hearts in pixels
var maxisize=28; // biggest size of hearts in pixels
var hearts=66; // maximum number of hearts on screen
var over_or_under="over"; // set to "over" for hearts to always be on top, or "under" to allow them to float behind other objects

/*****************************
*JavaScript Love Heart Cursor*
*  (c)2013+ mf2fm web-design *
*   http://www.mf2fm.com/rv  *
*  DON'T EDIT BELOW THIS BOX *
*****************************/
var x=ox=400;
var y=oy=300;
var swide=800;
var shigh=600;
var sleft=sdown=0;
var herz=new Array();
var herzx=new Array();
var herzy=new Array();
var herzs=new Array();
var kiss=false;

if (typeof('addRVLoadEvent')!='function') function addRVLoadEvent(funky) {
var oldonload=window.onload;
if (typeof(oldonload)!='function') window.onload=funky;
else window.onload=function() {
 if (oldonload) oldonload();
 funky();
}
}

addRVLoadEvent(mwah);

function mwah() { if (document.getElementById) {
var i, heart;
for (i=0; i<hearts; i++) {
 heart=createDiv("auto", "auto");
 heart.style.visibility="hidden";
	heart.style.zIndex=(over_or_under=="over")?"1001":"0";
 heart.style.color=colours[i%colours.length];
	heart.style.pointerEvents="none";
 if (navigator.appName=="Microsoft Internet Explorer") heart.style.filter="alpha(opacity=75)";
 else heart.style.opacity=0.75;
 heart.appendChild(document.createTextNode(String.fromCharCode(9829)));
 document.body.appendChild(heart);
 herz[i]=heart;
	herzy[i]=false;
}
set_scroll();
set_width();
herzle();
}}

function herzle() {
var c;
if (Math.abs(x-ox)>1 || Math.abs(y-oy)>1) {
 ox=x;
 oy=y;
 for (c=0; c<hearts; c++) if (herzy[c]===false) {
	  herz[c].firstChild.nodeValue=String.fromCharCode(9829);
   herz[c].style.left=(herzx[c]=x-minisize/2)+"px";
   herz[c].style.top=(herzy[c]=y-minisize)+"px";
   herz[c].style.fontSize=minisize+"px";
	  herz[c].style.fontWeight='normal';
   herz[c].style.visibility='visible';
   herzs[c]=minisize;
   break;
 }
}
for (c=0; c<hearts; c++) if (herzy[c]!==false) blow_me_a_kiss(c);
setTimeout("herzle()", 40);
}

document.onmousedown=pucker;
document.onmouseup=function(){clearTimeout(kiss);};

function pucker() {
ox=-1;
oy=-1;
kiss=setTimeout('pucker()', 100);
}

function blow_me_a_kiss(i) {
herzy[i]-=herzs[i]/minisize+i%2;
herzx[i]+=(i%5-2)/5;
if (herzy[i]<sdown-herzs[i] || herzx[i]<sleft-herzs[i] || herzx[i]>sleft+swide-herzs[i]) {
 herz[i].style.visibility="hidden";
 herzy[i]=false;
}
else if (herzs[i]>minisize+2 && Math.random()<.5/hearts) break_my_heart(i);
else {
 if (Math.random()<maxisize/herzy[i] && herzs[i]<maxisize) herz[i].style.fontSize=(++herzs[i])+"px";
 herz[i].style.top=herzy[i]+"px";
 herz[i].style.left=herzx[i]+"px";
}
}

function break_my_heart(i) {
var t;
herz[i].firstChild.nodeValue=String.fromCharCode(9676);
herz[i].style.fontWeight='bold';
herzy[i]=false;
for (t=herzs[i]; t<=maxisize; t++) setTimeout('herz['+i+'].style.fontSize="'+t+'px"', 60*(t-herzs[i]));
setTimeout('herz['+i+'].style.visibility="hidden";', 60*(t-herzs[i]));
}

document.onmousemove=mouse;
function mouse(e) {
if (e) {
 y=e.pageY;
 x=e.pageX;
}
else {
 set_scroll();
 y=event.y+sdown;
 x=event.x+sleft;
}
}

window.onresize=set_width;
function set_width() {
var sw_min=999999;
var sh_min=999999;
if (document.documentElement && document.documentElement.clientWidth) {
 if (document.documentElement.clientWidth>0) sw_min=document.documentElement.clientWidth;
 if (document.documentElement.clientHeight>0) sh_min=document.documentElement.clientHeight;
}
if (typeof(self.innerWidth)=='number' && self.innerWidth) {
 if (self.innerWidth>0 && self.innerWidth<sw_min) sw_min=self.innerWidth;
 if (self.innerHeight>0 && self.innerHeight<sh_min) sh_min=self.innerHeight;
}
if (document.body.clientWidth) {
 if (document.body.clientWidth>0 && document.body.clientWidth<sw_min) sw_min=document.body.clientWidth;
 if (document.body.clientHeight>0 && document.body.clientHeight<sh_min) sh_min=document.body.clientHeight;
}
if (sw_min==999999 || sh_min==999999) {
 sw_min=800;
 sh_min=600;
}
swide=sw_min;
shigh=sh_min;
}

window.onscroll=set_scroll;
function set_scroll() {
if (typeof(self.pageYOffset)=='number') {
 sdown=self.pageYOffset;
 sleft=self.pageXOffset;
}
else if (document.body && (document.body.scrollTop || document.body.scrollLeft)) {
 sdown=document.body.scrollTop;
 sleft=document.body.scrollLeft;
}
else if (document.documentElement && (document.documentElement.scrollTop || document.documentElement.scrollLeft)) {
 sleft=document.documentElement.scrollLeft;
 sdown=document.documentElement.scrollTop;
}
else {
 sdown=0;
 sleft=0;
}
}

function createDiv(height, width) {
var div=document.createElement("div");
div.style.position="absolute";
div.style.height=height;
div.style.width=width;
div.style.overflow="hidden";
div.style.backgroundColor="transparent";
return (div);
}
//]]>

</script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 <!-- 메인페이지 스타일 -->
 <style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');

 	
 	.reviewmain{
 		background: linear-gradient(#ead7da, #ffc3bf, #ffbfc0, #ffbfc5, #ffbfca);
		width: 100%;
		height: auto;
		padding: 5em 10em;
	}
	.membermain{
		border: 1px solid black;
		background: linear-gradient(#E16A9D,#E6749D,#F479DF, #FFB0D9, #F4B6D9);
		width: 100%;
		height: auto;
		padding: 5em 10em;
	}
	.membermain>div{
	    display: inline-block;		
		
		text-align:center;
		color: black;
	}
	
	#gen1{
		font-family: 'Jua', sans-serif;
		color: 
		border: 3px solid white;;
		background: linear-gradient(white,#FFBEC3);
		border-radius: 10px;
		background-size: inherit;
		margin-bottom: 50px;
		width:30%;
		text-align: center;
		margin-left: 475px;
	}
	#gen2{
		font-family: 'Jua', sans-serif;
		font-size: 40px;
		background: linear-gradient(white,#FFBEC3);
		border-radius: 15px;
	}

	:root {
		  --level-one: translateZ(3rem);
		  --level-two: translateZ(6rem);
		  --level-three: translateZ(9rem);
		  
		  --fw-normal: 400;
		  --fw-bold: 700;
		  
		  --clr: #b7c9e5;
		}	
	
		.card, .card::before, .card::after {
			box-sizing: border-box;
			margin: 0;
		}
		

		.card {
			width: 400px;

			
		}
	
		.card__content {
			text-align: center;
			position: relative;
			padding: 15em 5em;
			transition: transform 1s;
			transform-style: preserve-3d;
			
		}
		
		.card__front,
		.card__back {
			position: absolute;
			top: 0;
			bottom: 0;
			left: 0;
			right: 0;
			padding: 5em 3em;
			backface-visibility: hidden;
			transform-style: preserve-3d;
			align-content: center;
		}
		
		.card__title {
			font-size: 3rem;
			transform: var(--level-three);
			order: 2;
			text-transform: uppercase;			
		}
		
		
		.card:hover .card__content {
			transform: rotateX(.5turn);
		}
		
		.card__front {
			padding-top: 10em;
			background-color: var(--clr);
			background-size: 100% 100%;
			background-blend-mode: overlay;
			color: #333;
			background-position:center;
		}
		
		.card__back {
			transform: rotateX(.5turn);
			background: Azure;
			color: var(--clr);
			overflow: hidden;
		}
		
		
		
		.card__body {
			transform: var(--level-two);
  			font-weight: var(fw-normal);
			font-size: 1.5rem;
			line-height: 1.6;
		}
		
		.backfont:hover {
			color: pink;
		}
		
		.card__subtitle {
			transform: var(--level-two);
  			text-transform: uppercase;
			letter-spacing: 4px;
			font-size: .75em;
			font-weight: var(--fw-bold);
			opacity: .7;
		}
	
		.card__front::before {
		  content: '';
		  position: absolute;
		  --spacer: 1em;
		  top: var(--spacer);
		  bottom: var(--spacer);
		  left: var(--spacer);
		  right: var(--spacer);
		  border: 3px solid currentColor;
		  transform: var(--level-one);
		}
		
		#gen{
			margin-left: 280px;
 			
		}
		
		#mat{				
			/* position:fixed;  */
		   	float: right;
	  		margin-right: 280px;
		}
		
		.pie-chart{
			
		}
		.pie-chart {
		  position: relative;
		  display:inline-block;
		  width: 280px;
		  height: 280px;
		  border-radius: 50%;
		  transition: 0.3s;
		}
		span.center{
		  background: #fff;
		  display : block;
		  position: absolute;
		  top:50%; left:50%;
		  width:140px; height:140px;
		  border-radius: 50%;
		  text-align:center; 
		  line-height: 100px;
		  font-size:40px;
		  transform: translate(-50%, -50%);
		
		}
		.pie-chart1{
		  animation: pie1 0.5s forwards;
		}
		@keyframes pie1{
		  0%{background : conic-gradient(#CD426B 0% 0%, #0A6EFF 0% 100%)}
		  5%{background : conic-gradient(#CD426B 0% 5%, #0A6EFF 0% 100%)}
		  10%{background : conic-gradient(#CD426B 0% 10%, #0A6EFF 0% 100%)}
		  15%{background : conic-gradient(#CD426B 0% 15%, #0A6EFF 0% 100%)}
		  20%{background : conic-gradient(#CD426B 0% 20%, #0A6EFF 0% 100%)}
		  25%{background : conic-gradient(#CD426B 0% 25%, #0A6EFF 0% 100%)}
		  30%{background : conic-gradient(#CD426B 0% 30%, #0A6EFF 0% 100%)}
		  35%{background : conic-gradient(#CD426B 0% 35%, #0A6EFF 0% 100%)}
		  40%{background : conic-gradient(#CD426B 0% 40%, #0A6EFF 0% 100%)}
		  45%{background : conic-gradient(#CD426B 0% 45%, #0A6EFF 0% 100%)}	
		  100%{background : conic-gradient(#CD426B 0% 50%, #0A6EFF 0% 100%)}
		}
		.pie-chart2{
		 animation: pie2 0.5s forwards;
		}
		@keyframes pie2{
		  0%{background : conic-gradient(#288CFF 0% 0%, #464646 0% 100%)}
		  6%{background : conic-gradient(#288CFF 0% 5%, #464646 0% 100%)}
		  12%{background : conic-gradient(#288CFF 0% 10%, #464646 0% 100%)}
		  18%{background : conic-gradient(#288CFF 0% 15%, #464646 0% 100%)}
		  25%{background : conic-gradient(#288CFF 0% 20%, #464646 0% 100%)}
		  33%{background : conic-gradient(#288CFF 0% 25%, #464646 0% 100%)}
		  38%{background : conic-gradient(#288CFF 0% 30%, #464646 0% 100%)}
		  44%{background : conic-gradient(#288CFF 0% 35%, #464646 0% 100%)}
		  50%{background : conic-gradient(#288CFF 0% 40%, #464646 0% 100%)}
		  56%{background : conic-gradient(#288CFF 0% 44%, #464646 0% 100%)}
		  62%{background : conic-gradient(#288CFF 0% 52%, #464646 0% 100%)}
		  68%{background : conic-gradient(#288CFF 0% 60%, #464646 0% 100%)}
		  75%{background : conic-gradient(#288CFF 0% 69%, #464646 0% 100%)}
		  82%{background : conic-gradient(#288CFF 0% 76%, #464646 0% 100%)}
		  88%{background : conic-gradient(#288CFF 0% 81%, #464646 0% 100%)}
		  94%{background : conic-gradient(#288CFF 0% 87%, #464646 0% 100%)}
		  100%{background : conic-gradient(#288CFF 0% 93%, #464646 0% 100%)}
		}
 </style>

<!-- 팝업 스타일 설정 -->
<style> 
#popup{
   position:absolute;top:300px;left:130px;
   width:270px;height:100px; z-index: 2000;
	
   }
#popup>div{
	position: relative;
  background-color:white;top:0px;
   border: 1px solid gray; padding:10px;color:black; 
	width: 570px;
}
</style>
<!--     팝업 스타일 설정 -->

<!-- 팝업 제이쿼리 설정     -->
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script>
$(function () {
   $('#closeBtn').click(function(){
      $('#popup').hide();
      var chk =$("#inactiveToday:checked").val();
      if(chk=='1'){
         $.ajax({
            url:'./PopupCookie.jsp',
            type : 'get',
            data : {inactive:chk},
            datatype : 'text',
            success : function(){
               if(resData!='')location.reload();
            }
         })
      }
   });
});
</script>

<!-- 팝업 제이쿼리 설정 -->

</head>
<body>
<!-- 팝업이 나오는 창 -->
   <%
   if(popupMode.equals("on")){
   %>
   <div id="popup">
        <img alt="" src="../img/팝업.png" width="570px" >
      <div align="right">
         <form name="popForm">
            <input type="checkbox" id="inactiveToday" value="1">
            하루동안 안 열기
            <input type="button" value="닫기" id="closeBtn">
         </form>
      </div>   
   </div>
   <%
   }
   %>
<!--  팝업이 나오는 창 -->

<jsp:include page="../common/Top.jsp"/>


<div class="membermain">
	<h1 id="gen1">회 원 현 황</h1>
	<div id="gen">
		<h2 id="gen2">남녀 성비 비율은?</h2><br/><br/><br/>
		<div class="pie-chart pie-chart1"><span class="center">50%</span></div>
	</div>
	<div id="mat">
		<h2 id="gen2">매칭 성공 비율은?</h2><br/><br/><br/>
		<div class="pie-chart pie-chart2"><span class="center">93%</span></div>
	</div>
</div>
<section>
<div class="reviewmain" align="center">
				<c:choose>
					<c:when test="${empty mainReviewLists}">
							<div class="card" style="width: 18rem;"> 등록된 후기가 없습니다.</div>
					</c:when>
					<c:otherwise>
					<div class="row">
						<c:forEach items="${mainReviewLists}" var="list" varStatus="stat">
							<div class="col-lg-4 col-md-6" style="display: table-cell; border-spacing:0px;" >
								<div class="card">
									<div class="card__content">
										<div class="card__front" 
											style="background-image: url(../Storage/${list.nfile});">
								    		<h3 class="card__title">
								    			평점:
												<c:if test="${list.star==4}">★★★★</c:if>
												<c:if test="${list.star==5}">★★★★★</c:if>
											</h3>
									    </div> 
										<div class="card__back">
									    	<a href="/MProject/reviewBoard/reviewView.do?num=${list.num}" class="backfont">
										    	<p class="card__body">제목: ${list.name}</p>
											    <p class="card__body">작성자: ${list.RV_POSTNAME }</p>
											    <p class="card__body">작성일: ${list.postdate}</p>
										  		<p class="card__body">내용: ${list.content}</p>
									   		</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
					</div>
	

	
	   <div class="container"style="text-align: center; margin-top: 100px; margin-bottom: 100px; border: 1px solid rgba(0, 0, 0, 0.1);" >
    	<div class="row" style="margin: 30px;">
    		<div class="col">
		    	<img alt="" src="https://assets.website-files.com/61d28aad499f21ae92aa33ed/61e4d89641c3e5b3bc63a8ee_Main-Intro-Background.png" style="width:200px; height: auto;">
		    	<p style="margin-top: 30px;">2022 한국 브랜드 <br/>리더 대상</p>
    		</div>
    		<div class="col" style="margin-top: 40px">
		    	<img alt="" src="https://dimg.donga.com/ugc/CDB/WOMAN/Article/63/05/8c/72/63058c721c87d2738250.jpg" style="width:200px; height: auto;">
    			<p style="margin-top: 50px;">2022 대한민국 고객 만족 <br/>브랜드 대상</p>
    		</div>
    		<div class="col">
		    	<img alt="" src="https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202206/28/ec768f43-b08c-44d0-91a1-7e4e49c502f1.jpg" style="width:200px; height: auto;">
    			<p style="margin-top: 30px;">2022 고객 감동 우수 <br/>브랜드 대상</p>
    		</div>
    		<div class="col">
		    	<img alt="" src="https://compphoto.incruit.com/2013/05/title_gwpseoul_201352818830.gif" style="width:200px; height: auto;">
		    	<p style="margin-top: 30px;">2022 일하기 좋은 우수기업 <br/> 100선 선정</p>
    		</div>
    		
    	</div>
    </div>
</section>

<jsp:include page="../common/Footer.jsp"/>
</body>
</html>