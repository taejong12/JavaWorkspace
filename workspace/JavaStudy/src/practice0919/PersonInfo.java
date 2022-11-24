package practice0919;
//개요 : 유저 4명이서 로그인을 하여 각자 본인이 입력한 숫자를 로또 30회 추첨한 결과와 비교한다. 당첨된 숫자 개수만큼 1점씩 point 를 부여해서 점수를 비교한다. 
		
public class PersonInfo{
	private String id;
	private String pw;
	private String name;
	private int point;
	
	public PersonInfo(String ids, String pws, String names, int points) {
		id=ids;
		pw=pws;
		name=names;
		point=points;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
}
		
//**여기부터 시작**
//1. 클래스명 PersonInfo(사람 정보)로 public 클래스 생성.
//2. private 전역변수 id(아이디), pw(패스워드), name(유저이름), point(유저가 가진 포인트) 생성.
//3. PersonInfo 객체를 생성하기 위해, 전역변수들을 매개변수로 가진 public 생성자 생성.
//4. private로 보호하고 있는 변수들의 데이터 사용 및 수정을 위한 get,set 메소드 생성.