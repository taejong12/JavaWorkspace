package customerManage;

public class VipCustomer extends Customer {
	private Manager manager; // 관리자
	private double saleRatio; // 할인률

	public VipCustomer(String customerName,String managerName) {
		super(customerName);
		customerGrade="Vip";
		bonusRatio=0.05;
		saleRatio=0.1;
		bonusPoint=500;
		manager=new Manager(managerName);
		System.out.println("VipCustomer 생성자 실행");
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price-(int)(price*saleRatio);
	}

	@Override
	public String getCustomerInfo() {
		return super.getCustomerInfo()+"|매니저:"+manager.getManagerName();
	}
	
	public Manager getManager() {
		return manager;
	}
	
}
