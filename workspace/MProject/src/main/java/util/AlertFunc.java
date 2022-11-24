package util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

//오버로딩 오버라이딩
//오버로딩(Overloading) : 같은 이름의 메서드 여러개를 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술
//오버라이딩(Overriding) : 상위 클래스가 가지고 있는 메서드를 하위 클래스가 재정의해서 사용

public class AlertFunc {
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = "<script>" 
					+ " alert('" + msg + "');" 
					+ " location.href='" + url + "';" 
					+ "</script>";
			out.println(script);
		} catch (Exception e) {
		}
	}

	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "<script>" 
					+ " alert('" + msg + "');" 
					+ " history.back();" 
					+ "</script>";
			out.println(script);
		} catch (Exception e) {
		}
	}

	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = "<script>" 
					+ " alert('" + msg + "');" 
					+ " location.href='" + url + "';" 
					+ "</script>";
			writer.println(script);
		} catch (Exception e) {
		}
	}

	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = "<script>" 
					+ " alert('" + msg + "');" 
					+ " history.back();" 
					+ "</script>";
			writer.print(script);
		} catch (Exception e) {
		}
	}
	
	
	public static void confirmLocation(HttpServletResponse resp, String msg, String url) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = "<script>" 
					+ " if( confirm('" + msg + "')==false) return false;" 
					+ " location.href='" + url + "';" 
					+ "</script>";
			writer.println(script);
		} catch (Exception e) {
			System.out.println("confirmLocation 에러");
			e.printStackTrace();
		}
	}
	
	
	
	public static void confirmBack(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = "<script>" 
					+ " if(confirm('" + msg + "')==false) return false;"
					+ " history.back();" 
					+ "</script>";
			writer.print(script);
		} catch (Exception e) {
			System.out.println("confirmBack 에러");
			e.printStackTrace();
		}
	}
}
