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
</head>
<body>

<jsp:include page="../common/Top.jsp"/>
<script type="text/javascript">
function validateForm(form) { //   필수 항목 입력 확인
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
}
</script>
<h1 align="center"> 회원정보 수정하기</h1>

<table>
	<tr>
		<td>
<form name="PReviseFrm" method="post" action="../controller/PRevise.do" 
	onsubmit = "return validateForm(this);" align="center" >
			
		핸드폰 번호 : <input type="tel" placeholder="핸드폰 번호" name="ME_PHONE" value="${dto.ME_PHONE}"  />		  	
      		<font size = "2" id = "Mpf" ></font>
      		<button type="submit" id="peditbtn">번호수정하기</button>
      		<br /><br />
		</form>
		
		<form name="EReviseFrm" method="post" action="../controller/ERevise.do"
	onsubmit = "return validateForm(this);" align="center">	
		이메일 : <input type="email" placeholder="이메일 주소"  name="ME_EMAIL" id="emailchkv" value="${dto.ME_EMAIL}" />
      		<button type="submit" id="eeditbtn" onclick="$('#peditbtn').trigger('click');" >이메일수정하기</button>
  		</form>
  		
  		<hr>
  		<hr>
  		
	<form name="ReviseFrm2" method="post" action="../controller/Revise.do" 
	onsubmit = "return validateForm(this);" align="center">	
		
		비밀번호 : <input type="password" placeholder="비밀번호"  name="ME_PASS" id="ME_PASS" class="pw" value="${dto.ME_PASS}"/><br/><br/>
		비밀번호 재확인 : <input type="password" placeholder="비밀번호"  name="ME_PASS2" id="ME_PASS2" class="pw" value="${dto.ME_PASS}"/>
			<font id = "checkPw" size = "2"></font><br /><br />
		이름 : <input type="text" placeholder="이름"  name="ME_NAME" value="${dto.ME_NAME}"/><br /><br />
		
		생년월일 : <input type="text" placeholder="생년월일" name="ME_BIRTH" value="${dto.ME_BIRTH}"/><br /><br />
		
		성별 :  <select name="ME_SEX">
                  <option value="남"
                     <c:if test="${dto.ME_SEX=='남'}">selected</c:if>>남
                  </option>
                  <option value="여"
                  <c:if test="${dto.ME_SEX=='여'}">selected</c:if>>여
                  </option>               
               </select>
               <br/><br/>
		나이 : <input type="number" placeholder="나이"  name="ME_AGE" value="${dto.ME_AGE}"/><br /><br />
		
		카카오톡 아이디 : <input type="text"  name="ME_KAKAO" value="${dto.ME_KAKAO}"/><br /><br />
		
		
		지역번호 : 		
		<select name="RE_NUM">
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
   	<button type="submit" id="edit2" onclick="$('#eeditbtn').trigger('click');">수정하기11</button>
   	</form>
        </td>
        
   	</tr>
   	
   	<tr>	
   		<td>
   		
   	<form name="ReviseFrm3" method="post" enctype="multipart/form-data" action="../controller/Revise2.do" 
	onsubmit="return validateForm(this);" align="center">	
	<input type="hidden" name="me_num" value="${dto.ME_NUM}"/>
	<input type="hidden" name="prevOpic" value="${dto.in_opic}"/>
	<input type="hidden" name="prevNpic" value="${dto.in_npic}"/>
	<input type="hidden" name="prevOvoice" value="${dto.in_ovoice}"/>
	<input type="hidden" name="prevNvoice" value="${dto.in_nvoice}"/>
	
		키 : <input type="number" placeholder="키"  name="in_height" value="${dto.in_height}"/>cm<br /><br />
         
		체형 : <select name="in_style">
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
         </select> <br/><br/>
		
		학력 : <select name="in_edu">                  
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
       	 </select> <br/><br/>
		
		종교 : <select name="in_rlg">                  
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
        </select> <br/><br/>
		
		음주여부 : <select name="in_drunk">                  
				<option value="유"
                     <c:if test="${dto.in_drunk=='O'}">selected</c:if>>유
                </option>
				<option value="무"
                     <c:if test="${dto.in_drunk=='X'}">selected</c:if>>무
                </option>
        </select> <br/><br/>
        
        흡연여부 : <select name="in_smoke">                  
				<option value="유"
                     <c:if test="${dto.in_smoke=='O'}">selected</c:if>>유
                </option>
				<option value="무"
                     <c:if test="${dto.in_smoke=='X'}">selected</c:if>>무
                </option>
        </select> <br/><br/>
		
		
		
        성격 : <select name="in_char">                  
				<option value="외향적"
                     <c:if test="${dto.in_char=='외향적'}">selected</c:if>>외향적
                </option>
				<option value="내향적"
                     <c:if test="${dto.in_char=='내향적'}">selected</c:if>>내향적
                </option>
        </select> <br/><br/>
        
		mbti : <select name="in_mbti">                  
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
        </select> <br/><br/>

		취미 : <input type="text"  name="in_hobby" value="${dto.in_hobby}"/><br /><br />
		
		직업 : <select name="in_job">                  
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
        </select> <br/><br/>
		
		반려동물 유무 : <select name="in_haspet">                  
				<option value="유"
                     <c:if test="${dto.in_haspet=='유'}">selected</c:if>>유
                </option>
				<option value="무"
                     <c:if test="${dto.in_haspet=='무'}">selected</c:if>>무
                </option>
                
        </select> <br/><br/>

		<br/>		 
		사진파일 : 
 	 	<input type="file" name="in_opic2"/><img src="/ProjectMid/Storage/${dto.in_npic}"><br/>
		목소리파일 : 
		<input type="file" name="in_ovoice2"/><audio controls autoplay loop><source src="/ProjectMid/Storage/${dto.in_nvoice}"/></audio>	  	
	  	
        <button type="submit" id="editbtn" onclick="$('#edit2').trigger('click');">수정하기</button>
           
</form>

			</td>
		</tr>
</table>

<button type="button" id="delete" onclick="location.href='../controller/SignOut.do?me_num=${dto.ME_NUM}';">회원탈퇴</button>
             
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