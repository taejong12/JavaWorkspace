package threadPrac;

class DelayThread extends Thread{
	//run은 반드시 오버라이드 해야 한다
	@Override
	public void run() {
		for(int i=0;i<9999999;i++) {
			
		}
		// 우선순위 getPriority 기본이 5
		System.out.println(getName()+"||Priority"+getPriority()); 
	}
	
}

public class ThreadInffoRun {

	public static void main(String[] args) {
		Thread cut = Thread.currentThread();
		System.out.println(cut.getName());
		System.out.println(Thread.activeCount());
		System.out.println(cut.getState());
		System.out.println();

		for (int i = 0; i < 5; i++) {
			Thread th = new Thread();
			System.out.println(th.getName());
			System.out.println(Thread.activeCount());
			th.start();
			System.out.println(Thread.activeCount());
		}
		System.out.println();
		
		Thread thread = new Thread();
		thread.setName("직접만든 이름 쓰레드");
		thread.start();
		System.out.println(thread.getName());
		System.out.println(Thread.activeCount());
		System.out.println();
		
		for(int i=0;i<3;i++) {
			Thread dth=new DelayThread();
			dth.start();
		}
		System.out.println();
		System.out.println(Thread.activeCount());
		
		for(int i=0;i<3;i++) {
			Thread dth = new DelayThread();
			dth.setName("직접지정10 "+i+"쓰레드");
			dth.setPriority(10);
			dth.start();
		}
		System.out.println(Thread.activeCount());
		
		for(int i=0;i<3;i++) {
			Thread dth = new DelayThread();
			dth.setName("직접지정1 "+i+"쓰레드");
			dth.setPriority(1);
			dth.start();
		}
		System.out.println(Thread.activeCount());
		
	}

}
