package practice;

public class Subject {
    private String name; // 과목 이름 String
    private int scorePoint; // 과목 점수 int

    //getter setter 함수
    public String getName(){
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public int getScorePoint() {
    	return scorePoint;
    }
    public void setScorepoint(int scorePoint) {
    	this.scorePoint = scorePoint;
    }
}
