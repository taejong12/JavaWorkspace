package practiceNote;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class ConsumerRun {

	public static void main(String[] args) {
		Consumer<String> c = new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		c.accept("안녕");

		// 람다식
		Consumer<String> c1 = (String str) -> {
			System.out.println(str);
		};

		// 생략
		c1 = str -> System.out.println(str);

		// 래퍼런스
		c1 = System.out::println;

		// IntConsumer
		IntConsumer c2 = num -> System.out.println(num);

		// LongConsumer
		LongConsumer c3 = num -> System.out.println(num);

		// DoubleConsumer
		DoubleConsumer c4 = num -> System.out.println(num);

		// BiConsumer<t,t>
		BiConsumer<String, Integer> c5 = (name, age) -> System.out.println(name + age);
		c5.accept("윤미래", 30);
	}

}
