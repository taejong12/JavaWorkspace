package throwable;

public class ArithmeticRun {

	public static void main(String[] args) {
//		System.out.println(5/0);

		try {
			byte[] list = {'a','b','c'};
			System.out.println(list[5]);
			System.out.println(5 / 0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("예외 원인:" + e.getMessage());
			System.out.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("반드시 실행");
		}
	}

}
