package abstractPrac;

public class ComTest {

	public static void main(String[] args) {
		//Computer com = new Computer(); // 추상클래스는 객체 생성 불가
		//추상클래스 객체 생성 방법
		//1.자식클래스를 생성하면서 함께 만드는 방법
		Computer computer = new Desktop();
		//2.익명 클래스를 통해서 생성하는 방법
		Computer com = new Computer() {
			@Override
			public void typing() {
				System.out.println("익명내부클래스");
			}
			
		};
		com.typing();
		computer.display();
		computer.typing();
		computer.turnOn();
		computer.turnOff();
		Computer com2 = new PortableNoteBook();
		NoteBook com3 = new PortableNoteBook();
		com2.display();
		com3.display();
		com2.typing();
		com3.typing();
	}

}
