package customerManage;

import java.util.ArrayList;

public class CustomerRun {

	public static void main(String[] args) {
		ArrayList<Customer> cusList = new ArrayList<>();
		Customer lee = new Customer("이순신");
		Customer hong = new Customer("홍길동");
		//할인률 5%, 등급 Gold, 보너스포인트적립률 3%, 보너스포인트 300
		GoldCustomer sung = new GoldCustomer("성시경");
		VipCustomer kun = new VipCustomer("정현도", "이상무");
		VipCustomer mee = new VipCustomer("이미진", "이상무");
		cusList.add(lee);
		cusList.add(hong);
		cusList.add(kun);
		cusList.add(sung);
		cusList.add(mee);
		
		System.out.println("==고객==");
		for(Customer cus:cusList) {
			System.out.println(cus.getCustomerInfo());
		}
		
		System.out.println("==가격계산==");
		int price = 100000;
		for(Customer cus:cusList) {
			int cost = cus.calcPrice(price);
			System.out.println(cus.getCustomerName()+"고객님의 구매금액은"+cost+"원입니다.");
			System.out.println(cus.getCustomerInfo());
		}
		
	}
}
