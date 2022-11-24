package lambdaPrac;

import java.io.PrintWriter;

class NormalClass2 {
	void normalMethod() {
		System.out.println("일반메소드");
	}
	static void staticMethod() {
		System.out.println("정적메소드");
	}
}

class NCObj{
	void printString(String str) {
		System.out.println(str);
	}
}

interface IFforObject {
	void objectMethod (NCObj t, String k);
}

public class ReferanceLamdaRun {

	public static void main(String[] args) {
		//일반메소드
		NormalInterface ni1 = new NormalInterface() {

			@Override
			public void normalMethod() {
				NormalClass2 nc2 = new NormalClass2();
				nc2.normalMethod();
			}
		};
		ni1.normalMethod();

		//람다식
		NormalInterface ni2 = () -> {
			NormalClass2 nc2 = new NormalClass2();
			nc2.normalMethod();
		};
		ni2.normalMethod();

		// 인스턴스형태면 참조변수::메소드
		NormalClass2 nc3 = new NormalClass2();
		NormalInterface ni3 = nc3::normalMethod;
		ni3.normalMethod();

		NormalInterface3 ni31 = new NormalInterface3() {
			@Override
			public void normalMethod(int i) {
				System.out.println(i);
			}
		};
		ni31.normalMethod(33);

		//람다식
		ni31 = (int i) -> {
			System.out.println(i);
		};
		
		//생략
		ni31 = i -> System.out.println(i);
		ni31.normalMethod(33);
		
		//레퍼런스
		ni31=System.out::println;
		ni31.normalMethod(22);
		
		NormalInterface ni21 = new NormalInterface() {
			@Override
			public void normalMethod() {
				NormalClass2.staticMethod();
			}
		};
		
		//람다식
		ni21=()->{NormalClass2.staticMethod();};
		
		//생략
		ni21=()->NormalClass2.staticMethod();
		
		//래퍼런스
		ni21=NormalClass2::staticMethod;
		ni21.normalMethod();
		
		IFforObject iff = new IFforObject() {
			
			@Override
			public void objectMethod(NCObj t, String k) {
				t.printString(k);
			}
		};
		iff.objectMethod(new NCObj(), "아이고");
		
		iff = (NCObj t, String k)->{t.printString(k);};
		
		iff = (t, k)->t.printString(k);
		
		iff=NCObj::printString;
		iff.objectMethod(new NCObj(), "이런 제길");
		
	}

}
