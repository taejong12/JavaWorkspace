package cooperation;

public class Bus extends Trans {
	private int busNumber;
//	private int passengerCount;
//	private int income;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	public void take(int money) {
		this.income += money;
		passengerCount++;
	}
	public void showInfo() {
		System.out.println("==========================");
		System.out.println(busNumber+"번 Bus");
		System.out.println("탑승객수:"+passengerCount);
		System.out.println("총 수익:"+income);
		System.out.println("==========================");
	}
}
