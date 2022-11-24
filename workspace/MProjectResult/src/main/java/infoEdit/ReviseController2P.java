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

//핸드폰 번호 변경
//=========================================

@WebServlet("/controller/PRevise.do")
public class ReviseController2P extends HttpServlet{
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
      JoinDTO result;
            
      String me_num = (String)session.getAttribute("me_num");
      
      System.out.println("me_num");
      System.out.println(me_num);
      System.out.println(me_num);

      
      dto.setME_NUM(me_num);
      dto.setME_PHONE(req.getParameter("ME_PHONE"));      
      
      result=dao.UpdatePRevise(dto);
      
      dao.close();
      resp.sendRedirect("../controller/VRevise.do");
      //req.getRequestDispatcher("/05InfoEdit/Revise.jsp").forward(req, resp);
   }
}