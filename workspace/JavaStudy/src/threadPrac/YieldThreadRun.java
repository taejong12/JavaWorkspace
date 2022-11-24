package threadPrac;

class SharedClass {
	private int sum = 0;

	public void add(int x) {
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"시작");
		sum += x;
		System.out.println(Thread.currentThread().getName()+"끝");
	}

	public void getSum() {
		System.out.println(sum);
	}
}

public class YieldThreadRun {

	public static void main(String[] args) {
		// Yield 누군가에게 해당하는 자리를 양보해주다
		// NEW 객체 생성 -RUNNABLE 실행대기 -실행 -TERMINATER 종료
		
		SharedClass sc = new SharedClass();
		Thread t1 = new Thread() {
			public void run() {
				sc.add(13);
				sc.getSum();
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				sc.add(10);
				sc.getSum();
			}
		};

		t1.start();
		t2.start();

	}

}
