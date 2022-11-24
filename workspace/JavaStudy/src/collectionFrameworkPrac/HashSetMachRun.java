package collectionFrameworkPrac;

import java.util.*;

public class HashSetMachRun {

	public static void main(String[] args) {
		HashSet<String> hst = new HashSet<>();
		hst.add("Hi");
		hst.add("Hi");
		hst.add("hi");
		System.out.println(hst.size());
		System.out.println();
		
		// Food 안쪽에 있는 equeals, hashcode를 비교해야 한다. 없으면 최상위 Object
		HashSet<Food> hs = new HashSet<>();
		Food f1 = new Food("떡볶이","분식");
		Food f2 = new Food("떡볶이","분식");
		Food f3 = new Food("떡볶이","분식");
		hs.add(f1);
		hs.add(f2);
		hs.add(f3);
		System.out.println(f1.equals(f2));
		System.out.println("f1.hashCode():"+f1.hashCode());
		System.out.println("f2.hashCode():"+f2.hashCode());
		System.out.println(hs.size());
	}

}
class Food {
	String foodName;
	String foodKind;
	
	Food(String name,String kind){
		foodName=name;
		foodKind=kind;
	}

	@Override //오버라이딩-접근지정자만 변경할 수 있는데 더 큰거로만 가능
	public boolean equals(Object obj) {
		//instanceof
		if(obj instanceof Food) {
		//Object안에 있는 Food class를 사용하기 위해서 Food로 다운캐스팅해서 써야한다.
		//메소드가 오버라이딩 되어 있으면 오버라이딩한 객체가 상속되지만 Object를 가지고 접근불가 객체를 자식만 가지고 있으니까 다운캐스팅을 해야 한다 
		//Food로 다운캐스팅해서 접근한다.
		//Food temp =(Food)obj;
		//return foodName.equals(temp.foodName) && foodKind.equals(temp.foodKind);
		return foodName.equals(((Food)obj).foodName) && foodKind.equals(((Food)obj).foodKind);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		//Food 클래스 안에 있는 필드(foodName, foodKind)가 가지고 있는 주소(hashCode가 주소값이기 때문에)가 필요하다
		foodName.hashCode();
		foodKind.hashCode();
		return (foodName+foodKind).hashCode();
	}
	
	
	
}