package collectionFrameworkPrac;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListRun {

	public static void main(String[] args) {
		LinkedList<String> llist = new LinkedList<>();
		llist.add("재영");
		llist.add("홍근");
		llist.add("선미");
		llist.add(2,"현도");
		System.out.println(llist);
		System.out.println(llist.get(2));
		System.out.println(llist.getFirst());
		System.out.println(llist.getLast());
		System.out.println(llist.remove());
		System.out.println(llist.remove(0));
		System.out.println(llist);
		
		llist.add("기훈");
		llist.add("미진");
		System.out.println(llist.size());
		
		for(int i=0;i<llist.size();i++) {
			System.out.print(llist.get(i)+" ");
		}
		System.out.println();
		
		for(String str:llist) {
			System.out.print(str+" ");
		}
		System.out.println();
		
		Iterator<String> iter = llist.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		llist.set(2, "수연");
		System.out.println(llist);
		System.out.println(llist.contains("선미"));
		System.out.println(llist.indexOf("미진"));
		llist.add("수연");
		System.out.println(llist.lastIndexOf("수연"));
		llist.clear();
		System.out.println(llist);
		
		Collections.sort(llist);
		
		LinkedList<String> llist2 = new LinkedList<>(Arrays.asList("예진","민성","현우","시우","지민","정기")); 
		System.out.println(llist2);
		LinkedList<String> llist3 = new LinkedList<>(List.of("예진","민성","현우","시우","지민","정기"));
		System.out.println(llist3);
		
		Collections.sort(llist3);
		System.out.println(llist3);
		Collections.sort(llist3, Collections.reverseOrder());
		System.out.println(llist3);
		
		System.out.println(llist3.poll());
		System.out.println(llist3);
		System.out.println(llist3.pollLast());
		System.out.println(llist3);
		
	}

}
