package infoEdit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sign.JoinDTO;

//기존 데이터 삽입 -- 수정할 때
//==========================================

@WebServlet("/controller/VRevise.do")
public class SelectController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String idx=(String)session.getAttribute("me_num");
		
		System.out.println(idx);

		
		ReviseDAO dao = new ReviseDAO();
		
		JoinDTO dto = dao.selectView(idx);
		System.out.println(dto.getIn_npic());
		System.out.println(dto.getIn_opic());
		System.out.println(dto.getIn_nvoice());
		System.out.println(dto.getIn_ovoice());
		
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/05InfoEdit/Revise.jsp").forward(req,resp);
	}
}
