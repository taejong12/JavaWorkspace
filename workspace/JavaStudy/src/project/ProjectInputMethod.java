package project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.NavigableSet;

public class ProjectInputMethod {

	Scanner sc = new Scanner(System.in);

	ArrayList<ProjectSubject> alist = new ArrayList<>();

	// 입력
	public void Input() {
		System.out.println();
		System.out.println("========국어, 영어, 수학, 사회, 과학 입력========");
		ProjectSubject ps = new ProjectSubject();
		System.out.println("이름:");
		ps.setName(sc.next());
		System.out.println("국어:");
		ps.setKorean(sc.nextInt());
		System.out.println("영어:");
		ps.setEnglish(sc.nextInt());
		System.out.println("수학:");
		ps.setMath(sc.nextInt());
		System.out.println("사회:");
		ps.setSocial(sc.nextInt());
		System.out.println("과학:");
		ps.setScience(sc.nextInt());
		System.out.println("================");
		System.out.println("총점:" + ps.score());
		System.out.println("평균:" + ps.average());
		for (int i = 0; i < alist.size(); i++) {
			ps.setRanking(i);
		}

		alist.add(ps);
	}

	public void StudentScore() {
		// 총점
		System.out.println("2.총점");

		for (int i = 0; i < alist.size(); i++) {
			System.out.print("이름:" + alist.get(i).getName() + " ");
			System.out.print("국어:" + alist.get(i).getKorean() + " ");
			System.out.print("영어:" + alist.get(i).getEnglish() + " ");
			System.out.print("수학:" + alist.get(i).getMath() + " ");
			System.out.print("사회:" + alist.get(i).getSocial() + " ");
			System.out.print("과학:" + alist.get(i).getScience() + " ");
			System.out.print("총점:" + alist.get(i).score());
			System.out.println();

		}
	}

	public void StudentAverage() {
		// 평균
		System.out.println("3.평균");
		for (int i = 0; i < alist.size(); i++) {
			System.out.print("이름:" + alist.get(i).getName() + " ");
			System.out.print("국어:" + alist.get(i).getKorean() + " ");
			System.out.print("영어:" + alist.get(i).getEnglish() + " ");
			System.out.print("수학:" + alist.get(i).getMath() + " ");
			System.out.print("사회:" + alist.get(i).getSocial() + " ");
			System.out.print("과학:" + alist.get(i).getScience() + " ");
			System.out.print("평균:" + alist.get(i).average());
			System.out.println();
		}
	}

	// 석차 계산
	public void StudentRanking() {
		System.out.println("4.석차");
		TreeMap<Integer, String> tsn = new TreeMap<>();
		
		for(ProjectSubject al:alist) {
		tsn.put(al.score(), al.getName());
		}
		
		NavigableSet<Integer> tset = tsn.descendingKeySet();
		Iterator<Integer> it = tset.iterator();
		int i=1;
		while(it.hasNext()) {
			int key = it.next();
			System.out.printf("석차:%s 총점:%d 이름:%s \n",i,key,tsn.get(key));
			i++;
		}
		
//		for (Entry<Integer, String> entry : tset) {
//			System.out.printf("총점:%d 이름:%s \n ", entry.getKey(), entry.getValue());
//		}
//		System.out.println();
//		
	}
}

//for (int i = 0; i < alist.size(); i++) {
//	for (int j = i + 1; j < alist.size(); j++) {
//		if (alist.get(i).score() > alist.get(j).score()) {
//			alist.get(j).setRanking(alist.get(j).getRanking() + 1);
//		} else {
//			alist.get(i).setRanking(alist.get(i).getRanking() + 1);
//		}
//		
//	}
//}
//		for (int i = 0; i < alist.size(); i++) {
//			System.out.printf("이름:%4s 순위:%d\n", alist.get(i).getName(), alist.get(i).getRanking());
//		}