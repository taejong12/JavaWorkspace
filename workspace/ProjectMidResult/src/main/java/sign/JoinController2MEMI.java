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

//MEMINFOS --텍스트 회원가입
//===================================


@WebServlet("/controller/Join2.do")
public class JoinController2MEMI extends HttpServlet {


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
		JoinDTO dto  = new JoinDTO();
		HttpSession session = req.getSession();
		String me_num = (String)session.getAttribute("me_num");
//		int me_num = (int)session.getAttribute("me_num");
		String meid = (String)session.getAttribute("me_id");
		String mepass = (String)session.getAttribute("me_pass");
	
	
//		dto.setMe_num(mr.); 세션값 불러오기?
	//	dto.setMe_num(Integer.parseInt(mr.getParameter("me_num")));
		
		//1103 타입변환
		String k = mr.getParameter("in_height");
		dto.setIn_height(k);
		
		dto.setME_NUM(me_num);
		
//		dto.setIn_height(Integer.parseInt(mr.getParameter("in_height")));
		dto.setIn_style(mr.getParameter("in_style"));
		dto.setIn_edu(mr.getParameter("in_edu"));
		dto.setIn_rlg(mr.getParameter("in_rlg"));
		dto.setIn_drunk(mr.getParameter("in_drunk"));
		dto.setIn_smoke(mr.getParameter("in_smoke"));
		dto.setIn_char(mr.getParameter("in_char"));
		dto.setIn_mbti(mr.getParameter("in_mbti"));
		dto.setIn_hobby(mr.getParameter("in_hobby"));
		dto.setIn_job(mr.getParameter("in_job"));
		dto.setIn_haspet(mr.getParameter("in_haspet"));
		dto.setIn_opic(mr.getParameter("in_opic"));
		dto.setIn_npic(mr.getParameter("in_npic"));
		dto.setIn_ovoice(mr.getParameter("in_ovoice"));
		dto.setIn_nvoice(mr.getParameter("in_nvoice"));
		dto.setPe_num(mr.getParameter("pe_num"));

		System.out.println(dto.getIn_opic());


		
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
				
				dto.setIn_opic(fileName);//원래 파일 이름
				dto.setIn_npic(newFileName);//서버에 저장된 파일 이름
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
					
					dto.setIn_ovoice(fileName1);//원래 파일 이름
					dto.setIn_nvoice(newFileName1);//서버에 저장된 파일 이름
				}
				
				//  DAO를 통해 DB에 게시 내용 저장
			
				JoinDAO dao  = new JoinDAO();
				int result = dao.insertWrite2(dto);
				dao.close();
					
				if(result==1) {
			    	  AlertFunc.alert(resp, "회원가입에 성공하셨습니다. 다시 로그인해주세요");
			    	  resp.sendRedirect("../01MainPage/MainPage.jsp");
			    }else {
			    	  AlertFunc.alertBack(resp, "다시 등록해주세요");
			    }	
			}
	}
			

		
		
		
	

