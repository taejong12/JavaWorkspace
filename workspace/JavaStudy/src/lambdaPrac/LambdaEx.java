package lambdaPrac;

interface StringEx {
	String showInfo(String str);
}

public class LambdaEx {

	public static void main(String[] args) {
		// 익명이너클래스
		// 파라미터의 길이, 맨앞자리 글자만 더해서 반환
		StringEx se1 = new StringEx() {
			@Override
			public String showInfo(String str) {
				return str.substring(0, 1)+" "+str.length();
			}
		};
		System.out.println(se1.showInfo("안녕하세요"));

		// 람다식
		se1 = (String str) -> {
			System.out.println(str.length());
			return str.substring(0, 1);
		};
		System.out.println(se1.showInfo("너두 잘 할 수 있어."));

		se1 = str -> {
			System.out.println(str.length());
			return str.substring(0, 1);
		};

		// 익명이너클래스
		// 파라미터의 길이, 맨앞자리 글자만 더해서 반환
		StringEx se3 = new StringEx() {
			@Override
			public String showInfo(String str) {
				return str.length()+" "+str.substring(0, 1);
			}
		};
		System.out.println(se3.showInfo("안녕하세요"));

		// 람다식
		StringEx se2 = (String str) -> {
			return str.length() + " " + str.substring(0, 1);
		};
		se2 = str -> str.length() + " " + str.charAt(0);
		System.out.println("se2: 너두 잘 할 수 있어.");

	}

}
