package practice0919;

import java.util.Scanner;

public class LottoGame {
	// 4명의 플레이어가 각자 입력한 6개의 숫자와, 랜덤하게 생성되는 30번의 로또를 대조하여, 숫자를 맞춘 수만큼 포인트를 증가.
	// 로그인 후 6개의 숫자를 입력하는 방식으로 진행.
	public static void main(String[] args) {
		// PersonInfo 객체를 담을 배열객체 생성.
		// 배열에 PersonInfo 객체들을 만들어 집어넣기.
		PersonInfo[] per = new PersonInfo[4];
		per[0] = new PersonInfo("id0", "pw0", "name0", 0);
		per[1] = new PersonInfo("id1", "pw1", "name1", 0);
		per[2] = new PersonInfo("id2", "pw2", "name2", 0);
		per[3] = new PersonInfo("id3", "pw3", "name3", 0);

		System.out.println("====================================");
		System.out.println("│     ★로또게임에 오신 것을 환영합니다★     │");
		System.out.println("====================================");

		// 계속 돌아야되니까 무한반복문을 사용해서, 스캐너 작성하기.
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("아이디를 입력하세요 : ");

			System.out.println("*(종료하실 분은 'exit'를 입력해주세요)*"); // 밑에 exit 누르면 게임을 완전히 종료하는거 구현.

			String id = sc.next();

			if (id.equals("exit")) {
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}

			System.out.print("비밀번호를 입력하세요 : ");

			String pw = sc.next();

			int[] myNumber = new int[6];
			int[] lottoNumber = new int[30];

			for (int i = 0; i < per.length; i++) {
				if (per[i].getId().equals(id) && per[i].getPw().equals(pw)) {
					System.out.println("***로그인 완료***");
					System.out.println();
					System.out.println("====================================");
					System.out.println(
							"│" + per[i].getName() + "님 환영합니다. 현재 포인트는 " + per[i].getPoint() + "pt 입니다." + "│");
					System.out.println("====================================");

					System.out.println("1~45까지의 로또번호 6자리를 입력해주세요");

					for (int j = 0; j < myNumber.length; j++) {
						int number = sc.nextInt();
						if(number>45 && number<0) {
							System.out.println("입력값 초과");
							j--;
						}
						myNumber[j] = number;
						for(int k=0;k<j;k++) {
							if(myNumber[j]==myNumber[k]) {
								j--;
							}
						}
					}
					
					
					System.out.println("입력하신 번호 : 숫자 6개");
					
					for (int j = 0; j < myNumber.length; j++) {
						System.out.print(myNumber[j] + " ");
					}
					System.out.println();

					for (int j = 0; j < lottoNumber.length; j++) {
						lottoNumber[j] = (int) (Math.random() * 30);
						System.out.println(lottoNumber[j]);
						for (int k = 0; k < j; k++) {
							if (lottoNumber[k] == lottoNumber[j]) {
								j--;
							}
						}
					}

//					for(int j=0;j<lottoNumber.length;j++) {
//						System.out.println(lottoNumber[j]);
//					}

					// 맞춰볼 로또 번호 30회 생성. 중복 제외하고 6개씩 나오고 그걸 30회 반복.
//					Math.random()*30;
//					==
//							6개씩
//					for(30회반복)

					// 30회 반복하는 동안, 입력한 로또번호와 생성된 로또번호를 맞춰봐서 맞은 개수만큼 포인트 증가

					int num = 0;
					for (int j = 0; j < lottoNumber.length; j++) {
						for (int k = 0; k < myNumber.length; k++) {
							if (myNumber[k] == lottoNumber[j]) {
								per[i].setPoint(++num);
								System.out.print("점수:"+per[i].getPoint() + " ");
							}
						}
					}
					System.out.println();

				} else if (!per[i].getId().equals(id)) {
					System.out.println("아이디가 존재하지 않습니다");
					break;
					
				} else if (!per[i].getPw().equals(pw)) {
					System.out.println("패스워드가 틀립니다");
					break;
				}
			}

		}

	}

// 객체들의 정보, 조건문, 반복문을 사용해서 로그인 구현하기.
// Id, Pw, Nm 정보를 따로 배열로 관리해서하면 편한데, 다른 방법으로 하셔도 됩니다.
// 구현 예 로그인되면,
// System.out.println("***로그인 완료***");
// System.out.println();
// System.out.println("====================================");
// System.out.println("│"xxx"님 환영합니다. 현재 포인트는 "xxx"pt 입니다."+"│");
// System.out.println("====================================");

// 로그인 실패의 경우, 패스워드가 틀리면,
// System.out.println("패스워드가 틀립니다");
// 아이디가 틀리면,
// System.out.println("아이디가 존재하지 않습니다");

// 로그인된 회원의, 로또 번호 입력 스캐너 생성하고 그 정보를 배열로 관리.
// System.out.println("1~45까지의 로또번호 6자리를 입력해주세요");

// 입력한 6개의 숫자를 배열에 저장.

// System.out.println("입력하신 번호 : 숫자 6개"); 의 형태로 출력해보기.

// 맞춰볼 로또 번호 30회 생성. 중복 제외하고 6개씩 나오고 그걸 30회 반복.
// 30회 반복하는 동안, 입력한 로또번호와 생성된 로또번호를 맞춰봐서 맞은 개수만큼 포인트 증가

}
