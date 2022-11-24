package reviewBoard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 메인페이지
@WebServlet("/reviewBoard/ReviewMainPage.do")
public class ReviewMainPageController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReviewDAO dao = new ReviewDAO();
		
		List<ReviewDTO> mainReviewLists = dao.reviewMain();
		dao.close();
		
		req.setAttribute("mainReviewLists", mainReviewLists);
		req.getRequestDispatcher("/MainPage/MainPage.jsp").forward(req, resp);
		
	}
}
