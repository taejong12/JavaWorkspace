<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pqt</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 
 <style>
 	.reviewmain{
 		background: linear-gradient(#ead7da, #ffc3bf, #ffbfc0, #ffbfc5, #ffbfca);
		width: 100%;
		height: auto;
		padding: 5em 10em;
	}
	

	@import url('https://fonts.googleapis.com/css?family=Oswald:400,700');
	
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
 </style>


 
</head>
<body>
	
<jsp:include page="../Common/Top.jsp"/>

 <div style="text-align: center; margin-top: 100px; margin-bottom: 100px;" >회원현황 및 소개문구</div>

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

<jsp:include page="../Common/Footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>

<
</html>