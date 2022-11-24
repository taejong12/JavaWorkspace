package qnasBoard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import util.AlertFunc;
import util.FileUtil;

@WebServlet("/qnasBoard/qnasEdit.do")
public class QnasEditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String num = req.getParameter("num");
		QnasDAO dao = new QnasDAO();
		QnasDTO dto = dao.selectView(num);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/Qnas/QnasEdit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 1. 파일 업로드 처리
		// 업로드 디렉터리의 물리적 경로 확인
		String saveDirectory = req.getServletContext().getRealPath("/Storage");
		
		// 초기화 매개변수로 설정한 첨부 파일 최대 용량
		ServletContext application = this.getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		// 파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr == null) {
	        //파일 업로드 실패
	        AlertFunc.alertBack(resp, "첨부 파일이 제한 용량을 초과합니다.");
	        return;
	    }

		// 2. 파일 업로드 외 처리 ============================
		// 수정 내용을 매개변수에서 얻어옴
		String num = mr.getParameter("num");
		String prevOfile = mr.getParameter("prevOfile");
		String prevNfile = mr.getParameter("prevNfile");
		
		String name = mr.getParameter("name");
		String content = mr.getParameter("content");
		
		// 비밀번호는 session에서 가져옴
		HttpSession session = req.getSession();
		String pass = (String)session.getAttribute("pass");
		
		// DTO에 저장
		QnasDTO dto = new QnasDTO();
		dto.setNum(num);
		dto.setName(name);
		dto.setContent(content);
		dto.setPass(pass);
		System.out.println("수정:"+dto.getNum());
		System.out.println(dto.getName());
		System.out.println(dto.getContent());
		System.out.println(dto.getPass());
		
		// 원본 파일명과 저장된 파일 이름 설정
		String fileName = mr.getFilesystemName("ofile");
		if (fileName != null) {
		
			// 첨부 파일이 있을 경우 파일명 변경
			// 새로운 파일명 생성
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = now +ext;
			
			// 파일명 변경
			File oldFile = new File(saveDirectory + File.separator + fileName);
			File newFile = new File(saveDirectory + File.separator + newFileName);
			oldFile.renameTo(newFile);
			
			// DTO에 저장
			dto.setOfile(fileName); // 원래 파일 이름
			dto.setNfile(newFileName); // 서버에 저장된 파일 이름
			
			//기존 파일 삭제
	        FileUtil.deleteFile(req, "/Storage", prevNfile);
	
		}
		else {
			
			// 첨부 파일이 없으면 기존 이름 유지
			dto.setOfile(prevOfile); // 원래 파일 이름
			dto.setNfile(prevNfile); // 서버에 저장된 파일 이름
		}
		
		// DB에 수정 내용 반영
		QnasDAO dao = new QnasDAO();
		int result = dao.updatePost(dto);
		dao.close();
		
		// 성공 or 실패?
		if (result == 1) { // 수정 성공
			session.removeAttribute("pass");
			resp.sendRedirect("../qnasBoard/qnasView.do?num="+num);
		}
		else { // 수정 실패
			AlertFunc.alertLocation(resp, "비밀번호 검증을 다시 진행해주세요.", "../qnasBoard/qnasView.do?num=" + num);
		}
	}
}