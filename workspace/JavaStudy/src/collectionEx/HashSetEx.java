package collectionEx;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Desert{
	Integer dId;
	String name;
	
	public Desert(Integer dId, String name) {
		this.dId = dId;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Desert) {
		return dId.equals(((Desert)obj).dId);
		} else {
			return false;
		}		
	}

	@Override
	public int hashCode() {
		return dId.hashCode();
	}


	
}
public class HashSetEx {

	public static void main(String[] args) {
		//객체생성
		HashSet<String> hset = new HashSet<>();
		HashSet<String> hset1 = new HashSet<>();
		
		//추가 일식-오식
		hset.addAll(Arrays.asList("일식이","이식이","삼식이","사식이","오식이"));
		
		//다른객체 내용 다 옮기기
		hset1.addAll(hset);
		System.out.println(hset1);
		
		//반복 출력
		for(String str:hset) {
			System.out.print(str+" ");
		}
		System.out.println();
		
		Iterator<String> it = hset.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();

		//삼식이 있는지 확인해 보시고 있으면 육식 추가 없으면 오식이 삭제
		if(hset.contains("삼식이")) {
			hset.add("육식이");
		} else {
			hset.remove("오식이");
		}
		System.out.println(hset);
		
		//array 변환해서 반복문으로 출력
		String[] ar = hset.toArray(new String[0]);
		for(String str:ar) {
			System.out.print(str+" ");
		}
		System.out.println();
		System.out.println(Arrays.toString(ar));
		
		HashSet<Desert> hs = new HashSet<>();
		Desert d1 = new Desert(101,"케이크");
		Desert d2 = new Desert(101,"케이크");
		hs.add(d1);
		hs.add(d1);
		System.out.println(d1.equals(d2));
		System.out.println("d1.hashCode():"+d1.hashCode());
		System.out.println("d2.hashCode():"+d2.hashCode());
		System.out.println(hs.size());
	}

}
