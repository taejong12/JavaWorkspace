package practiceNote;

interface ArrIF {
	int[] sizeOfArray(int length);
}

public class ArrayLambdaPractice {

	public static void main(String[] args) {
		// #1
		ArrIF aif = new ArrIF() {
			@Override
			public int[] sizeOfArray(int length) {
				return new int[length];
			}
		};
		int[] arr1 = aif.sizeOfArray(4);
		System.out.println(arr1.length);

		// 람다식
		aif = (int num) -> {
			return new int[num];
		};

		// 생략
		aif = num -> new int[num];

		int[] arr2 = aif.sizeOfArray(8);
		System.out.println(arr2.length);

		// reference
		// 객체 생성(new)이 되어있으면 객체 생성을 위해 :: 뒤에 new를 작성한다 앞에는 타입을 적어준다
		// 타입::new
		aif = int[]::new;
		System.out.println(aif.sizeOfArray(10).length);

		// #2
		ConstLambda cl = new ConstLambda() {

			@Override
			public TwoConst getInstance() {
				return new TwoConst();
			}
		};
		cl.getInstance();

		// 람다식
		// 함수적 인터페이스만 쓸 수 있다
		ConstLambda cl1 = () -> {
			return new TwoConst();
		};

		// 생략
		ConstLambda cl2 = () -> new TwoConst();

		// reference
		ConstLambda cl3 = TwoConst::new;

		//#3
		ConstLambdaParam clp = str-> new TwoConst(str);
		clp.getInstance("안녕하세요");
		
		ConstLambdaParam clp1 = TwoConst::new;
		
		ConstLambdaParam clp2 = (String str)-> {return new TwoConst(str);};
	
		ConstLambdaParam clp3 = new ConstLambdaParam() {
			@Override
			public TwoConst getInstance(String str) {
				return new TwoConst(str);
			}
		};
		clp3.getInstance("a");
	}

}

interface ConstLambda {
	// 일반 클래스의 생성자를 가져온다
	TwoConst getInstance();
}

interface ConstLambdaParam{
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
