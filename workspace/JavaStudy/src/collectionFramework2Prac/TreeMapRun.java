package collectionFramework2Prac;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapRun {

	public static void main(String[] args) {
		// TreeMap
		TreeMap<Integer, String> tmap = new TreeMap<>();
		for (int i = 2; i <= 40; i += 2) {
			tmap.put(i, (i / 2) + "번 아이");
		}
		tmap.put(3, "이상한 아이");
		System.out.println("TreeMap:");
		System.out.println(tmap);

		// firstkey, lastkey
		System.out.println("firstkey, lastkey:");
		System.out.println(tmap.firstKey());
		System.out.println(tmap.lastKey());

		// firstEntry, lastEntry
		System.out.println("firstEntry, lastEntry:");
		Entry<Integer, String> firstEntry = tmap.firstEntry();
		System.out.println(tmap.firstEntry());
		System.out.println(tmap.lastEntry());

		// higherkey, lowerkey 자기 자신은 포함 안한다
		System.out.println(tmap.higherKey(20));
		System.out.println(tmap.lowerKey(20));

		// higherEntry, lowerEntry
		System.out.println(tmap.higherEntry(18));
		System.out.println(tmap.lowerEntry(18));

		// pollFirstEntry, pollLastEntry
		System.out.println(tmap.pollFirstEntry());
		System.out.println(tmap.pollLastEntry());
		System.out.println(tmap);

		// headMap 기준요소 앞에 있는 요소들
		SortedMap<Integer, String> head = tmap.headMap(18);
		NavigableMap<Integer, String> head2 = tmap.headMap(18, true);
		System.out.println(tmap.headMap(18));
		System.out.println(tmap.headMap(18, true)); // 포함할지 안할지

		// tailMap 자기 기준에서 뒤에 있는 요소들
		System.out.println(tmap.tailMap(32)); // default 값
		System.out.println(tmap.tailMap(32, false));

		// subMap 시작점 끝점 시작점은 포함 끝점은 미포함
		System.out.println(tmap.subMap(18, 32));
		System.out.println(tmap.subMap(18, false, 32, true));

		// ceilingKey, ceilingEntry
		System.out.println(tmap.ceilingKey(17));
		System.out.println(tmap.ceilingEntry(17));

		// floorKey, floorEntry
		System.out.println(tmap.floorKey(17));
		System.out.println(tmap.floorEntry(17));

		// keySet, entrySet, descendingKeySet
		System.out.println(tmap.keySet());
		System.out.println(tmap.entrySet());
		System.out.println(tmap.descendingKeySet());

		// descendingMap
		System.out.println(tmap.descendingMap());

		// replace
		System.out.println(tmap.replace(4, "4번 녀석"));
		System.out.println(tmap.replace(4, "모르는 녀석", "안나올 녀석"));
		System.out.println(tmap);

		// remove
		System.out.println(tmap.remove(4));
		System.out.println(tmap.remove(6, "3번 아이"));
		System.out.println(tmap);

		// values
		System.out.println("values:");
		System.out.println(tmap.values());

		// enhanced for 키값을 이용해서 구하기
		System.out.println("enhanced for 키값 이용");
		Set<Integer> a = tmap.keySet();
		for (Integer i : a) {
			System.out.printf("키:%d 값:%s ", i, tmap.get(i));
		}
		System.out.println();

		// Iterator
		System.out.println("Iterator 키값 이용");
		Iterator<Integer> it = a.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.printf("키:%d 값:%s ", i, tmap.get(i));
		}
		System.out.println();

		// Entry enhanced for
		System.out.println("Entry enhanced for");
		Set<Entry<Integer, String>> tset = tmap.entrySet();
		for (Entry<Integer, String> entry : tset) {
			System.out.printf("키:%d 값:%s ", entry.getKey(), entry.getValue());
		}
		System.out.println();

		// Entry Iterator
		System.out.println("Entry Iterator");
		Iterator<Entry<Integer, String>> entrys = tset.iterator();
		while (entrys.hasNext()) {
			Entry<Integer, String> en = entrys.next();
			System.out.printf("키:%d 값:%s ", en.getKey(), en.getValue());
		}
		System.out.println();

		// clear, isEmpty
		tmap.clear();
		System.out.println(tmap.isEmpty());
	}
}
