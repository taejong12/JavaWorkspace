/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-10-26 09:28:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.SignUp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SingUpWrite_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>자료실 게시판</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h2>회원가입</h2>\r\n");
      out.write("\r\n");
      out.write("	<form name=\"writeFrm\" method=\"post\" enctype=\"multipart/form-data\"\r\n");
      out.write("		action=\"../signUp/SingUpWrite.do\">\r\n");
      out.write("	\r\n");
      out.write("		아이디:<input type=\"text\" placeholder=\"아이디\"  name=\"ME_ID\"  /><br /><br />\r\n");
      out.write("				\r\n");
      out.write("		비밀번호:<input type=\"password\" placeholder=\"비밀번호\"  name=\"ME_PASS\" /><br /><br />\r\n");
      out.write("		\r\n");
      out.write("		이름:<input type=\"text\" placeholder=\"이름\"  name=\"ME_NAME\" /><br /><br />\r\n");
      out.write("		\r\n");
      out.write("		생년월일:<input type=\"text\" placeholder=\"생년월일\" name=\"ME_BIRTH\" /><br /><br />\r\n");
      out.write("		\r\n");
      out.write("		성별:<input type=\"radio\" placeholder=\"성별\"  name=\"ME_SEX\" checked/>남자		\r\n");
      out.write("		   <input type=\"radio\" placeholder=\"성별\"  name=\"ME_SEX\" />여자<br /><br />\r\n");
      out.write("		   \r\n");
      out.write("		나이:<input type=\"number\" placeholder=\"나이\"  name=\"ME_AGE\" /><br /><br />\r\n");
      out.write("		\r\n");
      out.write("		핸드폰 번호:<input type=\"tel\" placeholder=\"핸드폰 번호\"  name=\"ME_PHONE\"/><br /><br />\r\n");
      out.write("		\r\n");
      out.write("		이메일:<input type=\"email\" placeholder=\"이메일 주소\"  name=\"ME_EMAIL\"  /><br /><br />\r\n");
      out.write("		\r\n");
      out.write("		카카오ID:<input type=\"text\" placeholder=\"카카오ID\"  name=\"ME_KAKAO\" /><br /><br />\r\n");
      out.write("		\r\n");
      out.write("		<!-- 지역번호:<input type=\"number\" placeholder=\"지역번호\"  name=\"RE_NUM\" /><br /><br /> -->\r\n");
      out.write("		           \r\n");
      out.write("		<input type=\"submit\" value=\"회원가입\" id=\"signup\" />\r\n");
      out.write("		<button type=\"reset\">다시시작</button>							\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
