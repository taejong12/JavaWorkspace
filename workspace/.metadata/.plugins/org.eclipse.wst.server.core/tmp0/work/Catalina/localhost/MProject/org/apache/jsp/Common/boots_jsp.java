/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-10-31 01:17:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boots_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>Bootstrap demo</title>\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\r\n");
      out.write(" <style>\r\n");
      out.write(" 	a{text-decoration: none;}\r\n");
      out.write("	\r\n");
      out.write("	.gr{ background: linear-gradient(to right, #FF69B4, #FF9BE6, #FFB4FF);\r\n");
      out.write("\r\n");
      out.write("		 -webkit-background-clip: text;\r\n");
      out.write("		\r\n");
      out.write("		 -webkit-text-fill-color: transparent;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write(" </style>\r\n");
      out.write(" \r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <header>\r\n");
      out.write("  \r\n");
      out.write("    <div class=\"container text-center\">\r\n");
      out.write("	  <div class=\"row\">\r\n");
      out.write("	    <div class=\"col\" style=\"padding-top: 70px;\">\r\n");
      out.write("	    	<!-- 로고 -->\r\n");
      out.write("	    	<a href=\"../reviewBoard/ReviewMainPage.do\"><img src=\"https://lovelinelove.com/wp-content/uploads/2021/03/%EB%A1%9C%EA%B3%A01-e1616575767720.png\" style=\"width: 150px;height: auto;\"/></a>\r\n");
      out.write("	    </div>\r\n");
      out.write("	    \r\n");
      out.write("	    <div class=\"col\" style=\"padding-top: 100px; padding-bottom: 50px;\">\r\n");
      out.write("	    	<h1><a href=\"../reviewBoard/ReviewMainPage.do\" style=\"font-size: 1.5em;\" class=\"gr\">Perfect Quality</a></h1>\r\n");
      out.write("	    </div>\r\n");
      out.write("	    \r\n");
      out.write("	    <div class=\"col\" style=\"padding-top: 50px;\">\r\n");
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
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("  </header>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"container\" style=\"margin-top: 50px;\">\r\n");
      out.write("      \r\n");
      out.write("        <ul id=\"nav2\" class=\"nav justify-content-center bg-light\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link link-pink\" href=\"../MainPage/SiteInfo.jsp\">소개</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">매칭</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"../reviewBoard/reviewList.do\">게시판</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"../qnasBoard/qnasList.do\">1:1문의</a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("   \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <div style=\"text-align: center; margin-top: 100px; margin-bottom: 100px;\" >회원현황 및 소개문구</div>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"container text-center\" style=\" margin-top: 100px; margin-bottom: 100px;\">\r\n");
      out.write("    	<div class=\"row\">\r\n");
      out.write("    		<div class=\"col\">\r\n");
      out.write("    			<div class=\"card\" style=\"width: 18rem;\">\r\n");
      out.write("				  <img src=\"...\" class=\"card-img-top\" alt=\"...\">\r\n");
      out.write("				  <div class=\"card-body\">\r\n");
      out.write("				    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\r\n");
      out.write("				  </div>\r\n");
      out.write("				</div>\r\n");
      out.write("    		</div>\r\n");
      out.write("    		\r\n");
      out.write("    		<div class=\"col\">\r\n");
      out.write("    			<div class=\"card\" style=\"width: 18rem;\">\r\n");
      out.write("				  <img src=\"...\" class=\"card-img-top\" alt=\"...\">\r\n");
      out.write("				  <div class=\"card-body\">\r\n");
      out.write("				    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\r\n");
      out.write("				  </div>\r\n");
      out.write("				</div>\r\n");
      out.write("    		</div>\r\n");
      out.write("    		\r\n");
      out.write("    		<div class=\"col\">\r\n");
      out.write("    			<div class=\"card\" style=\"width: 18rem;\">\r\n");
      out.write("				  <img src=\"\" class=\"card-img-top\" alt=\"...\">\r\n");
      out.write("				  <div class=\"card-body\">\r\n");
      out.write("				    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\r\n");
      out.write("				  </div>\r\n");
      out.write("				</div>\r\n");
      out.write("    		</div>\r\n");
      out.write("    	</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"container\"style=\"text-align: center; margin-top: 100px; margin-bottom: 100px; border: 1px solid rgba(0, 0, 0, 0.1);\" >\r\n");
      out.write("    	<div class=\"row\" style=\"margin: 30px;\">\r\n");
      out.write("    		<div class=\"col\">\r\n");
      out.write("		    	<img alt=\"\" src=\"https://assets.website-files.com/61d28aad499f21ae92aa33ed/61e4d89641c3e5b3bc63a8ee_Main-Intro-Background.png\" style=\"width:200px; height: auto;\">\r\n");
      out.write("		    	<p style=\"margin-top: 30px;\">2022 한국 브랜드 <br/>리더 대상</p>\r\n");
      out.write("    		</div>\r\n");
      out.write("    		<div class=\"col\" style=\"margin-top: 40px\">\r\n");
      out.write("		    	<img alt=\"\" src=\"https://dimg.donga.com/ugc/CDB/WOMAN/Article/63/05/8c/72/63058c721c87d2738250.jpg\" style=\"width:200px; height: auto;\">\r\n");
      out.write("    			<p style=\"margin-top: 50px;\">2022 대한민국 고객 만족 <br/>브랜드 대상</p>\r\n");
      out.write("    		</div>\r\n");
      out.write("    		<div class=\"col\">\r\n");
      out.write("		    	<img alt=\"\" src=\"https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202206/28/ec768f43-b08c-44d0-91a1-7e4e49c502f1.jpg\" style=\"width:200px; height: auto;\">\r\n");
      out.write("    			<p style=\"margin-top: 30px;\">2022 고객 감동 우수 <br/>브랜드 대상</p>\r\n");
      out.write("    		</div>\r\n");
      out.write("    		<div class=\"col\">\r\n");
      out.write("		    	<img alt=\"\" src=\"https://compphoto.incruit.com/2013/05/title_gwpseoul_201352818830.gif\" style=\"width:200px; height: auto;\">\r\n");
      out.write("		    	<p style=\"margin-top: 30px;\">2022 일하기 좋은 우수기업 <br/> 100선 선정</p>\r\n");
      out.write("    		</div>\r\n");
      out.write("    		\r\n");
      out.write("    	</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("  \r\n");
      out.write("  <!-- Footer -->\r\n");
      out.write("<footer class=\"text-center text-lg-start bg-white text-muted\">\r\n");
      out.write("  <!-- Section: Social media -->\r\n");
      out.write("  <section class=\"d-flex justify-content-center justify-content-lg-between p-4 border-bottom\">\r\n");
      out.write("    <!-- Left -->\r\n");
      out.write("    <div class=\"me-5 d-none d-lg-block\">\r\n");
      out.write("      <span>Get connected with us on social networks:</span>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Left -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Right -->\r\n");
      out.write("    <div>\r\n");
      out.write("      <a href=\"\" class=\"me-4 link-secondary\">\r\n");
      out.write("        <i class=\"fab fa-facebook-f\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <a href=\"\" class=\"me-4 link-secondary\">\r\n");
      out.write("        <i class=\"fab fa-twitter\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <a href=\"\" class=\"me-4 link-secondary\">\r\n");
      out.write("        <i class=\"fab fa-google\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <a href=\"\" class=\"me-4 link-secondary\">\r\n");
      out.write("        <i class=\"fab fa-instagram\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <a href=\"\" class=\"me-4 link-secondary\">\r\n");
      out.write("        <i class=\"fab fa-linkedin\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <a href=\"\" class=\"me-4 link-secondary\">\r\n");
      out.write("        <i class=\"fab fa-github\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Right -->\r\n");
      out.write("  </section>\r\n");
      out.write("  <!-- Section: Social media -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Section: Links  -->\r\n");
      out.write("  <section class=\"\">\r\n");
      out.write("    <div class=\"container text-center text-md-start mt-5\">\r\n");
      out.write("      <!-- Grid row -->\r\n");
      out.write("      <div class=\"row mt-3\">\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("        <div class=\"col-md-3 col-lg-4 col-xl-3 mx-auto mb-4\">\r\n");
      out.write("          <!-- Content -->\r\n");
      out.write("          <h6 class=\"text-uppercase fw-bold mb-4\">\r\n");
      out.write("            <i class=\"fas fa-gem me-3 text-secondary\"></i>Company name\r\n");
      out.write("          </h6>\r\n");
      out.write("          <p>\r\n");
      out.write("            Here you can use rows and columns to organize your footer content. Lorem ipsum\r\n");
      out.write("            dolor sit amet, consectetur adipisicing elit.\r\n");
      out.write("          </p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("        <div class=\"col-md-2 col-lg-2 col-xl-2 mx-auto mb-4\">\r\n");
      out.write("          <!-- Links -->\r\n");
      out.write("          <h6 class=\"text-uppercase fw-bold mb-4\">\r\n");
      out.write("            Products\r\n");
      out.write("          </h6>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">Angular</a>\r\n");
      out.write("          </p>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">React</a>\r\n");
      out.write("          </p>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">Vue</a>\r\n");
      out.write("          </p>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">Laravel</a>\r\n");
      out.write("          </p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("        <div class=\"col-md-3 col-lg-2 col-xl-2 mx-auto mb-4\">\r\n");
      out.write("          <!-- Links -->\r\n");
      out.write("          <h6 class=\"text-uppercase fw-bold mb-4\">\r\n");
      out.write("            Useful links\r\n");
      out.write("          </h6>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">Pricing</a>\r\n");
      out.write("          </p>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">Settings</a>\r\n");
      out.write("          </p>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">Orders</a>\r\n");
      out.write("          </p>\r\n");
      out.write("          <p>\r\n");
      out.write("            <a href=\"#!\" class=\"text-reset\">Help</a>\r\n");
      out.write("          </p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("        <div class=\"col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4\">\r\n");
      out.write("          <!-- Links -->\r\n");
      out.write("          <h6 class=\"text-uppercase fw-bold mb-4\">Contact</h6>\r\n");
      out.write("          <p><i class=\"fas fa-home me-3 text-secondary\"></i> 서울, NY 10012, US</p>\r\n");
      out.write("          <p>\r\n");
      out.write("            <i class=\"fas fa-envelope me-3 text-secondary\"></i>\r\n");
      out.write("            info@example.com\r\n");
      out.write("          </p>\r\n");
      out.write("          <p><i class=\"fas fa-phone me-3 text-secondary\"></i> + 01 234 567 88</p>\r\n");
      out.write("          <p><i class=\"fas fa-print me-3 text-secondary\"></i> + 01 234 567 89</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Grid column -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- Grid row -->\r\n");
      out.write("    </div>\r\n");
      out.write("  </section>\r\n");
      out.write("  <!-- Section: Links  -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Copyright -->\r\n");
      out.write("  <div class=\"text-center p-4\" style=\"background-color: rgba(0, 0, 0, 0.025);\">\r\n");
      out.write("    © 2021 Copyright:\r\n");
      out.write("    <a class=\"text-reset fw-bold\" href=\"https://mdbootstrap.com/\">MDBootstrap.com</a>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- Copyright -->\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- Footer -->\r\n");
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