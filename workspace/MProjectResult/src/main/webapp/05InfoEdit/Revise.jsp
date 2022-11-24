<%@page import="sign.JoinDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<style>
<style type="text/css">

body {
  font-family:"Raleway";
}

.form {
  position:relative;
  top:0;
  left:0;
  margin-top:56px;
}


.form .form-header {
  height:30px;
  display:flex;
  align-items:center;
  text-align:center;
}

.form .form-header .show-signup {
  width:calc(100%);
  color:#f1575b;
  font-size:20px;
  font-weight:700;
  cursor:pointer;
}


.form .form-elements {
  margin-top:15px;
  width:650px;
  margin: 0 auto;
}



.form .form-elements input {
  font-size:14px;
  width: 100%;
  height: 30px;
  margin-top: 5px;
  margin:0 auto;
  padding : 2px 10px;
  border-radius:10px;
  box-sizing:border-box;
  border:none;
  background:#ffeaea;
}

#idchk, #Mpb, #emailchk, #kakaochk {
	line-height:30px;
	margin-left:590px;
	margin-top:5px;
	padding:0;
	width : 60px;
	font-size:12px;
	border-radius: 5px;
}
.form .form-elements button {
  
  font-size:14px;
  font-weight:600;
  border-radius:10px;
  background:#f1575b;
  color:#f5f5f5;
  cursor:pointer;
  border:none;
  outline:none;
}
.form-element {
	margin-top:10px;
	
}
.form-check-inline {
	margin-top:10px;
}
.div-left{
	float:left;
	margin-right:10px;
	
}
.div-right{
	float:left;
	
}
.main {
	display: flex;
	align-items: center;
	padding: 10px;
	justify-content: center
}
</style>
</head>
<body>
<jsp:include page="../common/Top.jsp"/>

<div class="form signup" class="p-3 mb-2 bg-secondary text-white">
	<div class="form-header">
    	<h1 class="show-signup">Sign Up</h1>
	</div>
<div class="main">
	<div class="total">	
		<div class = "div-left">
		<div class="container text-center">
		  <div class="row justify-content-md-center">

		  
			<form name="myFrm" method="post" enctype="multipart/form-data" 
			action="../controller/PRevise.do" onsubmit="return validateForm(this);" >
			<div align="center" class="form-elements">
		         
		      	<div class="form-element" >
					<input type="tel" placeholder="핸드폰번호(xxx-xxxx-xxxx)"  name="ME_PHONE" id="Mpv"
							required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"  maxlength="13" value="${dto.ME_PHONE}"/>
		            <button type="submit" id="peditbtn">번호수정하기</button>
		        </div>
		        </div>
		        </form>
		  
		<form name="EReviseFrm" method="post" action="../controller/ERevise.do"
		   onsubmit = "return validateForm(this);" align="center">
		   <div align="center" class="form-elements"> 
		<div class="form-element">   
		     <input type="email" placeholder="이메일 주소"  name="ME_EMAIL" id="emailchkv" value="${dto.ME_EMAIL}" />
		     <button type="submit" id="eeditbtn" onclick="$('#peditbtn').trigger('click');" >이메일수정하기</button>
		     <input type="hidden" id="emcheck" name="emDuplication" value="emUncheck" >
		     <font size = "2" id = "emailft" ></font>
		</div>
		</div>
		</form>
		       
		  
		   <form name="ReviseFrm2" method="post" action="../controller/Revise.do" 
		   onsubmit = "return validateForm(this);" align="center">   
		      <div align="center" class="form-elements">
		      <div class="form-element">
		     	<input type="password" placeholder="비밀번호"  name="ME_PASS" id="ME_PASS" class="pw" value="${dto.ME_PASS}"/><br><br>
		      	<input type="password" placeholder="비밀번호확인"  name="ME_PASS2" id="ME_PASS2" class="pw" value="${dto.ME_PASS}"/>
		        <font id = "checkPw" size = "2"></font><br /><br />
		      </div>
		      <div class="form-element">
		      	<input type="text" placeholder="이름"  name="ME_NAME" value="${dto.ME_NAME}"/><br /><br />
		      </div>
		      
		      <div class="form-element">
		      	<input type="date" placeholder="text" name="ME_BIRTH"  value="${dto.ME_BIRTH}"/><br /><br />
		      </div>
		     
		     <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
		      display: flex; width: 200px; justify-content: space-between; align-items: center;height:30px; width:80px;">
		      성별:<select name="ME_SEX" id="renum" style="background-color:white; border-radius: 10px;">
		                  <option value="남"
		                     <c:if test="${dto.ME_SEX=='남'}">selected</c:if>>남
		                  </option>
		                  <option value="여"
		                  <c:if test="${dto.ME_SEX=='여'}">selected</c:if>>여
		                  </option>               
		               </select>
		               <br/><br/>
		       </div>  
		      <div class="form-element">     
		      	<input type="number" placeholder="나이"  name="ME_AGE" value="${dto.ME_AGE}"/><br /><br />
		      </div>
		      
		      <div class="form-element">
		      <input type="text" placeholder="카카오ID" name="ME_KAKAO" value="${dto.ME_KAKAO}"/><br /><br />
		      </div>
		      
		     <div class="form-box" style="background-color:#ffeaea; border-radius: 10px; 
		      display: flex; width: 200px; justify-content: space-between; align-items: center;height:30px; width:160px;">
		      지역번호:<select name="RE_NUM" id="renum" style="background-color:white; border-radius: 10px;">
		                  <option value="201"                    
		                     <c:if test="${dto.RE_NUM=='201'}">selected</c:if>>강남구
		                  </option>
		                  <option value="202"
		                     <c:if test="${dto.RE_NUM=='202'}">selected</c:if>>강동구
		                  </option>
		                  <option value="203"
		                     <c:if test="${dto.RE_NUM=='203'}">selected</c:if>>강북구
		                  </option>
		                  <option value="204"
		                     <c:if test="${dto.RE_NUM=='204'}">selected</c:if>>강서구
		                  </option>
		                  <option value="205"
		                     <c:if test="${dto.RE_NUM=='205'}">selected</c:if>>관악구
		                  </option>
		                  <option value="206"
		                     <c:if test="${dto.RE_NUM=='206'}">selected</c:if>>광진구
		                  </option>
		                  <option value="207"
		                     <c:if test="${dto.RE_NUM=='207'}">selected</c:if>>구로구
		                  </option>
		                  <option value="208"
		                     <c:if test="${dto.RE_NUM=='208'}">selected</c:if>>금천구
		                  </option>
		                  <option value="209"
		                     <c:if test="${dto.RE_NUM=='209'}">selected</c:if>>노원구
		                  </option>
		                  <option value="210"
		                     <c:if test="${dto.RE_NUM=='210'}">selected</c:if>>도봉구
		                  </option>
		                  <option value="211"
		                     <c:if test="${dto.RE_NUM=='211'}">selected</c:if>>동대문구
		                  </option>
		                  <option value="212"
		                     <c:if test="${dto.RE_NUM=='212'}">selected</c:if>>동작구
		                  </option>
		                  <option value="213"
		                     <c:if test="${dto.RE_NUM=='213'}">selected</c:if>>마포구
		                  </option>
		                  <option value="214"
		                     <c:if test="${dto.RE_NUM=='214'}">selected</c:if>>서대문구
		                  </option>
		                  <option value="215"
		                     <c:if test="${dto.RE_NUM=='215'}">selected</c:if>>서초구
		                  </option>
		                  <option value="216"
		                     <c:if test="${dto.RE_NUM=='216'}">selected</c:if>>성동구
		                  </option>
		                  <option value="217"
		                     <c:if test="${dto.RE_NUM=='217'}">selected</c:if>>성북구
		                  </option>
		                  <option value="218"
		                     <c:if test="${dto.RE_NUM=='218'}">selected</c:if>>송파구
		                  </option>
		                  <option value="219"
		                     <c:if test="${dto.RE_NUM=='219'}">selected</c:if>>양천구
		                  </option>
		                  <option value="220"
		                     <c:if test="${dto.RE_NUM=='220'}">selected</c:if>>영등포구
		                  </option>
		                  <option value="221"
		                     <c:if test="${dto.RE_NUM=='221'}">selected</c:if>>용산구
		                  </option>
		                  <option value="222"
		                     <c:if test="${dto.RE_NUM=='222'}">selected</c:if>>은평구
		                  </option>
		                  <option value="223"
		                     <c:if test="${dto.RE_NUM=='223'}">selected</c:if>>종로구
		                  </option>
		                  <option value="224"
		                     <c:if test="${dto.RE_NUM=='224'}">selected</c:if>>중구
		                  </option>
		                  <option value="225"
		                     <c:if test="${dto.RE_NUM=='225'}">selected</c:if>>중랑구
		                  </option>         
		        </select><br/><br/>
		        </div>
		        
		      <div class="form-element">  
		      	<button type="submit" id="edit2" onclick="$('#eeditbtn').trigger('click');">수정하기</button>
		      </div>	
		      </div>
		      	</form>
		     </div> 	
		     </div>
		      </div>
	    </div>
		<div class="div-right">
	     	 <form name="ReviseFrm3" method="post" enctype="multipart/form-data" action="../controller/Revise2.do" 
	   			onsubmit="return validateForm(this);" align="center"> 
	   		<div align="center" class="form-elements">
	   		
	   		<div class="form-element">	  
	   			<input type="hidden" name="me_num" value="${dto.ME_NUM}"/>
	   			<input type="hidden" name="prevOpic" value="${dto.in_opic}"/>
	   			<input type="hidden" name="prevNpic" value="${dto.in_npic}"/>
	   			<input type="hidden" name="prevOvoice" value="${dto.in_ovoice}"/>
	   			<input type="hidden" name="prevNvoice" value="${dto.in_nvoice}"/>
			</div>
		
			<div class="form-element" style="width:300px;justify-content: center;">   
	    	  <input class="input" type="number" placeholder="키(cm)"  name="in_height"  style="margin:0; "value="${dto.in_height}"/><br /><br />
	   		</div>
	    
	  	
	   <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:120px; height:30px; width:120px;">     
	     체형 : <select name="in_style" id="renum" style="background-color:white; border-radius: 10px;">
	                  <option value="슬랜더"
	                     <c:if test="${dto.in_style=='슬랜더'}">selected</c:if>>슬랜더
	                     
	                  </option>
	                  <option value="보통"
	                     <c:if test="${dto.in_style=='보통'}">selected</c:if>>보통
	                  </option>
	                  
	                  <option value="근육질"
	                     <c:if test="${dto.in_style=='근육질'}">selected</c:if>>근육질
	                  </option>
	                  
	                  <option value="통통"
	                     <c:if test="${dto.in_style=='통통'}">selected</c:if>>통통
	                  </option>
	                  
	                  <option value="과체중"
	                     <c:if test="${dto.in_style=='과체중'}">selected</c:if>>과체중
	                  </option>
	         </select> <br/><br/></div>
	     
	     <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:150px;">     
	     학력 : <select name="in_edu" id="renum" style="background-color:white; border-radius: 10px;">  
	            <option value="중졸이하"
	                     <c:if test="${dto.in_edu=='중졸이하'}">selected</c:if>>중졸이하
	                </option>
	                <option value="고졸"
	                     <c:if test="${dto.in_edu=='고졸'}">selected</c:if>>고졸
	                </option>
	                <option value="대졸"
	                     <c:if test="${dto.in_edu=='대졸'}">selected</c:if>>대졸
	                </option>
	        
	              <option value="대학원이상"
	                     <c:if test="${dto.in_edu=='대학원이상'}">selected</c:if>>대학원이상
	                </option>              
	           </select> <br/><br/></div>
	           
	            <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	     		 display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:120px;">     
	     종교 : <select name="in_rlg" id="renum" style="background-color:white; border-radius: 10px;">       
	            <option value="천주교"
	                     <c:if test="${dto.in_rlg=='천주교'}">selected</c:if>>천주교
	                </option>
	                <option value="기독교"
	                     <c:if test="${dto.in_rlg=='기독교'}">selected</c:if>>기독교
	                </option>
	                <option value="불교"
	                     <c:if test="${dto.in_rlg=='불교'}">selected</c:if>>불교
	                </option>
	                <option value="힌두교"
	                     <c:if test="${dto.in_rlg=='힌두교'}">selected</c:if>>힌두교
	                </option>
	                <option value="이슬람"
	                     <c:if test="${dto.in_rlg=='이슬람'}">selected</c:if>>이슬람
	                </option>
	                <option value="무교"
	                     <c:if test="${dto.in_rlg=='무교'}">selected</c:if>>무교
	                </option>
	        </select> <br/><br/></div>
	    
	     <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:120px;">     
	     음주여부 : <select name="in_drunk" id="renum" style="background-color:white; border-radius: 10px;">             
	            <option value="유"
	                     <c:if test="${dto.in_drunk=='O'}">selected</c:if>>유
	                </option>
	            <option value="무"
	                     <c:if test="${dto.in_drunk=='X'}">selected</c:if>>무
	                </option>
	        </select> <br/><br/></div>
	    
	     
	     <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:120px;">     
	     흡연여부 : <select name="in_smoke" id="renum" style="background-color:white; border-radius: 10px;">                 
	            <option value="유"
	                     <c:if test="${dto.in_smoke=='O'}">selected</c:if>>유
	                </option>
	            <option value="무"
	                     <c:if test="${dto.in_smoke=='X'}">selected</c:if>>무
	                </option>
	        </select> <br/><br/></div>
	      
	      <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:120px;">     
	     성격 : <select name="in_char" id="renum" style="background-color:white; border-radius: 10px;">              
	            <option value="외향적"
	                     <c:if test="${dto.in_char=='외향적'}">selected</c:if>>외향적
	                </option>
	            <option value="내향적"
	                     <c:if test="${dto.in_char=='내향적'}">selected</c:if>>내향적
	                </option>
	        </select> <br/><br/></div>
	    
	     <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:115px;">     
	     MBTI : <select name="in_mbti" id="renum" style="background-color:white; border-radius: 10px;">               
	            <option value="ISTJ"
	                     <c:if test="${dto.in_mbti=='ISTJ'}">selected</c:if>>ISTJ
	                </option>
	                <option value="ISTP"
	                     <c:if test="${dto.in_mbti=='ISTP'}">selected</c:if>>ISTP
	                </option>
	                <option value="ISFJ"
	                     <c:if test="${dto.in_mbti=='ISFJ'}">selected</c:if>>ISFJ
	                </option>
	                <option value="ISFP"
	                     <c:if test="${dto.in_mbti=='ISFP'}">selected</c:if>>ISFP
	                </option>
	                <option value="INTJ"
	                     <c:if test="${dto.in_mbti=='INTJ'}">selected</c:if>>INTJ
	                </option>
	                <option value="INTP"
	                     <c:if test="${dto.in_mbti=='INTP'}">selected</c:if>>INTP
	                </option>
	                <option value="INFJ"
	                     <c:if test="${dto.in_mbti=='INFJ'}">selected</c:if>>INFJ
	                </option>
	                <option value="INFP"
	                     <c:if test="${dto.in_mbti=='INFP'}">selected</c:if>>INFP
	                </option>
	                <option value="ESTJ"
	                     <c:if test="${dto.in_mbti=='ESTJ'}">selected</c:if>>ESTJ
	                </option>
	                <option value="ESTP"
	                     <c:if test="${dto.in_mbti=='ESTP'}">selected</c:if>>ESTP
	                </option>
	                <option value="ESFJ"
	                     <c:if test="${dto.in_mbti=='ESFJ'}">selected</c:if>>ESFJ
	                </option>
	                <option value="ESFP"
	                     <c:if test="${dto.in_mbti=='ESFP'}">selected</c:if>>ESFP
	                </option>
	                <option value="ENTJ"
	                     <c:if test="${dto.in_mbti=='ENTJ'}">selected</c:if>>ENTJ
	                </option>
	                <option value="ENTP"
	                     <c:if test="${dto.in_mbti=='ENTP'}">selected</c:if>>ENTP
	                </option>
	                <option value="ENFJ"
	                     <c:if test="${dto.in_mbti=='ENFJ'}">selected</c:if>>ENFJ
	                </option>
	                <option value="ENFP"
	                     <c:if test="${dto.in_mbti=='ENFP'}">selected</c:if>>ENFP
	                </option>
	        </select> <br/><br/></div>
		
		<div class="form-element">
	    	<input  class="input" type="text" placeholder="취미"   name="in_hobby" value="${dto.in_hobby}" style= width:150px;/><br /><br />
	    </div>
	     
	     <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:135px;">     
	     직업 : <select name="in_job" id="renum" style="background-color:white; border-radius: 10px;">                  
	            <option value="회사원"
	                     <c:if test="${dto.in_job=='회사원'}">selected</c:if>>회사원
	                </option>
	                <option value="공무원"
	                     <c:if test="${dto.in_job=='공무원'}">selected</c:if>>공무원
	                </option>
	                <option value="프리랜서"
	                     <c:if test="${dto.in_job=='프리랜서'}">selected</c:if>>프리랜서
	                </option>
	                <option value="예체능"
	                     <c:if test="${dto.in_job=='예체능'}">selected</c:if>>예체능
	                </option>
	                <option value="군인"
	                     <c:if test="${dto.in_job=='군인'}">selected</c:if>>군인
	                </option>
	                <option value="교육"
	                     <c:if test="${dto.in_job=='교육'}">selected</c:if>>교육
	                </option>
	                <option value="의료"
	                     <c:if test="${dto.in_job=='의료'}">selected</c:if>>의료
	                </option>
	                <option value="금수저"
	                     <c:if test="${dto.in_job=='금수저'}">selected</c:if>>금수저
	                </option>
	                <option value="무직"
	                     <c:if test="${dto.in_job=='무직'}">selected</c:if>>무직
	                </option>
	                <option value="그외"
	                     <c:if test="${dto.in_job=='그외'}">selected</c:if>>그외
	                </option>
	        </select> <br/><br/></div>
	      
	       <div class="form-element" style="background-color:#ffeaea; border-radius: 10px; 
	      display: flex; width: 200px; justify-content: space-between; align-items: center; height:30px; width:155px;">     
	     반려동물 유무 : <select name="in_haspet" id="renum" style="background-color:white; border-radius: 10px;">               
	            <option value="유"
	                     <c:if test="${dto.in_haspet=='유'}">selected</c:if>>유
	                </option>
	            <option value="무"
	                     <c:if test="${dto.in_haspet=='무'}">selected</c:if>>무
	                </option>
	        </select> <br/><br/></div>
	      <br/>    
	      
	      <div class="form-element">   
	      	사진파일 : 
	        <input type="file" name="in_opic2" style="width:300px"/><img src="/ProjectMid/Storage/${dto.in_npic}"/><br/>
	      </div>
	      <div class="form-element">
	      	목소리파일 : 
	      	<input type="file" name="in_ovoice2" style="width:300px"/><audio controls autoplay loop><source src="/ProjectMid/Storage/${dto.in_nvoice}"/></audio>        
	      </div>
	      <div class="form-element">
	        <button type="submit" id="editbtn" onclick="$('#edit2').trigger('click');">수정하기</button>
			<button type="button" id="delete" onclick="location.href='../controller/SignOut.do?me_num=${dto.ME_NUM}';">회원탈퇴</button>
	      </div>     
		</div>
	</form>
	</div>      
	</div>   
	</div>
	

    <script type="text/javascript">
   //전화번호 총 변환
function autoHypenTel(str) {
        str = str.replace(/[^0-9]/g, '');
        var tmp = '';

        if (str.substring(0, 2) == 02) {
          // 서울 전화번호일 경우 10자리까지만 나타나고 그 이상의 자리수는 자동삭제
          if (str.length < 3) {
            return str;
          } else if (str.length < 6) {
            tmp += str.substr(0, 2);
            tmp += '-';
            tmp += str.substr(2);
            return tmp;
          } else if (str.length < 10) {
            tmp += str.substr(0, 2);
            tmp += '-';
            tmp += str.substr(2, 3);
            tmp += '-';
            tmp += str.substr(5);
            return tmp;
          } else {
            tmp += str.substr(0, 2);
            tmp += '-';
            tmp += str.substr(2, 4);
            tmp += '-';
            tmp += str.substr(6, 4);
            return tmp;
          }
        } else {
          // 핸드폰 및 다른 지역 전화번호 일 경우
          if (str.length < 4) {
            return str;
          } else if (str.length < 7) {
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3);
            return tmp;
          } else if (str.length < 11) {
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 3);
            tmp += '-';
            tmp += str.substr(6);
            return tmp;
          } else {
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 4);
            tmp += '-';
            tmp += str.substr(7);
            return tmp;
          }
        }

        return str;
      }
       $('#Mpv').keyup(function (event) {
          event = event || window.event;
          var _val = this.value.trim();
          this.value = autoHypenTel(_val);
        });



   function validateForm(form) { //   필수 항목 입력 확인
      
         if(form.ME_PHONE.value==""){
            alert("전화번호를 입력하지 않았습니다.");
            form.ME_PHONE.focus();
            return false;
         }
   
       if (form.email.value =="") {          
            alert("이메일을 입력하지 않았습니다.");
            form.ME_EMAIL.focus();
            return false;
         }
         if(form.ME_PASS.value==""){
            alert("비밀번호를 입력하지 않았습니다.");
            form.ME_PASS.focus();
            return false;
         }
         if(form.ME_PASS.value!= form.ME_PASS2.value){
            alert("비밀번호가 일치하지 않았습니다.");
            form.ME_PASS.focus();
            return false;
         }
         if(form.ME_PASS2.value==""){
            alert("비밀번호 재확인을 입력하지 않았습니다.");
            form.ME_PASS2.focus();
            return false;
         }
         if(form.ME_NAME.value==""){
            alert("이름을 입력하지 않았습니다.");
            form.ME_NAME.focus();
            return false;
         }
         if(form.ME_BIRTH.value==""){
            alert("생년원일을 입력하지 않았습니다.");
            form.ME_BIRTH.focus();
            return false;
         }
 
         if(form.ME_SEX.value==""){
            alert("성별을 입력하지 않았습니다.");
            form.ME_SEX.focus();
            return false;
         }
         if(form.ME_AGE.value==""){
            alert("나이를 입력하지 않았습니다.");
            form.ME_AGE.focus();
            return false;
         }
      //미성년자 체크
         if(form.ME_AGE.value<20){
            alert("미성년자입니다. 나이를 다시 체크 해주세요.")
            form.ME_AGE.focus();
            return false;
         }//오버 나이 체크
         if(form.ME_AGE.value>90){
            alert("나이를 다시 체크 해주세요.")
            form.ME_AGE.focus();
            return false;
         }      
      
         if(form.ME_KAKAO.value==""){
            alert("카카오 아이디를 입력하지 않았습니다.");
            form.ME_KAKAO.focus();
            return false;
         }
         if(form.RE_NUM.value==""){
            alert("지역번호를 입력하지 않았습니다.");
            form.RE_NUM.focus();
            return false;
      }         
        if (form.in_height.value == "") {          
            alert("키를 입력하지 않았습니다.");
            form.in_height.focus();
            return false;
         }
      if (form.in_style.value == "") {          
          alert("체형을 입력하지 않았습니다.");
          return false;
       }
         if(form.in_edu.value==""){
            alert("학력을 입력하지 않았습니다."); 
            return false;
         }

         if(form.in_rlg.value==""){
            alert("종교를 입력하지 않았습니다.");
            return false;
         }
         if(form.in_drunk.value==""){
            alert("음주여부를 입력하지 않았습니다.");  
            return false;
         }
         if(form.in_smoke.value==""){
            alert("흡연여부를 입력하지 않았습니다.");
            return false;
         }
         if(form.in_char.value==""){
            alert("성격을 입력하지 않았습니다.");
            return false;
         }
         if(form.in_mbti.value==""){
            alert("mbti를 입력하지 않았습니다.");
            return false;
         }
         if(form.in_hobby.value==""){
            alert("취미를 입력하지 않았습니다.");
            form.in_hobby.focus();
            return false;
         }
         if(form.in_job.value==""){
            alert("직업을 입력하지 않았습니다.");
            return false;
         }
         if(form.in_haspet.value==""){
            alert("반려동물 여부를 입력하지 않았습니다.");
            return false;
      }
         if(form.in_opic.value==""){
            alert("사진을 입력하지 않았습니다.");
            return false;
      }
         if(form.in_ovoice.value==""){
            alert("목소리를 입력하지 않았습니다.");
            return false;
      }

        //이메일 중복체크 + ajax
        if(form.emDuplication.value == "emUncheck"){
            alert("이메일 중복체크를 해주세요.");
            return false;
        }
        //카카오 아이디 중복체크 + ajax
        if(form.koDuplication.value == "kaUncheck"){
            alert("카카오 아이디 중복체크를 해주세요.");
            return false;
        }
        //생년월일 미성년자 체크
         if(2022-Number(form.ME_BIRTH.value.substr(0,4))<20){
            alert("미성년자 입니다. 생년월일을 다시 체크 해주세요.")
            return false;
         }
      //키 제한
         if(form.in_height.value>300){
            alert("키를 다시 입력 해주세요.")
            form.in_height.focus();
            return false;
         }//오버 키 제한
         if(form.in_height.value<100){
            alert("키를 다시 체크 해주세요.")
            form.in_height.focus();
            return false;
         }
   }        
</script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   
<script type ="text/javascript">
    $('#Mpb').click(function(){
           let userPh = $('#Mpv').val(); // input_id에 입력되는 값            
        $.ajax({
            url : "phCheck.jsp",
            type : "post",
            data : {userPh: userPh},
            dataType : 'json',
            success : function(result){
                if(result == 0){
                    $("#Mpf").html('사용할 수 없는 전화번호입니다.');
                    $("#Mpf").attr('color','#dc3545');
                    $("#btnConfirm").prop("disabled",true);
                } else{
                    $("#Mpf").html('사용할 수 있는 전화번호입니다.');
                    $("#Mpf").attr('color','#2fb380');
                    $("#phcheck").val('phcheck');
                    $("#btnConfirm").prop("disabled",false);
                } 
            },
            error : function(){
            alert("서버요청실패");
            }
        })             
    })             
</script>

<script type ="text/javascript">
        $('#emailchk').click(function(){
        let userEmail = $('#emailchkv').val(); // input_id에 입력되는 값            
           $.ajax({
              url : "emailCheck.jsp",
              type : "post",
              data : {userEmail: userEmail},
              dataType : 'json',
              success : function(result){
                 if(result == 0){
                          $("#emailft").html('사용할 수 없는 이메일입니다.');
                          $("#emailft").attr('color','#dc3545');
                          $("#btnConfirm").prop("disabled",true);
                          
                        } else{
                           $("#emailft").html('사용할 수 있는 이메일입니다.');
                           $("#emailft").attr('color','#2fb380');
                           $("#emcheck").val('emcheck');
                           $("#btnConfirm").prop("disabled",false);
                        } 
                 },
              error : function(){
                 alert("서버요청실패");
              }
           })             
        })             
</script>

<script type ="text/javascript">
        $('#kakaochk').click(function(){
        let userKakao = $('#kakaochkv').val(); // input_id에 입력되는 값            
           $.ajax({
              url : "kakaoCheck.jsp",
              type : "post",
              data : {userKakao: userKakao},
              dataType : 'json',
              success : function(result){
                 if(result == 0){
                          $("#kakaoft").html('사용할 수 없는 카카오ID입니다.');
                          $("#kakaoft").attr('color','#dc3545');
                          $("#btnConfirm").prop("disabled",true);
                       
                        } else{
                           $("#kakaoft").html('사용할 수 있는 카카오ID입니다.');
                           $("#kakaoft").attr('color','#2fb380'); 
                           $("#kacheck").val('kacheck');
                           $("#btnConfirm").prop("disabled",false);
                        } 
              },
              error : function(){
                 alert("서버요청실패");
              }
           })             
        })             
</script>
<script src = "js/jquery-3.6.0.min.js"></script>
<script>
   $('.pw').keyup(function(){
       let pw1 = $("#ME_PASS").val();
        let pw2 = $("#ME_PASS2").val();
        
        if (pw1 != "" || pw2 != ""){
           if (pw1 == pw2){
               $("#checkPw").html('비밀번호 일치');
               $("#checkPw").attr('color','green');
            } else {
               $("#checkPw").html('비밀번호 불일치');
                $("#checkPw").attr('color','red');
            }
        }     
   })
    
</script>
<jsp:include page="../common/Footer.jsp"/>
</body>
</html>