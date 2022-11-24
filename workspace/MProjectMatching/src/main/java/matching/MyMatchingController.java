package matching;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AlertFunc;

public class MyMatchingController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//매칭신청목록 DB에 저장
		MyMatchingDAO dao = new MyMatchingDAO();
		
		HttpSession session = req.getSession();
		String me_num = (String)session.getAttribute("me_num");
		
		String ma_from_num = req.getParameter("ma_from_num");
		String ma_from_name = req.getParameter("ma_from_name");
		String ma_to_num = req.getParameter("ma_to_num");
		String ma_to_name = req.getParameter("ma_to_name");
		String ma_message = req.getParameter("ma_message");
		
		String ma_to_kakao = req.getParameter("ma_to_kakao");
		String ma_to_phone = req.getParameter("ma_to_phone");
		String ma_to_email = req.getParameter("ma_to_email");
		String ma_from_kakao = req.getParameter("ma_from_kakao");
		String ma_from_phone = req.getParameter("ma_from_phone");
		String ma_from_email = req.getParameter("ma_from_email");
		
				
		
		MyMatchingDTO dto = new MyMatchingDTO();
		dto.setMa_from_num(Integer.parseInt(ma_from_num));
		dto.setMa_from_name(ma_from_name);
		dto.setMa_to_num(Integer.parseInt(ma_to_num));
		dto.setMa_to_name(ma_to_name);
		dto.setMa_message(ma_message);
		
		dto.setMa_to_kakao(ma_to_kakao);
		dto.setMa_to_phone(ma_to_phone);
		dto.setMa_to_email(ma_to_email);
		dto.setMa_from_kakao(ma_from_kakao);
		dto.setMa_from_phone(ma_from_phone);
		dto.setMa_from_email(ma_from_email);
		
		//DAO에 있는 메소드로 DB에 저장
		int result = dao.insertList(dto);
		dao.close();
		
		if(result==1) {
			AlertFunc.alertLocation(resp, "매칭신청이 완료되었습니다.", "/MProject/myPage/MyPage.do?me_num="+me_num);
		}else {
			AlertFunc.alertLocation(resp, "매칭신청이 실패했습니다.", "/MProject/myPage/MyPage.do?me_num="+me_num);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//나에게 보낸 상대 회원번호가 들어와야됨
		String ma_from_num = req.getParameter("ma_from_num");
		String ma_to_num = req.getParameter("ma_to_num");
		
		HttpSession session = req.getSession();
		String me_num = (String)session.getAttribute("me_num");
		
		MyMatchingDAO dao = new MyMatchingDAO();
		int result = dao.rejectList(ma_from_num,ma_to_num);
		dao.close();
		if(result==1) {
			AlertFunc.alertLocation(resp, "해당 매칭목록이 삭제되었습니다.", "/MProject/myPage/MyPage.do?me_num="+me_num);
		}else{
			AlertFunc.alertBack(resp, "매칭목록 삭제 실패했습니다.");
		}
	}
}
