package array;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPrac {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(); // class -> object 객체생성
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>(10);
		ArrayList<Integer> list4 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		ArrayList<String> list5 = new ArrayList<String>();
		// <> generic 제너릭
		// Integer = int wrapper class

		ArrayList<String> a = new ArrayList<>();
		a.add("안녕하세요");
		a.add("안녕");
		a.add("잘가세요");
		System.out.println(a);
		System.out.println(a.size());
		a.add(1, "태종"); // 해당 인덱스에 추가
		System.out.println(a);
		System.out.println(a.size());
		a.set(2, "소정"); // 해당 인덱서의 값을 수정
		System.out.println(a);
		System.out.println(a.size());
		a.remove("소정"); // 동일객체 삭제
		System.out.println(a);
		System.out.println(a.size());
		a.remove(2); // index의 저장공간 삭제
		System.out.println(a);
		System.out.println(a.size());
		a.clear();
		System.out.println(a);
		System.out.println(a.size());

		a.add("안녕하세요");
		a.add("안녕");
		a.add("잘가세요");

		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();

		for (String str : a) {
			System.out.print(str + " ");
		}
		System.out.println();

		a.forEach(System.out::println);

		// 검색 기능 제공
		System.out.println(a.contains("태종"));
		System.out.println(a.indexOf("안녕"));
		System.out.println(a.indexOf("안녕하세요"));
		System.out.println(a.indexOf("잘가세요"));
		System.out.println(a.indexOf("태종"));// 해당하는 값이 없으면 -1
		System.out.println();

		// 복사

		// clone()
		ArrayList<String> newA1 = (ArrayList<String>)a.clone();
		printArrayList(newA1);
		System.out.println();
		//addA11()
		ArrayList<String> newA2 = new ArrayList<>();
		newA2.addAll(a);
		printArrayList(newA2);
		System.out.println();
		//for
		ArrayList<String> newA3 = new ArrayList<>();
		for(String str:a) {
			newA3.add(str);
		}
		printArrayList(newA3);
		System.out.println();
		
		//isEmpty()
		System.out.println(newA3.isEmpty());
		newA3.clear();
		System.out.println(newA3.isEmpty());

	}
	
	static void printArrayList(ArrayList<String> arr) {

		for(String str:arr) {

			System.out.println(str);

		}

	}
	

}

