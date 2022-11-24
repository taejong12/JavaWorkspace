package studyPrac;

import java.util.Scanner;

public class GravityCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double gravity = -9.81; // a
		double initPos = 1000; // ip
		System.out.println("낙하시간:");
		double time = sc.nextDouble(); // t
		double initV = 0; // iv
		//0.5at^2 + vt + x
		double finPos = 0.5*gravity*Math.pow(time, 2)+ initV*time+initPos;
		System.out.printf("%.2f초 후, 물체의 고도는 %.2fm",time,finPos);
		
	}

}
