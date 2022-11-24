package servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/2Servlet/LifeCycle.do")
public class LifeCycle extends HttpServlet {

	@PostConstruct
	public void mPostConstruct() {
		System.out.println("PostConstruct call");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() call");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() call");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() call");
		req.getRequestDispatcher("/2Servlet/LifeCycle.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() call");
		req.getRequestDispatcher("/2Servlet/LifeCycle.jsp").forward(req, resp);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() call");
	}
	
	@PreDestroy
	public void mPreDestory() {
		System.out.println("PreDestroy() call");
	}
	
	
	
}
