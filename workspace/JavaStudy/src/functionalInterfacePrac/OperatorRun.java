package functionalInterfacePrac;

import java.nio.FloatBuffer;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class OperatorRun {

	public static void main(String[] args) {
		UnaryOperator<Double> o = new UnaryOperator<Double>() {
			@Override
			public Double apply(Double t) {
				return t*12.3;
			}
		};
		System.out.println(o.apply(3.2));
		
		//람다식
//		UnaryOperator<Double> o2 = (Double dd) -> {return Double};
		UnaryOperator<Double> o2 = (Double dd) -> {return dd*12.3;};
		
		//생략
		o2 = dd -> dd*12.3;
		System.out.println(o2.apply(2.2));
		
		//BinaryOperator<T> 같은 타입의 입력값을 2개 받고 같은 타입의 결과값이 나온다
		BinaryOperator<String> o3 = (str1,str2)->str1+str2;
		System.out.println(o3.apply("어서", "오세요"));
		
		//IntUnaryOperator 명령문 자체에 타입을 정해서 들어가는 것
		IntUnaryOperator o4 = num->num+3;
		System.out.println(o4.applyAsInt(2));
		
		//LongUnaryOperator
		LongUnaryOperator o5 = num->num+21L;
		System.out.println(o5.applyAsLong(23L));
		
		//DoubleUnaryOperator
		DoubleUnaryOperator o6 = num -> num*1.2;
		System.out.println(o6.applyAsDouble(2.3));
		
		//타입이 정해져 있는 입력값 2개를 받아 같은 타입의 결과값을 리턴해준다
		//IntBinaryOperator
		IntBinaryOperator o7 = (num1, num2)->num1-num2;
		System.out.println(o7.applyAsInt(12, 100));
		
		//LongBinaryOperator
		LongBinaryOperator o8 = (num1, num2)->num1-num2;
		System.out.println(o8.applyAsLong(12L, 100L));
		
		//DoubleBinaryOperator
		DoubleBinaryOperator o9 = (num1, num2)->num1-num2;
		System.out.println(o9.applyAsDouble(12.4, 42.25));
		
	}

}
