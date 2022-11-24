package utils;

public class ELUtils {

	// 주민번호=>성별 반환
	public String getGender(String juminNum) {
		String res="";
		String regExp="^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$";
		if(juminNum.matches(regExp)) { //매칭 주민번호와 정규식
			int beginIdx = juminNum.indexOf("-")+1;
			String genderStr = juminNum.substring(beginIdx, beginIdx + 1);
			int genderInt = Integer.parseInt(genderStr);
			if(genderInt==1||genderInt==3)
				res="남자";
			else if(genderInt==2||genderInt==4)
				res="여자";
		} else {
			res="주민번호 오류입니다.";
		}
		return res;
	}
	
	// 문자열=>숫자인지 판별
	public static boolean isNumber(String value) {
		char[] chArr = value.toCharArray();
		for(int i=0; i<chArr.length;i++) {
			if(!(chArr[i] >= '0' && chArr[i] <= '9')) {
				return false;
			}
		}
		return true;
	}
	
	// 입력받은 정수까지의 구구단을 HTML 테이블로 출력해줍니다.
	public static String showGugudan(int limitDan) {
		//태그를 StringBuffer에 쌓는다
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<table border='1'>");
			for(int i=2; i<=limitDan;i++) {
				sb.append("<tr>");
				for(int j=1;j<=9; j++) {
					sb.append("<td>"+i+"*"+j+"="+(i*j)+"</td>");
				}
				sb.append("</tr>");
			}
			sb.append("</table>");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	

}
