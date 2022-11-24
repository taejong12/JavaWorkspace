package m2board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/m2board/view.do")
public class ViewController  extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 게시물 가져오기
		MBoardDAO dao = new MBoardDAO();
		String idx = req.getParameter("idx");
		dao.updateVisiteCount(idx); // 조회수 증가
		MBoardDTO dto = dao.selectView(idx);
		dao.close();
		
		// 줄바꿈 처리
		// 윈도우상 줄바꿈을 브라우저 안에 줄바꿈으로 바꿔준다(os에 따라서 앞에 줄바꿈 바뀜)
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/14M2Board/View.jsp").forward(req, resp);
	}

}
