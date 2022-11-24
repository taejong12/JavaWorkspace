package lambdaPrac;

//functional interface
@FunctionalInterface
public interface NormalInterface {
	void normalMethod();
	// 함수형 인터페이스는 메서드가 하나만
	// 함수는 하나의 기능으로 만들어야 하는데 함수만 따로 만들 방법이 없다
	// 하나의 객체를 만들어야 하는데 그걸 인터페이스로 한다
	// 메서드가 하나 들어가야해서 추상메서드 1개가 있다.
}

interface NormalInterface1 {
	// input(파라미터)이 없고 output(리턴)도 없는 경우
	void normalMethod();
}

interface NormalInterface2 {
	// input이 없고 output이 있는 경우
	int normalMethod();
}

interface NormalInterface3 {
	// input이 있고 output이 없는 경우
	void normalMethod(int i);
}

interface NormalInterface4 {
	// input이 있고 output도 있는 경우
	double normalMethod(int i, double d);
}
