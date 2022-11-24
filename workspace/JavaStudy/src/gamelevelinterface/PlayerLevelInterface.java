package gamelevelinterface;

public interface PlayerLevelInterface {
	public abstract void run(); // abstract 생략 가능
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	public abstract void hack();
	public abstract void slash();
	
	default void go(int count) {
		run();
		jump();
		for(int i=0;i<count;i++) {
			hack();
			slash();
			System.out.println();
		}
		turn();
	}
}
