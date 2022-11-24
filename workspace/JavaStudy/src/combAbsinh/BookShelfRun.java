package combAbsinh;

public class BookShelfRun {

	public static void main(String[] args) {
		Queue sQueue = new BookShelf(); 
		Shelf sShelf = new BookShelf();
		BookShelf b = new BookShelf();
		b.enQueue("우리집");
		b.deQueue2();
		
		sQueue.enQueue("태백산맥1");
		sQueue.enQueue("태백산맥2");
		sQueue.enQueue("태백산맥3");
		sQueue.enQueue("태백산맥4");
		sQueue.enQueue("태백산맥5");
		
		//sQueue.deQueue2();
		//sShelf.enQueue(); // 정의된 곳이 인터페이스여서 안됨
		//sShelf.deQueue2(); // 변수의 타입에 정의된 메소드만 사용가능
		
		System.out.println(sQueue.deQueue());
		System.out.println(sQueue.getSize());
		System.out.println(sQueue.deQueue());
		System.out.println(sQueue.getSize());
	}

}
