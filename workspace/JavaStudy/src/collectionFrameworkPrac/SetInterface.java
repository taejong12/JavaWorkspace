package collectionFrameworkPrac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class SetInterface {

	public static void main(String[] args) {
		//HashSet 객체생성 (Collection 상속받음)
		HashSet<String> hset = new HashSet<>();
		hset.add("A");
		HashSet<String> hset2 = new HashSet<>(Arrays.asList("A","B","C"));
		System.out.println(hset);
		System.out.println(hset2);
		
		// LinkedHashSet 객체 생성
		LinkedHashSet<String> lset = new LinkedHashSet<>();
		lset.add("A");
		LinkedHashSet<String> lset2 = new LinkedHashSet<>(Arrays.asList("A","B","C"));
		System.out.println(lset);
		System.out.println(lset2);
		
		// TreeSet 객체 생성
		TreeSet<String> tset = new TreeSet<>();
		tset.add("A");
		TreeSet<String> tset2 = new TreeSet<>(List.of("A","B","C"));
		System.out.println(tset);
		System.out.println(tset2);
		
	
	}

}
