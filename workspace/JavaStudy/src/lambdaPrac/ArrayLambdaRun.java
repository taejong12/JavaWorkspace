package lambdaPrac;

interface ArrIF {
	int[] sizeOfArray(int length);
}

public class ArrayLambdaRun {

	public static void main(String[] args) {
		//#1
		ArrIF aif = new ArrIF() {

			@Override
			public int[] sizeOfArray(int length) {
				return new int[length];
			}
		};
		int[] arr1 = aif.sizeOfArray(4);
		System.out.println(arr1.length);

		// 람다식
		aif = (int length) -> {
			return new int[length];
		};
		
		//생략
		aif = length -> new int[length];
		int[] arr2 = aif.sizeOfArray(8);
		System.out.println(arr2.length);

		// 래퍼런스 
		//객체 생성(new)이 되어있으면 객체 생성을 위해 :: 뒤에 new를 작성한다 앞에는 타입을 적어준다 
		//타입::new
		aif = int[]::new;
		System.out.println(aif.sizeOfArray(10).length);

		//#2
		ConstLambda cl = new ConstLambda() {
			@Override
			public TwoConst getInstance() {
				return new TwoConst();
			}
		};
		TwoConst tc = cl.getInstance();

		// 인터페이스를 객체화시키기 위해서 하는 것이기에 타입이 인터페이스여야 한다
		// 람다식
		cl = () -> {
			return new TwoConst();
		};

		// 생략
		cl = () -> new TwoConst();

		// 객체를 생성하고자 할 떄는 new가 호출된다 들어오는 값이랑 처리하는 값이 일치해야한다
		// 생성자를 호출하려고 하는데 생성자가 있는 클래스 주소를 적어줘야 한다
		// 생성자가 2개일 때는 정확하게 모른다
		// 그래서 인터페이스 기준으로 생각할 수 밖에 없다
		// 파라미터가 있는지 보고 확인
		// 래퍼런스
		cl = TwoConst::new;
		cl.getInstance();

		ConstLambdaParam clp = new ConstLambdaParam() {

			@Override
			public TwoConst getInstance(String str) {
				return new TwoConst(str);
			}
		};

		// 람다식
		clp = (String str) -> {
			return new TwoConst(str);
		};

		// 생략 타입, 소괄호, 중괄호, 리턴 (하나만 있으면 생략 가능)
		clp = str -> new TwoConst(str);

		// 레퍼런스
		clp = TwoConst::new;
		clp.getInstance("안녕하세요");
	}

}

interface ConstLambda {
	TwoConst getInstance();
}

interface ConstLambdaParam {
	TwoConst getInstance(String str);
}

class TwoConst {
	// 기본생성자
	TwoConst() {
		System.out.println("기본생성자");
	}

	// String 매개변수 하나를 가진 생성자
	TwoConst(String str) {
		System.out.println("매개변수 생성자");
	}

}
