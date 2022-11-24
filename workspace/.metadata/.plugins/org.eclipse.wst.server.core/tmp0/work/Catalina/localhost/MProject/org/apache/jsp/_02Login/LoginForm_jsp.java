/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-11-03 07:36:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._02Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cookie.ManageCookie;

public final class LoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("cookie.ManageCookie");
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
      out.write("    \r\n");

	String loginId = ManageCookie.readCookie(request, "loginId");
	
	String cookieCheck = "";
	if (!loginId.equals("")) {
	   cookieCheck = "checked";
	}
	
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Log In</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script> \r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("  font-family:\"Raleway\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form {\r\n");
      out.write("  position:relative;\r\n");
      out.write("  top:0;\r\n");
      out.write("  left:0;\r\n");
      out.write("  margin-top:56px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".form .form-header {\r\n");
      out.write("  height:30px;\r\n");
      out.write("  display:flex;\r\n");
      out.write("  align-items:center;\r\n");
      out.write("  text-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form .form-header .show-signup {\r\n");
      out.write("  width:calc(100%);\r\n");
      out.write("  color:#f1575b;\r\n");
      out.write("  font-size:20px;\r\n");
      out.write("  font-weight:700;\r\n");
      out.write("  cursor: default;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".form .form-elements {\r\n");
      out.write("  margin-top:15px;\r\n");
      out.write("  width:650px;\r\n");
      out.write("  margin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".form .form-elements input {\r\n");
      out.write("  font-size:14px;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  height: 30px;\r\n");
      out.write("  margin-top: 5px;\r\n");
      out.write("  margin:0 auto;\r\n");
      out.write("  padding : 2px 10px;\r\n");
      out.write("  border-radius:10px;\r\n");
      out.write("  box-sizing:border-box;\r\n");
      out.write("  border:none;\r\n");
      out.write("  background:#ffeaea;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#idchk, #Mpb, #emailchk, #kakaochk {\r\n");
      out.write("	line-height:30px;\r\n");
      out.write("	margin-left:590px;\r\n");
      out.write("	margin-top:5px;\r\n");
      out.write("	padding:0;\r\n");
      out.write("	width : 60px;\r\n");
      out.write("	font-size:12px;\r\n");
      out.write("	border-radius: 5px;\r\n");
      out.write("}\r\n");
      out.write(".form .form-elements button {\r\n");
      out.write("  \r\n");
      out.write("  font-size:14px;\r\n");
      out.write("  font-weight:600;\r\n");
      out.write("  border-radius:10px;\r\n");
      out.write("  background:#f1575b;\r\n");
      out.write("  color:#f5f5f5;\r\n");
      out.write("  cursor:pointer;\r\n");
      out.write("  border:none;\r\n");
      out.write("  outline:none;\r\n");
      out.write("}\r\n");
      out.write(".form-element {\r\n");
      out.write("	margin-top:10px;\r\n");
      out.write("}\r\n");
      out.write(".form-check-inline {\r\n");
      out.write("	margin-top:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#chkbox {\r\n");
      out.write("	display:inline-block;\r\n");
      out.write("	width:15px;\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write(".cb {\r\n");
      out.write("	text-align: right;\r\n");
      out.write("	vertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write(".chk-text {\r\n");
      out.write("	margin :0;\r\n");
      out.write("	padding : 0;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Common/Top.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <span style=\"color:red; font-size: 1.2em;\">\r\n");
      out.write("      ");
      out.print( request.getAttribute("LoginErrMsg")== null? "":request.getAttribute("LoginErrMsg") );
      out.write("\r\n");
      out.write("   </span>\r\n");
      out.write("   ");

   if(session.getAttribute("me_id")==null){ //로그인 상태 확인
      //로그아웃 상태
   
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   <script>\r\n");
      out.write("   function validateForm(form) {\r\n");
      out.write("       	if(!form.mem_id.value){\r\n");
      out.write("	        alert(\"아이디를 입력하세요.\");\r\n");
      out.write("	        return false;\r\n");
      out.write("       	}\r\n");
      out.write("       \r\n");
      out.write("      	if(form.mem_password.value==\"\"){\r\n");
      out.write("          	alert(\"패스워드를 입력하세요.\");\r\n");
      out.write("          	return false;\r\n");
      out.write("       	}\r\n");
      out.write("    \r\n");
      out.write("    }\r\n");
      out.write("   </script>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("	<div class=\"form signup\" class=\"p-3 mb-2 bg-secondary text-white\">\r\n");
      out.write("		<div class=\"form-header\">\r\n");
      out.write("	    	<h1 class=\"show-signup\">Sign in</h1>\r\n");
      out.write("	  	</div>\r\n");
      out.write("	  	\r\n");
      out.write("		<form action=\"../Loginout/Login.do\" method=\"post\" name=\"LoginFrm\" \r\n");
      out.write("			onsubmit=\"return validateForm(this);\" >\r\n");
      out.write("			<div class=\"form-elements\" align=\"center\" >\r\n");
      out.write("				<div class=\"form-element\" style=\"position: relative;\">\r\n");
      out.write("					<input type=\"text\" name=\"me_id\" placeholder=\"ID 입력\" id=\"Idchecks\" value=\"");
      out.print( loginId );
      out.write("\" />\r\n");
      out.write("					<div class=\"cb\">\r\n");
      out.write("						<input id=\"chkbox\" type=\"checkbox\" name=\"save_check\" value=\"Y\" style=\"height:15px;\" ");
      out.print( cookieCheck );
      out.write(" />\r\n");
      out.write("				 		<p class=\"chk-text\">아이디 저장</p>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"form-element\">\r\n");
      out.write("					<div>\r\n");
      out.write("						<input type=\"password\" name=\"me_pass\" placeholder=\"8자 이상 입력(문자/숫자/기호 사용 가능)\"/>\r\n");
      out.write("					</div>\r\n");
      out.write("				\r\n");
      out.write("					<button type=\"submit\" id=\"signup\" style=\"margin-top:10px;\">로그인</button>\r\n");
      out.write("					<button type=\"button\" id=\"join\" value=\"회원가입\" onclick=\"location.href='../01Join/Join.jsp'\">회원가입</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("   ");

   }
   
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Common/Footer.jsp", out, false);
      out.write("   \r\n");
      out.write("</body>\r\n");
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
