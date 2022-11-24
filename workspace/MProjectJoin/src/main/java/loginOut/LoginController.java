package loginOut;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;


public class LoginController extends HttpServlet{
        
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("../03LoginOut/LoginForm.jsp").forward(req,resp);
		}
	
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String meId = req.getParameter("me_id");
      String mePass = req.getParameter("me_pass");
      HttpSession session = req.getSession();
      
      LoginDAO dao = new LoginDAO();
      LoginDTO dto = dao.getLoginDTO(meId, mePass);
      System.out.println(dto.getMe_id());
      dao.close();
      
           
      if(dto.getMe_id() !=null){
         session.setAttribute("me_id", dto.getMe_id());
         session.setAttribute("me_name", dto.getMe_name());
         session.setAttribute("me_num", dto.getMe_num());
         session.setAttribute("in_mbti", dto.getIn_mbti());
         session.setAttribute("me_kakao", dto.getMe_kakao());
         session.setAttribute("me_phone", dto.getMe_phone());
         session.setAttribute("me_email", dto.getMe_email());
         System.out.println(session.getAttribute("me_id"));
         System.out.println(session.getAttribute("me_name"));
         System.out.println(session.getAttribute("me_num"));
         System.out.println(session.getAttribute("in_mbti"));
         System.out.println(session.getAttribute("me_kakao"));
         System.out.println(session.getAttribute("me_phone"));
         System.out.println(session.getAttribute("me_email"));
         
         req.getRequestDispatcher("../01MainPage/MainPage.jsp").forward(req,resp);
      }
      else{
         req.setAttribute("LoginErrMsg", "로그인 오류입니다.");
         req.getRequestDispatcher("../03LogInOut/LoginForm.jsp").forward(req,resp);
      }
   }

}