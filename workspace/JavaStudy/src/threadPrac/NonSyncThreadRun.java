package threadPrac;

//여러개의 스레드 같이 접근할 수 있는 공통된 곳
class Result{
	int result=100;
	
	public void calResult() {
		int temp = result;
		System.out.println(temp);
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
		}
		result = result/2;
		System.out.println(result);
	}
}

class CalThread extends Thread{
	Result result;
	public CalThread(Result result) {
		this.result=result;
	}
	
	@Override
	public void run() {
		result.calResult();
		System.out.println(getName()+" "+result.result);
	}
}

public class NonSyncThreadRun {

	public static void main(String[] args) {
		Result res = new Result();
		
		Thread cal1 = new CalThread(res);
		cal1.setName("1번쓰레드");
		cal1.start();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			
//		}
		
		Thread cal2 = new CalThread(res);
		cal2.setName("2번쓰레드");
		cal2.start();
		

	}

}
