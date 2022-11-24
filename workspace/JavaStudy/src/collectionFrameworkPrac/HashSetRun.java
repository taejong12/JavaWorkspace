package collectionFrameworkPrac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetRun {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("홍길동");
		hs.addAll(Arrays.asList("이순신","유관순","김구"));
		System.out.println(hs);
		System.out.println(hs.size());
		
		//Set은 같은 요소의 중복을 허용하지 않는다
		hs.add("김구");
		System.out.println(hs);
		System.out.println(hs.size());
		
		hs.add(null);
		hs.add(null);
		System.out.println(hs);
		System.out.println(hs.size());
		
		//set 값 구하는 방법(contains, Iterator)
		System.out.println(hs.contains("이순신"));
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		
		//지우기
		hs.remove("홍길동");
		System.out.println(hs);
		hs.clear();
		System.out.println(hs);
		System.out.println(hs.isEmpty());
		
		//toArray()
		hs.addAll(Arrays.asList("과일","사과","배","귤"));
		String[] str = hs.toArray(new String[0]);
		System.out.println(Arrays.toString(str));
		
		
	}

}
