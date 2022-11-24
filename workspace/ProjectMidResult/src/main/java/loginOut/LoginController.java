package loginOut;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AlertFunc;

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
      dao.close();
      
      String me_num=dto.getMe_num(); 
      SecChartChkDAO dao2 = new SecChartChkDAO();
      SecChartChkDTO dto2 = dao2.SecChartChk(me_num);
      dao2.close();
      
      System.out.println(dto.getMe_id());
      System.out.println(dto2.getIn_mbti());
      //두번째페이지 작성 안한 경우 세션에 저장안해서 로그인이 되지 않고 바로 회원가입 2페이지로 뜸
      if(dto.getMe_num()!=null && dto2.getMe_num()==null) {
    	  session.setAttribute("me_id", dto.getMe_id());
          session.setAttribute("me_name", dto.getMe_name());
          session.setAttribute("me_num", dto.getMe_num());
          session.setAttribute("me_kakao", dto.getMe_kakao());
          session.setAttribute("me_phone", dto.getMe_phone());
          session.setAttribute("me_email", dto.getMe_email());
    	  AlertFunc.alert(resp, "상세정보를 기입하지 않으셨습니다. 회원가입2 페이지로 넘어갑니다.");
    	  req.getRequestDispatcher("../02Join/Join3.jsp").forward(req, resp);
      
      }else if(dto.getMe_id() !=null && dto2.getIn_mbti()!=null){
         session.setAttribute("me_id", dto.getMe_id());
         session.setAttribute("me_name", dto.getMe_name());
         session.setAttribute("me_num", dto.getMe_num());
         session.setAttribute("in_mbti", dto2.getIn_mbti());
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
         
         
         req.getRequestDispatcher("../reviewBoard/ReviewMainPage.do").forward(req,resp);
         
      }
      else{
         req.setAttribute("LoginErrMsg", "로그인 오류입니다.");
         req.getRequestDispatcher("../03LogInOut/LoginForm.jsp").forward(req,resp);
      }
   }

}