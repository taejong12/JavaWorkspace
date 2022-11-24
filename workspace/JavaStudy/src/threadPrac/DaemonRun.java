package threadPrac;

class CoThread extends Thread {

	@Override
	public void run() {
		System.out.println(getName());
		if (isDaemon()) {
			for (int i = 0; i < 10; i++) {
				System.out.println("     ||");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		} else {
			for (int i = 0; i < 7; i++) {
				System.out.println("||");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

public class DaemonRun {

	public static void main(String[] args) {
		Thread normalTh = new CoThread();
		normalTh.setName("normal thread");
		normalTh.setDaemon(false); // 기본적으로 false 로 되어있다
		normalTh.start();

		Thread deamonTh = new CoThread();
		deamonTh.setName("Daemon thread");
		deamonTh.setDaemon(true);
		deamonTh.start();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

		}
		System.out.println("main terminated");
	}

}
