package threadPrac;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class ThreadStateBasicRun {

	public static void main(String[] args) {
		// 상태읽어오기
		// NEW 객체 생성 -RUNNABLE 실행대기 -실행 -TERMINATER 종료
		Thread test = new Thread() {
			public void run() {
				for (long i = 0; i < 9999999999L; i++) {
				}
			}
		};
		System.out.println(test.getState());
		test.start();
		System.out.println(test.getState());
		// 메인 스레드, 테스트 스레드 따로 노는데 조인이라고 하면 메인한테 오던 처리(cpu)를 테스트로 보낸다
		try {
			test.join();
		} catch (InterruptedException e) {
		}
		System.out.println(test.getState());
	}

}
