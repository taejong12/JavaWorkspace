package matching;

	import java.io.IOException;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	public class MatchingViewController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//게시물 가져오기
	MatchingDAO dao = new MatchingDAO();
	int me_num = Integer.parseInt(req.getParameter("me_num"));
	MatchingDTO dto = dao.selectView(me_num);
	dao.close();

	req.setAttribute("dto", dto);
	req.getRequestDispatcher("/06Matching/MatchingView.jsp").forward(req, resp);
	}

	
}
