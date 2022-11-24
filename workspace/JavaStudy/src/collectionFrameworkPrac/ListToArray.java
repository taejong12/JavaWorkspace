package collectionFrameworkPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class ListToArray {

	public static void main(String[] args) {
//		toArray()
		ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		LinkedList<Integer> llist = new LinkedList<>(Arrays.asList(5, 6, 7, 8));
		Vector<Integer> vec = new Vector<>(Arrays.asList(9, 10, 11, 12));

		Object[] obj = alist.toArray();
		System.out.println(Arrays.toString(obj));
		Integer[] integer = alist.toArray(new Integer[0]);
		System.out.println(Arrays.toString(integer));
		Integer[] integer1 = llist.toArray(new Integer[0]);
		System.out.println(Arrays.toString(integer1));
		Integer[] integer2 = vec.toArray(new Integer[0]);
		System.out.println(Arrays.toString(integer2));

		alist.addAll(llist);
		System.out.println(alist);
		alist.addAll(llist);
		System.out.println(alist);
		alist.addAll(3, vec);
		System.out.println(alist);
	}

}
