package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

//어노테이션으로 작성
//	* 다 받아주겠다
@WebServlet("*.set")
public class FirstController extends HttpServlet {

	//	요청받은 주소 앞쪽으로 나오는 애들만 잘랐다
	//	맨 마지막 슬래시 인덱스를 받아온다
	//	뒤에 있는 내용만 딱 잘라서 온다
	//	그거랑 뒤에 있는 내용을 비교한다
	//	해당하는 주소 배열에 맞춰서 서로 다른 펑션을 작동
	//	주소창에 여러개가 올 수 있어서 여러개를 맵핑해줘야 한다
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String commandStr = uri.substring(lastSlash);
		System.out.println(commandStr);
		
		if(commandStr.equals("/regist.set")) {
			registFunc(req);
		} else if(commandStr.equals("/login.set")) {
			loginFunc(req);
		} else if(commandStr.equals("/board.set")) {
			boardFunc(req);
		} 
		
		//	눈으로 보이는게 없는 상황
		//	보여주기 위해서 작성
		req.setAttribute("uri", uri);
		req.setAttribute("comStr", commandStr);
		
		// 이게 실행이 되면 주소로 이동한다
		req.getRequestDispatcher("/13Servlet/FirstView.jsp").forward(req, resp);
		
		//스프링에서는 return만 해줘도 getRequestDispatcher 알아서 처리해준다
		
		
	}
	
	void registFunc(HttpServletRequest req) {
		req.setAttribute("result", "<h3>회원가입</h3>");	
	}
	
	void loginFunc(HttpServletRequest req) {
		req.setAttribute("result", "<h3>로그인</h3>");
	}
	
	void boardFunc(HttpServletRequest req) {
		req.setAttribute("result", "<h3>게시판</h3>");
	}
		
}
