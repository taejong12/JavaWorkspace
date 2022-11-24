package sign;

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

import utils.AlertFunc;
import utils.FileUtil;

@WebServlet("/controller/Sign.do")
public class SignController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 파일 업로드처리==========================================
		//업로드 디렉터리의 물리적 경로 확인
		String saveDirectory = req.getServletContext().getRealPath("/Storage");
		System.out.println(saveDirectory);
		
		// 초기화 매개변수로 설정한 첨부 파일 최대 용량 확인
		ServletContext application =  getServletContext();   
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		// 파일업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
	
		
		if(mr == null ) {
			// 파일업로드 실패
			AlertFunc.alertLocation(resp, "첨부 파일이 제한 용량을 초과합니다.","두번쨰페이지 주소");
		return;
		}
		//2.파일 업로드 외 처리; ==========
		// 폼값을 DTO에 저장
	//  DAO를 통해 DB에 게시 내용 저장
		
					JoinDAO dao  = new JoinDAO();
					JoinDTO dto = new JoinDTO();
				  
				      dto.setME_ID(req.getParameter("ME_ID"));
				      System.out.println(dto.getME_ID());
				      dto.setME_PASS(req.getParameter("ME_PASS"));
				      dto.setME_NAME(req.getParameter("ME_NAME"));
				      dto.setME_BIRTH(req.getParameter("ME_BIRTH"));
				      dto.setME_SEX(req.getParameter("ME_SEX"));
				      dto.setME_AGE(req.getParameter("ME_AGE"));      
				      dto.setME_PHONE(req.getParameter("ME_PHONE"));
				      dto.setME_EMAIL(req.getParameter("ME_EMAIL"));
				      dto.setME_KAKAO(req.getParameter("ME_KAKAO"));
				      dto.setRE_NUM(req.getParameter("RE_NUM"));     
				  
				      dao.insertWrite(dto);
				      dao.close();
		JoinDTO dto2  = new JoinDTO();
		HttpSession session = req.getSession();
		String me_num = (String)session.getAttribute("me_num");
//		int me_num = (int)session.getAttribute("me_num");
		String meid = (String)session.getAttribute("me_id");
		String mepass = (String)session.getAttribute("me_pass");
	
	
//		dto.setMe_num(mr.); 세션값 불러오기?
	//	dto.setMe_num(Integer.parseInt(mr.getParameter("me_num")));
		
		dto2.setME_NUM(me_num);		
//		dto.setIn_height(Integer.parseInt(mr.getParameter("in_height")));
		dto2.setIn_height(mr.getParameter("in_height"));
		dto2.setIn_style(mr.getParameter("in_style"));
		dto2.setIn_edu(mr.getParameter("in_edu"));
		dto2.setIn_rlg(mr.getParameter("in_rlg"));
		dto2.setIn_drunk(mr.getParameter("in_drunk"));
		dto2.setIn_smoke(mr.getParameter("in_smoke"));
		dto2.setIn_char(mr.getParameter("in_char"));
		dto2.setIn_mbti(mr.getParameter("in_mbti"));
		dto2.setIn_hobby(mr.getParameter("in_hobby"));
		dto2.setIn_job(mr.getParameter("in_job"));
		dto2.setIn_haspet(mr.getParameter("in_haspet"));
		dto2.setIn_opic(mr.getParameter("in_opic"));
		dto2.setIn_npic(mr.getParameter("in_npic"));
		dto2.setIn_ovoice(mr.getParameter("in_ovoice"));
		dto2.setIn_nvoice(mr.getParameter("in_nvoice"));
		dto2.setPe_num(mr.getParameter("pe_num"));

		System.out.println(dto2.getIn_opic());


		
//		원본 파일 명과 저장된 파일 이름 설정
				String fileName = mr.getFilesystemName("in_opic");
				if(fileName != null ) {
				//첨부 파일이	있을 경우 파일명 변경
				// 새로운 파일명 생성
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				String ext = fileName.substring(fileName.lastIndexOf("."));
				String newFileName = now+ ext;
					
					//파일명 변경
				File oldFile= new File(saveDirectory + File.separator+ fileName); 
				File newFile= new File(saveDirectory + File.separator+ newFileName); 
				oldFile.renameTo(newFile);
				System.out.println(newFileName);
				
				dto2.setIn_opic(fileName);//원래 파일 이름
				dto2.setIn_npic(newFileName);//서버에 저장된 파일 이름
				}
					
				String fileName1 = mr.getFilesystemName("in_ovoice");
				if(fileName1 != null ) {
					//첨부 파일이	있을 경우 파일명 변경
					// 새로운 파일명 생성
					String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
					String ext = fileName1.substring(fileName1.lastIndexOf("."));
					String newFileName1 = now+ ext;
				
					//파일명 변경
					File oldFile1= new File(saveDirectory + File.separator+ fileName1); 
					File newFile1= new File(saveDirectory + File.separator+ newFileName1); 
					oldFile1.renameTo(newFile1);
					System.out.println(newFileName1);
					
					dto2.setIn_ovoice(fileName1);//원래 파일 이름
					dto2.setIn_nvoice(newFileName1);//서버에 저장된 파일 이름
				}
		
			
				JoinDAO dao2  = new JoinDAO();
			    int result = dao2.insertWrite2(dto2);
				dao2.close();
					
				//성공 or 실패?
				//글쓰기 성공
				req.getRequestDispatcher("../02Join/Sign.jsp").forward(req, resp);
					resp.sendRedirect("../01MainPage/MainPage.jsp");
					
			}
}
