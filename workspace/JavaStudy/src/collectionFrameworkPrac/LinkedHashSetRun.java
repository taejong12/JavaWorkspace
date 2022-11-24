package collectionFrameworkPrac;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetRun {

	public static void main(String[] args) {
		// LinkedHashSet은 Set에 없는 순서가 생긴다
		LinkedHashSet<String> lset = new LinkedHashSet<>(); 
		
		//입력하는 순서에 맞춰서 들어간다
		lset.add("한국");
		lset.add("미국");
		lset.add("중국");
		lset.add("영국");
		
		//Set은 중복을 허용하지 않는다.
		lset.addAll(lset);
		System.out.println(lset);
		
		LinkedHashSet<Integer> lset2 = new LinkedHashSet<>();
		lset2.addAll(Arrays.asList(1,2,3,3,867,346,234));
		System.out.println(lset2);
		System.out.println(lset.size());
		System.out.println(lset2.size());
		
		//내용확인하기 contains
		System.out.println(lset.contains("미국"));
		System.out.println(lset2.contains(1));
		
		//Iterator while(반복구문작성)
		Iterator<String> it = lset.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		Iterator<Integer> it1 = lset2.iterator();
		while(it1.hasNext()) {
			System.out.print(it1.next()+" ");
		}
		System.out.println();
		
		//지우기
		lset.remove("영국");
		System.out.println(lset);
		lset.clear();
		System.out.println(lset);
		System.out.println(lset.isEmpty());
		System.out.println(lset2.isEmpty());
		
		//toArray() (T[] b = a.toArray(T[]);)
		Integer[] integer =lset2.toArray(new Integer[0]);
		System.out.println(Arrays.toString(integer));
		String[] string = lset.toArray(new String[0]);
		System.out.println(Arrays.toString(string));
		
	}

}
