package practiceNote;

//functional interface
public interface NormalInterfacePractice {
	//함수형 인터페이스는 추상 메서드가 하나만 존재해야 한다
	void normalMethod();
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