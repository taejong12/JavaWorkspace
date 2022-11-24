package practiceNote;

public class FunctionalInterfaceLambdaPractice {

	public static void main(String[] args) {
		NormalInterface1 ixox = new NormalInterface1() {
			@Override
			public void normalMethod() {
				System.out.println("ixox");
			}
		};
		ixox.normalMethod();

		// 람다식
		NormalInterface1 ixox1 = () -> {
			System.out.println("ixox 람다식");
		};
		ixox1.normalMethod();

		// 생략
		NormalInterface1 ixox2 = () -> System.out.println("ixox 람다식 생략");
		ixox2.normalMethod();

//		interface NormalInterface2 {
//			// input이 없고 output이 있는 경우
//			int normalMethod();
//		}
//
//		interface NormalInterface3 {
//			// input이 있고 output이 없는 경우
//			void normalMethod(int i);
//		}
//
//		interface NormalInterface4 {
//			// input이 있고 output도 있는 경우
//			double normalMethod(int i, double d);
//		}
		NormalInterface2 ixoo = new NormalInterface2() {
			@Override
			public int normalMethod() {
				System.out.println("ixoo 메서드");
				return 100;
			}
		};
		ixoo.normalMethod();

		// 람다식
		NormalInterface2 ixoo1 = () -> {
			System.out.println("ixoo 메서드");
			return 100;
		};

		NormalInterface3 ioox = new NormalInterface3() {
			@Override
			public void normalMethod(int i) {
				System.out.println("ioox 메소드");
			}
		};
		ioox.normalMethod(3);

		// 람다식
		NormalInterface3 ioox1 = (int i) -> {
			System.out.println("ioox 메소드");
		};

		// 생략
		NormalInterface3 ioox2 = i -> System.out.println("ioox 메소드");

		NormalInterface4 iooo = new NormalInterface4() {
			@Override
			public double normalMethod(int i, double d) {
				System.out.println("iooo 메서드");
				return i * d;
			}
		};
		System.out.println(iooo.normalMethod(3, 3.3));

		// 람다식
		NormalInterface4 iooo1 = (int i, double d) -> {
			return 1000;
		};

		// 생략
		NormalInterface4 iooo2 = (i, d) -> 1000;

	}

}
