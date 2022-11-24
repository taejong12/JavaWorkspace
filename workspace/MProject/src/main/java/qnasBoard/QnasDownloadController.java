package qnasBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.FileUtil;


@WebServlet("/qnas/qnasdownload.do")
public class QnasDownloadController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//매개변수 받기
		String ofile = req.getParameter("ofile");	//원본 파일명
		String nfile = req.getParameter("nfile");	//저장된 파일명
		String num = req.getParameter("num");		//게시물 일련번호
		System.out.println(nfile);
		//파일 다운로드
		FileUtil.download(req, resp, "/Storage", nfile, ofile);

		
	}
	
}
