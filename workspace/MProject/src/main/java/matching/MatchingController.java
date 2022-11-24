package matching;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MatchingController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MatchingDAO dao = new MatchingDAO();
		
		Map<String, Object> map= new HashMap<>();
		System.out.println("MatchingController map에 넣을 변수들");
		String sex = req.getParameter("sex");
		System.out.println(sex);
		String age = req.getParameter("age");
		System.out.println(age);
		
		String minage = req.getParameter("minage");
		System.out.println(minage);
		String maxage = req.getParameter("maxage");
		System.out.println(maxage);
		
		String height = req.getParameter("height");
		System.out.println(height);
		
		String minHeight = req.getParameter("minHeight");
		String maxHeight = req.getParameter("maxHeight");
		
		String style = req.getParameter("style");
		System.out.println(style);
		String edu = req.getParameter("edu");
		System.out.println(edu);
		String rlg = req.getParameter("rlg");
		System.out.println(rlg);
		String drunk = req.getParameter("drunk");
		System.out.println(drunk);
		String smoke = req.getParameter("smoke");
		System.out.println(smoke);
		String exin = req.getParameter("exin");
		System.out.println(exin);
		
		// 로그인 하면 세션에 마이엠비티아이 넣어야됨.
		HttpSession session = req.getSession();
		String my_mbti = (String)session.getAttribute("in_mbti");
		String mbti = req.getParameter("mbti");
		
		System.out.println(mbti);
		System.out.println(my_mbti);
		
		String job = req.getParameter("job");
		System.out.println(job);
		String pet = req.getParameter("pet");
		System.out.println(pet);
		
		if(sex != null) {
			map.put("sex", sex);
		}
		if(age!= null) {
			map.put("age", age);
		}
		
		if(minage != "") {
			map.put("minage", minage);
		}
		if(maxage != "") {
			map.put("maxage", maxage);
		}
		
		if(height!= null) {
			map.put("height", height);
		}
		
		if(minHeight!= "") {
			map.put("minHeight", minHeight);
		}
		if(maxHeight!= "") {
			map.put("maxHeight", maxHeight);
		}
		
		if(style != null) {
			map.put("style", style);
		}
		if(edu != null) {
			map.put("edu", edu);
		}
		if(rlg != null) {
			map.put("rlg", rlg);
		}
		if(drunk != null) {
			map.put("drunk", drunk);
		}
		if(smoke != null) {
			map.put("smoke", smoke);
		}
		if(exin != null) {
			map.put("exin", exin);
		}
		if(mbti != null) {
			map.put("mbti", mbti);
		}
		if(my_mbti != null) {
			map.put("my_mbti", my_mbti);
		}
		if(job != null) {
			map.put("job", job);
		}
		if(pet != null) {
			map.put("pet", pet);
		}
		
		System.out.println("map 에 담긴 변수들");
		System.out.println(map.get("sex"));
		System.out.println(map.get("age"));
		System.out.println(map.get("minage"));
		System.out.println(map.get("maxage"));
		System.out.println(map.get("height"));
		System.out.println(map.get("minHeight"));
		System.out.println(map.get("maxHeight"));
		System.out.println(map.get("style"));
		System.out.println(map.get("edu"));
		System.out.println(map.get("rlg"));
		System.out.println(map.get("drunk"));
		System.out.println(map.get("smoke"));
		System.out.println(map.get("exin"));
		System.out.println(map.get("mbti"));
		System.out.println(map.get("my_mbti"));
		System.out.println(map.get("job"));
		System.out.println(map.get("pet"));
		
		
		List<MatchingDTO> boardLists = dao.selectList(map);
		dao.close();
		
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/06Matching/MatchingMain.jsp").forward(req, resp);
	}
}
