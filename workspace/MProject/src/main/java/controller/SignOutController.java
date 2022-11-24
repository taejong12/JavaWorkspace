package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import joinProc.JoinDAO;
import util.AlertFunc;

@WebServlet("/controller/SignOut.do")
public class SignOutController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//현재 로그인 되어있는 사람의 회원번호를 VIEW단인 Revise.jsp의 381번 줄에 있는 회원탈퇴 버튼으로, request 단에 "me_num" 이라는 키값으로 전달받았다.
		//이 곳에서 사용하기 위해 me_num 에 저장.
		String me_num = req.getParameter("me_num");
		System.out.println(me_num);
		
		//회원기본정보 테이블 MEMBERS 데이터 중 나의 회원번호와 같은 번호로 ME_NUM을 가진 데이터를 지움으로서 회원탈퇴를 한다.
		//이를 위해 MODEL단에 구현한 기능인 signOut 메소드를 사용한다.
		JoinDAO dao1 = new JoinDAO();
		int result1 = dao1.signOut(me_num);
		
		System.out.println(result1);
		
		//사용순서의 역순인 rs, (stmt,psmt), con 순으로 종료해주는 JDBConnect에 있는 메소드 close를 사용하여 dao1을 종료해준다.
		dao1.close();
		
		//회원기본정보 테이블 MEMINFOS 데이터 중 나의 회원번호와 같은 번호로 ME_NUM을 가진 데이터도 지워줘야한다..
		//이를 위해 MODEL단에 구현한 기능인 signOut2 메소드를 사용한다.
		JoinDAO dao2 = new JoinDAO();
		int result2 = dao2.signOut2(me_num);
		
		System.out.println(result2);
		
		//사용순서의 역순인 rs, (stmt,psmt), con 순으로 종료해주는 JDBConnect에 있는 메소드 close를 사용하여 dao2을 종료해준다.
		dao2.close();
		
		//두 실행 결과에 따라 얼랏으로 반응해준다.
		if(result1==1 && result2==1) {
			AlertFunc.alertLocation(resp, "성공적으로 삭제되었습니다.", "../01MainPage/MainPage.jsp");
		}else if(result1==1 && result2!=1) {
			AlertFunc.alertBack(resp, "회원기본정보만 삭제되었습니다");
		}else if(result1!=1 && result2==1) {
			AlertFunc.alertBack(resp, "회원추가정보만 삭제되었습니다");
		}else {
			AlertFunc.alertBack(resp, "회원탈퇴에 실패했습니다");
		}
		
		//세션에 저장된 회원의 정보들을 삭제해주기 위해 세션객체를 만들어준다.
		HttpSession session = req.getSession();
		
		//세션에 저장된 정보를 날리는 메소드 invalidate 를 실행해서 정보들을 삭제해준다.
		session.invalidate();
	}

}
