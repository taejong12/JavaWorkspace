package lambdaPrac;

public class FunctionalInterfaceLambdaRun {

	public static void main(String[] args) {
		NormalInterface1 ixox = new NormalInterface1() {
			@Override
			public void normalMethod() {
				System.out.println("i x o x 메소드");
			}
		};
		ixox.normalMethod();

		NormalInterface1 ixox1 = () -> {
			System.out.println("i x o x 람다식 메소드");
		};
		ixox1.normalMethod();

		ixox = () -> {
			System.out.println("i x o x 람다식 메소드");
		};
		ixox.normalMethod();

		ixox = () -> System.out.println("i x o x 람다식 메소드"); // 한줄일때 중괄호 생략 가능
		ixox.normalMethod();

		NormalInterface2 ixoo = new NormalInterface2() {

			@Override
			public int normalMethod() {
				System.out.println("i x o o 람다식 메소드");
				return 100;
			}
		};
		System.out.println(ixoo.normalMethod());
		
		ixoo = ()->{System.out.println("i x o o 람다식 메소드"); return 100;};
		System.out.println(ixoo.normalMethod());
		
		//리턴만 존재할 때는 return 생략 가능
		ixoo = ()->100;
		System.out.println(ixoo.normalMethod());
		
		NormalInterface3 ioox = new NormalInterface3() {

			@Override
			public void normalMethod(int i) {
				System.out.println("i o o x 메소드 입력값:"+i);
			}
		};
		ioox.normalMethod(10);
		
		//중괄호 생략가능
		ioox = (int i)->System.out.println("i o o x 메소드(한줄 중괄호 생략) 입력값:"+i);
		ioox.normalMethod(11);
		
		
		//타입 생략 가능 인터페이스에 있으니까 가능
		ioox = (i)->System.out.println("i o o x 메소드(매개변수 타입 생략) 입력값:"+i);
		ioox.normalMethod(12);
		
		//매개 변수가 1개면 괄호 생략 가능
		ioox = i->System.out.println("i o o x 메소드(매개변수가 하나이면 괄호 생략) 입력값:"+i);
		ioox.normalMethod(13);
		
		NormalInterface4 iooo = new NormalInterface4() {

			@Override
			public double normalMethod(int i, double d) {
				System.out.println("i o o o 람다식 메소드");
				return i*d;
			}
		};
		System.out.println(iooo.normalMethod(9, 3.5));
		
		iooo=(int i, double d)->{return i*d;};
		//타입 생략 가능, 중괄호 생략 가능, return 생략 가능
		iooo=(i,d)->i*d;
		System.out.println(iooo.normalMethod(9, 3.5));
		
	}

}
