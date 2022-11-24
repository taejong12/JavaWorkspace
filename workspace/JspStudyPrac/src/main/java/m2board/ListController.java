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

	//	기본적인 흐름
	//	커넥션을 만들어서 디비에서 해당하는 내용을 읽어온다
	//	페이징하기 위해서 
	//	전체갯수 쿼리문 하나 작성하고(전체리스트를 불러오는 것)
	//	해당 데이터 조건절을 포함시킨 데이터를 읽어오는 쿼리문을 하나 더 추가했다(카운트)
	//	카운트하는걸 한 번하고 전체리스트를 불러오는 것을 한 번 더 했다
	//	카운트하고 전체리스트를 하는 것을 해줘야한다
	//	넘겨줄때 게시물에 갯수는
	//	검색 조건을 포함해서 페이징을 하고 데이터를 보여주는것도 검색 조건을 포함해야 한다
	//	검색 옵션을 해야 한다
	//	데이터를 날리고 새로고침
	//	form으로 데이터를 날리고 새로고침해서 값을 입력 받아서 
	//	자기자신에서 받은 값을 파라미터로 저장해서 
	//	셀렉트 카운트를 하든 리스트페이지를 하든 검색 조건 값을 파람으로 넘겼다
	//	jsp 뷰단에 form이 있는데 자바소스리스트점 jsp 리퀘스트로 전달해올 때 
	//	해당 하는 값들을 받아서 맵에 넣고 셀렉트 리스트 페이지나 카운트해서 값을 넘겨준다
	//	검색옵션
	//	받아온 검색값으로 전체갯수 파악하고 페이지 몇개 게시물 몇개 보여줄지 정함
	//	2개의 값을 받아와서
	//	자바이기 때문에 어플케이션 바로 접근이 안돼서
	//	서블릿컨테스트를 통해서 어플리케이션으로 접근
	//	페이징이 현재 페이지를 알아야 하니까
	//	새로고침하면 페이지값을 리퀘스트로 다시 받는다
	//	null이나 빈값이 아니면 현재페이지로 받는다 그게 아니면 1
	
	//	첫 게시물 번호랑 끝 게시물 번호
	//	범위 내에 있는 것

public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 해당하는 게시판 목록을 만드는게 1번
		// 제일 먼저 해야하는것은 DAO 객체를 생성해서 커넥션하는게 1번
		// DAO 생성
		MBoardDAO dao = new MBoardDAO();
		
		// 변수 저장용
		Map<String, Object> map = new HashMap<>();
		
	    //검색 옵션
	    String searchType = req.getParameter("searchType");
	    String searchStr = req.getParameter("searchStr");
	    if(searchStr != null) {
	    	System.out.println(searchType+"dasdasdad");
	    	System.out.println(searchStr+"dasdasdad");
	        map.put("searchType", searchType);
	        map.put("searchStr", searchStr);
	    }
	    
	    int totalCount = dao.selectCount(map); //게시물의 갯수
	    System.out.println(totalCount);
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
		int pageBlock = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
		System.out.println(pageSize+" "+pageBlock);
		//페이지 확인
	    int pageNum = 1;
	    String pageTemp = req.getParameter("pageNum");
	    if(pageTemp!=null && !pageTemp.equals("")) {
	    	
	        pageNum=Integer.parseInt(pageTemp);
	    }
	    System.out.println(pageNum);

		
	    //목록에 보여줄 게시물 범위 계산
	    int start = (pageNum-1)*pageSize+1;
	    int end = pageNum*pageSize;
	    map.put("start",start);
	    map.put("end",end);
	    System.out.println(start+" "+end);
		
		// DB에서 게시물 정보를 받아와야 한다
		// 최종적으로 리퀘스트해서 데이터를 넘길 떄는 
		// req.getRequestDispatcher("/14M2Board/List.jsp").forward(req, resp); 를 통해서
		// set 해서 넘긴다 받아온 값(보드값)을 넘겨줘야 한다 DTO값을 포함하고 있는 목록값
		// 검색조건, 페이징처리를 넘겨줘야 한다 웹값으로 넘겨준다
		List<MBoardDTO> boardLists = dao.selectListPage(map);
//		System.out.println(boardLists);
//		
//	    for(MBoardDTO i : boardLists) {
//	         System.out.println(i.getName());
//	    }

		dao.close();
		
		//	자바에 있는 것을 jsp로 전달을 해줘야 한다
		//	jsp에서 페이징 처리를 할 값들을 맵에 넣어줘야 한다
		//	리퀘스트할 때 같이 전달
		//	리퀘스트에 다 set을 할 수도 있다
		//	게시물을 표현하려면 게시물을 자바에서 뷰단으로 같이 넘겨줘야 한다
		//	뷰단에서 받아서 화면을 구현한다
		//	컨트롤단에서 다 처리하고 넘겨준다
		//	딱 봐서 필요한 기능이 있으면 시켜만 주는게 mvc 모델2에서 컨트롤러가 하는 일
	
		// 뷰(jsp)에 전달할 값들 추가
		String pagingStr = PagingUtil.pagingCenter(totalCount,
				pageSize, pageBlock, pageNum, "../m2board/list.do");
		map.put("pagingStr", pagingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		System.out.println(pagingStr);
		
		// 뷰(jsp)로 최종 전달 
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map",map);
		req.getRequestDispatcher("/14M2Board/List.jsp").forward(req, resp);

	}
	
	//	리스트에 보여줄 것을 리스트 컨트롤러를 처리하는 것 디비 읽어오는 것 실행시키기 위해서 파라미터 검색어나 중간처리
	//	디비에서 읽어와서 해당 변수에 담고
	//	뷰랑 컨트롤러 단이 분리되면서 별개의 파일이라서 컨트롤러단에 있는 값을 뷰에 넘겨줘야 한다
	//	그러므로 값을 저장해서 포워딩
}
