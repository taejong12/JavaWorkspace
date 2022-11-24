package collectionFramework2Prac;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapRun {

	public static void main(String[] args) {
		// Map 제너릭 타입이 2개씩 들어간다 인터페이스
		// Nested(내포 포함되어 있다) Classes 이너클래스
		// HashMap put 내용을 집어넣을 때

		// 입력 순서와 출력 순서에는 아무런 상관 관계가 없다
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("C", 24);
		hashMap.put("B", 30);
		hashMap.put("A", 24);
		hashMap.put("C", 99);
		System.out.println(hashMap);
		System.out.println(hashMap.size());

		Map<Integer, String> hashTable = new Hashtable<>();
		hashTable.put(101, "kim");
		hashTable.put(102, "kim");
		hashTable.put(103, "lee");
		hashTable.put(101, "koo");
		System.out.println(hashTable);
		System.out.println(hashTable.size());

		// 입력한 순서대로 나온다
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("C", 24);
		linkedHashMap.put("B", 30);
		linkedHashMap.put("A", 24);
		linkedHashMap.put("C", 99);
		System.out.println(linkedHashMap);
		System.out.println(linkedHashMap.size());

		// 오름차순으로 정렬 키값으로 대소 구분이 가능한게 들어와야 한다
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(103, "lee");
		treeMap.put(102, "kim");
		treeMap.put(101, "kim");
		treeMap.put(103, "hong");
		System.out.println(treeMap);
		System.out.println(treeMap.size());

	}

}
