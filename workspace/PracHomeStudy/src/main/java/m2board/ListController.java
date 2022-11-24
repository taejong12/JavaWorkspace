package m2board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.PagingUtil;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MBoardDAO dao = new MBoardDAO();
		
		Map<String, Object> map = new HashMap<>();
		
		String searchType = req.getParameter("searchType");
		String searchStr = req.getParameter("searchStr");
		if(searchStr != null) {
			map.put("searchType", searchType);
			map.put("searchStr", searchStr);
		}
		
		int totalCount = dao.selectCount(map);
		
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
		int pageBlock = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
		
		int pageNum=1;
		String pageTemp = req.getParameter("pageNum");
		if(pageTemp != null && !pageTemp.equals("")) {
			pageNum=Integer.parseInt(pageTemp);
		}
		
		int start = (pageNum-1)*pageSize+1;
		int end = pageNum*pageSize;
		map.put("start", start);
		map.put("end", end);
		
		
		List<MBoardDTO> boardLists = dao.selectListPage(map);
		
		dao.close();
		
		String pagingStr = PagingUtil.pagingStr(totalCount, pageSize, pageBlock, pageNum, "../m2board/list.do");
		map.put("pagingStr", pagingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/3M2Board/List.jsp").forward(req, resp);
		
		
		
	}
}
