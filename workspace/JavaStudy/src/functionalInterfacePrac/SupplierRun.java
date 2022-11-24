package functionalInterfacePrac;

import java.util.function.*;

public class SupplierRun {

	public static void main(String[] args) {
		Supplier<String> s = new Supplier<>() {
			@Override
			public String get() {
				return "Supplier 값 반환";
			}
		};
		System.out.println(s.get());

		// Supplier<String> s2 = () -> {return "반환값";};
		Supplier<String> s2 = () -> "반환값";
		System.out.println(s2.get());

		// BooleanSupplier s3 = ()->{return 3>2;};
		BooleanSupplier s3 = () -> (3 > 2);

		// IntSupplier s4 = ()->{return 12+3;};
		IntSupplier s4 = () -> 12 + 3;

		// LongSupplier s5 = ()->{return 23L;};
		LongSupplier s5 = () -> 23L;

		// DoubleSupplier s6 = ()->{return 12.34;};
		DoubleSupplier s6 = () -> 12.34;

		// get에 따른 명칭이 붙는다
		System.out.println(s3.getAsBoolean());
		System.out.println(s4.getAsInt());
		System.out.println(s5.getAsLong());
		System.out.println(s6.getAsDouble());
	}
}
