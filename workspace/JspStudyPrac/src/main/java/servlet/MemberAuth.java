package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;

//	jsp에서 눌렀을 때 web.xml을 통해 자바클래스(서블릿)에서 동작실행

public class MemberAuth extends HttpServlet {
	
	//	해당하는 db에 관한 커넥션을 관리하는게 1번이다
	//	DAO는 JDBC를 상속받았다 디비 접근하기 위해 멤버변수로 생성
	//	서비스할 때마다 새로운 커넥션을 할 필요없기 때문에 init에 dao변수를 넣어준다
	MemberDAO dao;
	
	@Override
	public void init() throws ServletException {
		
		//	이미 서블릿을 상속받고 있고 있으니
		//	받기만 하면 안되고 어딘가에 할당해야 한다
		//	자바는 리퀘스트 안에 서블릿 컨텍스트에서 어플리케이션 경로를 통해 파라미터를 받아야 한다
		ServletContext application = this.getServletContext();
		
		//web.xml에 초기값으로 설정해놓았다
		// 초기화 멤버변수
		
		String driver = application.getInitParameter("OracleDriver");
		String url = application.getInitParameter("OracleUrl");
		String id = application.getInitParameter("OracleId");
		String pw = application.getInitParameter("OraclePw");
		
		dao=new MemberDAO(driver, url, id, pw);
		
		//	멤버 dao 매개변수 4개를 받는 객체를 선언하는데
		//	4개 값을 모르니까 값을 받아와야 한다
		//	web.xml에 매개변수 값을 설정했으니 설정값을 읽어와야 한다
		//	우리가 만든 설정값이 내장객체 안에 담겨있으니
		//	어플케이션을 통해서 설정값을 받아야 하는데
		//	서블릿컨텍스트를 통해서 받아올 수 있다 
		//	설정값을 받기 위해 서블릿컨텍스트 객체를 생성했다

	}
	
	
	//	리퀘스트에서 겟파라미터로 꺼낸다
	//	변수를 선언해서 값을 저장
	//	우리가 넘겨준 값이 초기에 넘겨준 값 말고 
	//	초기값으로 매니저 아이디를 따로 넘겨줬다
	//	그것도 같이 받아줘야 한다
	//	초기화변수로 들어가 있으니 초기화변수로 받아야 한다
	
	//	처리한 값이 우리가 만든 jsp든 결과값을 도출해서 출력하든 처리돼서 나온다
	//	결과값을 ${authmsg}로 받는다
	//	admin이면 관리자입니다
	//	회원이면 회원
	//	비회원이면 비회원
	
	//	해당하는게 디비에 있는지
	//	있다면 해당하는 이름을 받아야한다
	//	해당 정보를 받아서 실행시켜줘야 한다
	//	멤버DTO로 받아줘야 한다
	//	아이디랑 패스워드는 여기서 입력받았던 값 그대로
	//	없다면 없는 상태
	//	이름을 출력
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 인증에 필요한 값
		String manager_id = this.getInitParameter("manager_id");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		//	아이디랑 패스워드 둘 다 체크
		//	아이디값이 프라이머리 키여서 1개의 값만 받기 때문에 
		//	있다면 나오고 없다면 안 나온다
		
		//	필요한 동작처리(회원찾기)
		MemberDTO dto = dao.getMemberDTO(id, pass);
		
		//	결과값에 따른 처리
		String memberName = dto.getName();
		
		if(memberName!=null) { //	회원
			req.setAttribute("authMsg", memberName+"회원님 반갑습니다.");
			
			// 회원이 아니라면 비회원이나 매니저 둘 중의 하나이기에 else로 처리
		} else {
			if(manager_id.equals(id)) {	//	관리자
				
				req.setAttribute("authMsg", manager_id+":관리자입니다.");
			} else{	//	비회원
				req.setAttribute("authMsg", "회원이 아닙니다.");
			}
		}
		
		//	결과에 따른 페이지이동
		req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp);
		
	}
	
	@Override
	public void destroy() {
		
		//	연결했던 커넥션을 종료해줘야 한다
		//	해당서블릿이 삭제될 때 만들어놨던 커넥션도 같이 삭제된다.
		dao.close();
	}
		

}
