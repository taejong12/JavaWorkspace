package collectionFrameworkPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListRun {
	public static void main(String[] args) {
		// 객체 생성
		System.out.println("객체생성: ArrayList<E> a = new ArrayList<>();");
		ArrayList<String> ar = new ArrayList<>();

		//add 요소 추가
		System.out.println("add():");
		ar.add("자바 공부");
		System.out.println(ar);
		ar.add(0, "java");
		System.out.println(ar);

		//get 요소 읽기
		System.out.println("get():");
		System.out.println(ar.get(0));

		//remove 요소 삭제
		System.out.println("remove():");
		ar.remove(0);
		System.out.println(ar);
		ar.remove("자바 공부");
		System.out.println(ar);

		//for 반복문
		System.out.println("for():");
		ar.add("java");
		ar.add("화이팅");
		for (int i = 0; i < ar.size(); i++) {
			System.out.print(ar.get(i) + " ");
		}
		System.out.println();
		
		//enhanced for
		System.out.println("enhanced for():");
		for (String str : ar) {
			System.out.print(str + " ");
		}
		System.out.println();

		//Iterator
		System.out.println("Iterator():");
		Iterator<String> iter = ar.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println();
		
		//size 요소의 개수
		System.out.println("size():");
		System.out.println(ar.size());
		
		//set 요소의 수정
		System.out.println("set():");
		ar.set(1, "f");
		System.out.println(ar);
		
		//contains, indexOf 요소의 검색 포함여부 확인/대상의 인덱스 확인
		System.out.println("contains, indexOf():");
		System.out.println(ar.contains("f"));
		System.out.println(ar.indexOf("자바 공부"));
		System.out.println(ar.indexOf("java"));
		
		//clear 전체 삭제 isEmpty 비어있는지 확인
		System.out.println("clear, isEmpty():");
		ar.clear();
		System.out.println(ar);
		System.out.println(ar.isEmpty());
		
		//Collections.sort 배열 정렬(sorting)
		ar.add("예진");
		ar.add("민성");
		ar.add("현우");
		ar.add("시우");
		ar.add("지민");
		ar.add("정기");
		System.out.println(ar);
		System.out.println("Collections.sort():");
		Collections.sort(ar);
		System.out.println(ar);
		System.out.println("Collections.sort(.reverseOrder()):");
		Collections.sort(ar, Collections.reverseOrder());
		System.out.println(ar);

		//Arrays.asList, List.of (한 번에 입력하기, 추가 입력 x)
		System.out.println("Arrays.asList(), List.of():");
		ArrayList<String> alist2 = new ArrayList<>(Arrays.asList("예진", "민성", "현우", "시우", "지민", "정기"));
		System.out.println(alist2);
		ArrayList<String> alist3 = new ArrayList<>(List.of("예진", "민성", "현우", "시우", "지민", "정기"));
		System.out.println(alist3);

	}

}
