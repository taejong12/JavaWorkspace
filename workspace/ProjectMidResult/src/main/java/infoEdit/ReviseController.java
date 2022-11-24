package infoEdit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sign.JoinDAO;
import sign.JoinDTO;


@WebServlet("/controller/Revise.do")
public class ReviseController extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String me_num = req.getParameter("me_num");
		ReviseDAO dao = new ReviseDAO();
		JoinDTO dto = dao.selectView(me_num);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/05InfoEdit/Revise.jsp").forward(req, resp);
		}


   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //DAO를 통해 DB에 게시 내용 저장
	   ReviseDAO dao = new ReviseDAO();
      JoinDTO dto = new JoinDTO();
      
      HttpSession session = req.getSession();
      int result = 0;
      
      String me_num = (String)session.getAttribute("me_num");
      
      dto.setME_NUM(me_num);      
      
      //MEMBERS
      dto.setME_PASS(req.getParameter("ME_PASS"));
      dto.setME_NAME(req.getParameter("ME_NAME"));
      dto.setME_BIRTH(req.getParameter("ME_BIRTH"));
      dto.setME_SEX(req.getParameter("ME_SEX"));
      dto.setME_AGE(req.getParameter("ME_AGE"));      
      dto.setME_KAKAO(req.getParameter("ME_KAKAO"));
      dto.setRE_NUM(req.getParameter("RE_NUM"));
      
      
      result = dao.UpdateRevise(dto);
      dao.close();
      resp.sendRedirect("../controller/VRevise.do");
      //req.getRequestDispatcher("/05InfoEdit/Revise.jsp").forward(req, resp);
   }
}