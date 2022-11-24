package collectionFrameworkPrac;

import java.util.TreeSet;

public class TreeSetMachRun {

	public static void main(String[] args) {
		// TreeSet 크기 비교가 되야 된다 Comparable<>-비교 가능한 compareTO
		TreeSet<Integer> tset1 = new TreeSet<>();
		Integer intVal1 = new Integer(30);
		Integer intVal2 = new Integer(20);
		tset1.add(intVal1);
		tset1.add(intVal2);
		System.out.println(tset1);

		TreeSet<String> tset2 = new TreeSet<>();
		String str1 = new String("당신");
		String str2 = new String("당신");
		tset2.add(str1);
		tset2.add(str2);
		System.out.println(tset2);

		// Comparable interface Implements 해야한다
		CompareMemberTreeSet cts = new CompareMemberTreeSet();
		Member lee = new Member(101, "이순신", 45);
		cts.addMember(lee);
		Member Koo = new Member(102, "구준표", 18);
		cts.addMember(Koo);
		Member Kim = new Member(103, "김주환", 32);
		cts.addMember(Kim);
		cts.showAll();
//		cts.removeMember(101);
//		cts.showAll();
		
		if(cts.removeMember(101)) {
			System.out.println("삭제완료.");
		}else {
			System.out.println("해당 아이디는 존재하지 않습니다.");
		}
		cts.showAll();
	}
}


