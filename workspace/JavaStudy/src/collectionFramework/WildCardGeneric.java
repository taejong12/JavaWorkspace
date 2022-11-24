package collectionFramework;

class Top{}
class Sub extends Top{}
class Cen extends Sub{}
class Bot extends Cen{}

class Team<T> { // 제너릭 클래스 생성
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class Member{
	void show1(Team<Top> t) {} //Team 객체 Top 객체
	void show2(Team<?> t) {} //Team 객체 아무거나
	void show3(Team<? extends Sub> t) {} //Team 객체 Sub, Cen, Bot
	void show4(Team<? super Sub> t) {} //Team 객체 Top,Sub,Object
}

public class WildCardGeneric {

	public static void main(String[] args) {
		Member mem =new Member();
		mem.show1(new Team<Top>());
//		mem.show1(new Team<Sub>());
//		mem.show1(new Team<Cen>());
//		mem.show1(new Team<Bot>());
		
		mem.show2(new Team<Top>());
		mem.show2(new Team<Sub>());
		mem.show2(new Team<Cen>());
		mem.show2(new Team<Bot>());
		mem.show2(new Team<Object>());
		mem.show2(new Team<Integer>());
		
//		mem.show3(new Team<Top>());
		mem.show3(new Team<Sub>());
		mem.show3(new Team<Cen>());
		mem.show3(new Team<Bot>());
		
		mem.show4(new Team<Top>());
		mem.show4(new Team<Sub>());
//		mem.show4(new Team<Cen>());
//		mem.show4(new Team<Bot>());
		mem.show4(new Team<Object>());
//		mem.show4(new Team<Integer>());
	}

}
