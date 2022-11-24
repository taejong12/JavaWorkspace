package objectPrac;

public class ObjectMethod {

	public static void main(String[] args) {
		// equals
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		valEquals(v1, v2);

//		if (v1.equals(v2)) {
//			System.out.println("같다.");
//		} else {
//			System.out.println("다르다.");
//		}
//
		v1 = v2; // 얕은 복사 주소가 복사됨.
//		if (v1.equals(v2)) {
//			System.out.println("같다.");
//		} else {
//			System.out.println("다르다.");
//		}
		valEquals(v1, v2);

		Cost c1 = new Cost(10);
		Cost c2 = new Cost(10);
		valEquals(c1, c2);
		System.out.println(c1.hashCode());
		System.out.println(System.identityHashCode(c1));
		System.out.println(c2.hashCode());
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		//toString()
		System.out.println("toString:"+c1.toString());
		//getClass()
		Class c1c = c1.getClass();
		System.out.println(c1c.getName());
		c1c = Cost.class;
		System.out.println(c1c.getName());
		//clone() => array 복사
		
	
		c1 = c2;
		valEquals(c1, c2);
//		if(c1.equals(c2)) {
//			System.out.println("같다");
//		}else {
//			System.out.println("다르다");
//		}
	}

	public static void valEquals(Object v3, Object v4) {
		if (v3.equals(v4)) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}

	}
}

class Value { // extends Object
	int value;

	Value(int value) {
		this.value = value;
	}
}

class Cost { // extends Object
	int cost;

	Cost(int cost) {
		this.cost = cost;

	}
}