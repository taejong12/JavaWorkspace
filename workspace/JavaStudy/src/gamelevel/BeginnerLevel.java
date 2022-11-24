package gamelevel;

public class BeginnerLevel extends PlayerLevel {
	@Override
	public void run() {
		System.out.println("run slowly.");
	}
	@Override
	public void jump() {
		System.out.println("can't jump.");
	}
	@Override
	public void turn() {
		System.out.println("turn hardly.");
	}
	@Override
	public void showLevelMessage() {
		System.out.println("BeginnerLevel>>>>>>>>>>>");
	}
	@Override
	public void hack() {
		System.out.print("*hack^&*>");
	}
	@Override
	public void slash() {
		System.out.print("~slash--<>");
	}
}
