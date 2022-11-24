package threadPrac;

import java.time.LocalTime;

class JoinThread extends Thread {
	@Override
	public void run() {
		System.out.println(LocalTime.now() + "Thread start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Interrupt 발생");
		}
		System.out.println(LocalTime.now() + "Thread end");
	}
}

public class JoinThreadRun {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new JoinThread();
		System.out.println(LocalTime.now()+"쓰레드 시작");
		thread.start();
		System.out.println(LocalTime.now()+"쓰레드 종료 대기");
		thread.join();
		System.out.println(LocalTime.now()+"쓰레드 종료여부 확인"+thread.isAlive());
		
	}

}
