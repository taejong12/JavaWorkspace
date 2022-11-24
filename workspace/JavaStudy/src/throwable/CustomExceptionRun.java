package throwable;

import java.nio.file.attribute.AclEntry;

public class CustomExceptionRun {

	public static void main(String[] args) {
		Sample s = new Sample();
		try {
		s.sayNic("바보"); //예외발생
		s.sayNic("말미잘"); //실행안됨
		}catch(FoolException e) {
			System.out.println("FoolException 발생");
		}
	}

}

class Sample {

	public void sayNic(String nick) throws FoolException { // 별명을 부르는 메소드 출력
//		try {
		if ("바보".equals(nick)) {
			throw new FoolException();
		} else {
			System.out.printf("당신의 별명은 %s 입니다.", nick);
		}
//		} catch (FoolException e) {
//			System.out.println("FoolException 발생");
//		}
	}
}

class FoolException extends Exception {
	
}
