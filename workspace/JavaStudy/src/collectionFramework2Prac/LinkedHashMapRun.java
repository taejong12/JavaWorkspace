package collectionFramework2Prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashMapRun {

	public static void main(String[] args) {
		// HashMap
		HashMap<Integer, String> hmap = new HashMap<>();

		// put() Map 결과값 {}괄호
		hmap.put(1, "이순신");
		hmap.put(2, "홍길동");
		hmap.put(3, "윤봉길");
		hmap.put(4, "김유신");
		System.out.println("hash:"+hmap.toString());
		
		// LinkedHashMap은 HashMap을 상속받음
		LinkedHashMap<Integer, String> lmap = new LinkedHashMap<>();

		// put() Map 결과값 {}괄호
		lmap.put(1, "이순신");
		lmap.put(2, "홍길동");
		lmap.put(3, "윤봉길");
		lmap.put(4, "김유신");
		System.out.println("linked:"+lmap.toString());
		System.out.println(lmap.size());

		// putAll()
		LinkedHashMap<Integer, String> lmap2 = new LinkedHashMap<>();
		lmap2.putAll(hmap);
		System.out.println("hash->linked:"+lmap2);

		// replace() 키값을 기준으로 찾는다
		lmap.replace(3, "김구"); // key값만 비교
		lmap.replace(9, "김구");
		System.out.println(lmap);

		lmap.replace(2, "홍길동", "임꺽정"); // key값과 value값 둘 다 비교
		lmap.replace(4, "봉달이", "처녀귀신");
		System.out.println(lmap);

		// get()
		System.out.println(lmap.get(3));

		// entrySet() 2개의 키값과 밸류값이 결과값으로 Set로 하나로 묶여서(entry) 돌아온다 Set 결과값 []괄호
		Set entrySet = lmap.entrySet();
		System.out.println(entrySet.toString());

		// 엔트리는 키값 밸류값을 짝을 지어놓은 객체
		// 엔트리셋은 셋으로 돌려준다. 엔트리라는 클래스로 만든 객체를 돌려준다. 엔트리는 이너클래스 Map.Entry
		Set<Map.Entry<Integer, String>> entrySet1 = lmap.entrySet();
		System.out.println(entrySet1.toString());

		// keySet()
		Set<Integer> keySet = lmap.keySet();
		System.out.println(keySet);
		System.out.println(lmap.size());

		// containsKey()
		System.out.println(lmap.containsKey(3));
		System.out.println(lmap.containsKey(7));
		System.out.println(lmap.containsValue("김구"));
		System.out.println(lmap.containsValue("홍길동"));

		// remove()
		System.out.println(lmap.remove(4));
		System.out.println(lmap.remove(2, "임꺽정"));
		System.out.println(lmap);

		// clear(), isEmpty()
		lmap.clear();
		System.out.println(lmap.isEmpty());
		
		//반복문 keySet lmap2
		Set<Integer> key = lmap2.keySet();
		//enhanced for
		for(Integer k:key) {
			System.out.print(k+lmap2.get(k)+" ");
			
		}
		System.out.println();
		
		//iterator
		//hasNext 값을 뽑아낸다
		Iterator<Integer> key1 = key.iterator();
		while(key1.hasNext()) {
			Integer key2 = key1.next();
			System.out.print(key2+lmap2.get(key2)+" ");
		}
		System.out.println();
		
		//values collection 값만 가져올 때 values() (키값은 버리고 값만 가져온다)
		System.out.println(lmap2.values());
	}

}
