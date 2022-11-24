package interfacePrac;

public interface Calc {
	// 상수
	final double PI = 3.14;
	final int ERROR = -99999;

	// 추상메소드
	int add(int num1, int num2);

	int sub(int num1, int num2);

	int times(int num1, int num2);

	int div(int num1, int num2);

	// 디폴트 메소드: 공통적 구현해야 되는 메소드를 기본구현
	default void desc() {
		privateMethod();
		privateStaticMethod();
		System.out.println("계산기 구현");
	}

	// static 메소드
	static int total(int[] arr) {
		int total = 0;
		for (int i : arr) {
			total += i;
		}
		// privateMethod(); // static method 안에서는 static만 사용가능
		privateStaticMethod();
		return total;
	}

	// private 메소드
	private void privateMethod() {
		System.out.println("private method");
	}

	// private static 메소드
	private static void privateStaticMethod() {
		System.out.println("private static method");
	}
}
