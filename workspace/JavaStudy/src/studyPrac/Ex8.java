package studyPrac;

import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
//		int N = 474;
//		int a = N%10;
//		int b = N/10;
//		System.out.println(a);
//		System.out.println(b);
//		int c = b%10;
//		System.out.println(c);
//		int d = N/100;
//		System.out.println(d);

		Scanner sc = new Scanner(System.in);
//		System.out.println("세자리 정수 입력:");
//		int a = sc.nextInt();
//		System.out.println("첫번째 자리:");
//		int b = sc.nextInt();
//		System.out.println("두번째 자리:");
//		int c = sc.nextInt();
//		System.out.println("세번째 자리:");
//		int d = sc.nextInt();

//		System.out.println("세자리 정수 입력:");
//		int i = sc.nextInt();
//		//932%10=2
//		//932/10=93
//		int a0 = i%10;
//		int a1 = (i/10)%10;
//		int a2 = (i/100)%10;
//		int sum = a0+a1+a2;
//		System.out.println("자리수의 합계:"+sum);

		System.out.println("세자리 양수 입력:");
		int i = sc.nextInt();
		// 세자리 정수 예외처리
		if (i >= 1000 || i < 100) {
			System.out.println("세자리가 아닙니다.");
		} else {
			// 932%10=2
			// 932/10=93
			int a0 = i % 10;
			int a1 = (i / 10) % 10;
			int a2 = (i / 100) % 10;
			int sum = a0 + a1 + a2;
			System.out.println("자리수의 합계:" + sum);
		}
		System.out.println("세자리 양수 입력:");
		
		String s = sc.next();
		if(s.length()==3) {
			int sum=0;
			String[] sarr = s.split("");
			for(String sae:sarr) {
				sum += Integer.parseInt(sae);
			}
			System.out.println("자리수의 합계:"+sum);
		}else {
			System.out.println("세자리가 아닙니다.");
		}
	}

}
