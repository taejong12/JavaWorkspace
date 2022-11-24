package studyPrac;

import java.util.Scanner;

public class Prac20 {

	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		System.out.println("정수값 입력:");
//		int n = input.nextInt(); // 정수값 입력
//		String str = input.next(); // 문자열 입력
//		
//		int a = 0;
//		int b = 0;
//		
//		
//		
//	

//		for (int i = 0; i < str.length(); i++) {
//			switch (str.charAt(i)) {
//			case 'a':
//			case 'e':
//			case 'i':
//			case 'o':
//			case 'u':
//
//				break;
//			default:
//
//				break;
//			}
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수값 입력:");
		String str = sc.nextLine();
		int k = Integer.parseInt(str);

		String[] y = new String[k];
		int[] a = new int[k]; // 자음
		int[] b = new int[k]; // 모음

		for (int i = 0; i < k; i++) {
			System.out.println("문자열 입력:");
			y[i] = sc.nextLine();
			for (int j = 0; j < y[i].length(); j++) {
				char z = y[i].charAt(j);
				switch (z) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					a[i]++;
					break;
				default:
					b[i]++;
					break;
				}
			}
		}
		for(int i=0;i<k;i++) {
			System.out.println(y[i]+" "+a[i]+" "+b[i]);
		}

	}

}
