package fileUpDown;

// DTO는 클라이언트 요청에 포함된 데이터를 담아 서버 측에 전달하고, 
// 서버 측의 응답 데이터를 담아 클라이언트에 전달하는 계층간 전달자 역할을 합니다.

public class MyFileDTO {

	private String idx;
	private String name; // 작성자 이름
	private String title; // 제목
	private String cate; // 카테고리
	private String ofile; // 원본 파일명
	private String nfile; // 저장된 파일명
	private String regdate; // 등록 날짜
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
