package signUp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp/SignUpDo.do")
public class SignUpDoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SignUpDAO dao = new SignUpDAO();
		
		Map<String, Object> map = new HashMap<>();
		
		String ME_ID = req.getParameter("ME_ID");
		String ME_PASS = req.getParameter("ME_PASS");
		String ME_NAME = req.getParameter("ME_NAME");
		String ME_BIRTH = req.getParameter("ME_BIRTH");
		String ME_SEX = req.getParameter("ME_SEX");
		int ME_AGE = Integer.parseInt(req.getParameter("ME_AGE"));
		String ME_PHONE = req.getParameter("ME_PHONE");
		String ME_EMAIL = req.getParameter("ME_EMAIL");
		String ME_KAKAO = req.getParameter("ME_KAKAO");
		
		map.put("ME_ID", ME_ID);
		map.put("ME_PASS", ME_PASS);
		map.put("ME_NAME", ME_NAME);
		map.put("ME_BIRTH", ME_BIRTH);
		map.put("ME_SEX", ME_SEX);
		map.put("ME_AGE", ME_AGE);
		map.put("ME_PHONE", ME_PHONE);
		map.put("ME_EMAIL", ME_EMAIL);
		map.put("ME_KAKAO", ME_KAKAO);
		
		req.setAttribute("map", map);
			
		
	}
	
	
}
