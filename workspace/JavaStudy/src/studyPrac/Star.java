package studyPrac;

import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("입력:");
//		int line = sc.nextInt();
//		for(int i=0; i<line; i++) { // 줄 for문
//			for(int j=0; j<=i; j++) { // 별 그리는 for문
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
		int line = 5; // 출력할 줄수
		for(int i=0; i<line; i++) { // 정한 줄수만큼 반복
			for(int j=0; j<=i; j++) { // 반복횟수만큼 별 출력
				System.out.print("*");
		}
			System.out.println(""); // 줄마다 줄바꿈(개행)
		}
		
		int line1 = 5; // 출력할 줄수
		for(int i=line1; i>0; i--) { // 정한 줄수만큼 반복
			for(int j=0; j<i; j++) { // 반복횟수만큼 별 출력
				System.out.print("*");
		}
			System.out.println(""); // 줄마다 줄바꿈(개행)
		}
		
		int line3 = 5; // 출력할 줄수
		for(int i=0; i<line3; i++) { // 정한 줄수만큼 반복
			
			for(int j=0; j<=i; j++) { // 반복횟수만큼 별 출력
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) { // 반복횟수만큼 별 출력
				System.out.print("*");
		}
			System.out.println(""); // 줄마다 줄바꿈(개행)
		}
	}
}
