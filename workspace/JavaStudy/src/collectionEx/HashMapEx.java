package collectionEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

class PersonInfo implements Comparable<PersonInfo> {
	private String tel;
	private String address;

	public PersonInfo(String tel, String address) {
		this.tel = tel;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return (tel + address).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PersonInfo)
			return tel.equals(((PersonInfo) obj).tel) && address.equals(((PersonInfo) obj).address);
		else
			return false;
	}

	@Override
	public int compareTo(PersonInfo o) {
		return (tel.compareTo(o.tel)) + (address.compareTo(o.address));
	}

	public String toString() {
		return tel + " " + address;

	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, PersonInfo> hmap = new HashMap<>();
		// 이름 개인정보
		// 010-1111-1111 서울 010-2222-2222 대전 010-3333-3333 대구
		hmap.put("인순이", new PersonInfo("010-1111-1111", "서울"));
		hmap.put("권보아", new PersonInfo("010-2222-2222", "대전"));
		hmap.put("이보람", new PersonInfo("010-3333-3333", "대구"));
//		PersonInfo p1 = new PersonInfo("010-1111-1111", "서울");
//		PersonInfo p2 = new PersonInfo("010-2222-2222", "대전");
//		PersonInfo p3 = new PersonInfo("010-3333-3333", "대구");
//		hmap.put("인순이", p1);
//		hmap.put("권보아", p2);
//		hmap.put("이보람", p3);

		// 무한반복 돌때 exit 브레이크문
		Scanner sc = new Scanner(System.in);
//		while (true) {
//			System.out.println("검색대상:");
//			String input = sc.next();
//			if (input.equals("exit")) {
//				System.out.println("검색종료");
//				break;
//			}
//			// 해당 대상 있는지 검색
////			PersonInfo pi = hmap.get(input);
////			if(pi!=null) {
////				System.out.printf("||이름: %s||전화번호: %s||주소: %s||%n",input,pi.getTel(),pi.getAddress());
////			} else {
////				System.out.println("없는 사람입니다.");
////			}
//			
//			if(hmap.containsKey(input)) {
//				PersonInfo pi = hmap.get(input);
//				System.out.printf("||이름: %s||전화번호: %s||주소: %s||%n",input,pi.getTel(),pi.getAddress());
//			} else {
//				System.out.println("없는 사람입니다.");
//			}
//			// 있으면 해당 사람의 이름 전화번호 주소 출력
//			// 없으면 없는 사람이라고 출력

		while (true) {
			// 1번 2번 구분
			System.out.println("1--이름");
			System.out.println("2--전화번호");
			System.out.println("검색대상 선택:");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("검색대상:");
				String input = sc.next();
				if (input.equals("exit")) {
					System.out.println("검색종료");
					break;
				}
				if (hmap.containsValue(input)) {
					PersonInfo pi = hmap.get(input);
					System.out.printf("||이름: %s||전화번호: %s||주소: %s||%n", input, pi.getTel(), pi.getAddress());
				} else {
					System.out.println("없는 사람입니다.");
				}
			} else if (menu == 2) {
				System.out.println("검색 전화번호:");
				String input = sc.next();
				if (input.equals("exit")) {
					System.out.println("검색종료");
					break;
				}
				Set<Entry<String, PersonInfo>> eset = hmap.entrySet();
				Iterator<Entry<String, PersonInfo>> entry = eset.iterator();
				int mu = hmap.size();
				while (entry.hasNext()) {
					Entry<String, PersonInfo> en = entry.next();
					if (en.getValue().getTel().indexOf(input) >= 0) {
						System.out.printf("||이름: %s||전화번호: %s||주소: %s||%n", en.getKey(), en.getValue().getTel(),
								en.getValue().getAddress());
					} else {
						mu--;
					}

				}
				if (mu == 0) {
					System.out.println("없는 번호입니다.");
				}
			}else {
				System.out.println("없는 사람입니다");
			}
		}
	}
}
