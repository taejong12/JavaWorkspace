/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-11-03 02:22:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NewFile1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write(" <html>  \r\n");
      out.write("<head>\r\n");
      out.write("	<link href=\"https://fonts.googleapis.com/css2?family=Poppins&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("	\r\n");
      out.write("		<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\r\n");
      out.write("		\r\n");
      out.write("		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script> 	    \r\n");
      out.write("		\r\n");
      out.write("		<script type =\"text/javascript\">\r\n");
      out.write("		    $('#Logout').click(function(){\r\n");
      out.write("		    	let userId = $('#Idchecks').val(); // input_id에 입력되는 값            \r\n");
      out.write("	            $.ajax({\r\n");
      out.write("	               	url : \"MainPage.jsp\",\r\n");
      out.write("	               	type : \"post\",\r\n");
      out.write("	               	data : {userId: userId},\r\n");
      out.write("	               	dataType : 'json',\r\n");
      out.write("	               	success : function(result){\r\n");
      out.write("	                  	if(result == 0){\r\n");
      out.write("	                           $(\"#checkId\").html('사용할 수 없는 아이디입니다.');\r\n");
      out.write("	                           $(\"#checkId\").attr('color','#dc3545');\r\n");
      out.write("	                        } else{\r\n");
      out.write("	                           $(\"#checkId\").html('사용할 수 있는 아이디입니다.');\r\n");
      out.write("	                           $(\"#checkId\").attr('color','#2fb380');\r\n");
      out.write("	                        }\r\n");
      out.write("	               	},\r\n");
      out.write("	               	error : function(){\r\n");
      out.write("	                  alert(\"서버요청실패\");\r\n");
      out.write("	               	}\r\n");
      out.write("          		});          \r\n");
      out.write("		    });\r\n");
      out.write("		</script> \r\n");
      out.write("		    \r\n");
      out.write("		   \r\n");
      out.write("		\r\n");
      out.write("	<style>\r\n");
      out.write("		\r\n");
      out.write(" 	a{text-decoration: none;}\r\n");
      out.write("	\r\n");
      out.write("	.gr {\r\n");
      out.write("		font-family: Helvetica Neue, Helvetica, Arial, sans-serif;\r\n");
      out.write("		font-size: 3em;\r\n");
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
      out.write("\r\n");
      out.write("	*{\r\n");
      out.write("		margin: 0px;\r\n");
      out.write("		padding: 0px;\r\n");
      out.write("		box-sizing: border-box;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	nav {\r\n");
      out.write("		display: flex;\r\n");
      out.write("		justify-content: space-around;\r\n");
      out.write("		align-items: center;\r\n");
      out.write("		min-height: 8vh;\r\n");
      out.write("		font-family: 'Poppins', sans-serif;\r\n");
      out.write("		background: aqua;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav-links {\r\n");
      out.write("		width: 40%;\r\n");
      out.write("		display: flex;\r\n");
      out.write("		justify-content: space-around;\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.nav-links li {\r\n");
      out.write("		width: 25%;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		font-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		list-style: none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav-links a {\r\n");
      out.write("		color: gray;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		letter-spacing: 3px;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		font-size:1.2em;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.burger {\r\n");
      out.write("		display: none;\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.burger div{\r\n");
      out.write("		width: 25px;\r\n");
      out.write("		height: 3px;\r\n");
      out.write("		background-color: #f35626;\r\n");
      out.write("		margin: 5px;\r\n");
      out.write("		transition: all 0.3s ease; \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	@media screen and (max-width:1024px) {\r\n");
      out.write("		.nav-links {\r\n");
      out.write("			width: 60%;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		.row{\r\n");
      out.write("			width: 100%;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	@media screen and (max-width:768px) {\r\n");
      out.write("	\r\n");
      out.write("		body {\r\n");
      out.write("			overflow-x: hidden;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		.row{\r\n");
      out.write("			width: 100%;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		#title{\r\n");
      out.write("			display: none;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		.nav-links {\r\n");
      out.write("			position: absolute;\r\n");
      out.write("			top: 51vh;\r\n");
      out.write("			right: 0;\r\n");
      out.write("			height: 90vh;\r\n");
      out.write("			background: red;\r\n");
      out.write("			flex-direction: column;\r\n");
      out.write("			align-items: center;\r\n");
      out.write("			width: 50%;\r\n");
      out.write("			transform: translateX(100%);\r\n");
      out.write("			transition: transform 0.3s ease-in;\r\n");
      out.write("		} \r\n");
      out.write("		\r\n");
      out.write("		.nav-links li {\r\n");
      out.write("			opacity: 0;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		.burger{\r\n");
      out.write("			display: block;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav-active{\r\n");
      out.write("		transform: translateX(0%);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	@keyframes navLinkFade {\r\n");
      out.write("		from {\r\n");
      out.write("			opacity:0;\r\n");
      out.write("			transform: translateX(50px);\r\n");
      out.write("		}\r\n");
      out.write("		to {\r\n");
      out.write("			opacity:1;\r\n");
      out.write("			transform: translateX(0);\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.toggle. line1{\r\n");
      out.write("		transform: rotate(-45deg) translate(-5px, 6px);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.toggle. line2{\r\n");
      out.write("		opacity: 0;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.toggle. line3{\r\n");
      out.write("		transform: rotate(45deg) translate(-5px, -6px);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write(" </style> \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("	  <div class=\"row\" style=\"width: 100%;\">\r\n");
      out.write("	    <div class=\"col\" style=\"padding-top: 70px;\">\r\n");
      out.write("	    	<!-- 로고 -->\r\n");
      out.write("	    	<a href=\"../reviewBoard/ReviewMainPage.do\"><img src=\"../Img/MProjectLogo.png\" alt=\"로고없음\" style=\"width: 200px; height: auto;\" /></a>\r\n");
      out.write("	    </div>\r\n");
      out.write("	    \r\n");
      out.write("	    <div id=\"title\" class=\"col\" style=\"padding-top: 100px; padding-bottom: 50px; \">\r\n");
      out.write("	    	\r\n");
      out.write("	    		<a href=\"../reviewBoard/ReviewMainPage.do\" class=\"gr\" data-text=\"PreciousQualityTime\">PreciousQualityTime</a>\r\n");
      out.write("	    \r\n");
      out.write("	    </div>\r\n");
      out.write("	    \r\n");
      out.write("	    <div id=\"loginButton\" class=\"col\" style=\"padding-top: 100px;\">\r\n");
      out.write("	    	");

			if(session.getAttribute("me_id") != null){
			
      out.write("\r\n");
      out.write("			");
      out.print( session.getAttribute("me_name") );
      out.write(" 회원님\r\n");
      out.write("				<div style=\"float: right;\">\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-danger\" onclick=\"location.href='../Loginout/Logout.do';\">로그아웃</button>\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-danger\" onclick=\"location.href='../MainPage/MyPage.jsp';\">회원정보수정</button>\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-danger\" onclick=\"location.href='../MainPage/MyPage.jsp';\">내정보페이지</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			");

			} else {
			
      out.write("\r\n");
      out.write("				<div class=\"text-end\">\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-outline-danger\" onclick=\"location.href='../02Login/LoginForm.jsp';\">로그인</button>\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-danger\" onclick=\"location.href='../01Join/Join.jsp';\">회원가입</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			");

			}
			
      out.write("\r\n");
      out.write("	    </div>\r\n");
      out.write("	  </div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<!-- 네비게이션바 -->\r\n");
      out.write("	<nav>\r\n");
      out.write("	    <ul class=\"nav-links\">\r\n");
      out.write("	        <li><a href=\"../MainPage/SiteInfo.jsp\">소개</a></li>\r\n");
      out.write("	        <li><a href=\"#\">매칭</a></li>\r\n");
      out.write("	        <li><a href=\"../reviewBoard/reviewList.do\">게시판</a></li>\r\n");
      out.write("	        <li><a href=\"../qnasBoard/qnasList.do\">1:1문의</a></li>   \r\n");
      out.write("	    </ul>   \r\n");
      out.write("	    <div class=\"burger\">\r\n");
      out.write("	    	<div class=\"line1\"></div>\r\n");
      out.write("	    	<div class=\"line2\"></div>\r\n");
      out.write("	    	<div class=\"line3\"></div>\r\n");
      out.write("	    </div>\r\n");
      out.write("	</nav>\r\n");
      out.write("	\r\n");
      out.write("  \r\n");
      out.write("  </header>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("	const navSlide = () => {\r\n");
      out.write("		const burger = document.querySelector(\".burger\");\r\n");
      out.write("		const nav = document.querySelector(\".nav-links\");\r\n");
      out.write("		const navLinks = document.querySelectorAll(\".nav-links li\");\r\n");
      out.write("	\r\n");
      out.write("		burger.addEventListener('click', () => {\r\n");
      out.write("			//Toggle Nav\r\n");
      out.write("			nav.classList.toggle('nav-active');\r\n");
      out.write("			\r\n");
      out.write("			//Animate Links\r\n");
      out.write("			navLinks.forEach((link, index) => {\r\n");
      out.write("				if (link.style.animation) {\r\n");
      out.write("					link.style.animation ='';\r\n");
      out.write("				} else {\r\n");
      out.write("					link.style.animation = 'navLinkFade 0.5s ease forwards ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${index / 7 + 0.3}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("s';\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			//Buger Animation\r\n");
      out.write("			burger.classList.toggle('toggle');\r\n");
      out.write("			\r\n");
      out.write("		});\r\n");
      out.write("	\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	navSlide();\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
      out.write("   \r\n");
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