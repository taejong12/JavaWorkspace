package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

//import utils.AlertFunc;

//import javax.servlet.jsp.JspWriter;


public class FileUtil {
//파일 업로드()MultiparT/form-data 요청) 처리
	public static MultipartRequest uploadFile(HttpServletRequest req,
		String saveDirectory, int maxPostSize) {
			try {
				return new MultipartRequest(req, saveDirectory,maxPostSize, "UTF-8");
			}catch(Exception e) {
				e.printStackTrace();
			return null;
			}
		
		}
		
		//파일 다운로드 처리 별도로 하기
		public static void download(HttpServletRequest req, HttpServletResponse resp
				,String directory, String sFilename, String oFilename) {
			String saveDirectory = req.getServletContext().getRealPath(directory);//메소드화하면 패스에다 디렉토리 입력.
		
			try{
				//서버에 있는 파일을 찾아 올 입력스트림 생성
				File file = new File(saveDirectory, sFilename); //저장되어있는 디렉토리와 파일명으로 이루어진 파일객체 생성
				InputStream inStream = new FileInputStream(file); //입력스트림 생성하고 파일객체 넣어줌
				
				//한글 파일명 깨짐 방지
				String client = req.getHeader("User-Agent");
				if(client.indexOf("WOW64")== -1){
				oFilename = new String(oFilename.getBytes("UTF-8"), "ISO-8859-1");
				}
				else{
				oFilename = new String(oFilename.getBytes("KSC5601"), "ISO-8859-1");
				}
				
				//파일 다운로드용 응답 헤더 설정
				resp.reset(); //충돌 방지를 위해 한번 리셋.
				//웹브라우저가 인식하지 못하는 ContentType(MIME)타입 설정. 브라우저가 인식할 수 있게 해줌. 여기선 8비트타입.
				resp.setContentType("application/octet-stream");
				//응답헤더명 "Content-Disposition", 응답헤더값 attachment;filename
				resp.setHeader("Content-Disposition", "attachment; filename=\""+oFilename+"\"");
				resp.setHeader("Content-Length",""+file.length()); //프로그레스바를 표시하기 위한 컨텐츠 길이 설정
				
				//출력스트림 초기화
				//out.clear(); //jsp에 이미 있는 out 이라는 출력스트림과 충돌하지 않기 위해 초기화시켜놓음.
				//out = pageContext.pushBody();
				
				//response 내장 객체로부터 웹브라우저에 연결할 새로운 출력스트림 생성
				OutputStream outStream = resp.getOutputStream();
				
				//출력스트림에 파일 내용 출력
				byte b[] = new byte[(int)file.length()]; // 리드버퍼에서 받아올 거니까 파일 컨텐츠만큼의 용량을 지정.
				int readBuffer = 0;
				while ((readBuffer = inStream.read(b))>0){ //서버에서 입력스트림으로 b용량만큼 받았을 때 그 값이 0보다 큰 동안, 버퍼에 그 내용을 담는다. 반복문이니까 리드버퍼의 전부를 담을 수 있다.
					outStream.write(b,0,readBuffer); //b[0]에서부터 readBuffer개의 바이트 데이터를 outStream으로 보내어 출력
					}
					//입/출력 스트림 닫음
					inStream.close();
					outStream.close();
				
				
			}catch(FileNotFoundException e){
				//AlertFunc.alertBack("파일을 찾을 수 없습니다", out);
				System.out.println("파일을 찾을 수 없습니다.");
				e.printStackTrace();
			}catch(Exception e){
				//AlertFunc.alertBack("예외가 발생하였습니다.", out);
				System.out.println("예외가 발생하였습니다.");
				e.printStackTrace();
			}
		}
		
		//파일 삭제
		public static void deleteFile(HttpServletRequest req, String filename, String directory) {
		String saveDirectory = req.getServletContext().getRealPath(directory);
		File file = new File(saveDirectory+File.separator+filename);
		if(file.exists()) {
		file.delete();
		}
	}
}
