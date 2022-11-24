package project;

public class ProjectStudentInfo {

	private String studentId;
	private String studentPassword;
	private String name;
	
	public ProjectStudentInfo() {
		
	}
	
	public ProjectStudentInfo(String studentId, String studentPassword, String name) {
		this.studentId = studentId;
		this.studentPassword = studentPassword;
		this.name=name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
