package throwable;

import java.lang.invoke.WrongMethodTypeException;

class NoExistIDException extends Exception { // NoExistIDException // 예외 클래스 기본 생성자 메세지를 받는 생성자

	public NoExistIDException() {
	}

	public NoExistIDException(String message) {
		super(message);
	}
}

class WrongPasswordExceptiom extends Exception { // WrongPasswordExceptiom// 예외 클래스 기본 생성자 메세지를 받는 생성자

	public WrongPasswordExceptiom() {
	}

	public WrongPasswordExceptiom(String message) {
		super(message);
	}
}

public class LoginProc {

	public static void main(String[] args) {
		try {
			login("apple", "1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			login("java", "12345");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	public static void login(String id, String pw) throws Exception {
//		String[] idArr = { "ajax", "java", "script", "css" };
//		String[] pwArr = { "1234", "2345", "3456", "4567" };
//		Stirng result = "";
//		for (int i = 0; i < idArr.length; i++) {
//			// 아이디가 존재하는지 체크
//			if (!idArr[i].equals(id)) {
//				result="NoExistID";
//			}
//			// 해당 아이디에 대한 패스워드 맞는지 확인
//			else {
//				if (!pwArr[i].equals(pw)) {
//					result="WrongPW";
//				}
//				// 아이디도 있고 패워드 맞으면
//				else {
//					System.out.println("로그인 완료.");
//					break;
//				}
//			}
//		}
//		switch (result) {
//		case "NoExistID":
//			throw new NoExistIDException("아이디가 존재하지 않습니다");
//		case "WrongPW":
//			throw new WrongMethodTypeException("패스워드가 틀립니다.");
//		default:
//		}
	public static void login(String id, String pw) throws Exception {
		String oId = "java";
		String oPW = "1234";
		if (!oId.equals(id)) {
			throw new NoExistIDException("아이디가 존재하지 않습니다");
		} else {
			if (!oPW.equals(pw)) {
				throw new WrongMethodTypeException("패스워드가 틀립니다.");
			}
			else {
				System.out.println("로그인 완료.");
			}

		}
	}
}
