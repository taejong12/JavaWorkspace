package functionalInterfacePrac;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateRun {

	public static void main(String[] args) {
		//Predicate<> 결과값이 boolean으로 정해져있다
		Predicate<Integer> p = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return (t>3);
			}
		};
		System.out.println(p.test(4));
		
		//람다식
		Predicate<Integer> p1 = (Integer t)->{return (t>3)?true:false;};
		
		//생략
		p1=t->(t>3)?true:false;
		System.out.println(p1.test(2));
		
		//입력값 2개를 받는다 결과값은 boolean이다 
		BiPredicate<String, String> p3 = (String str1,String str2)->{return str1.equals(str2);};
		
		//생략
		p3 = (str1,str2)->str1.equals(str2);
		System.out.println(p3.test("apple", "apple"));
		
		//IntPredicate Integer 값을 입력값으로 받아 결과값은 boolean으로 리턴한다.
		IntPredicate p4 = num -> {return (num%2==0)?true:false;};
		
		//생략
		p4 = num -> (num%2==0)?true:false;
		System.out.println(p4.test(4));
		
		//LongPredicate Long 값을 입력값으로 받아 결과값은 boolean으로 리턴한다.
		LongPredicate p5 = num->{return (num>100);};
		
		//생략
		p5 = num->(num>100);
		System.out.println(p5.test(102L));
		
		//DoublePredicate Double 값을 입력값으로 받아 결과값은 boolean으로 리턴한다.
		DoublePredicate p6 = num->{return num*20>100;};
		
		//생략
		p6 = num->num*20>100;
		System.out.println(p6.test(2.5));
		
		
	}

}
