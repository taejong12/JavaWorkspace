package collectionFramework2Prac;

import java.util.TreeMap;

public class TreeMapMachRun {
	// 1
	public static void main(String[] args) {
		TreeMap<Integer, Integer> tmap1 = new TreeMap<>();
		Integer intVal1 = new Integer(30);
		Integer intVal2 = new Integer(20);
		tmap1.put(intVal1, 1);
		tmap1.put(intVal2, 3);
		System.out.println(tmap1);

		TreeMap<String, String> tmap2 = new TreeMap<>();
		String str1 = new String("우리");
		String str2 = new String("우리");
		tmap2.put(str1, "너");
		tmap2.put(str2, "넌");
		System.out.println(tmap2);

		CompareMemberTreeMap ctm = new CompareMemberTreeMap();
		Member lee = new Member(101, "이순신", 45);
		Point leep = new Point(1000);
		ctm.addMember(lee, leep);
		Member koo = new Member(102, "구준표", 18);
		Point koop = new Point(1000);
		ctm.addMember(koo, koop);
		Member kim = new Member(103, "김주환", 32);
		Point kimp = new Point(1000);
		ctm.addMember(kim, kimp);
		ctm.showAll();
		if (ctm.removeMember(111)) {
			System.out.println("삭제완료.");
		} else {
			System.out.println("해당 아이디는 존재하지 않습니다.");
		}
		ctm.showAll();
	}
}
