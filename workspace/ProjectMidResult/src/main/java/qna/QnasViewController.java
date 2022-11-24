package qna;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.CommentsDTO;
import comments.CommentsDAO;

@WebServlet("/qnasBoard/qnasView.do")
public class QnasViewController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		String pageNum = req.getParameter("pageNum");
		System.out.println(num);
		System.out.println(pageNum);
		// 게시물 가져오기
		QnasDAO dao = new QnasDAO();
		QnasDTO dto = dao.selectView(num);
		dao.close();
		// 줄바꿈 처리
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		// 댓글 가져오기
		Map<String, Object> map = new HashMap<>();
		CommentsDAO dao2 = new CommentsDAO();
		int qnaNum = Integer.parseInt(req.getParameter("num"));
		System.out.println("qna_num");
		map.put("qna_num", qnaNum);
		System.out.println(map.get("qna_num"));
		
		List<CommentsDTO> commLists = dao2.commList(map);
		dao2.close();
		System.out.println(commLists);
		System.out.println("ddd");
		
		//필요한 변수 사용하기 위해 0으로 설정해서 넘겨줌
		int comm_num=0, regroup=0, reglevel=0, regorder=0;
		
		req.setAttribute("comm_num", comm_num);
		req.setAttribute("regroup", regroup);
		req.setAttribute("reglevel", reglevel);
		req.setAttribute("regorder", regorder);
		
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("commLists", commLists);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/07QnABoard/QnasView.jsp").forward(req, resp);
	
	}
}
