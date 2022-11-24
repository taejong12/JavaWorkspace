package cooperation;

public abstract class Trans { // 교통수단 전체

	int passengerCount; // 승객숫자
	int income; // 총 수익

	public void take(int money) {
		income += money;
		passengerCount++;
	}

	public abstract void showInfo();
}
