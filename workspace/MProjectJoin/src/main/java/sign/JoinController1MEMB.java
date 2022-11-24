package sign;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//MEMBER테이블 회원가입
//===============================

@WebServlet("/controller/Join.do")
public class JoinController1MEMB extends HttpServlet{
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doGet(req, resp);
		}


   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //DAO를 통해 DB에 게시 내용 저장
      JoinDAO dao = new JoinDAO();
      JoinDTO dto = new JoinDTO();
      
      String k = req.getParameter("ME_NUM");
      
      //1103 바꾸기
      String date = req.getParameter("ME_BIRTH");
      System.out.println(date);
      System.out.println(date);
      System.out.println(date);
      System.out.println(date);
      dto.setME_BIRTH(date);
      
      
      System.out.println(k);
      dto.setME_NUM(req.getParameter("ME_NUM"));
      dto.setME_ID(req.getParameter("ME_ID"));
      dto.setME_PASS(req.getParameter("ME_PASS"));
      dto.setME_NAME(req.getParameter("ME_NAME"));
      dto.setME_SEX(req.getParameter("ME_SEX"));
      dto.setME_AGE(req.getParameter("ME_AGE"));      
      dto.setME_PHONE(req.getParameter("ME_PHONE"));
      dto.setME_EMAIL(req.getParameter("ME_EMAIL"));
      dto.setME_KAKAO(req.getParameter("ME_KAKAO"));
      dto.setRE_NUM(req.getParameter("RE_NUM"));     
  
      dao.insertWrite(dto);
  
      dao.close();
      
      req.getRequestDispatcher("../02Join/Join2.jsp").forward(req, resp);

      
   }
}