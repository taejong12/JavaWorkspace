<%@page import="java.io.FileReader"%>
<%@page import="smtp.NaverSmtp"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 폼값(이메일 내용) 저장
	Map<String, String> emailInfo = new HashMap<String, String>();
	emailInfo.put("from", request.getParameter("from")); // 보내는 사람
	emailInfo.put("to", request.getParameter("to")); // 받는 사람
	emailInfo.put("subject", request.getParameter("subject")); // 제목
	
	// 내용은 메일 포맷에 따라 다르게 처리
	String content = request.getParameter("content"); // 내용
	String format = request.getParameter("format"); // 메일 포맷(text 혹은 html)
	if (format.equals("text")) {
		
		// 텍스트 포맷일 때는 그대로 저장
		emailInfo.put("content", content);
		emailInfo.put("format", "text/plain;charset=UTF-8");
	}
	else if (format.equals("html")) {
		
		// HTML 포맷일 때는 HTML 형태로 변환해 저장
		content = content.replace("\r\n", "<br/>"); // 줄바꿈을 HTML 형태로 수정
		
		// HTML 용으로 변환된 내용을 담을 변수
		String htmlContent = ""; 
		
		try{
			// HTML 메일용 템플릿 파일 읽기
			String templatePath = application.getRealPath("/15SendEmail/MailForm.html");
			BufferedReader br = new BufferedReader(new FileReader(templatePath));
			
			// 한 줄씩 읽어 htmlContent 변수에 저장
			String oneLine;
			while ((oneLine = br.readLine()) != null) {
				htmlContent += oneLine + "\n";
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		// 템플릿의 "__CONTENT__" 부분을 메일 내용 대체 (변환 완료)
		htmlContent = htmlContent.replace("__CONTENT__", content);
		
		// 변환된 내용을 저장
		emailInfo.put("content", htmlContent);
		emailInfo.put("format", "text/html;charset=UTF-8");
		
	}
	
	try{
		NaverSmtp smtpServer = new NaverSmtp(); // 메일 전송 클래스 생성
		smtpServer.emailSending(emailInfo); // 전송
		out.print("이메일 전송 성공");
	} catch (Exception e){
		out.print("이메일 전송 실패");
		e.printStackTrace();
	}
%>

<%-- 전부 다 스크립틀릿으로 작성했다(자바소스)
	보내는걸 처리해주는 애가 임포트 네이버stmp
	이메일 보냄
	이 방식은 해당하는 라이브러리 안쪽에서 실제로 smtp 활용하는 예문 검색해서 파악해야 한다
	만들어 놓은 기본적인 기능
	조건이 있어야 네이버 서버에 접근 가능
	기본적인 설정을 해줘야 한다
	사용자가 들어가야 하니까 사용자에 대한 부분 작성
	이메일 샌딩 메서드에 실제로 보내는 기능
	이메일 보내는거에 형식이 정해져 있다
	받은 형태를 정해진 형식으로 보낸다
	네이버 서버 접근 셋팅이랑 문제가 없다면 보내진다
	뒤에 메일을 실제로 보내주는건 네이버 서버다
	내 메일 이름으로 그 쪽 서버에 보내진다 --%>

