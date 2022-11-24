package comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AlertFunc;

@WebServlet("/qnasBoard/reDelete.do")
public class CommentsDelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int qna_num = Integer.parseInt(req.getParameter("qna_num"));
		int comm_num = Integer.parseInt(req.getParameter("comm_num"));
		CommentsDAO dao = new CommentsDAO();
		int result = dao.deleteComm(comm_num);
		dao.close();
		
		if(result ==1) {
			resp.sendRedirect("../qnasBoard/qnasView.do?num="+qna_num+"&pageNum="+pageNum);
		} else {
			resp.sendRedirect("../qnasBoard/qnasView.do?num="+qna_num+"&pageNum="+pageNum);
		}
		
	}
}
