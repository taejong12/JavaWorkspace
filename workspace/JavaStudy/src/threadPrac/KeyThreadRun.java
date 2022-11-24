package threadPrac;

//공유되는 객체 필요
//키값이 같을 때는 동시에 진행할 수 없다 각자 따로 구분돼서 진행된다
class CommonUse {
	synchronized void commonMethod1() {
		for (int i = 0; i < 4; i++) {
			System.out.println(i + "★");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

		}
	}

	synchronized void commonMethod2() {
		for (int i = 0; i < 4; i++) {
			System.out.println(i + "□");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

		}
	}

	Object obj = new Object();
	void commonMethod3() {
		synchronized (obj) { // 키값에는 object 객체 아무거나 들어갈 수 있다 객체가 가지고 있는 구별값을 키값으로 사용한다
			for (int i = 0; i < 4; i++) {
				System.out.println(i + "※");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	//키값으로 중복 조절이 가능하다
	void commonMethod4() {
		synchronized (obj) { // 키값에는 object 객체 아무거나 들어갈 수 있다 객체가 가지고 있는 구별값을 키값으로 사용한다
			for (int i = 0; i < 4; i++) {
				System.out.println(i + "＃");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}
//	void commonMethod3() {
//		synchronized (new Object()) { // 키값에는 object 객체 아무거나 들어갈 수 있다 객체가 가지고 있는 구별값을 키값으로 사용한다
//			for (int i = 0; i < 4; i++) {
//				System.out.println(i + "※");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//				}
//			}
//		}
//	}
//	
//	//위에 값이랑 주소값이 달라서 키값이 다르다 그래서 자기 마음대로 찍는다
//	void commonMethod4() {
//		synchronized (new Object()) { // 키값에는 object 객체 아무거나 들어갈 수 있다 객체가 가지고 있는 구별값을 키값으로 사용한다
//			for (int i = 0; i < 4; i++) {
//				System.out.println(i + "＃");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//				}
//			}
//		}
//	}
}

public class KeyThreadRun {

	public static void main(String[] args) {
		CommonUse cu = new CommonUse();
		
		new Thread() {
			public void run() {
				cu.commonMethod1();
			};
		}.start();
		
		new Thread() {
			public void run() {
				cu.commonMethod2();
			};
		}.start();
		
		new Thread() {
			public void run() {
				cu.commonMethod3();
			};
		}.start();
		
		new Thread() {
			public void run() {
				cu.commonMethod4();
			};
		}.start();
	}

}
