package comments;

import java.util.Date;

public class CommentsDTO {
	private int qna_num;
	private int me_num;
	private String writer;
	private int comm_num;
	private Date comm_regdate;
	private String content;
	private int regroup;
	private int regorder;
	private int reglevel;
	private int pass;
	
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public int getMe_num() {
		return me_num;
	}
	public void setMe_num(int me_num) {
		this.me_num = me_num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public Date getComm_regdate() {
		return comm_regdate;
	}
	public void setComm_regdate(Date comm_regdate) {
		this.comm_regdate = comm_regdate;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRegroup() {
		return regroup;
	}
	public void setRegroup(int regroup) {
		this.regroup = regroup;
	}
	public int getRegorder() {
		return regorder;
	}
	public void setRegorder(int regorder) {
		this.regorder = regorder;
	}
	public int getReglevel() {
		return reglevel;
	}
	public void setReglevel(int reglevel) {
		this.reglevel = reglevel;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	
	
}
