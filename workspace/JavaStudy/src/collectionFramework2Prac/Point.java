package collectionFramework2Prac;

public class Point {
	private int point;

	public Point(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return String.format("포인트:%s", point);
	}


	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
