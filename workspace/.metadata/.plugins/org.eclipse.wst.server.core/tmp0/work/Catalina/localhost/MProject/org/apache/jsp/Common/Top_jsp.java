/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-11-06 10:43:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLEncoder;

public final class Top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.net.URLEncoder");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write(" <html>  \r\n");
      out.write("<head>\r\n");
      out.write("	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\r\n");
      out.write("		\r\n");
      out.write("	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script> 	    \r\n");
      out.write("		\r\n");
      out.write("		  \r\n");
      out.write("		\r\n");
      out.write("	<style>\r\n");
      out.write("		\r\n");
      out.write(" 	a{text-decoration: none;}\r\n");
      out.write("	\r\n");
      out.write("	#btn1,#btn2,#btn3,#btn4,#btn5 {\r\n");
      out.write("  		margin-top: 20px;\r\n");
      out.write("  	 	width: 140px;\r\n");
      out.write("  		height: 45px;\r\n");
      out.write("	  	font-family: 'Roboto', sans-serif;\r\n");
      out.write("	  	font-size: 11px;\r\n");
      out.write("	  	text-transform: uppercase;\r\n");
      out.write("	  	letter-spacing: 2.5px;\r\n");
      out.write("	  	font-weight: bold;\r\n");
      out.write("	  	color: black;\r\n");
      out.write("	  	background: linear-gradient(60deg,#FFB6C1,#FFC6C3);\r\n");
      out.write("	  	border: 1px #fff;\r\n");
      out.write("	  	border-radius: 45px;\r\n");
      out.write("	  	box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);\r\n");
      out.write("	  	transition: all 0.3s ease 0s;\r\n");
      out.write("	  	cursor: pointer;\r\n");
      out.write("	  	outline: none;\r\n");
      out.write("  	}\r\n");
      out.write("  	\r\n");
      out.write("	#btn1:hover, #btn2:hover, #btn3:hover, #btn4:hover, #btn5:hover {\r\n");
      out.write("	  	background: linear-gradient(60deg,#FF69B4,#D7567F);\r\n");
      out.write("	  	box-shadow: 0px 15px 20px rgba(246, 59, 167, 0.6);\r\n");
      out.write("	  	color: white;\r\n");
      out.write("	  	transform: translateY(-7px);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.gr { \r\n");
      out.write("		font-family: Helvetica Neue, Helvetica, Arial, sans-serif;\r\n");
      out.write("		font-size: larger;\r\n");
      out.write("		font-weight:  100;\r\n");
      out.write("		letter-spacing: 2px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		color: #f35626;\r\n");
      out.write("		background-image: -webkit-linear-gradient(92deg, #f35626, #feab3a);\r\n");
      out.write("		-webkit-background-clip: text;\r\n");
      out.write("		-webkit-text-fill-color: transparent;\r\n");
      out.write("		-webkit-animation: hue 5s infinite linear;\r\n");
      out.write("		position:relative; \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.gr:after {\r\n");
      out.write("		background: none;\r\n");
      out.write("	  	content: attr(data-text);\r\n");
      out.write("		left: 0;\r\n");
      out.write("		position: absolute;\r\n");
      out.write("		text-shadow: 2px 1px 3px pink;\r\n");
      out.write("		top: 0;\r\n");
      out.write("		z-index: -1;\r\n");
      out.write("		text-align:initial;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	@-webkit-keyframes hue {\r\n");
      out.write("	  from {\r\n");
      out.write("	    -webkit-filter: hue-rotate(0deg);\r\n");
      out.write("		}\r\n");
      out.write("	  to {\r\n");
      out.write("	    -webkit-filter: hue-rotate(-360deg);\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav {\r\n");
      out.write("		position: relative;\r\n");
      out.write("		top: 0;\r\n");
      out.write("		right: 0;\r\n");
      out.write("		left: 0;\r\n");
      out.write("		width: 60%;\r\n");
      out.write("		display: table;\r\n");
      out.write("		margin-top: 50px;\r\n");
      out.write("		transform: translateY(-50%);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a {\r\n");
      out.write("		position:relative;\r\n");
      out.write("		width: 20%;\r\n");
      out.write("		display: table-cell;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		color: gray;\r\n");
      out.write("		font-size:1.2em;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		font-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		padding: 10px 20px;\r\n");
      out.write("		transition: 0.2s ease color;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:before,\r\n");
      out.write("	#nav a:after {\r\n");
      out.write("	  content: \"\";\r\n");
      out.write("	  position: absolute;\r\n");
      out.write("	  border-radius: 50%;\r\n");
      out.write("	  transform: scale(0);\r\n");
      out.write("	  transition: 0.2s ease transform;\r\n");
      out.write("	  \r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:before {\r\n");
      out.write("	  top: 0;\r\n");
      out.write("	  left: 10px;\r\n");
      out.write("	  width: 6px;\r\n");
      out.write("	  height: 6px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:after {\r\n");
      out.write("	  top: 5px;\r\n");
      out.write("	  left: 18px;\r\n");
      out.write("	  width: 4px;\r\n");
      out.write("	  height: 4px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:nth-child(1):before {\r\n");
      out.write("	  background-color: yellow;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(1):after {\r\n");
      out.write("	  background-color: red;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(2):before {\r\n");
      out.write("	  background-color: #00e2ff;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:nth-child(2):after {\r\n");
      out.write("	  background-color: #89ff00;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(3):before {\r\n");
      out.write("	  background-color: skyblue;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(3):after {\r\n");
      out.write("	  background-color: blue;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:nth-child(4):before {\r\n");
      out.write("	  background-color: palevioletred;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(4):after {\r\n");
      out.write("	  background-color: palevioletred;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(5):before {\r\n");
      out.write("	  background-color: gray;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(5):after {\r\n");
      out.write("	  background-color: black;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	#indicator {\r\n");
      out.write("  		position: absolute;\r\n");
      out.write("  		left: 0;\r\n");
      out.write(" 		bottom: 0;\r\n");
      out.write("  		width: 20%;\r\n");
      out.write("  		height: 3px;\r\n");
      out.write("  		background-color: #fff;\r\n");
      out.write("  		border-radius: 5px;\r\n");
      out.write("  		transition: 0.2s ease left;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:hover {\r\n");
      out.write("		color: pink;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:hover:before,\r\n");
      out.write("	#nav a:hover:after {\r\n");
      out.write("	  transform: scale(1);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:nth-child(1):hover ~ #indicator {\r\n");
      out.write("	  background: linear-gradient(130deg, yellow, red);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:nth-child(2):hover ~ #indicator {\r\n");
      out.write("	  left: 20%;\r\n");
      out.write("	  background: linear-gradient(130deg, #00e2ff, #89ff00);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:nth-child(3):hover ~ #indicator {\r\n");
      out.write("	  left: 40%;\r\n");
      out.write("	  background: linear-gradient(130deg, skyblue, blue);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#nav a:nth-child(4):hover ~ #indicator {\r\n");
      out.write("	  left: 60%;\r\n");
      out.write("	  background: linear-gradient(130deg, purple, palevioletred);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#nav a:nth-child(5):hover ~ #indicator {\r\n");
      out.write("	  left: 80%;\r\n");
      out.write("	  background: linear-gradient(130deg, white, black);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#navback {\r\n");
      out.write("		background-color: Azure; \r\n");
      out.write("		overflow: hidden; \r\n");
      out.write("		z-index: -1; \r\n");
      out.write("		margin-top: 100px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	#nav #indicator:checked, #nav #indicator:active {\r\n");
      out.write("   		background: linear-gradient(130deg, yellow, red);\r\n");
      out.write("   	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" </style> \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("  \r\n");
      out.write("    <div class=\"container text-center\">\r\n");
      out.write("	  <div class=\"row\">\r\n");
      out.write("	    <div class=\"col\" style=\"padding-top: 70px;\"  align=\"center\">\r\n");
      out.write("	    	<!-- 로고 -->\r\n");
      out.write("	    	<a href=\"../reviewBoard/ReviewMainPage.do\"><img src=\"../Img/MProjectLogo.png\" alt=\"로고없음\" style=\"width: 200px; height: auto;\" /></a>\r\n");
      out.write("	    </div>\r\n");
      out.write("	    \r\n");
      out.write("	    <div class=\"col\" style=\"padding-top: 100px; padding-bottom: 50px;\">\r\n");
      out.write("	    	<h1>\r\n");
      out.write("	    		<a href=\"../reviewBoard/ReviewMainPage.do\" class=\"gr\" data-text=\"PreciousQualityTime\">PreciousQualityTime</a>\r\n");
      out.write("	    	</h1>\r\n");
      out.write("	    </div>\r\n");
      out.write("	    \r\n");
      out.write("	    <div class=\"col\" style=\"padding-top: 50px;\"  >\r\n");
      out.write("	    	");

			if(session.getAttribute("me_id") != null){
			
      out.write("\r\n");
      out.write("				<div style=\"font-family: 'Roboto', sans-serif; font-weight: bold;\">\r\n");
      out.write("					");
      out.print( session.getAttribute("me_name") );
      out.write(" 회원님\r\n");
      out.write("				</div>\r\n");
      out.write("				\r\n");
      out.write("				<div align=\"center\">\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-danger\" id=\"btn3\" onclick=\"location.href='../Loginout/Logout.do';\">로그아웃</button>\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-danger\" id=\"btn5\" onclick=\"location.href='../MainPage/MyPage.jsp';\">내정보페이지</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			");

			} else {
			
      out.write("\r\n");
      out.write("				<div align=\"center\">\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-outline-danger\" id=\"btn1\" onclick=\"location.href='../02Login/LoginForm.jsp';\">로그인</button>\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-danger\" id=\"btn2\" onclick=\"location.href='../01Join/Join.jsp';\">회원가입</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			");

			}
			
      out.write("\r\n");
      out.write("	    </div>\r\n");
      out.write("	  </div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div id=\"navback\" align=\"center\">\r\n");
      out.write("	    <div id=\"nav\">\r\n");
      out.write("	        <a href=\"../InfoBoard/InfoPage.jsp\">소개</a>\r\n");
      out.write("	        <a href=\"../InfoBoard/InfoPage.jsp\">가이드</a>\r\n");
      out.write("	        <a href=\"../matching/main.do\">매칭</a>\r\n");
      out.write("	        <a href=\"../reviewBoard/reviewList.do\">게시판</a>\r\n");
      out.write("	        <a href=\"../qnasBoard/qnasList.do\">1:1문의</a>      \r\n");
      out.write("	    	<div id=\"indicator\"></div>\r\n");
      out.write("	    </div>\r\n");
      out.write("	</div>\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("  </header>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.6.1.min.js\" integrity=\"sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("	\r\n");
      out.write("		var div2 = document.getElementsByClassName(\"div2\");\r\n");
      out.write("\r\n");
      out.write("      	function handleClick(event) {\r\n");
      out.write("	        console.log(event.target);\r\n");
      out.write("	        // console.log(this);\r\n");
      out.write("	        // 콘솔창을 보면 둘다 동일한 값이 나온다\r\n");
      out.write("	\r\n");
      out.write("	        console.log(event.target.classList);\r\n");
      out.write("	\r\n");
      out.write("	        if (event.target.classList[1] === \"clicked\") {\r\n");
      out.write("	        	event.target.classList.remove(\"clicked\");\r\n");
      out.write("	        } else {\r\n");
      out.write("	        	for (var i = 0; i < div2.length; i++) {\r\n");
      out.write("	            	div2[i].classList.remove(\"clicked\");\r\n");
      out.write("	          	}\r\n");
      out.write("	\r\n");
      out.write("	          	event.target.classList.add(\"clicked\");\r\n");
      out.write("	        }\r\n");
      out.write("   		}\r\n");
      out.write("\r\n");
      out.write("      	function init() {\r\n");
      out.write("        	for (var i = 0; i < div2.length; i++) {\r\n");
      out.write("          		div2[i].addEventListener(\"click\", handleClick);\r\n");
      out.write("        	}\r\n");
      out.write("      	}\r\n");
      out.write("\r\n");
      out.write("      init();\r\n");
      out.write("      \r\n");
      out.write("	</script>\r\n");
      out.write("	\r\n");
      out.write("	<script type =\"text/javascript\">\r\n");
      out.write("     	$('#Logout').click(function(){\r\n");
      out.write("    	  	let userId = $('#Idchecks').val(); // input_id에 입력되는 값            \r\n");
      out.write("            $.ajax({\r\n");
      out.write("               	url : \"MainPage.jsp\",\r\n");
      out.write("               	type : \"post\",\r\n");
      out.write("               	data : {userId: userId},\r\n");
      out.write("               	dataType : 'json',\r\n");
      out.write("               	success : function(result){\r\n");
      out.write("                 	if(result == 0){\r\n");
      out.write("                      	$(\"#checkId\").html('사용할 수 없는 아이디입니다.');\r\n");
      out.write("                      	$(\"#checkId\").attr('color','#dc3545');\r\n");
      out.write("                   	} else{\r\n");
      out.write("                      	$(\"#checkId\").html('사용할 수 있는 아이디입니다.');\r\n");
      out.write("                      	$(\"#checkId\").attr('color','#2fb380');\r\n");
      out.write("                   	} \r\n");
      out.write("               	},\r\n");
      out.write("               	error : function(){\r\n");
      out.write("                  	alert(\"서버요청실패\");\r\n");
      out.write("               }\r\n");
      out.write("            });             \r\n");
      out.write("        });\r\n");
      out.write("	</script>\r\n");
      out.write("	\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
