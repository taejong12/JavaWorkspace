package qna;

public class QnasDTO {
	
	private String num; // 고유번호
	private String name; // 제목
	private String content; // 내용
	private String ofile; // 오리지널 파일
	private String nfile; // 새파일
	private String writer; // 작성자(익명)
	private String me_num; // 실제 작성회원번호
	private String me_name; // 실제 작성회원명
	private java.sql.Date postdate; // 날짜
	private String pass; // 비밀번호
	
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
	public java.sql.Date getPostdate() {
		return postdate;
	}
	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMe_num() {
		return me_num;
	}
	public void setMe_num(String me_num) {
		this.me_num = me_num;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	
	

}
