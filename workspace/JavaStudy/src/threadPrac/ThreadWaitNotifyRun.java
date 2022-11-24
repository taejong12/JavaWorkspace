package threadPrac;

class SaveBox {
	boolean isEmpty = true;
	int num;

	synchronized void inputNum(int num) {
		if (!isEmpty) {
			try {
				wait();//대기실에 넣는다 저장되어 있는 wait부터 시작
 			} catch (InterruptedException e) {
			}
		}
		this.num = num;
		isEmpty = false;
		System.out.println("input:" + num);
		notify();// 대기자한테 알려준다
	}

	synchronized void outputNum() {
		if (isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("output:" + num);
		isEmpty = true;
		notify();
	}
}

public class ThreadWaitNotifyRun {

	public static void main(String[] args) {
		SaveBox sb = new SaveBox();

		Thread t1 = new Thread() {
			public void run() {
				for (int i = 1; i < 10; i++) {
					sb.inputNum(i);
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 1; i < 10; i++) {
					sb.outputNum();
				}
			}
		};

		t1.start();
		t2.start();

	}

}
