package collectionEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		//객체
		ArrayList<String> alist = new ArrayList<>();
		ArrayList<String> alist1 = new ArrayList<>();
		ArrayList<String> alist2 = new ArrayList<>();
		
		//내용 추가 일식이~칠식이
		alist.addAll(Arrays.asList("일식이","이식이","삼식이","사식이","오식이","육식이","칠식이"));
		System.out.println(alist);
		alist1.addAll(List.of("일식이","이식이","삼식이","사식이","오식이","육식이","칠식이"));
		System.out.println(alist1);
		alist2.add("일식이");
		alist2.add("이식이");
		alist2.add("삼식이");
		alist2.add("사식이");
		alist2.add("오식이");
		alist2.add("육식이");
		alist2.add("칠식이");
		System.out.println(alist2);
		
		//반복구문 출력
		for(int i=0;i<alist.size();i++) {
			System.out.print(alist.get(i)+" ");
		}
		System.out.println();
		
		for(String one:alist1) {
			System.out.print(one+" ");
		}
		System.out.println();
		
		Iterator<String> two = alist2.iterator();
		while(two.hasNext()) {
			System.out.print(two.next()+" ");
		}
		System.out.println();
	}

}
