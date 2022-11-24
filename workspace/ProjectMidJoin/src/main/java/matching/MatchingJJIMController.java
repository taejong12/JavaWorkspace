package matching;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AlertFunc;

public class MatchingJJIMController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//찜목록 DB에 저장
			MatchingJJIMDAO dao = new MatchingJJIMDAO();
			
			String jjim_from_num = req.getParameter("jjim_from_num");
			String jjim_to_num = req.getParameter("jjim_to_num");
			String jjim_to_name = req.getParameter("jjim_to_name");
			String jjim_to_age = req.getParameter("jjim_to_age");
			
			MatchingJJIMDTO dto = new MatchingJJIMDTO();
			dto.setJjim_from_num(Integer.parseInt(jjim_from_num));
			dto.setJjim_to_num(Integer.parseInt(jjim_to_num));
			dto.setJjim_to_name(jjim_to_name);
			dto.setJjim_to_age(Integer.parseInt(jjim_to_age));
			//DAO에 있는 메소드로 DB에 저장
			int result = dao.insertList(dto);
			dao.close();
			
			if(result==1) {
				AlertFunc.alertLocation(resp, "찜했습니다.", "/ProjectMid/matching/main.do");
				//resp.sendRedirect("../matching/main.do");
				//resp.sendRedirect("../myPage/MyPage.do?me_num="+jjim_from_num);
			}
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String jjim_from_num = req.getParameter("jjim_from_num");
			String jjim_to_num = req.getParameter("jjim_to_num");
			
			MatchingJJIMDAO dao = new MatchingJJIMDAO();
			int result = dao.deleteList(jjim_from_num,jjim_to_num);
			dao.close();
			System.out.println(result);
			if(result==1) {
				AlertFunc.alertLocation(resp, "해당 찜목록이 삭제되었습니다.", "/ProjectMid/myPage/MyPage.do?me_num="+jjim_from_num);
			}else{
				AlertFunc.alertBack(resp, "찜목록 삭제 실패했습니다.");
			}
		}
		
		

	
}
