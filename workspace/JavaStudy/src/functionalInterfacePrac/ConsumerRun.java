package functionalInterfacePrac;

import java.util.function.*;

public class ConsumerRun {

	public static void main(String[] args) {
		Consumer<String> c = new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		c.accept("안녕");
		
		//람다식
//		Consumer<String> c2 = t->System.out.println(t);
		Consumer<String> c2 = System.out::println;
		c=(String t)->{System.out.println(t);};
		
		//인터페이스를 객체로 만드는 방법
		//IntConsumer c3 = (int num)->{System.out.println(num);};
		IntConsumer c3 = num->System.out.println(num); //c3 = num->System.out.println(num);
		
		//LongConsumer c4 = (long num)->{System.out.println(num);};
		LongConsumer c4 = num->System.out.println(num);
		
		//DoubleConsumer c5 = (Double num)->{System.out.println(num);};
		DoubleConsumer c5 = num->System.out.println(num);
		
		//BiConsumer<String, Integer> c6 = (String name,Integer age)->{System.out.println(name+age)};
		BiConsumer<String, Integer> c6 = (name, age)->System.out.println(name+age);
		c6.accept("윤미래", 30);
	}

}
