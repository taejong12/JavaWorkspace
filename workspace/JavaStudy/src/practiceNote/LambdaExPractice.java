package practiceNote;

interface StringEx {
	String showInfo(String str);
}

public class LambdaExPractice {

	public static void main(String[] args) {
		//익명이너클래스
		// 파라미터의 길이, 맨앞자리 글자만 더해서 반환
		StringEx se1 = new StringEx() {
			@Override
			public String showInfo(String str) {
				return str.substring(0,1)+" "+str.length();
			}
			
		};
		System.out.println(se1.showInfo("안녕하세요"));
		
		// 람다식
		se1 = (String str) -> {return str.substring(0,1)+" "+str.length();};
		System.out.println(se1.showInfo("잘 할 수 있어."));
		
		//생략
		se1= str->str.substring(0,1)+" "+str.length();
		
	}

}
