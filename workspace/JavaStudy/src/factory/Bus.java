package factory;

public class Bus extends Car {
	public static void main(String[] args) {
		Bus b = new Bus();
		//b.carNum(); //private 접근 불가
		int speed = b.speed; // default
		b.getSpeed(); //protected
		b.getCarNum(); //public
	}
}
