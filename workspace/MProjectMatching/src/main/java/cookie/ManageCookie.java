package cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageCookie {
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName,cValue);
		cookie.setPath("/");
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
		}

		//쿠키 값을 반환
		public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue ="";
		Cookie[]cookies = request.getCookies();
		if(cookies !=null) {
		for(Cookie c : cookies) {
		String cookieName = c.getName();
		if(cookieName.equals(cName)) {
		cookieValue = c.getValue();
		}
		}
		}
		return cookieValue;
		}

		//쿠키 삭제 - 정확하게는 수정
		public static void deleteCookie(HttpServletResponse response, String cName) {
		makeCookie(response, cName,"",0);
		}
}
