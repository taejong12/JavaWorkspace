/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-10-30 08:33:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class carouse1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("nav .navbar-nav a.nav-link {\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	color: #2c3e50 !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav .navbar-nav  a.nav-link.active {\r\n");
      out.write("	color: #42b983 !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*carousel ????????????*/\r\n");
      out.write(".carousel-item {\r\n");
      out.write("	min-height: 800px;\r\n");
      out.write("	max-height: 800px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#image1 {\r\n");
      out.write("	background-image: url('resources/img/camp.jpg');\r\n");
      out.write("	background-repeat: no-repeat;\r\n");
      out.write("	background-size: cover;\r\n");
      out.write("	background-position: center center;\r\n");
      out.write("}\r\n");
      out.write("#image2 {\r\n");
      out.write("	background-image: url('resources/img/60jpg.jpg');\r\n");
      out.write("	background-repeat: no-repeat;\r\n");
      out.write("	background-size: cover;\r\n");
      out.write("	background-position: center center;\r\n");
      out.write("}\r\n");
      out.write("#image3 {\r\n");
      out.write("	background-image: url('resources/img/qwert.jpg');\r\n");
      out.write("	background-repeat: no-repeat;\r\n");
      out.write("	background-size: cover;\r\n");
      out.write("	background-position: center center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<section id=\"carousel\">\r\n");
      out.write("	<!-- Carousel -->\r\n");
      out.write("		<div id=\"carouselExampleDark\" class=\"carousel carousel-dark slide\"\r\n");
      out.write("			data-bs-ride=\"carousel\">\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"carousel-indicators\">\r\n");
      out.write("			<button type=\"button\" data-bs-target=\"#carouselExampleDark\"\r\n");
      out.write("				data-bs-slide-to=\"0\" class=\"active\" aria-current=\"true\"\r\n");
      out.write("				aria-label=\"Slide 1\"></button>\r\n");
      out.write("				\r\n");
      out.write("			<button type=\"button\" data-bs-target=\"#carouselExampleDark2\"\r\n");
      out.write("				data-bs-slide-to=\"1\" class=\"active\" aria-current=\"true\"\r\n");
      out.write("				aria-label=\"Slide 2\"></button>\r\n");
      out.write("				\r\n");
      out.write("			<button type=\"button\" data-bs-target=\"#carouselExampleDark\"\r\n");
      out.write("				data-bs-slide-to=\"2\" aria-label=\"Slide 3\"></button>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"carousel-inner\">\r\n");
      out.write("			<div class=\"carousel-item active\" data-bs-interval=\"10000\" id=\"image1\">\r\n");
      out.write("				<img src=\"\" class=\"d-block w-100\" alt=\"\">\r\n");
      out.write("				<div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"carousel-item\" data-bs-interval=\"2000\" id=\"image2\">\r\n");
      out.write("				<img src=\"\" class=\"d-block w-100\" alt=\"\">\r\n");
      out.write("				<div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"carousel-item\" id=\"image3\">\r\n");
      out.write("				<img src=\"\" class=\"d-block w-100\" alt=\"\">\r\n");
      out.write("				<div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<button class=\"carousel-control-prev\" type=\"button\"\r\n");
      out.write("			data-bs-target=\"#carouselExampleDark\" data-bs-slide=\"prev\">\r\n");
      out.write("			<span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span> <span\r\n");
      out.write("				class=\"visually-hidden\">Previous</span>\r\n");
      out.write("		</button>\r\n");
      out.write("		<button class=\"carousel-control-next\" type=\"button\"\r\n");
      out.write("			data-bs-target=\"#carouselExampleDark\" data-bs-slide=\"next\">\r\n");
      out.write("			<span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span> <span\r\n");
      out.write("				class=\"visually-hidden\">Next</span>\r\n");
      out.write("		</button>\r\n");
      out.write("	</div>\r\n");
      out.write("</section>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
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
