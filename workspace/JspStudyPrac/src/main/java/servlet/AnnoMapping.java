package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//	임포트 시켜줘야 한다 
//	어노테이션은 주석에 지나지 않는다
//	그래서 동작을 구현하기 위해서는
//	구현되어 있는 객체를 불러와야 한다
//	동작을 만들어주는 것은 구현되어 있는 객체가 있어서이다
//	클래스 위에다가 괄호 안에 url 패턴을 받아들여서 해당하는 서블릿을 실행
@WebServlet("/13Servlet/AnnoMapping.do")

public class AnnoMapping extends HttpServlet {

	//	3.어노테이션
	//	처음 컴파일을 진행할 때 작성한 
	//	어노테이션을 기준으로 서블릿 맵핑을 자동으로 해준다
	//	jsp 같은 경우에도 매번 맵핑해주는게 방식이었다
	//	그 방식을 해결해주기 위해서 어노테이션을 달기 시작했다
	//	어노테이션이 달려있는 자바파일이면 서블릿 맵핑을 자동으로 해준다
	//	web.xml에 작성하는 과정을 어노테이션이 해준다
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("message", "annotation mapping");
		req.getRequestDispatcher("/13Servlet/AnnoMapping.jsp")
			.forward(req, resp);
	}
	
}