package practice;

public class PracticeCalculatorEx1 {

	public static void main(String[] args) {

		Calculator10 cal = new Calculator10();
		cal.add(3);
		System.out.println(cal.getValue());

		MineralCalculator min = new MineralCalculator();
		min.add(new Gold());
		min.add(new Silver());
		min.add(new Bronze());
		System.out.println(min.getValue());

		Animal a = new Lion();
		Lion b = new Lion();
		Predator c = new Lion();
		System.out.println(c.bark());

	}

}

class Calculator10 {
	Integer value;

	Calculator10() {
		this.value = 0;
	}

	void add(int val) {
		this.value += val;
	}

	public Integer getValue() {
		return this.value;
	}
}

class Gold {

}

class Silver {

}

class Bronze {

}

class MineralCalculator {
	int value = 0;

	public void add(Gold gold) {
		this.value += 100;
	}

	public void add(Silver silver) {
		this.value += 90;
	}

	public void add(Bronze bronze) {
		this.value += 80;
	}

	public int getValue() {
		return this.value;
	}
}

interface Predator {
	String bark();
}

abstract class Animal {
	public String hello() {
		return "hello";
	}
}

class Dog extends Animal {
}

class Lion extends Animal implements Predator {
	public String bark() {
		return "Bark bark!!";
	}
}
