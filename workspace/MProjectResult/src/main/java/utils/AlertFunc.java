package utils;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class AlertFunc {
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = "<script>"
						+"alert('"+msg+"');"
						+"location.href='"+url+"';"
						+"</script>";
			out.println(script); //http 안에 프린트하는 느낌으로 자바단에서 http 태그같은 것을 실행할 때 out류의 객체의 println을 사용한다.
		}catch(Exception e) {}
	}
	
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "<script>"
						+"alert('"+msg+"');"
						+"history.back();"
						+"</script>";
			out.println(script);
		}catch(Exception e) {}
	}
	
	
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = "<script>"
						+"alert('"+msg+"');"
						+"location.href='"+url+"';"
						+"</script>";
			writer.print(script);
		}catch(Exception e) {}
	}
	
	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter writer = resp.getWriter();
			String script ="<script>"
						+"alert('"+msg+"');"
						+"history.back();"
						+"</script>";
			writer.print(script);
		}catch(Exception e) {}
	}
	
	public static void alert(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter writer = resp.getWriter();
			String script ="<script>"
						+"alert('"+msg+"');"
						+"</script>";
			writer.print(script);
		}catch(Exception e) {}
	}
}
