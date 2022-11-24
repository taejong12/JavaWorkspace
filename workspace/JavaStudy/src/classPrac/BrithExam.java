package classPrac;

class Birthday {
	// 필드 멤버변수
	private int date;
	private int month;
	private int year;

	// 생성자
	public Birthday() {
		//this.year=1933; this.month=4;this.date=3;
		this(1970,3,15);
	}

	// class this
	public Birthday(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	// 메소드
	public int getDate() {
		return date;
	}
	public int getMonth() {
		return month;
	}
	public int year() {
		return year;
	}
	public void setDate(int date) {
		if(date<=30) {
		this.date=date;
		}
	}
	public void setMonth(int month) {
		this.month=month;
	}
	public void setYear(int year) {
		this.year=year;
	}
	
	
	public String toString() {
		return year+"년"+month+"월"+date+"일";	
	}
	public Birthday returnSelf() {
		return this;
	}
}

public class BrithExam {

	public static void main(String[] args) {
		Birthday bDay1 = new Birthday(2022,7,27);
		Birthday bDay2 = new Birthday();
		System.out.println(bDay1.toString());
		System.out.println(bDay2.toString());
		System.out.println(bDay1.returnSelf());
		System.out.println(bDay2.returnSelf());
		System.out.println(bDay1.getDate());
		bDay1.setDate(150);
		System.out.println(bDay1.toString());
		
	}

}
