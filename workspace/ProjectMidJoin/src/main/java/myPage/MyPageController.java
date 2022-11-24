package myPage;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matching.MatchingJJIMDAO;
import matching.MatchingJJIMDTO;
import matching.MyMatchingDAO;
import matching.MyMatchingDTO;


public class MyPageController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//찜목록 가져오는 부분
		MatchingJJIMDAO dao = new MatchingJJIMDAO();
		String jjim_from_num = req.getParameter("me_num");
		List<MatchingJJIMDTO> jjimLists = dao.selectList(jjim_from_num);
		dao.close();
		
		
		//매칭 현황 가져올 부분
		MyMatchingDAO dao2 = new MyMatchingDAO();
		String my_num = req.getParameter("me_num");
		List<MyMatchingDTO> matchLists = dao2.selectList(my_num);
		System.out.println(matchLists);
		dao2.close();
		
		req.setAttribute("jjimLists", jjimLists);
		req.setAttribute("matchLists", matchLists);
		req.getRequestDispatcher("/04MyPage/MyPage.jsp").forward(req, resp);
	}

	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MatchingJJIMDAO dao = new MatchingJJIMDAO();
		String jjim_from_num = req.getParameter("me_num");
		System.out.println(jjim_from_num);
		List<MatchingJJIMDTO> jjimLists = dao.selectList(jjim_from_num);
		dao.close();
		
		//매칭 현황 가져올 부분
		MyMatchingDAO dao2 = new MyMatchingDAO();
		String my_num = req.getParameter("my_num");
		
		List<MyMatchingDTO> matchLists = dao2.selectList(my_num);
		dao2.close();
		
		req.setAttribute("jjimLists", jjimLists);
		req.setAttribute("matchLists", matchLists);
		req.getRequestDispatcher("/04MyPage/MyPage.jsp").forward(req, resp);
	}*/

}
