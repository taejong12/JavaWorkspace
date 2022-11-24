<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fileUpDown.MyFileDTO"%>
<%@page import="fileUpDown.MyFileDAO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 저장동작 --%>
<%-- 
	파일 업로드할 때 필요한것 MultipartRequest 객체 생성 
	request,
	application.실제경로("/폴더명");
--%>

<%
	String saveDirectory = application.getRealPath("/Storage"); // 저장할 디렉터리
	System.out.println(saveDirectory);
	int maxPostSize = 1024 * 1000; // 파일 최대 크기(1MB)
	String encoding = "UTF-8"; // 인코딩 방식
	
	try{
		// 1. MultipartRequest 객체 생성
		MultipartRequest mr = new MultipartRequest(request, saveDirectory,
													maxPostSize, encoding);
		
		// 2. 새로운 파일명 생성
		String fileName = mr.getFilesystemName("attachedFile"); // 현재 파일 이름
		String ext = fileName.substring(fileName.lastIndexOf(".")); // 파일 확장자
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		String newFileName = now + ext; // 새로운 파일 이름("업로드일시.확장자")
		
		// 3. 파일명 변경
		File oldFile = new File(saveDirectory + File.separator + fileName);
		File newFile = new File(saveDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		// 4. 다른 폼값 받기
		String name= mr.getParameter("name");
		String title= mr.getParameter("title");
		String[] cateArray = mr.getParameterValues("cate");
		StringBuffer cateBuf = new StringBuffer();
		if (cateArray == null){
			cateBuf.append("선택 없음");
		} else {
			for(String s : cateArray) {
				cateBuf.append(s+",");
			}
			
		}
		
		// 5. DTO 생성
		MyFileDTO dto = new MyFileDTO();
		dto.setName(name);
		dto.setTitle(title);
		dto.setCate(cateBuf.toString());
		dto.setOfile(fileName);
		dto.setNfile(newFileName);
		
		// 6. DAO를 통해 데이터베이스에 반영
		MyFileDAO dao = new MyFileDAO();
		dao.insertFile(dto);
		dao.close();
		
		// 7.파일 목록 jsp로 리디렉션
		response.sendRedirect("FileList.jsp");
		
	} catch (Exception e){
		e.printStackTrace();
		
		//에러 리퀘스트에 셋팅
		request.setAttribute("errMasge", "파일 업로드 오류");
		
		//밑에 리퀘스트에 저장되서 같이 전달
		//파일 업로드 쪽에 에러메시지 작성하면 에러 났을 때 뜬다
		request.getRequestDispatcher("FileUploadMain.jsp").forward(request, response);
	}

%>

<%-- 파일이름이랑 확장자까지 나온다
.확장자
.이 여러개 들어가는 경우도 있어서 제일 마지막에 들어가는 점을 기준으로 확장자만 들어온다 ext
포맷팅해서 집어넣은 날짜 이름
날짜이름이랑 확장자랑 합치면 새로운 파일 이름이 된다

올드파일
클라이언트에서 옮겨간 파일 

클라이언트에서 서버쪽에 멀티파트 하는 순간 넘어간 파일 이름
파일 이름을 지칭하기 위한 객체를 만든다
이름이랑 위치변경을 하기 위해서 새로 만든 객체에 넣어준다
 이름이랑 패스경로를 새로 만든 객체로 옮겨준다
 이전 파일을 새 파일로 만들어준다
 리네임으로 바꿔주면서 옮겨준다
 
 그 다음
 리퀘스트를 받는 mr
 mr로 다 연결해서 받는다
 카테고리 여러개 같이 온다
 
 전달받은 폼값을 정리
 
 맨 마지막에 테이블에 정보를 넣어준다
 
 파일을 파일대로 파일정보는 파일정보대로 따로 정리해야 한다--%>
 
