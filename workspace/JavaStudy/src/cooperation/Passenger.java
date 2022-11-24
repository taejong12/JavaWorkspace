package cooperation;

public class Passenger {
	private String passengerName;
	private int money;
	
	public Passenger(String passenger, int money) {
		this.passengerName = passenger;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.take(1000);
		money -= 1000;
	}
	
	public void takeSubway(Subway subway) {
		subway.take(1000);
		money -= 1000;
	}
	
	public void takeTrans(Trans trans,int money) {
		trans.take(money);
		this.money -= money;
	}
	
	public void showInfo() {
		System.out.println("==========================");
		System.out.println("승객:"+passengerName);
		System.out.println("소지금:"+money);
		System.out.println("==========================");
		
	}
	
}
