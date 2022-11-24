package project;

public class ProjectSubject {
	private String name;
	private int korean; // 국 영 수 사 과
	private int english;
	private int math;
	private int social;
	private int science;
	private int ranking; // 순위

	public ProjectSubject() {
		name = "";
		this.korean = 0;
		this.english = 0;
		this.math = 0;
		this.social = 0;
		this.science = 0;
		ranking = 1;
	}

	public ProjectSubject(String name, int korean, int english, int math, int social, int science, int ranking) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.social = social;
		this.science = science;
		this.ranking = ranking;
	}

	// 국 영 수 사 과 합
	public int score() {
		return (korean + english + math + social + science);
	}

	// 평균
	public int average() {
		return (korean + english + math + social + science) / 5;
	}
	
	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
