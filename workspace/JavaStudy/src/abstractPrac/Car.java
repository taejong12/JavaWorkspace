package abstractPrac;

public abstract class Car {
	public abstract void drive();

	public abstract void stop();

	public abstract void turnOn();

	public abstract void turnOff();

	// 탬플릿메소드
	final public void run() {
		turnOn();
		drive();
		stop();
		turnOff();

	}
}
