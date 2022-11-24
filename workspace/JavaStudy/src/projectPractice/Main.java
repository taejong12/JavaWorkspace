package projectPractice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. 회원가입 2. 로그인 3. 회원정보수정 4. 회원탈퇴 5. 종료
		// 회원가입 학생과 선생님 별개 아이디와 비밀번호, 이름 저장하는데 중복 x
		// 로그인 아이디와 비밀번호 아이디, 비밀번호 틀리면 틀린다고 예외처리
		// 회원정보수정 아이디 비밀번호 이름 변경가능
		// 종료 누르면 아웃
		
		Scanner scanner=new Scanner(System.in);
		// 객체, setScanner() 메서드, start() 메서드 만들어서 넣기
		ScannerManagement scannerManagement = new ScannerManagement();
		scannerManagement.setScanner(scanner);
		scannerManagement.start();
		

	}

}
