<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="fileUpDown.PracMyFileDTO"%>
<%@page import="fileUpDown.PracMyFileDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String saveDirectory = application.getRealPath("/Storage");
System.out.println(saveDirectory);
int maxPostSize = 1024 * 1000;
String encoding = "UTF-8";

try {
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);

	String fileName = mr.getFilesystemName("attachedFile");
	String ext = fileName.substring(fileName.lastIndexOf("."));
	String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
	String newFileName = now + ext;

	File oldFile = new File(saveDirectory + File.separator + fileName);
	File newFile = new File(saveDirectory + File.separator + newFileName);
	oldFile.renameTo(newFile);

	String name = mr.getParameter("name");
	String title = mr.getParameter("title");
	String[] cateArray = mr.getParameterValues("cate");
	StringBuffer cateBuf = new StringBuffer();
	if (cateArray == null) {
		cateBuf.append("선택 없음");
	} else {
		for (String s : cateArray) {
	cateBuf.append(s + ",");
		}
	}

	PracMyFileDTO dto = new PracMyFileDTO();
	dto.setName(name);
	dto.setTitle(title);
	dto.setCate(cateBuf.toString());
	dto.setOfile(fileName);
	dto.setNfile(newFileName);

	PracMyFileDAO dao = new PracMyFileDAO();
	dao.insertFile(dto);
	dao.close();

	response.sendRedirect("PracFileList.jsp");

} catch (Exception e) {
	e.printStackTrace();

	request.setAttribute("errMessage", "파일 업로드 오류");

	request.getRequestDispatcher("FileUploadMain.jsp").forward(request, response);
}
%>
