package polymorphism;

import array.Book;

class People {
	String name;

	public void setName(String name) {
		this.name = name;

	}

	public void showInfo() {
		System.out.println(name+" 사람입니다.");
	}

	public void eatFood() {
		//super.showInfo();
		System.out.println("음식을 먹습니다.");
	}
}

class Male extends People {

	@Override
	public void showInfo() {
		//super.showInfo();
		System.out.println(name+" 남자입니다.");
	}
}

class Female extends People {

	@Override
	public void showInfo() {
		//super.showInfo();
		System.out.println(name+" 여자입니다.");

	}

}

public class PersonRun {

	public static void main(String[] args) {
		Male m = new Male();
		Female f = new Female();

		m.showInfo();
		f.showInfo();

		People pp = new Male();
		pp.showInfo();
		pp = new Female();
		pp.showInfo();

		// instanceof 그것에 대해서 객체가 되느냐
		if (pp instanceof Female) {
			System.out.println("Female instance");
		}
		if (pp instanceof Male) {
			System.out.println("Male instance");
		}
		if (pp instanceof People) {
			System.out.println("People instance");
		}
		if (pp instanceof Object) {
			System.out.println("Object instance");
		}

		People p1 = new People();
		People pm = new Male();
		People pf = new Female();
		p1.showInfo();
		pm.showInfo();
		pf.showInfo();

		People[] pArr = new People[3];
		pArr[0] = new People();
		pArr[1] = new Male();
		pArr[2] = new Female();

		for (int i = 0; i < pArr.length; i++) {
			pArr[i].showInfo();
		}
		
		whoAreYou(p1);
		whoAreYou(pm);
		whoAreYou(pf);
		
		//Male m1= (Male) new People(); // 상속관계인 경우 캐스트 가능
		//Female f1 = (Female)new Book(); // 상속관계가 아닌 경우 포함 불가능
		//m1.showInfo();// 넣는건 가능하지만 실행은 불가능
		People p2 = new Male();
		Male m2 = (Male) p2;
		m2.showInfo();
		
		//Object a = new ArrayList();
		//ArrayList b = (ArrayList)a;
		
	}
	
	public static void whoAreYou(People p) {
		p.setName("선미");
		p.showInfo();
	}
}
