package inheritance;

class Animal {
	String name;

	public void setName(String name) {
		this.name = name;
	}

	void sleep() {
		System.out.println("zzz");
	}

}

class Human extends Animal {
	void sleep() {
		System.out.println("쿨쿨");
	}

}

class Dog extends Animal{
	void sleep() {
		System.out.println(name+"는 그르렁 그르렁");
	}
}

class Cat extends Animal{
	void sleep() {
		System.out.println(name+"는 갸르릉 갸르릉");
	}
}

class PetDog extends Dog{
	void sleep() {
		System.out.println(name+"는 그렁 그렁 집에서 잡니다.");
	}
	
	//오버로딩
	void sleep(int hour) {
		System.out.println(name+"는 "+hour+"시간동안 그렁그렁 집에서 잡니다.");
	}
}

public class AnimalRun {

	public static void main(String[] args) {
		PetDog pDog = new PetDog();
		pDog.setName("해피");
		pDog.sleep();
		pDog.sleep(3);
		Cat c = new Cat();
		c.setName("야옹이");
		c.sleep();
		pDog.sleep();
		
	}

}
