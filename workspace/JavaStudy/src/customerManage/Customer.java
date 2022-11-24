package customerManage;

public class Customer {
	static int seqNum = 1000;

	// 정보은닉 private, protected 가 주로 쓰임
	protected int customerId;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;

	// public Customer 삭제하고 public Customer(String customerName) this(); 대신 작성 가능
//	public Customer() {
//		customerGrade = "silver";
//		bonusRatio = 0.01;
//		bonusPoint=100;
//	}

	public Customer(String customerName) {
		// this(); // this(); = customerGrade="silver"; bonusRatio=0.01; bonusPoint=100;
		this.customerName = customerName;
		customerId = seqNum++;
		customerGrade = "silver";
		bonusRatio = 0.01;
		bonusPoint = 100;
		System.out.println("Customer 생성자 실행");
	}

	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}

	public String getCustomerInfo() {
		return "이름:" + customerName + "|등급:" + customerGrade + "|보너스포인트:" + bonusPoint;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	public static int getSeqNum() {
		return seqNum;
	}

}
