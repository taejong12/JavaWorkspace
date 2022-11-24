package collectionFramework;

//익명클래스, 자식클래스 생성
interface TestInterface {
	public abstract void test();
}

class SubClass implements TestInterface {

	@Override
	public void test() {
		System.out.println("subclass test() run");
	}

}

class NormalClass { // 일반 클래스 내에서 제너릭 작성
	public <T extends TestInterface> void genMethod(T t) { // 제너릭에서는 implements 대신 extends를 쓴다
		t.test();
	}
}

public class LimitedTypeGenericClass2 {

	public static void main(String[] args) {
		NormalClass nc = new NormalClass();	
		
		SubClass sc = new SubClass();
		nc.genMethod(sc);
		
		nc.genMethod(new TestInterface() {
			@Override
			public void test() {
				System.out.println("익명클래스 test() run");
			}
		});
	}
}
