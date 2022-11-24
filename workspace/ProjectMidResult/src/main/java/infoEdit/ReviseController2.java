package infoEdit;

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

import sign.JoinDTO;
import utils.AlertFunc;
import utils.FileUtil;

@WebServlet("/controller/Revise2.do")
public class ReviseController2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String me_num = req.getParameter("me_num");
		ReviseDAO dao = new ReviseDAO();
		JoinDTO dto = dao.selectView(me_num);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/05InfoEdit/Revise.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 파일 업로드 처리================================
		//업로드 디렉터리의 물리적 경로 확인
		String saveDirectory = req.getServletContext().getRealPath("/Storage");

		//초기화 매개변수로 설정한 첨부 파일 최대 용량 확인
		ServletContext application = this.getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));

		//파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);

		if(mr==null) {
		//파일 업로드 실패
		AlertFunc.alertBack(resp, "첨부파일이 제한 용량을 초과합니다.");
		return;
		}

		//2. 파일 업로드 외 처리
		HttpSession session = req.getSession();
		//수정 내용을 폼값에서 넘어온 매개변수에서 얻기
		String me_num = mr.getParameter("me_num");
		String prevOpic = mr.getParameter("prevOpic");
		String prevNpic = mr.getParameter("prevNpic");
		String prevOvoice = mr.getParameter("prevOvoice");
		String prevNvoice = mr.getParameter("prevNvoice");

		String in_height = mr.getParameter("in_height");
		String in_style = mr.getParameter("in_style");
		String in_edu = mr.getParameter("in_edu");
		String in_rlg = mr.getParameter("in_rlg");
		String in_drunk = mr.getParameter("in_drunk");
		String in_smoke = mr.getParameter("in_smoke");
		String in_char = mr.getParameter("in_char");
		String in_mbti = mr.getParameter("in_mbti");
		String in_hobby = mr.getParameter("in_hobby");
		String in_job = mr.getParameter("in_job");
		String in_haspet = mr.getParameter("in_haspet");
		

		//DTO에 저장
		JoinDTO dto = new JoinDTO();
		dto.setME_NUM(me_num);
		dto.setIn_height(in_height);
		dto.setIn_style(in_style);
		dto.setIn_edu(in_edu);
		dto.setIn_rlg(in_rlg);
		dto.setIn_drunk(in_drunk);
		dto.setIn_smoke(in_smoke);
		dto.setIn_char(in_char);
		dto.setIn_mbti(in_mbti);
		dto.setIn_hobby(in_hobby);
		dto.setIn_job(in_job);
		dto.setIn_haspet(in_haspet);
		
		//사진
		//원본 파일명과 저장된 파일 이름 생성
		String fileName1=mr.getFilesystemName("in_opic2");
		if(fileName1 != null) {
			//첨부파일이 있는 경우 파일명 변경
			//새로운 파일명 생성
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = fileName1.substring(fileName1.lastIndexOf("."));
			String newFileName = now+ext;
	
			//파일명 변경
			File oldFile = new File(saveDirectory+File.separator+fileName1);
			File newFile = new File(saveDirectory+File.separator+newFileName);
			oldFile.renameTo(newFile);
	
			//DTO에 저장
			dto.setIn_opic(fileName1); //원래 파일명
			dto.setIn_npic(newFileName); //서버에 저장될 방식
	
			//기존 파일 삭제
			FileUtil.deleteFile(req, "/Storage", prevNpic);
		}else {
			//첨부 파일이 없으면 기존이름 유지
			dto.setIn_opic(prevOpic);
			dto.setIn_npic(prevNpic);
		}
		//보이스파일
		//원본 파일명과 저장된 파일 이름 생성
		String fileName2=mr.getFilesystemName("in_ovoice2");
		if(fileName2 != null) {
			//첨부파일이 있는 경우 파일명 변경
			//새로운 파일명 생성
			String now2 = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext2 = fileName2.substring(fileName2.lastIndexOf("."));
			String newFileName2 = now2+ext2;
	
			//파일명 변경
			File oldFile2 = new File(saveDirectory+File.separator+fileName2);
			File newFile2 = new File(saveDirectory+File.separator+newFileName2);
			oldFile2.renameTo(newFile2);
	
			//DTO에 저장
			dto.setIn_ovoice(fileName2); //원래 파일명
			dto.setIn_nvoice(newFileName2); //서버에 저장될 방식
	
			//기존 파일 삭제
			FileUtil.deleteFile(req, "/Storage", prevNvoice);
		}else {
			//첨부 파일이 없으면 기존이름 유지
			dto.setIn_ovoice(prevOvoice);
			dto.setIn_nvoice(prevNvoice);
		}

		//DB에 수정내용 반영
		ReviseDAO dao = new ReviseDAO();
		int result = dao.UpdateRevise2(dto);
		dao.close();

		//성공? 실패'?
		if(result==1) {//수정 성공
		session.invalidate();
		AlertFunc.alertLocation(resp, "수정이 완료되었습니다. 다시 로그인해주세요", "../reviewBoard/ReviewMainPage.do");
		//resp.sendRedirect("../reviewBoard/ReviewMainPage.do");
		}
		else {
		AlertFunc.alertLocation(resp, "비밀번호 검증을 다시 진행해주세요", "../controller/VRevise.do");
		}
	}
}
