package collectionFramework;

class UtillBox{ // 일반클래스
	public <T> T boxing(T t) { //제너릭 메소드
		return t;
	}
	public <T> boolean boxing(T t1,T t2) {
		return t1==t2;
	}
	public <K, V> void boxing2(K k, V v) {
		System.out.println(k+":"+v);
	}
//	public <T> void method(T t) {
//		System.out.println(t.length()); // 사용불가=>Object 메소드만 사용가능
//	}
}
public class UtillBoxRun {
	public static void main(String[] args) {
		UtillBox ub = new UtillBox();
		System.out.println(ub.<String>boxing("사과"));
		System.out.println(ub.boxing("오렌지"));
		
		System.out.println(ub.<Integer>boxing(3,3));
		System.out.println(ub.<String>boxing("우리집","우리집"));
		String str1 = new String("우리집");
		String str2 = new String("우리집");
		System.out.println(str1.equals(str2));
		System.out.println(ub.<String>boxing(str1,str2));
		
		ub.<String,Integer>boxing2("java", 90);
		
	}

}
