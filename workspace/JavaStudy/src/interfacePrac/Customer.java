package interfacePrac;

public class Customer implements Buy,Sell {

	@Override
	public void sell() {
		System.out.println("고객판매");
	}
	@Override
	public void buy() {
		System.out.println("고객구입");
	}
	public void order() {
		System.out.println("고객주문");
	}
	public void comp() {
		System.out.println("고객불만");
	}
}
