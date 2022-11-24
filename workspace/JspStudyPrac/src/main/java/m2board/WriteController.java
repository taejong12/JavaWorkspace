package m2board;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import fileUpDown.FileUtil;
import utils.AlertFunc;

	//	두겟 겟방식
	//	해당 주소로 접근
	//	디스패치로 라이트 jsp로 보낸다
	//	일반 주소는 작성하는 페이지
	//	
	//	데이터를 포함하는 방식은 포스트로 온다
	//	
	//	둘 다 라이트컨트롤러로 온다
	//	
	//	글쓰기 메서드를 설정하지 않았으니 디폴트 겟방식으로 온다
	//	
	//	데이터를 포함했느냐가 중요한게 아니라 메서드가 get인지 post인지가 중요하다
	//	
	//	한개의 컨트롤러로 다른 메서드들을 받아줄 수 있다

public class WriteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.getRequestDispatcher("/14M2Board/Write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//	1. 파일 업로드 처리
		//	업로드 디렉터리의 물리적 경로 확인
		String saveDirectory =req.getServletContext().getRealPath("/Storage");
		
		//	초기화 매개변수로 설정한 첨부 파일 최대 용량 확인
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		//	파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		if(mr==null) {
			
			//	파일 업로드 실패
			AlertFunc.alertLocation(resp, "첨부 파일이 제한 용량을 초과합니다", 
						"../m2board/write.do");
			return;
		}
		
		//	2. 파일 업로드 외 처리 ==================
		//	폼값을 DTO에 저장
		MBoardDTO dto = new MBoardDTO();
		dto.setName(mr.getParameter("name"));
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		dto.setPass(mr.getParameter("pass"));
		
		//	원본 파일명과 저장된 파일 이름 설정
		String fileName = mr.getFilesystemName("ofile");
		
		if(fileName != null) {
			
			//	첨부 파일이 있을 경우 파일명 변경
			//	새로운 파일명 생성
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = now + ext;
			System.out.println(newFileName);
			
			//	파일명 변경
			File oldFile = new File(saveDirectory + File.separator + fileName);
			File newFile = new File(saveDirectory + File.separator + newFileName);
			oldFile.renameTo(newFile);
			
			
			dto.setOfile(fileName);	//	원래 파일 이름
			dto.setNfile(newFileName);	//	 서버에 저장된 파일 이름
		}
		
		//	DAO를 통해 DB에 게시 내용 저장
		MBoardDAO dao = new MBoardDAO();
		int result = dao.insertWrite(dto);
		dao.close();
		
		
		//	성공 or 실패?
		if(result == 1) { //	글쓰기 성공
			resp.sendRedirect("../m2board/list.do");
		}
		else { //	글쓰기 실패
			resp.sendRedirect("../m2board/write.do");
		}

	}

	
	
	
	
	
	
}
