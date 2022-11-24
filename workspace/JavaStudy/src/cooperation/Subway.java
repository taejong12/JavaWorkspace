package cooperation;

public class Subway extends Trans {
	private int lineNumer;
	private int passengerCount;
	private int income;
	
	public Subway(int lineNumber) {
		this.lineNumer=lineNumber;
	}
	
	public void take(int money) {
		this.income += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.println("==========================");
		System.out.println(lineNumer+"번 지하철");
		System.out.println("탑승객 수:"+passengerCount);
		System.out.println("총 수익:"+income);
		System.out.println("==========================");
	}
}
