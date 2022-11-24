package customerManage;

public class GoldCustomer extends Customer {
	private double saleRatio; // 할인률
	
	public GoldCustomer(String customerName) {
		super(customerName);
		customerGrade="GOLD";
		bonusRatio=0.03;
		saleRatio=0.05;
		bonusPoint=300;
		System.out.println("GoldCustomer 생성자 실행");
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price-(int)(price*saleRatio);
	}

//	@Override // Customer 에 있는 내용과 같기 떄문에 상속 받을 필요없음
//	public String getCustomerInfo() {
//		return super.getCustomerInfo();
//	} 
	
}
