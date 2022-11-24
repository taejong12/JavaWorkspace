/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-11-05 09:30:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._01MainPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!--     팝업설정 -->\r\n");
      out.write(" ");

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
    
      out.write("   \r\n");
      out.write("<!--     팝업 설정  -->\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Main Home Page</title>\r\n");
      out.write("<!-- 팝업 스타일 설정 -->\r\n");
      out.write("<style> \r\n");
      out.write("#popup{\r\n");
      out.write("   position:absolute;top:100px;left:50px;\r\n");
      out.write("   color:yellow;width:270px;height:100px;background-color:gray;\r\n");
      out.write("   }\r\n");
      out.write("#popup>div{\r\n");
      out.write("   position:relative;background-color:white;top:0px;\r\n");
      out.write("   border: 1px solid gray; padding:10px;color:black; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<!--     팝업 스타일 설정 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 팝업 제이쿼리 설정     -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.1.min.js\" integrity=\"sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$(function () {\r\n");
      out.write("   $('#closeBtn').click(function(){\r\n");
      out.write("      $('#popup').hide();\r\n");
      out.write("      var chk =$(\"#inactiveToday:checked\").val();\r\n");
      out.write("      if(chk=='1'){\r\n");
      out.write("         $.ajax({\r\n");
      out.write("            url:'./PopupCookie.jsp',\r\n");
      out.write("            type : 'get',\r\n");
      out.write("            data : {inactive:chk},\r\n");
      out.write("            datatype : 'text',\r\n");
      out.write("            success : function(){\r\n");
      out.write("               if(resData!='')location.reload();\r\n");
      out.write("            }\r\n");
      out.write("         })\r\n");
      out.write("      }\r\n");
      out.write("   });\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- 팝업 제이쿼리 설정 -->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 팝업이 나오는 창 -->\r\n");
      out.write("   ");

   if(popupMode.equals("on")){
   
      out.write("\r\n");
      out.write("   <div id=\"popup\">\r\n");
      out.write("      <h2 align=\"center\">환 영 합 니 다.</h2>\r\n");
      out.write("      <div align=\"right\">\r\n");
      out.write("         <form name=\"popForm\">\r\n");
      out.write("            <input type=\"checkbox\" id=\"inactiveToday\" value=\"1\">\r\n");
      out.write("            하루동안 안 열기\r\n");
      out.write("            <input type=\"button\" value=\"닫기\" id=\"closeBtn\">\r\n");
      out.write("         </form>\r\n");
      out.write("      </div>   \r\n");
      out.write("   </div>\r\n");
      out.write("   ");

   }
   
      out.write("\r\n");
      out.write("<!--  팝업이 나오는 창 -->\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/Top.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<section>\r\n");
      out.write("	<table border=\"1\" width=\"100%\">\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>\r\n");
      out.write("				<p>회원현황 및 소개문구</p>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>\r\n");
      out.write("				<p>후기 (평점 4.5 이상 후기 중 최신 순으로 3개 출력)</p>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>\r\n");
      out.write("				<p>수상기록</p>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/Footer.jsp", out, false);
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
