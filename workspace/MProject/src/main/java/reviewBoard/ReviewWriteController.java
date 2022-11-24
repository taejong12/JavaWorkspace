package reviewBoard;

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



@WebServlet("/reviewBoard/reviewWrite.do")
public class ReviewWriteController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Review/ReviewWrite.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDirectory =req.getServletContext().getRealPath("/Storage");
		System.out.println(saveDirectory);
		
	    HttpSession session = req.getSession();
	    System.out.println(session.getAttribute("me_num"));
	    System.out.println(session.getAttribute("me_id"));
	    System.out.println(session.getAttribute("me_name"));
	    
		//	초기화 매개변수로 설정한 첨부 파일 최대 용량 확인
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		//	파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		if(mr==null) {
			
			//	파일 업로드 실패
			AlertFunc.alertLocation(resp, "첨부 파일이 제한 용량을 초과합니다", 
						"../reviewBoard/reviewWrite.do");
			return;
		}
		
		//	2. 파일 업로드 외 처리 ==================
		//	폼값을 DTO에 저장
		ReviewDTO dto = new ReviewDTO();
		dto.setMenum((String) session.getAttribute("me_num"));
		dto.setRV_POSTNAME(mr.getParameter("RV_POSTNAME"));
		dto.setName(mr.getParameter("name"));
		dto.setContent(mr.getParameter("content"));
		dto.setPass(mr.getParameter("pass"));
		dto.setStar(Integer.parseInt(mr.getParameter("star")));
		System.out.println("글쓰기"+mr.getParameter("content"));
		System.out.println(mr.getParameter("name"));
		System.out.println(mr.getParameter("pass"));
		System.out.println(mr.getParameter("star"));
		System.out.println(session.getAttribute("me_num"));
		System.out.println(mr.getParameter("RV_POSTNAME"));
		
		
		
		
		
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
		ReviewDAO dao = new ReviewDAO();
		int result = dao.insertWrite(dto);
		dao.close();
		
		
		//	성공 or 실패?
		if(result == 1) { //	글쓰기 성공
			resp.sendRedirect("../reviewBoard/reviewList.do");
		}
		else { //	글쓰기 실패
			resp.sendRedirect("../reviewBoard/reviewWrite.do");
		}

	}
}
