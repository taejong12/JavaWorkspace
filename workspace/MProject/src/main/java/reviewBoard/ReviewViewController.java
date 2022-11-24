package reviewBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewBoard/reviewView.do")
public class ReviewViewController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 게시물 가져오기
		ReviewDAO dao = new ReviewDAO();
		String num = req.getParameter("num");
		ReviewDTO dto = dao.selectView(num);
		dao.close();
		
		System.out.println("뷰"+dto.getContent());
		// 줄바꿈 처리
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/Review/ReviewView.jsp").forward(req, resp);
		
	}
}
