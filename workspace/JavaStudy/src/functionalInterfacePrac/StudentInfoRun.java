package functionalInterfacePrac;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

class Student {
	private String name;
	private String city;
	private Integer age;

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, String city) {
		this(name);
		this.city = city;
	}

	public Student(String name, String city, Integer age) {
		this(name, city);
		this.age = age;
	}

	public String toString() {
		return name + "(" + city + "," + age + ")";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

public class StudentInfoRun {

	public static void main(String[] args) {
		// Function name 객체 Student
		Function<String, Student> func = new Function<>() {
			@Override
			public Student apply(String name) {
				return new Student(name);
			}
		};
		Student stu1 = func.apply("Sojoo");

//		// 람다식
//		Function<String, Student> func1 = (String name) -> {
//			return new Student(name);
//		};
//
//		// 생략
//		func1 = name -> new Student(name);
//
//		// 래퍼런스
//		func1 = Student::new;

		BiFunction<String, String, Student> func2 = new BiFunction<String, String, Student>() {
			@Override
			public Student apply(String t, String u) {
				return new Student(t, u);
			}
		};
		Student stu2 = func2.apply("makgulri", "seoul");

//		// 람다식
//		BiFunction<String, String, Student> func3 = (String t, String u) -> {
//			return new Student(t, u);
//		};
//
//		// 생략
//		func3 = (t, u) -> new Student(t, u);
//
//		// 래퍼런스
//		func3 = Student::new;

		// stu1에 나이와 도시 정보 추가 stu2에 나이정보 추가
		stu1.setAge(20);
		stu1.setCity("Seoul");
		stu2.setAge(21);
		stu2.setCity("America");
		System.out.println(stu1.toString() + "||" + stu2.toString());
		IntBinaryOperator oper;
		// staticSum 활용할 객체 생성
		oper = new IntBinaryOperator() {
			@Override
			public int applyAsInt(int x, int y) {
				return StudentInfoRun.staticSum(x, y);
			}
		};
		
		oper = (x, y) -> StudentInfoRun.staticSum(x, y);
		int nextyearAge = oper.applyAsInt(stu1.getAge(), 1);// stu1의 나이에 1 더하기
		System.out.println(stu1.getName() + "'s next year age:" + nextyearAge);

		// instanceSum을 활용할 객체 생성
		StudentInfoRun sir = new StudentInfoRun();
		oper = (x,y) ->sir.instanceSum(x,y);
		nextyearAge = oper.applyAsInt(stu2.getAge(), 1);// stu2의 나이에 1 더하기
		System.out.println(stu2.getName() + "'s next year age:" + nextyearAge);

		// String 클래스의 비교하는 것중 integer 결과로 나오는 것을 활용한 객체 생성
		ToIntBiFunction<String, String> func4 = (str1, str2) -> str1.compareTo(str2);
		compareResult(func4.applyAsInt(stu1.getCity(), stu2.getCity()));// stu1의 도시와 stu2의 도시명을 비교한 결과 출력

	}

	public static int staticSum(int x, int y) {
		return x + y;
	}

	public int instanceSum(int x, int y) {
		return x + y;
	}

	public static void compareResult(int result) {
		if (result == 0) {
			System.out.println("동일한 문자열입니다.");
			return;
		}
		System.out.println("동일하지 않은 문자열입니다.");
	}
}
