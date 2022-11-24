package threadPrac;

//여러개의 스레드 같이 접근할 수 있는 공통된 곳
class SyncResult {
	int result = 100;

	public synchronized void calResult() {
		int temp = result;
		System.out.println(temp);
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
		}
		result = result / 2;
		System.out.println(result);
	}
}

class SyncCalThread extends Thread {
	SyncResult result;

	public SyncCalThread(SyncResult result) {
		this.result = result;
		System.out.println(getState());
	}

	@Override
	public void run() {
		result.calResult();
		System.out.println(getName() + " " + result.result);
		System.out.println(getState());
	}
}

public class SyncThreadRun {

	public static void main(String[] args) {
		SyncResult res = new SyncResult();

		Thread cal1 = new SyncCalThread(res);
		cal1.setName("1번쓰레드");
		cal1.start();

		Thread cal2 = new SyncCalThread(res);
		cal2.setName("2번쓰레드");
		cal2.start();
	}

}
