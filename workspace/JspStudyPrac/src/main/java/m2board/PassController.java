package m2board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fileUpDown.FileUtil;
import utils.AlertFunc;


// 여기는 jsp에서 실행시켰던 서버랑 방식이 다르다
// jsp 직접 접근
// was에서 해당하는 내용을 가지고 그 주소로 접근
// 접근하는 방식이 다르다
// was서버값 /JspStudyPrac(contextpath) 초기에 설정한 여기에 url패턴과 매칭해서 사용

@WebServlet("/m2board/pass.do")
public class PassController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/14M2Board/Pass.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 매개변수 저장
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		
		// 비밀번호 확인
		MBoardDAO dao = new MBoardDAO();
		boolean confirmed = dao.confirmPassword(pass, idx);
		dao.close();
		
		if(confirmed) { // 비밀번호 일치
			if (mode.equals("edit")) { // 수정 모드
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				resp.sendRedirect("../m2board/edit.do?idx="+idx);
			}
			
			else if(mode.equals("delete")) { // 삭제 모드
				dao = new MBoardDAO();
				MBoardDTO dto = dao.selectView(idx);
				int result = dao.deletePost(idx); // 게시물 삭제
				dao.close();
				if(result==1) { // 게시물 삭제 성공 시 첨부파일도 삭제
					String saveFileName = dto.getNfile();
					FileUtil.deleteFile(req, "/Storage", saveFileName);
				}
				AlertFunc.alertLocation(resp, "삭제되었습니다.", "../m2board/list.do");
			}
		}
		else { // 비밀번호 불일치
			AlertFunc.alertBack(resp, "비밀번호 검증에 실패했습니다.");
		}
	}

}
