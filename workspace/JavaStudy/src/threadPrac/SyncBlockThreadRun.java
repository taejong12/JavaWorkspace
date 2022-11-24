package threadPrac;

class SyncBlockResult {
	int result = 10;
	

	public void minusResult() {
		//synchronized(key) 키값을 어디랑 어디랑 같게 할것인가 함께 막을 곳을 정의할 수 있다
		synchronized(this) { 
		int temp = result;
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
		}
		result -= 1;
		}	
	}
}

class MinusThread extends Thread {
	SyncBlockResult sbres;

	public MinusThread(SyncBlockResult sbres) {
		this.sbres = sbres;
	}

	@Override
	public void run() {
		sbres.minusResult();
		System.out.println(getName() + " " + sbres.result);
	}
}

public class SyncBlockThreadRun {

	public static void main(String[] args) {
		SyncBlockResult sb = new SyncBlockResult();

		Thread mt1 = new MinusThread(sb);
		mt1.setName("1 thread");
		mt1.start();

		Thread mt2 = new MinusThread(sb);
		mt2.setName("2 thread");
		mt2.start();

	}

}
