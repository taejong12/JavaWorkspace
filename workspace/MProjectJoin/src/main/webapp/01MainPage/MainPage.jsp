<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- 팝업 스타일 설정 -->
<style> 
#popup{
   position:absolute;top:100px;left:50px;
   color:yellow;width:270px;height:100px;background-color:gray;
   }
#popup>div{
   position:relative;background-color:white;top:0px;
   border: 1px solid gray; padding:10px;color:black; 
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
      <h2 align="center">환 영 합 니 다.</h2>
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


<section>
	<table border="1" width="100%">
		<tr align="center">
			<td>
				<p>회원현황 및 소개문구</p>
			</td>
		</tr>
		<tr align="center">
			<td>
				<p>후기 (평점 4.5 이상 후기 중 최신 순으로 3개 출력)</p>
			</td>
		</tr>
		<tr align="center">
			<td>
				<p>수상기록</p>
			</td>
		</tr>
	</table>
</section>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script>
	$(function() {
		$( "#popup" ).draggable();
	});
</script>
<jsp:include page="../common/Footer.jsp"/>
</body>
</html>