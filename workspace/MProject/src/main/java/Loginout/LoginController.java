package Loginout;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.AlertFunc;
import util.FileUtil;

import javax.servlet.*;

@WebServlet("/Loginout/Login.do")
public class LoginController extends HttpServlet{
        
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../02Login/LoginForm.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meId = req.getParameter("me_id");
		String mePass = req.getParameter("me_pass");
		HttpSession session = req.getSession();
      
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = dao.getLoginDTO(meId, mePass);
		
		
		dao.close();
      
		if(dto.getMe_id() !=null){
	        session.setAttribute("me_id", dto.getMe_id());
	        session.setAttribute("me_name", dto.getMe_name());
	        session.setAttribute("me_num", dto.getMe_num());
	        System.out.println(session.getAttribute("me_id"));
	        System.out.println(session.getAttribute("me_name"));
	        System.out.println(session.getAttribute("me_num"));
	        req.getRequestDispatcher("../reviewBoard/ReviewMainPage.do").forward(req,resp);
	        
		}
		else{
	        req.setAttribute("LoginErrMsg", "로그인 오류입니다.");
	        req.getRequestDispatcher("../02Login/LoginForm.jsp").forward(req,resp);
		}
	}

}