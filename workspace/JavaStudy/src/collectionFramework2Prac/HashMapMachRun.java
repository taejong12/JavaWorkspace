package collectionFramework2Prac;

import java.util.HashMap;


class Food2 {
	String foodName;

	Food2(String name) {
		foodName = name;
	}

	@Override
	public String toString() {
		return foodName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Food2) { // Food2를 이용했는지 확인
			return foodName.equals(((Food2) obj).getFoodName());
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return foodName.hashCode();
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

}

public class HashMapMachRun {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(3, "Hi");
		hm.put(4, "Hi");
		hm.put(3, "hi");
		System.out.println(hm);
		System.out.println(hm.size());
		System.out.println();

		HashMap<Food2, String> hm1 = new HashMap<>();
		Food2 f1 = new Food2("떡볶이");
		Food2 f2 = new Food2("떡볶이");
		hm1.put(f1, "양식");
		hm1.put(f2, "중식");
		System.out.println(f1.equals(f2));
		System.out.println("f1.hashCode():" + f1.hashCode());
		System.out.println("f2.hashCode():" + f2.hashCode());
		System.out.println(hm1.size());
		System.out.println(hm1);
		System.out.println();
	}

}
