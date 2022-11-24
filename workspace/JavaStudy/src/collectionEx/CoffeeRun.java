package collectionEx;

import java.util.HashMap;

enum CoffeeType{Americano,IcedAmericano,CafeLatte}
public class CoffeeRun {

	static void printCoffeePrice(CoffeeType type) {
		HashMap<CoffeeType,Integer> priceMap = new HashMap<>();
		priceMap.put(CoffeeType.Americano, 3000);
		priceMap.put(CoffeeType.Americano, 3000);
		priceMap.put(CoffeeType.Americano, 3000);
		int price = priceMap.get(type);
		System.out.println(String.format("가격은 %d원 입니다.",price));
	}
public static void main(String[] args) {
	printCoffeePrice(CoffeeType.Americano);	
	}

}
