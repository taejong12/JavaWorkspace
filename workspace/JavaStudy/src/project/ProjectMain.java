package project;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ProjectMain {

	private static int usernum = 0;
	private static ProjectStudentInfo psi[] = new ProjectStudentInfo[300];
	private static Scanner sc = new Scanner(System.in);
	private static String inputId, inputPassword;

	public static void main(String[] args) {

		ProjectSubject ps = new ProjectSubject();

		ProjectInputMethod pim = new ProjectInputMethod();

		ProjectView pv = new ProjectView();

		for (int i = 0; i < 10; i++) { // NullpointerException 방지 배열 초기화
			psi[i] = new ProjectStudentInfo();
		}

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("원하는 메뉴를 숫자로 입력하여 선택하세요:");
				System.out.println("1.회원가입 2.로그인 3.탈퇴 4.종료");
				System.out.print("선택 > ");
				int select = sc.nextInt();
				if (select == 1) {// 회원가입 선택
					if (usernum == 300) {
						System.out.println("용량 초과 회원가입 실패");
						break;
					} else {
						createAccount();
					}
				} else if (select == 2) {// 로그인 선택
					while (true) {
						loginAccount();
						pv.View();
						int number = sc.nextInt();
						if (number == 1) {
							pim.Input();
						} else if (number == 2) {
							pim.StudentScore();
						} else if (number == 3) {
							pim.StudentAverage();
						} else if (number == 4) {
							pim.StudentRanking();
						} else if (number == 5) {
							System.out.println("종료하겠습니다.");
							break;
						}
					}
				} else if (select == 3) {
					deleteAccount();
				} else {// 종료선택
					System.out.println("프로그램 종료");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 숫자를 선택하세요.");
			} catch (NullPointerException e) {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 입력해주세요.");
			}
		}

	}

	private static void createAccount() {// 회원가입선택
		System.out.println("아이디를 입력하세요:");
		inputId = sc.next();
		psi[usernum].setStudentId(inputId);
		System.out.println("비밀번호를 입력하세요:");
		inputPassword = sc.next();
		psi[usernum].setStudentPassword(inputPassword);
		usernum++;
		System.out.println("회원가입완료!!");
	}

	private static void loginAccount() {// 로그인 선택
		System.out.print("아이디를 입력하세요:");
		inputId = sc.next();
		System.out.println("비밀번호를 입력하세요:");
		inputPassword = sc.next();

		int loginSuccess = 0;
		for (int i = 0; i < psi.length; i++) {
			if (inputId.equals(psi[i].getStudentId()) && inputPassword.equals(psi[i].getStudentPassword())) {
				System.out.println("로그인 성공");
				System.out.println(psi[i].getStudentId());
				loginSuccess = 1;
				break;
			}
		}
		if (loginSuccess == 0) {
			System.out.println("로그인 실패");
		}
	}

	private static void deleteAccount() { // 탈퇴선택
		System.out.println("아이디를 입력하세요:");
		inputId = sc.next();
		System.out.println("비밀번호를 입력하세요:");
		inputPassword = sc.next();
		int deleteSuccess = 0;
		for (int i = 0; i < psi.length; i++) {
			if (inputId.equals(psi[i].getStudentId()) && inputPassword.equals(psi[i].getStudentPassword())) {
				System.out.println("탈퇴 성공");
				psi[i].setStudentId(null);
				psi[i].setStudentPassword(null);
				deleteSuccess = 1;
			}
		}
		if (deleteSuccess == 0) {
			System.out.println("일치하는 정보 없음");
		}
	}

}
