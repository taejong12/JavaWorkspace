<%@page import="java.io.PrintWriter"%>
<%@page import="sign.JoinDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
   //ajax로 값을 받기 때문에 UTF-8로 인코딩해준다
   response.setCharacterEncoding("EUC-KR");

   
   String userKakao = request.getParameter("userKakao");
   //join.jsp에서 받아온 key값이 userId이고
   //value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
   PrintWriter outs = response.getWriter();
         
   JoinDAO dao = new JoinDAO();
         
   
   int kakaoCheck = dao.checkKakao(userKakao);
   
         
   if (kakaoCheck == 0 ) {
      System.out.println("이미 존재하는 카카오ID입니다.");
   } else if (kakaoCheck == 1) {
      System.out.println("사용 가능한 카카오ID입니다.");
   }         
   outs.write(kakaoCheck + ""); // --> ajax 결과값인 result가 됨
         // --> String으로 값을 내보낼 수 있도록 + "" 를 해준다
   
   
%>