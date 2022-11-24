package servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//	membership에 있는 MemberDAO와 MemberDTO에 있는 아이디와 비밀번호를
//	모델영역에 있는 값
//	멤버테이블을 활용
//	서블릿 컨트롤러단과 화면을 보여주기 위한 jsp(view)
//	인증하는 것은 Auth를 많이 쓴다


@WebServlet("/13Servlet/LifeCycle.do")

public class LifeCycle extends HttpServlet {
	
	//	일련의 라이프사이클을 자바소스에서 진행
	//	초기에 생성자를 생성하기 전에 처리 @PostConstruct
	@PostConstruct
	public void mPostConstruct() {
		System.out.println("PostConstruct call");
		
		//	다시 말해서 @PostConstruct 해당하는 어노테이션을 통해서 선언을 해주고 
		//	초기화하기 전에 이 동작을 처리해주고 다음 동작을 해준다. 
		//	상속 받은 메서드가 아닌 메서드를 생성
		//	전처리가 됐다면 초기화를 해줘야 한다
		//	init은 존재하는 메서드이기에 오버라이딩 해준다
		//	init 호출
		//	서비스를 호출해준다
		//	서비스도 상위에 존재하는 기본적인 메서드
		//	메서드를 살펴보기 위해서 일부러 오버라이딩 하는중
		//	애초에 전달받은 리퀘스트 리스폰스를 받아서 처리해주는 곳이 시작 서블렛에서 만들어져 있는 서비스를 실행
		//	슈퍼에 있는 서비스가 실행이 돼야 연동이 되므로 실행시켜줌
		//	반드시 오버라이딩 해줘야 하는 doGet과 doPost
		//	jsp를 하나 만들어서 그 쪽으로 찍어주게 해준다
		//	doGet과 doPost 똑같은 화면 출력만 다르게
		//	그 다음에 실행되는게 destroy()
		//	마무리해야할 최후의 실행될 내용 PreDestroy
		
		// 일반적인 동작 흐름에 대한 어노테이션
		// 실행한것에 의해 화면에 보여질때는 주소로 이동
		// 동작 흐름이 해당하는 리퀘스트가 온다
		// 리퀘스트 저넹 이것과 상관없이 서블릿을 만들었을 떄
		// 컨테이너가 알아서 해준다
		// 해당하는 컨테이너가 인지를 하면 객체 생성을 위한 초기화를 해준다
		// @PostConstruct을 하고 init을 해주고
		// service가 진행
		
		
		// 해당하는 서블릿 컨테이너를 실행
		// 이닛을 하기전에 @PostConstruct 앞쪽에 실행될 내용이 있으면 하고
		// init()->service()->destroy()
		// 앞쪽에 전처리 해주는 @PostConstruct나 @PreDestroy
		// init()->service()->destroy()가 기본이다
		// service() 에는 doGet(req,resp), doPost(req,resp) 가 있다
		// 리퀘스트를 받고 어떤 동작을 해야하는지 판단해서 
		//	둘 중(doGet(req,resp), doPost(req,resp))에 하나 실행
		// 마지막에 destroy()를 해서 삭제
		// 일련의 동작은 서블릿 컨테이너가 한다
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() call");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("service() call");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("doGet() call");
		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("doPost() call");
		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
		
	//	getRequestDispatcher 대신
	//	주소만 주고 get 방식으로 받으니까 redirect도 가능하다(여기서는)

	//	서비스가 실행되면 doGet이나 doPost로 실행된다 
	//	있으면 객체를 이닛하고 해당 서비스에 맞춰서 서블릿을 유지하고 있다가 
	//	필요없으면 디스트로이 해버린다
	//	디스트로이는 서버를 스탑했을때 출력된다.
	
	@Override
	public void destroy() {
		System.out.println("destroy() call");
	}
	
	@PreDestroy
	public void mPreDestory() {
		System.out.println("PreDestroy() call");
	}

}
