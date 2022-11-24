package collectionFramework2Prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapRun {
	public static void main(String[] args) {
		// HashMap
		HashMap<Integer, String> hmap = new HashMap<>();

		// put() Map 결과값 {}괄호
		hmap.put(1, "이순신");
		hmap.put(2, "홍길동");
		hmap.put(3, "윤봉길");
		hmap.put(4, "김유신");
		System.out.println(hmap.toString());
		System.out.println(hmap.size());

		// putAll()
		HashMap<Integer, String> hmap2 = new HashMap<>();
		hmap2.putAll(hmap);
		System.out.println(hmap2);
		
		//putIfAbsent 만약에 해당하는 값이 없으면 해당하는 값을 넣는다
		hmap.putIfAbsent(5, "무지개");
		hmap.putIfAbsent(3, "누구나");
		System.out.println(hmap);
		
		// replace() 키값을 기준으로 찾는다
		hmap.replace(3, "김구"); // key값만 비교
		hmap.replace(9, "김구");
		System.out.println(hmap);

		hmap.replace(2, "홍길동", "임꺽정");// key값과 value값 둘 다 비교
		hmap.replace(4, "봉달이", "처녀귀신");
		System.out.println(hmap);

		// get()
		System.out.println(hmap.get(3));
		
		//getOrDefault 키값이 있으면 해당하는 값을 가져온다 없으면 기본적인 값을 받겠다
		System.out.println(hmap.getOrDefault(5, "아무거나"));
		System.out.println(hmap.getOrDefault(6, "아무거나"));
		System.out.println(hmap);

		// entrySet() 2개의 키값과 밸류값이 결과값으로 Set로 하나로 묶여서(entry) 돌아온다 Set 결과값 []괄호
		Set entrySet = hmap.entrySet();
		System.out.println(entrySet.toString());

		// 엔트리는 키값 밸류값을 짝을 지어놓은 객체
		// 엔트리셋은 셋으로 돌려준다. 엔트리라는 클래스로 만든 객체를 돌려준다. 엔트리는 이너클래스 Map.Entry
		Set<Map.Entry<Integer, String>> entrySet1 = hmap.entrySet();
		System.out.println(entrySet.toString());

		// keySet()
		Set<Integer> keySet = hmap.keySet();
		System.out.println(keySet);
		System.out.println(hmap.size());

		// containsKey()
		System.out.println(hmap.containsKey(3));
		System.out.println(hmap.containsKey(7));
		System.out.println(hmap.containsValue("김구"));
		System.out.println(hmap.containsValue("홍길동"));

		// remove()
		System.out.println(hmap.remove(4));
		System.out.println(hmap.remove(2, "임꺽정"));
		System.out.println(hmap);

		// clear(), isEmpty()
		hmap.clear();
		System.out.println(hmap.isEmpty());

	}
}
