package road;

import factory.Car;

public class CarTestRoad {

	public static void main(String[] args) {
		Car c = new Car();
		//c.carNum; //private 접근 불가
		//int speed = c.speed; //default
		//c.getSpeed(); //protected
		c.getCarNum(); //public
		
	}

}
