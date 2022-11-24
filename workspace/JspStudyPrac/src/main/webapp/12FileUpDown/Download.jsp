<%@page import="utils.AlertFunc"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 파일 다운로드 -->
<!DOCTYPE html>
<%
	String saveDirectory = application.getRealPath("/Storage");
	String saveFilename = request.getParameter("nName").trim();
	String originalFilename = request.getParameter("oName").trim();
	
	try {
		// 파일을 찾아 입력 스트림 생성
		File file = new File(saveDirectory, saveFilename);
		InputStream inStream = new FileInputStream(file);
		
		// 한글 파일명 깨짐 방지
		String client = request.getHeader("User-Agent");
		if (client.indexOf("WOW64") == -1) {
			originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
		} else {
			originalFilename = new String(originalFilename.getBytes("KSC5601"), "ISO-8859-1");
		}
		
		// 파일 다운로드용 응답 헤더 설정
		response.reset();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\""+originalFilename+"\"");
		response.setHeader("Content-Length", ""+file.length());
		
		// 출력 스트림 초기화
		out.clear();
		
		// response 내장 객체로부터 새로운 출력 스트림 생성
		OutputStream outStream = response.getOutputStream();
		
		// 출력 스트림에 파일 내용 출력
		byte b[] = new byte[(int)file.length()];
		int readBuffer=0;
		while((readBuffer = inStream.read(b)) > 0) {
			outStream.write(b,0,readBuffer);
		}
		
		// 입/출력 스트림 닫음
		inStream.close();
		outStream.close();
		
	} catch (FileNotFoundException e){
		AlertFunc.alertBack("파일을 찾을 수 없습니다", out);
		
	} catch (Exception e){
		AlertFunc.alertBack("예외가 발생하였습니다.", out);
	}
%>

<!-- 

	최종다운은 브라우저에서 한다
	WAS 자바 입장에서는 파일도 서버 밖에 있고 브라우저도 밖에 있다
	저쪽에서 파일을 받아와서 외부에 출력을 해줘야 한다
	입력 스트림과 아웃 스트림을 사용
	
	파일인풋스트림
	파일 내용 경로를 통해 파일객체를 만듬
	
	한글이 깨져서 하는거
	유저 에이전트 정보를 받아오는 이유
	현재 사용하고 있는 브라우저가 어떤건지 파악하기 위해
	이프 조건절에서 인터넷 익스플로 확인 
	영어쓰면 필요없음
	
	중요한건
	클라이언트 블아줘 리스폰스
	쪽으로 보낼 헤더를 만들어야 한다
	파일 정보값은 단순하게 안 보내짐
	파일 정보값을 넣기 위한 헤더 구조를 짜야함
	파일이 아닌 파일 정보값을 보내는거임
	셋팅한 정보를 바탕으로 리스폰스에서 아웃풋스트림을 받아온다
	
	인풋스트림에서 정보를 받아와서 아웃풋스트림으로 보내준다
	아웃풋스트림을 받은 내 쪽에서 다운로드 받겠냐고 뜨면서 실행
	
	파일서버에 있는 파일을 인풋스트림으로 불러와서 브라우저로 아웃풋스트림으로 전달
	
-->
	
	
</body>
</html>