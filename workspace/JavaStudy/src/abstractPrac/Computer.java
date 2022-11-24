package abstractPrac;

public abstract class Computer {

	public void display() {
	};

	// public void test(); //실행문 or abstract

	public abstract void typing(); // 추상메서드

	public void turnOn() {
		System.out.println("전원켜기");
	}

	public void turnOff() {
		System.out.println("전원끄기");
	}
}
