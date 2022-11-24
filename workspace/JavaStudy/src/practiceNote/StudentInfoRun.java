package practiceNote;

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
		//Function name 객체 Student
		Function<String,Student> func = str-> new Student(str);
		Student stu1 = func.apply("Sojoo");
		
		
		BiFunction<String, String, Student> func2 = (str1, str2)->new Student(str1, str2);
		Student stu2 = func2.apply("makgulri", "seoul");
		
		
		
		//stu1에 나이와 도시 정보 추가 stu2에 나이정보 추가
		stu1.setAge(20);
		stu1.setCity("서울");
		stu2.setAge(21);
		stu2.setCity("미국");
		System.out.println(stu1.toString()+"||"+stu2.toString());
		
		IntBinaryOperator oper;
		//staticSum 활용할 객체 생성
		oper = new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				return staticSum(left, right);
			}
		};
		int nextyearAge = oper.applyAsInt(stu1.getAge(), 1);//stu1의 나이에 1 더하기
		System.out.println(stu1.getName()+"s next year age:"+nextyearAge );		
		
		//instanceSum을 활용할 객체 생성
		StudentInfoRun sir =new StudentInfoRun();
		oper=(x,y)->sir.instanceSum(x,y);
		nextyearAge = oper.applyAsInt(stu2.getAge(), 1);//stu2의 나이에 1 더하기
		System.out.println(stu2.getName()+"s next year age:"+nextyearAge);
		
		//String 클래스의 비교하는 것중 integer 결과로 나오는 것을 활용한 객체 생성
		ToIntBiFunction<String, String> func3 = (str1,str2)->str1.compareTo(str2);
		compareResult(func3.applyAsInt(stu1.getCity(), stu2.getCity()));//stu1의 도시와 stu2의 도시명을 비교한 결과 출력
		
	}

	public static int staticSum(int x, int y) {
		return x + y;
	}

	public int instanceSum(int x, int y) {
		return x + y;
	}

	public static void compareResult(int result) {
		if(result==0) {
			System.out.println("동일한 문자열입니다.");
			return;
		}
		System.out.println("동일하지 않은 문자열입니다.");
	}
}
