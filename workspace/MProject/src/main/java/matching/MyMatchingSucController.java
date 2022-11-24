package matching;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.AlertFunc;

public class MyMatchingSucController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//매칭신청목록 DB에 저장
		MyMatchingDAO dao = new MyMatchingDAO();
		
		String ma_sfrom_num = req.getParameter("ma_sfrom_num");
		String ma_sto_num = req.getParameter("ma_sto_num");
		String ma_sfrom_name = req.getParameter("ma_sfrom_name");
		String ma_sto_name = req.getParameter("ma_sto_name");
		
		HttpSession session = req.getSession();
		String me_num = (String)session.getAttribute("me_num");
		
		//찍어보기
		System.out.println(ma_sfrom_num);
		System.out.println(ma_sfrom_name);
		System.out.println(ma_sto_num);
		System.out.println(ma_sto_name);
		
		
		
		MyMatchingDTO dto = new MyMatchingDTO();
		dto.setMa_sfrom_num(Integer.parseInt(ma_sfrom_num));
		dto.setMa_sto_num(Integer.parseInt(ma_sto_num));
		dto.setMa_sfrom_name(ma_sfrom_name);
		dto.setMa_sto_name(ma_sto_name);
		//DAO에 있는 메소드로 DB에 저장
		int result = dao.insertSucList(dto);
		System.out.println(result);
		dao.close();
		
		if(result==1) {
			util.AlertFunc.alertLocation(resp, "매칭신청이 완료되었습니다.", "/MProject/myPage/MyPage.do?me_num="+me_num);
		}else {
			AlertFunc.alertLocation(resp, "매칭신청이 실패했습니다.", "/MProject/myPage/MyPage.do?me_num="+me_num);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//나에게 보낸 상대 회원번호가 들어와야됨
		String ma_sfrom_num = req.getParameter("ma_sfrom_num");
		String ma_sto_num = req.getParameter("ma_sto_num");
		HttpSession session = req.getSession();
		String me_num = (String)session.getAttribute("me_num");
		
		MyMatchingDAO dao = new MyMatchingDAO();
		int result = dao.rejectList(ma_sfrom_num,ma_sto_num);
		dao.close();
		if(result==1) {
			AlertFunc.alertLocation(resp, "성공적으로 삭제하였습니다.", "/MProject/myPage/MyPage.do?me_num="+me_num);
		}else {
			AlertFunc.alertLocation(resp, "삭제에 실패하였습니다..", "/MProject/myPage/MyPage.do?me_num="+me_num);
		}
	}
}
