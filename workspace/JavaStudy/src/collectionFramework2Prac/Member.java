package collectionFramework2Prac;

public class Member implements Comparable<Member> {
	private Integer memberId;
	private String memberName;
	private Integer memberAge;

	public Member(int memberId, String membername, int memberage) {
		this.memberId = memberId;
		this.memberName = membername;
		this.memberAge = memberage;
	}

	@Override
	public int hashCode() {
		return memberId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			return ((Member) obj).getMemberId() == this.memberId;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return String.format("||ID: %s||이름: %s||나이: %s||", memberId,memberName,memberAge);
	}

	@Override
	//compareTo에서 equeals, hashCode를 처리해준다
	public int compareTo(Member mem) {
		return memberId.compareTo(mem.getMemberId());
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return memberName;
	}

	public void setName(String membername) {
		this.memberName = membername;
	}

	public int getMemberage() {
		return memberAge;
	}

	public void setMemberage(int memberage) {
		this.memberAge = memberage;
	}

}
