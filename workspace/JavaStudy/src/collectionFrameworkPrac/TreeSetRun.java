package collectionFrameworkPrac;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetRun {

	public static void main(String[] args) {
		//TreeSet 객체 생성 객체를 생성할 때 생성자를 호출한다
		System.out.println("TreeSet<E> a = new TreeSet<>();:");
		TreeSet<String> tset = new TreeSet<>();
		
		//add()
		System.out.println("add():");
		tset.add("apple");
		tset.add("orange");
		tset.add("banana");
		System.out.println(tset);
		
		TreeSet<Integer> tset2 = new TreeSet<>();
		tset2.add(55);
		tset2.add(7);
		tset2.add(32);
		tset2.add(1);
		System.out.println(tset2);
		
		//Set은 중복을 허용하지 않는다. 
		System.out.println("addAll(): Set은 중복을 허용하지 않는다.");
		tset.addAll(tset);
		System.out.println(tset);
		
		//clear(), isEmpty()
		System.out.println("clear(), isEmpty():");
		tset2.clear();
		System.out.println(tset2.isEmpty());
		
		//for
		System.out.println("for:");
		for(int i=3;i<100;i+=3) {
			tset2.add(i);
//			if(i%3==0) {
//				tset2.add(i);
//			}
//			System.out.println();
		}
		System.out.println(tset2);
		
		//first, last
		System.out.println("first(), last():");
		System.out.println(tset2.first());
		System.out.println(tset2.last());
		
		//lower(), higher()
		System.out.println("lower(), higher():");
		System.out.println(tset2.lower(50));
		System.out.println(tset2.higher(50));
		
		//floor()=버림 바닥 ceiling()=올림 천장
		System.out.println("floor(), ceiling():");
		System.out.println(tset2.floor(18));
		System.out.println(tset2.floor(17));
		System.out.println(tset2.ceiling(25));
		System.out.println(tset2.ceiling(24));
		
		//size()
		System.out.println("size():");
		System.out.println(tset2.size());
		System.out.println();
		
		//지우고 반환해준다
		System.out.println("pollFirst(), pllLast():");
		System.out.println(tset2.pollFirst());
		System.out.println(tset2.pollLast());
		System.out.println(tset2);
		
		//headSet 앞에 있는 값들을 가져온다
		System.out.println("headSet():");
		SortedSet<Integer> sset = tset2.headSet(50); //Set<Integer> sset = tset2.headSet(50); 가능
		System.out.println(tset2.headSet(18)); 
		
		//SortedSet<Integer> nset = tset2.headSet(18, true); 가능, Set<Integer> nset = tset2.headSet(18, true); 가능
		NavigableSet<Integer> nset = tset2.headSet(18, true); 
		System.out.println(tset2.headSet(18, true)); // 자기 자신을 포함할지 말지 true일 때 포함 false일 때 미포함 default value: false
		
		//tailSet 뒤에 있는 값들을 반환한다.
		System.out.println("tailSet():");
		System.out.println(tset2.tailSet(84));
		System.out.println(tset2.tailSet(84,false)); // true일 때 미포함 false일 때 포함 default value: true
		
		//subSet
		System.out.println("subSet():");
		System.out.println(tset2.subSet(42, 54)); // 앞에 값은 포함 뒤에 값은 미포함
		System.out.println(tset2.subSet(42, false, 54, true)); // true=포함, false=미포함
		
		//descendingSet 역순으로 강조 큰쪽에서 작은쪽으로
		System.out.println("descendingSet():");
		System.out.println(tset2.descendingSet());
		System.out.println(tset.descendingSet());
		
		//remove
		System.out.println("remove():");
		System.out.println(tset.remove("apple"));
		System.out.println(tset);
		
		
		//Iterator, descendingIterator
		System.out.println("Interator:");
		Iterator<Integer> iter = tset2.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		
		System.out.println("Iterator, descendingIterator:");
		Iterator<Integer> iter2 = tset2.descendingIterator();
		while(iter2.hasNext()) {
			System.out.print(iter2.next()+" ");
		}
		System.out.println();
		
		TreeSet<Integer> tset3 = new TreeSet<>(tset2);
		System.out.println(tset3);
		int treesize = tset2.size();
		System.out.println();
		
		//for, pollFirst()
		System.out.println("for, pollFirst():");
		for(int i=0;i<treesize;i++) {
			System.out.print(tset2.pollFirst()+" ");
		} System.out.println();
		System.out.println(tset2.isEmpty());
		
		//for, pollLast():
		System.out.println("for, pollLast:");
		treesize=tset3.size();
		for(int i=0;i<treesize;i++) {
			System.out.print(tset3.pollLast()+" ");
		}
		System.out.println();
		System.out.println(tset3.isEmpty());
		
		//toArray()
		System.out.println("toArray():");
		String[] str = tset.toArray(new String[0]);
		System.out.println(Arrays.toString(str));
		
		for(String str1:tset) {
			System.out.print(str1+" ");
		}
		System.out.println();
	}

}
