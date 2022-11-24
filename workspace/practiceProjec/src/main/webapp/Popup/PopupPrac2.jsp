<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		
		function openPop(){
		     if(getCookie("cookiename")!="cookievalue"){
		        window.open('PopupPracP.jsp','안내','left=550, top=5, width=442, height=420, status=no, scrollbars=no, resizeable=no');
		     }    
		}
		
		function getCookie(name){
		    var nameOfCookie = name + "=";
		    var x =0;
		    while (x<=document.cookie.length){
		        var y = (x+nameOfCookie.length);
		        if(document.cookie.substring(x,y) == nameOfCookie){
		            if((endOfCookie=document.cookie.indexOf(";",y))==-1)
		                endOfCookie = document.cookie.length;
		            return unescape(document.cookie.substring(y, endOfCookie));
		            }
		            x=document.cookie.indexOf(" ",x) +1;
		            if(x==0)
		            break;
		            }
		        return "";
		}
	</script>
</head>
<body onLoad="openPop()">
	
</body>
</html>