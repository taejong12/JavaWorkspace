package qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AlertFunc;
import utils.FileUtil;

@WebServlet("/qnasBoard/qnasPass.do")
public class QnasPassController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/07QnABoard/QnasPass.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 매개변수 저장
				String num = req.getParameter("num");
				String mode = req.getParameter("mode");
				String pass = req.getParameter("pass");
				
				// 비밀번호 확인
				QnasDAO dao = new QnasDAO();
				boolean confirmed = dao.confirmPassword(pass, num);
				dao.close();
				
				if(confirmed) { // 비밀번호 일치
					if (mode.equals("edit")) { // 수정 모드	
						HttpSession session = req.getSession();
						session.setAttribute("pass", pass);
						resp.sendRedirect("../qnasBoard/qnasEdit.do?num="+num);
					}
					
					else if(mode.equals("delete")) {
						dao = new QnasDAO();
						QnasDTO dto = dao.selectView(num);
						int result = dao.deletePost(num);
						dao.close();
						if(result==1) {
							String saveFileName = dto.getNfile();
							FileUtil.deleteFile(req, "/Storage", saveFileName);
						}
						AlertFunc.alertLocation(resp, "삭제되었습니다.", "../qnasBoard/qnasList.do");
					}
				}
				else { // 비밀번호 불일치
					AlertFunc.alertBack(resp, "비밀번호 검증에 실패했습니다.");
				}
	}
	
}
