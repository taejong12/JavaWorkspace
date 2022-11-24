package afterComm;

public class ReviewDTO {

	private String num; // 고유번호
	private String name; // 제목
	private String content; // 내용
	private int star; // 평점
	private String ofile; // 오리지널 파일
	private String nfile; // 새파일
	private String menum; // 멤버넘버
	private String pass; // 비밀번호
	private java.sql.Date postdate; // 날짜
	private String RV_POSTNAME; // 작성자
	
	public String getRV_POSTNAME() {
		return RV_POSTNAME;
	}
	public void setRV_POSTNAME(String rV_POSTNAME) {
		RV_POSTNAME = rV_POSTNAME;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getNfile() {
		return nfile;
	}
	public void setNfile(String nfile) {
		this.nfile = nfile;
	}
	public String getMenum() {
		return menum;
	}
	public void setMenum(String menum) {
		this.menum = menum;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public java.sql.Date getPostdate() {
		return postdate;
	}
	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}
	
	
	
	
}
