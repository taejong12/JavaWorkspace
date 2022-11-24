package projectPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerManagement {

	Scanner scanner;
	ArrayList<MembershipInfo> arrayListMembershipInfo = new ArrayList<>();
	MembershipInfo membershipInfo = new MembershipInfo();

	ArrayListStore arrayListStore = new ArrayListStore();

	void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	void start() {
		LoginView loginView = new LoginView();

		while (true) {
			loginView.loginView();
			int select = scanner.nextInt();

			if (select == 1) { // 회원가입
				singUp();

			} else if (select == 2) { // 로그인
				login();

			} else if (select == 3) { // 회원정보수정
				editProfile();

			} else if (select == 4) { // 회원탈퇴
				withdrawal();

			} else if (select == 5) { // 종료
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}
		}
	}

	void singUp() { // 회원가입
		System.out.println("====학생 회원가입====");
		System.out.print("생성할 아이디: ");
		String mId=scanner.next();
		membershipInfo.setMembershipId(mId);
		System.out.print("생성할 비밀번호: ");
		String mPw=scanner.next();
		membershipInfo.setMembershipPassword(mPw);
		System.out.print("생성자 이름: ");
		String mNa=scanner.next();
		membershipInfo.setMembershipName(mNa);
		System.out.println(membershipInfo.getMembershipName() + "님 회원가입이 완료되었습니다.");
		arrayListMembershipInfo.add(membershipInfo);
		for(int i=0;i<arrayListMembershipInfo.size();i++) {
			if(arrayListMembershipInfo.get(i).getMembershipId()==mId
			&& arrayListMembershipInfo.get(i).getMembershipPassword()==mPw
			&& arrayListMembershipInfo.get(i).getMembershipName()==mNa
			&& arrayListMembershipInfo.get(i).getMembershipId()!=null) {
				System.out.println("중복 생성 불가");
				break;
			}
		}
		start();
	}

	void login() { // 로그인
		System.out.println("====학생 로그인====");
		System.out.print("로그인 아이디: ");
		String mId = scanner.next();
		System.out.print("로그인 비밀번호: ");
		String mPw = scanner.next();

		for (int i = 0; i < arrayListMembershipInfo.size(); i++) {
			if (mId.equals(arrayListMembershipInfo.get(i).getMembershipId())
					&& mPw.equals(arrayListMembershipInfo.get(i).getMembershipPassword())) {
				System.out.println(membershipInfo.getMembershipName() + "님 로그인이 완료되었습니다.");
			} else {
				System.out.println("로그인 실패");
			}
		}

	}

	int n=0;
	
	void editProfile() { // 회원정보수정
		System.out.println("====학생 회원정보수정====");
		System.out.print("로그인 아이디: ");
		String mId = scanner.next();
		System.out.print("로그인 비밀번호: ");
		String mPw = scanner.next();
		System.out.print("이름: ");
		String mNa = scanner.next();
		for (int i = 0; i < arrayListMembershipInfo.size(); i++) {
			if (mId.equals(arrayListMembershipInfo.get(i).getMembershipId())
					&& mPw.equals(arrayListMembershipInfo.get(i).getMembershipPassword())
					&& mNa.equals(arrayListMembershipInfo.get(i).getMembershipName())) {
					System.out.println("====수정하실 항목을 선택하세요.====");
					System.out.println("1.아이디 2.비밀번호 3.이름");
					n=scanner.nextInt();
					
					switch(n) {
					case 1:
						System.out.println("아이디를 새로 입력하세요.");
						mId=scanner.next();
						arrayListMembershipInfo.get(i).setMembershipId(mId);
						break;
					case 2:
						System.out.println("비밀번호를 새로 입력하세요.");
						mPw=scanner.next();
						arrayListMembershipInfo.get(i).setMembershipPassword(mPw);
						break;
					case 3:
						System.out.println("이름을 새로 입력하세요.");
						mNa=scanner.next();
						arrayListMembershipInfo.get(i).setMembershipName(mNa);
						break;	
					}
					System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("입력하신 정보가 일치하지 않습니다.");
			}
		}
		
	}

	void withdrawal() { // 회원탈퇴
		System.out.println("====학생 회원탈퇴====");
		System.out.print("탈퇴할 아이디: ");
		String mId = scanner.next();
		System.out.print("탈퇴할 비밀번호: ");
		String mPw = scanner.next();
		System.out.print("이름: ");
		String mNa = scanner.next();
		for (int i = 0; i < arrayListMembershipInfo.size(); i++) {
			if (mId.equals(arrayListMembershipInfo.get(i).getMembershipId())
					&& mPw.equals(arrayListMembershipInfo.get(i).getMembershipPassword())
					&& mNa.equals(arrayListMembershipInfo.get(i).getMembershipName())) {
				arrayListMembershipInfo.set(i, membershipInfo).setMembershipId(null);
				arrayListMembershipInfo.set(i, membershipInfo).setMembershipPassword(null);
				arrayListMembershipInfo.set(i, membershipInfo).setMembershipPassword(null);
				System.out.println(membershipInfo.getMembershipName() + "님 회원탈퇴가 완료되었습니다.");
			} else {
				System.out.println("입력하신 정보가 일치하지 않습니다.");
			}
		}
		
	}

}
