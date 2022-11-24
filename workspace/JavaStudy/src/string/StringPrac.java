package string;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringPrac {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1 == str2);
		String str3 = "bcd";
		String str4 = "bcd";
		System.out.println(str3 == str4);
		str3 = "cde";
		System.out.println(str3 == str4);
		System.out.println(str4.toString());
		str4 = "cde";
		System.out.println(str3 == str4);
		System.out.println(str1);
		System.out.println(str3);
		System.out.println();

		// equals()
		String a = "hello";
		String b = "world";
		String c = "hello";
		String d = new String("hello");
		System.out.println(a);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a.equals(d));
		System.out.println(a == d);
		System.out.println();

		// indexOf() 해당 문자열의 시작 인덱스
		String e = "Hello world.";
		System.out.println(e.indexOf("wor"));

		// contains() 해당 문자열의 포함여부
		System.out.println(e.contains("ro"));

		// chatAt() 특정 위치의 문자 반환
		System.out.println("chatAt:"+e.charAt(4));

		// replaceAll() 특정 문자열의 교체한 문자열 반환
		System.out.println(e.replaceAll("world", "baby"));
		System.out.println(e.toString());

		// substring() 문자열의 특정 부분 추출
		System.out.println(e.substring(0, 7));

		// toUpperCase(), toLowerCase() 대소문자 변경
		System.out.println(e.toUpperCase());
		System.out.println(e.toLowerCase());
		System.out.println(e.toString());

		// compareTo(), compareToIgnoreCase()
		// 문자열을 비교하여 같다면 0을 작으면 음수 크면 양수 반환
		String str = new String("abcd");
		System.out.println(str.compareTo("bcde"));
		System.out.println(str.compareTo("abcd"));

		System.out.println(str.compareTo("Abcd"));
		System.out.println(str.compareToIgnoreCase("Abcd"));
		
		//concat() 문자열을 추가하여 새로운 문자열 반환
		System.out.println(e.concat(str));
		
		//trim() 문자열의 맨앞 맨뒤의 공백을 제거
		String f = "     Java Java     ";
		System.out.print("|||");
		System.out.print(f.trim());
		System.out.println("|||");
		System.out.println(f);
		
		//length() isEmpty()
		System.out.println(f.length());
		System.out.println(f.isEmpty());
		System.out.println();
		
		//split
		String test = "이 문장은 스트링-입니다./this is String";
		String[] token = test.split(" ");
		System.out.println(Arrays.toString(token));
		token = test.split("");
		System.out.println(Arrays.toString(token));
		token = test.split("/");
		System.out.println(Arrays.toString(token));
		//기본
//		StringTokenizer stk = new StringTokenizer(test);
//		System.out.println(stk.countTokens());
//		//파라미터 구분자포함
//		StringTokenizer stk = new StringTokenizer(test,"-");
//		//구분자를 포함하여 스트링 나누는 경우
		StringTokenizer stk = new StringTokenizer(test,"-",true);
		System.out.println(stk.countTokens());
		System.out.println();
		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}
	}

}
