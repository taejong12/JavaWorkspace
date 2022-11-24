package collectionFramework2Prac;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CompareMemberTreeMap {
	private TreeMap<Member, Point> tMap;

	public CompareMemberTreeMap() {
		tMap = new TreeMap<Member, Point>();
	}

	public void addMember(Member member, Point point) {
		tMap.put(member, point);
	}

	public void showAll() {
		for (Entry<Member, Point> entry : tMap.entrySet()) {
			Member m = entry.getKey();
			Point p = entry.getValue();
			System.out.println(m.toString());
			System.out.println(p.toString());
		}
	}

	public boolean removeMember(Integer memberId) {
		Set<Member> k = tMap.keySet();
		for (Member mem : k) {
			if (mem.getMemberId() == memberId) {
				tMap.remove(mem);
				return true;
			}
		}
		return false;

//		Iterator<Member> it = k.iterator();
//		while (it.hasNext()) {
//			Member i = it.next();
//			if (i.getMemberId() == memberId) {
//				tMap.remove(i);
//				return true;
//			}
//		}
//		return false;
		
//		Set<Map.Entry<Member, Point>> mp = tMap.entrySet();
//		for(Entry<Member, Point> emp: mp) {
//			if(emp.getKey()==memberId) {
//				tMap.remove(emp);
//				return true;
//			}
//		}
//		return false;
	}

	public TreeMap<Member, Point> gettMap() {
		return tMap;
	}

	public void settMap(TreeMap<Member, Point> tMap) {
		this.tMap = tMap;
	}

}
