package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticeCalculatorEx {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.add(10);
		cal.minus(3);
		System.out.println(cal.getValue());

		MaxLimitCalculator cal1 = new MaxLimitCalculator();
		cal1.add(50);
		cal1.add(60);
		System.out.println(cal1.getValue());

		int[] data = { 1, 3, 5, 7, 9 };
		Calculator cal2 = new Calculator();
		int result = cal2.avg(data);
		System.out.println(result);

		ArrayList<Integer> data1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
		Calculator cal3 = new Calculator();
		int result1 = cal3.avg(data1);
		System.out.println(result1);
		
		
	}
}

class Calculator {
	int value;

	Calculator() {
		this.value = 0;
	}

	public int avg(ArrayList<Integer> val) {
		int sum = 0;
		int avg = 0;
		
		for (int i = 0;i<val.size(); i++) {
			sum += val.get(i);
		}
		return avg = sum / (val.size());
	}

	void add(int val) {
		this.value += val;
	}

	void minus(int val) {
		this.value -= val;
	}

	boolean isOdd(int val) {
		return val % 2 == 0;
	}

	int avg(int[] val) {
		int sum = 0;
		int avg = 0;
		for (int i = 0;i<val.length; i++) {
			sum += val[i];
		}
		return avg = sum / (val.length);
	}

	int getValue() {
		return this.value;
	}

}

class MaxLimitCalculator extends Calculator {
	int value;

	public MaxLimitCalculator() {
		this.value = 0;
	}

	@Override
	void add(int val) {
		this.value += val;
	}

	@Override
	int getValue() {
		return this.value;
	}

}