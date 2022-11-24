package projectPractice;

public class MembershipInfo {
	
	private String membershipId;
	private String membershipPassword;
	private String membershipName;
	
	MembershipInfo(){
		
	}
	MembershipInfo(String membershipIds, String membershipPasswords, String membershipNames){
		membershipId=membershipIds;
		membershipPassword=membershipPasswords;
		membershipName=membershipNames;
	}
	public String getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	public String getMembershipPassword() {
		return membershipPassword;
	}
	public void setMembershipPassword(String membershipPassword) {
		this.membershipPassword = membershipPassword;
	}
	public String getMembershipName() {
		return membershipName;
	}
	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}

	public String toString() {
		return  "아이디: "+membershipId+" "+"비밀번호: "+membershipPassword+" "+"이름: "+membershipName;
	}
	
	
	
}
