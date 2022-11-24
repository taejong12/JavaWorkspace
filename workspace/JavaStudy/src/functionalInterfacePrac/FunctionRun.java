package functionalInterfacePrac;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntFunction;

public class FunctionRun {

	public static void main(String[] args) {
		//<input, result> 입력값의 타입이 뭐냐 결과값의 타입이 뭐냐 가 있고 결과값 타입으로 리턴해서 나온다
		Function<String, Integer> f = new Function<>() {
			//Function에 있는 추상 메서드 apply 생성
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		System.out.println(f.apply("너는 뭐지?"));
		
		//람다식
		Function<String,Integer> f2 =(String t)->{return t.length();};
		
		//생략 타입, 소괄호, 중괄호, return 하나만 있을때만 생략 가능
		f=t->t.length();
		
		//입력값이 정해져 있으면 input 타입은 정해져 있고 리턴하는 타입만 정하면 된다
		//To가 붙어 있으면 결과값은 정해져 있고 입력값만 정하면 된다
		
		//IntFunction<R>
		IntFunction<Double> f3 = num -> {return num*1.3;};
		
		//생략
		f3 = num -> num*1.3;
		System.out.println(f3.apply(3));
		
		//LongFunction<R>
		LongFunction<String> f4 = num-> {return String.valueOf(num);};
		f4 = num-> String.valueOf(num);
		System.out.println(f4.apply(12L));
		
		//DoubleFunction<R> Double 보다 Integer가 작기 때문에 형변환을 해줘야 한다
		DoubleFunction<Integer> f5 = num->{return (int)num;};
		f5 = num->(int)num;
		System.out.println(f5.apply(12.3413241));
		
		//2개의 인풋을 받아 결과값을 낸다
		//BiFunction<String, String, String> f6 = (String,String)->{return };
		BiFunction<String, String, String> f6 = (addr1,addr2)->addr1+" "+addr2+" 상세주소";
		System.out.println(f6.apply("서울시", "강남구"));
		
		//Long 보다 Double 이 더 크기 때문에 묵시적 형변환이 일어난다
		LongToDoubleFunction f7 = num->num;
		System.out.println(f7.applyAsDouble(12L));
		
		//Long 보다 Integer 가 작기 때문에 형변환을 직접해줘야 한다
		LongToIntFunction f8 = num->(int)num;
		System.out.println(f8.applyAsInt(1234L));
		
		ToIntFunction<String> f9 = str->str.length();
		System.out.println(f9.applyAsInt("이건길이가"));
		
		ToDoubleBiFunction<Integer, Double> f10 = (intNum, ddNum)->intNum*ddNum;
		System.out.println(f10.applyAsDouble(12, 13.29));
	}

}
