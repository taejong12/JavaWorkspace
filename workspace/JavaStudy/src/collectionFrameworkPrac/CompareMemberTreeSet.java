package collectionFrameworkPrac;

import java.util.Iterator;
import java.util.TreeSet;

public class CompareMemberTreeSet {
	private TreeSet<Member> tset;

	public CompareMemberTreeSet() {
		tset = new TreeSet<Member>();
	}

	public void addMember(Member mem) {
		tset.add(mem);
	}

	public boolean removeMember(int memberId) {
//		for (Member mem : tset) {
//			if (mem.getMemberId() == memberId) {
//				tset.remove(mem);
//				return true;
//			}
//		}
//		return false;

		//속도는 for문이 빠르나 유지보수 측면에서 iterator를 사용
		Iterator<Member> itr =tset.iterator();
		while(itr.hasNext()) {
			Member mem = itr.next();
			if(mem.getMemberId()==memberId) {
				tset.remove(mem);
				return true;
			}
		}
		return false;
		
//		Iterator<Member> mem = tset.iterator();
//		while(mem.hasNext()) {
//			if((mem.next()).getMemberId()==memberId) {
//				tset.remove(mem);
//				return true;
//			}
//		}
//		return false;
	}
	

	public void showAll() {
		for (Member mem : tset) {
			System.out.print("ID:" + mem.getMemberId());
			System.out.print("/이름:" + mem.getName());
			System.out.println("/나이:" + mem.getAge());
		}
		System.out.println();
	}
}
