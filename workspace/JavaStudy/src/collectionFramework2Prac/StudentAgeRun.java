package collectionFramework2Prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
	int stuId;
	String name;
	int age;

	public Student(int stuId, String name, int age) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return stuId+" "+name+" "+age;
	}
}

//Comparable-compareTo 나랑 특정대상이랑 비교 그 클래스에서 만들어진 객체랑 다른 클래스에서 만들어진 객체 비교
//Comparator-compare 나랑 상관없이 다른 2개의 객체를 비교
class AgeComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.age-o2.age;
//		if (o1.age == o2.age)
//			return 0;
//		else if (o1.age > o2.age)
//			return 1;
//		else
//			return -1;
	}

}

public class StudentAgeRun {

	public static void main(String[] args) {
		ArrayList<Student> alist = new ArrayList<>();
		alist.add(new Student(111,"구름",10));
		alist.add(new Student(222,"달",11));
		alist.add(new Student(333,"해",12));
		System.out.println(alist);
		Collections.sort(alist, new AgeComparator());
		System.out.println(alist);
		
		ArrayList<Student> alist2 = new ArrayList<>();
		alist2.add(new Student(222,"달",11));
		alist2.add(new Student(333,"구름",12));
		alist2.add(new Student(111,"해",10));
		System.out.println(alist2);
		Collections.sort(alist2, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		System.out.println(alist2);
		
		Student s1 = new Student(222,"달",11);
		Student s2 = new Student(333,"해",12);
	}

}
