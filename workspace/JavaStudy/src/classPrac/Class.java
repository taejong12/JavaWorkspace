package classPrac;

public class Class {
	static int a=2;

	public static void main(String[] args) {
		Student studentA = new Student();
		studentA.korea.getSubjectName();

		Student studentB = new Student(100, "이순신");
		studentB.english = new Subject();
		studentB.english.getSubjectName();

		studentB.setKorea();
		studentB.korea.getScore();
		Subject sub = studentB.getKorea();
		sub.getScore();

		studentA.studentID = 100;
		studentA.studentName = "홍길동";
		studentA.address = "서울시 어딘가";
		studentA.gender = "남성";

		studentA.showStudentInfo();
		
		System.out.println(addInt(10,20));
		printA(false);
		printA(true);
	}
	
	public static int addInt(int n1,int n2) {
		return n1+n2;
	}

	public static void printA(boolean stop) {
		if(stop) {
			System.out.println("stop");
			return;
		}
		System.out.println("print:"+a);
	}
}
