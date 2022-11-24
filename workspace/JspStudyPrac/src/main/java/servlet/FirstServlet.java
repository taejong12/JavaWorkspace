package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1.먼저 서블릿 상속을 받아야 한다
//web.xml에서 맵핑을 시켜주면 최초의 리퀘스트를 여기서 받는다
public class FirstServlet extends HttpServlet {
		
	@Override
	
	//2.doGet 오버라이딩
	//처음 만나는 doGet 메서드가 받는다 (get과 post는 들어오는 방식 차이(doGet, doPost))
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//만들고자 하는 것을 작성
		req.setAttribute("message", "안녕하세요.");
		
		// 우리가 받아온 리퀘스트 값을 해당하는 곳으로 보내준다
		req.getRequestDispatcher("/13Servlet/FirstServlet.jsp")
			.forward(req, resp);

	}
	

}
