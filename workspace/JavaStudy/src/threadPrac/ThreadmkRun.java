package threadPrac;

class DdukThread extends Thread {
	// Thread를 상속받아 클래스를 생성
	@Override
	public void run() {
		String[] lman = { "짝", "떡", "짝", "떡", "짝", "떡" };
		for (int i = 0; i < lman.length; i++) {
			System.out.println("왼쪽 떡방아:" + lman[i]);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {

			}
		}
	}
}

//class DdukThread2 extends Thread {
//
//	@Override
//	public void run() {
//
//		String[] rman = { "쿵", "쿵", "쿵", "쿵", "쿵", "쿵" };
//
//		for (int i = 0; i < rman.length; i++) {
//			System.out.println("오른쪽 떡방아:" + rman[i]);
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//
//			}
//		}
//	}
//}

//런만 있고 스타트는 없다
class DdukRunnable implements Runnable {
	@Override
	public void run() {

		String[] rman = { "쿵", "쿵", "쿵", "쿵", "쿵", "쿵" };

		for (int i = 0; i < rman.length; i++) {
			System.out.println("오른쪽 떡방아:" + rman[i]);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {

			}
		}
	}
}

public class ThreadmkRun {
	public static void main(String[] args) {
		// thread 생성
		Thread ldduk = new DdukThread();

		// thread는 start로 실행
		ldduk.start();

		// Runnable 구현한 클래스 객체 생성
		Runnable rman = new DdukRunnable();

		// 스타트가 없어서 추가했다
		Thread rdduk = new Thread(rman);
		// Thread rdduk = new Thread(new DdukRunnable());
		rdduk.start();

//		Runnable ra = new Runnable() {
//			@Override
//			public void run() {
//				String[] tman = { "핫", "핫", "핫", "핫", "핫", "핫" };
//				for (int i = 0; i < tman.length; i++) {
//					System.out.println("떡 마는 사람:" + tman[i]);
//					try {
//						Thread.sleep(300);
//					} catch (InterruptedException e) {
//
//					}
//				}
//			}
//		};
//		Thread tdduk = new Thread(ra);
//		tdduk.start();
//	}

		Thread tdduk = new Thread(new Runnable() {
			@Override
			public void run() {
				String[] tman = { "핫", "핫", "핫", "핫", "핫", "핫" };
				for (int i = 0; i < tman.length; i++) {
					System.out.println("떡 마는 사람:" + tman[i]);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {

					}
				}
			}
		});
		tdduk.start();

	}

//		Thread rdduk = new DdukThread2();
//		
//		rdduk.start();

//		String[] rman = { "쿵", "쿵", "쿵", "쿵", "쿵", "쿵" };
//
//		for (int i = 0; i < rman.length; i++) {
//			System.out.println("오른쪽 떡방아:" + rman[i]);
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				
//			}
//		}

//		for(int i=0;i<lman.length;i++) {
//			System.out.println("왼쪽 떡방아:"+lman[i]);
//			try {
//				Thread.sleep(300);
//			} catch(InterruptedException e) {
//				
//			}
//		}

	// thread 생성 Class Thread 를 상속받아서 만든다
	// Runnable 구현해야 하는 내용이다
	// 상태를 변경해주는 run 클래스에서 하는 일은 기초적인 환경을 구성해주고 실행시켜주는 일 run만 호출하면 아무것도 없다
	// run 안 쪽에 오버라이딩해서 동작을 구현해줘야한다
	// 동작은 start로 해준다
	// 스타트와 런의 차이
	// 런은 우리가 실행하고자 하는 것, 실제 구현은 런에 한다
	// 스타트는 런+실행시켜주기 위한 환경설정, 실제 실행은 스타트로 한다
	// 런을 만드는건 runable
	
	
}
