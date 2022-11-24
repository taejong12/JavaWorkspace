package collectionFramework;

class GenBox<T>{
	private T type;
	public T getBox() {
		return type;
	}
	public void setBox(T type) {
		this.type=type;
	}
}
class Gen2Box<K, V>{ // 타입이 같다 제너릭 메소드가 된다
	private K key;
	private V value;
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
public class BoxRun2 {

	public static void main(String[] args) {
		GenBox<Integer> b1 = new GenBox<Integer>();
		b1.setBox(12);
		System.out.println(b1.getBox());
		GenBox<String> b2 = new GenBox<>(); // 뒤쪽 생략 가능
		b2.setBox("젠너릭박스");
		System.out.println(b2.getBox());
		//Object 보다 제너릭이 타입체크에 강함
		Gen2Box<String,Integer> b21 = new Gen2Box<>(); // 타입을 허용하지 않으면 최상위 클래스인 Object가 들어간다
		b21.setKey("java");
		b21.setValue(1234);
		System.out.println(b21.getKey()+" "+b21.getValue());
		
		Gen2Box<Integer,String> b22 = new Gen2Box<>();
		b22.setKey(7);
		b22.setValue("제임스 본드");
		System.out.printf("%03d %s %n",b22.getKey(),b22.getValue());
		
		Gen2Box<String,Void> b23 = new Gen2Box<>();
		b23.setKey("key만 사용");
		System.out.printf("%s %n",b23.getKey());
	}

}
