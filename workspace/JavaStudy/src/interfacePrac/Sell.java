package interfacePrac;

public interface Sell {
	void sell();
	default void order() {
		System.out.println("ํ๋งค์๋ฃ");
	}
}
