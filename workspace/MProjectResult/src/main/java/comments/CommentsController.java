package comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.QnasDAO;
import qna.QnasDTO;

@WebServlet("/qnasBoard/reWrite.do")
public class CommentsController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int qna_num = Integer.parseInt(req.getParameter("qna_num"));
		
		System.out.println("작성단으로 넘어오는지 확인");
		System.out.println(pageNum);
		System.out.println(req.getParameter("qna_num"));
		System.out.println(req.getParameter("me_num"));
		System.out.println(req.getParameter("writer"));
		System.out.println(req.getParameter("comm_num"));
		System.out.println(req.getParameter("content"));
		System.out.println(req.getParameter("regroup"));
		System.out.println(req.getParameter("reglevel"));
		System.out.println(req.getParameter("regorder"));
		System.out.println(req.getParameter("pass"));
		
		
		CommentsDAO dao = new CommentsDAO();
		CommentsDTO dto = new CommentsDTO();
		dto.setQna_num(Integer.parseInt(req.getParameter("qna_num")));
		dto.setMe_num(Integer.parseInt(req.getParameter("me_num")));
		dto.setWriter(req.getParameter("writer"));
		dto.setComm_num(Integer.parseInt(req.getParameter("comm_num")));
		dto.setContent(req.getParameter("content"));
		dto.setRegroup(Integer.parseInt(req.getParameter("regroup")));
		dto.setReglevel(Integer.parseInt(req.getParameter("reglevel")));
		dto.setRegorder(Integer.parseInt(req.getParameter("regorder")));
		dto.setPass(Integer.parseInt(req.getParameter("pass")));
		
		int result = dao.insertComm(dto);
		dao.close();
		
		if(result ==1) {
			resp.sendRedirect("../qnasBoard/qnasView.do?num="+qna_num+"&pageNum="+pageNum);
		} else {
			resp.sendRedirect("../qnasBoard/qnasView.do?num="+qna_num+"&pageNum="+pageNum);
		}
	}	
}
