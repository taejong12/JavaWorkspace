package collectionEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class NumbersEx {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,1,1,3,3,6,7,8,4,2,10));
		System.out.println(numbers); 
		
		// 중복제거, 오름차순 정렬
		TreeSet<Integer> numbers1 = new TreeSet<>();
		numbers1.addAll(numbers);
		System.out.println(numbers1);
		
		TreeSet<Integer> numbers2 = new TreeSet<>(numbers);
		System.out.println(numbers2);
		
	}

}
