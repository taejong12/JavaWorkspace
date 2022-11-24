package collectionFramework2Prac;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableRun {

	public static void main(String[] args) {
		// Enumeration=Iterator
		// Hashtable
		Hashtable<Integer, String> ht = new Hashtable<>();

		// put() Map 결과값 {}괄호
		ht.put(2, "홍길동");
		ht.put(4, "김유신");
		ht.put(3, "윤봉길");
		ht.put(1, "이순신");
		System.out.println(ht.toString());

		// HashMap 상속관계
		// putAll()
		HashMap<Integer, String> hm = new HashMap<>();
		hm.putAll(ht);
		System.out.println(ht);

		// putIfAbsent 만약에 해당하는 값이 없으면 해당하는 값을 넣는다
		ht.putIfAbsent(5, "무지개");
		ht.putIfAbsent(3, "아무나");
		System.out.println(ht);

		// replace() 키값을 기준으로 찾는다
		ht.replace(3, "김구"); // key값만 비교
		ht.replace(9, "김구");
		System.out.println(ht);

		ht.replace(2, "홍길동", "임꺽정"); // key값과 value값 둘 다 비교
		ht.replace(4, "봉달이", "처녀귀신");
		System.out.println(ht);

		// get()
		System.out.println(ht.get(3));

		// getOrDefault 키값이 있으면 해당하는 값을 가져온다 없으면 기본적인 값을 받겠다
		System.out.println(ht.getOrDefault(5, "아무거나"));
		System.out.println(ht.getOrDefault(6, "아무거나"));
		System.out.println(ht);

		// entrySet() 2개의 키값과 밸류값이 결과값으로 Set로 하나로 묶여서(entry) 돌아온다 Set 결과값 []괄호
		Set<Map.Entry<Integer, String>> entrySet = ht.entrySet();
		System.out.println(entrySet.toString());
		
		// keySet()
		Set<Integer> keyset = ht.keySet();
		System.out.println(keyset);
		System.out.println(ht.size());

		// containsKey()
		System.out.println(ht.containsKey(3));
		System.out.println(ht.containsKey(7));
		System.out.println(ht.containsValue("김구"));
		System.out.println(ht.containsValue("홍길동"));

		System.out.println(ht.remove(4));
		System.out.println(ht.remove(2,"임꺽정"));
		System.out.println(ht);
		
		ht.clear();
		System.out.println(ht.isEmpty());
		
		Hashtable<Integer, String> ht1 = new Hashtable<>(hm);
		System.out.println(ht1);
		
		Set<Integer> kset = ht1.keySet();
		//enhanced for
		for(Integer key:kset) {
			System.out.printf("키: %d 값: %s",key,ht1.get(key));
		}
		System.out.println();
		
		//iterator
		Iterator<Integer> it = kset.iterator();
		while(it.hasNext()) {
			Integer k = it.next();
			System.out.printf("키: %d 값: %s",k,ht1.get(k));
		}
		System.out.println();
		
		System.out.println(ht1.values());
		
		//Enumeration  hasMoreElements(더 이상 요소가 있는지 없는 확인해주는 역할)
		Enumeration<Integer> en = ht1.keys();
		while(en.hasMoreElements()) {
			Integer key = en.nextElement();
//			System.out.println(key+"="+ht1.get(key)+" ");
			System.out.printf("키: %d 값: %s ",key,ht1.get(key));
		}
		System.out.println();
		
		Enumeration<String> en2 = ht1.elements();
		while(en2.hasMoreElements()) {
			String value = en2.nextElement();
			System.out.printf(value+" ");
		}
		System.out.println();
	}

}
