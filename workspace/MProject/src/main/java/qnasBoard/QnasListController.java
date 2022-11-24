package qnasBoard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.PagingUtil;

@WebServlet("/qnasBoard/qnasList.do")
public class QnasListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QnasDAO dao = new QnasDAO();
		
		// 변수 저장용
		Map<String, Object> map = new HashMap<>();
		
		// 검색 옵션
		String searchType = req.getParameter("searchType");
		String searchStr = req.getParameter("searchStr");
		if(searchStr != null) {
			map.put("searchType", searchType);
			map.put("searchStr", searchStr);
		}
		
		// 게시물의 갯수
		int totalCount = dao.selectCount(map);
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
		int pageBlock = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
		
		//페이지 확인
	    int pageNum = 1;
	    String pageTemp = req.getParameter("pageNum");
	    if(pageTemp!=null && !pageTemp.equals("")) {
	    	
	        pageNum=Integer.parseInt(pageTemp);
	    }
	    
	    //목록에 보여줄 게시물 범위 계산
	    int start = (pageNum-1)*pageSize+1;
	    int end = pageNum*pageSize;
	    map.put("start",start);
	    map.put("end",end);
	   
	    List<QnasDTO> boardLists = dao.selectListPage(map);

		dao.close();
		
		String pagingStr = PagingUtil.pagingCenter(totalCount,
				pageSize, pageBlock, pageNum, "../qnasBoard/qnasList.do");
		map.put("pagingStr", pagingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		// 뷰(jsp)로 최종 전달 
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map",map);
		req.getRequestDispatcher("/Qnas/QnasList.jsp").forward(req, resp);

	}
	
	
}
