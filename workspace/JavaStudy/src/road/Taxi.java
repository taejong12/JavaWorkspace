package road;

import factory.Car;

public class Taxi extends Car {
	public static void main(String[] args) {
		Taxi c = new Taxi();
		//c.carNum; //private 접근 불가
		//int speed = c.speed; //default
		c.getSpeed(); //protected
		c.getCarNum(); //public
		
	}
	
}
