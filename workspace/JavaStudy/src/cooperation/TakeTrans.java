package cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		Passenger kim = new Passenger("이순신", 9000);
		Passenger lim = new Passenger("홍길동", 12000);
		Bus bus122 = new Bus(122);
		Subway subway2 = new Subway(2);
		Trans bus233 = new Bus(233);
		
		kim.takeBus(bus122);
		lim.takeSubway(subway2);
		kim.takeTrans(bus233, 1200);
		lim.takeTrans(subway2, 1500);
		
		kim.showInfo();
		lim.showInfo();
		bus122.showInfo();
		subway2.showInfo();
		bus233.showInfo();
	}
}
