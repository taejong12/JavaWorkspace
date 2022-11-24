package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	//	1.서블릿 상속
public class ServletView extends HttpServlet{

	//	기본적인 주소값은 doGet
	//	데이터를 옮길 때는 doPsot
	
	@Override
	//	서블릿 자체에서 리스폰스를 클라이언트에 쏴주려고 한다 jsp없이
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
			//	서블릿에서 직접 넘겨줄 때 브라우저에서 사용할 정보를 작성해줘야 한다
			//	jsp 상단에 있는 정보
			//	<%@ page language="java" contentType="text/html; charset=UTF-8"
			//	   	pageEncoding="UTF-8"%>
			resp.setContentType("text/html;charset=UTF-8");
			
			//		아웃풋스트림
			//		라이터 객체
			//		아웃도 라이터객체
			//		겟 라이터 해서 출력하고자 하는 태그를 작성
			//		실제로 작성하면 태그문을 작성하고
			//		한줄로 만들어서 넣어주는게 편하다
			//		직접 쳐야 한다면 눈으로 보고 쳐야 한다
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<head><title>서블릿 뷰</title></head>");
			writer.println("<body>");
			writer.println("<h2>서블릿에서 직접 출력 get방식</h2>");
			writer.println("<p>jsp를 거치지 않습니다.</p>");
			writer.println("</body>");
			writer.println("</html>");
			
			writer.close();
			
			//ServletView.do web.xml 직접 작성해보기
		
	}
	
	@Override
	//	서블릿 자체에서 리스폰스를 클라이언트에 쏴주려고 한다 jsp없이
	//	get 방식은 web.xml에 작성한 url을 통해서 서블릿 클래스로 직접 접근 가능하지만
	//	post 방식은 jsp를 통해서 form을 만들어서 접근하기 위한 용도로만 사용
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
			//	서블릿에서 직접 넘겨줄 때 브라우저에서 사용할 정보를 작성해줘야 한다
			//	jsp 상단에 있는 정보
			//	<%@ page language="java" contentType="text/html; charset=UTF-8"
			//	   	pageEncoding="UTF-8"%>
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			
			//		아웃풋스트림
			//		라이터 객체
			//		아웃도 라이터객체
			//		겟 라이터 해서 출력하고자 하는 태그를 작성
			//		실제로 작성하면 태그문을 작성하고
			//		한줄로 만들어서 넣어주는게 편하다
			//		직접 쳐야 한다면 눈으로 보고 쳐야 한다
			writer.println("<html>");
			writer.println("<head><title>서블릿 뷰</title></head>");
			writer.println("<body>");
			writer.println("<h2>서블릿에서 직접 출력 post 방식</h2>");
			writer.println("<p>jsp를 거치지 않습니다.</p>");
			writer.println("</body>");
			writer.println("</html>");
			
			writer.close();
			
			//ServletView.do web.xml 직접 작성해보기
		
	}
	
	
}
