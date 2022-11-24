package reviewBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.AlertFunc;
import util.FileUtil;


@WebServlet("/reviewBoard/reviewPass.do")
public class ReviewPassController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/Review/ReviewPass.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 매개변수 저장
				String num = req.getParameter("num");
				String mode = req.getParameter("mode");
				String pass = req.getParameter("pass");
				
				// 비밀번호 확인
				ReviewDAO dao = new ReviewDAO();
				boolean confirmed = dao.confirmPassword(pass, num);
				dao.close();
				
				if(confirmed) { // 비밀번호 일치
					if (mode.equals("edit")) { // 수정 모드
						HttpSession session = req.getSession();
						session.setAttribute("pass", pass);
						resp.sendRedirect("../reviewBoard/reviewEdit.do?num="+num);
					}
					
					else if(mode.equals("delete")) { 
						dao = new ReviewDAO();
						ReviewDTO dto = dao.selectView(num);
						int result = dao.deletePost(num);
						dao.close();
						if(result==1) {
							String saveFileName = dto.getNfile();
							FileUtil.deleteFile(req, "/Storage", saveFileName);
						}
						
						AlertFunc.alertLocation(resp, "삭제되었습니다.", "../reviewBoard/reviewList.do");
					}
				}
				else { // 비밀번호 불일치
					AlertFunc.alertBack(resp, "비밀번호 검증에 실패했습니다.");
				}
	}
	
}
