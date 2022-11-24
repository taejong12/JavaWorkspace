package classPrac;

public class Student {
	int studentID;
	String studentName;
	String address;
	String gender;

	Subject korea;
	Subject math;
	Subject english;

	public Student() {
		korea = new Subject();
		math = new Subject();
		english = new Subject();
	}

	public Student(int id, String name) {
		this();
		studentID = id;
		studentName = name;
		/*
		 * korea = new Subject(); math = new Subject(); english = new Subject();
		 */
	}

	public Student(int studentID, String studentName, String gender) {
		// this(); (O) //생성자를 호출하는 것을 생성자 안에서 첫줄이어야 한다!!
		this.studentID = studentID;
		this.studentName = studentName;
		this.gender = gender;
		korea = new Subject();
		math = new Subject();
		english = new Subject();
		//this(); (X) //첫줄에서 호출해야 한다!!
	}

	public void showStudentInfo() {
		System.out.println(studentID + "," + studentName + "," + address + "," + gender);
	}

	// getter%setter
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Subject getKorea() {
		return korea;
	}

	public void setKorea() {
		this.korea = new Subject();
	}

}
