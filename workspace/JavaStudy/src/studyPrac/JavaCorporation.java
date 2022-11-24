package studyPrac;

import java.util.Scanner;

//public class Ex15 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("근무시간:");
//		double t = sc.nextDouble();
//		System.out.println("기본시급:");
//		double m = sc.nextDouble();
//				if(t>40) {
//			System.out.println((t-40)*m*1.5);
//		} else {
//			System.out.println(t*m);
//		}
//		
//		if(m<8.00) {
//			System.out.println("ERROR: 최저시급 불이행");
//		}
//		
//		if(t>60) {
//			System.out.println("ERROR: 제한 근무시간 초과");
//		}
//				
//	}
//	
//
//}

public class JavaCorporation {
	public static void printPay(double basePay, int hours) {
		// 메소드를 구현하세요..
//    	직원의 임금은 주급으로 정산하며, (근무시간) X (기본시급)을 기준으로 한다.
//    	주당 근무시간이 40시간을 초과시, 초과급여는 (초과시간) X (기본시급) X (1.5)으로 한다.
//    	기본시급은 최저 $8.00이며, 이보다 작을 경우 에러를 출력한다.
//    	주당 근무시간이 60시간을 초과하는 경우 에러를 출력한다.
//    	
//    	double bh = basePay*hours;
//    	double bhO = (hours-40)*basePay*1.5;
//    	
//    	if(basePay<8.00) {
//    		System.out.println("ERROR: 최저시급 불이행");
//    	}else if(hours>60) {
//    		System.out.println("ERROR: 제한 근무시간 초과");
//    	}else if(hours>40) {
//    		System.out.printf("$ %.2f%n", (basePay*40)+bhO);
//    	} else {
//    		System.out.println(bh);
//    	}

		if (hours > 60) {
			System.out.println("ERROR: 제한 근무시간 초과.");
		} else if (basePay < 8) {
			System.out.println("ERROR: 최저시급 불이행");
		} else {
			double weekPay = 0;
		if (hours > 40) {
			weekPay = basePay * 40 + basePay * (hours - 40) * 1.5;
		} else {
			weekPay = basePay * hours;
		}
		System.out.printf("$ %.1f %n", weekPay);
	}
//    	double hoursOut = 0; 
//    	if(hours>40) {
//    		hoursOut=(hours-40)*basePay*1.5;
//    	} else {
//    		System.out.println("미지급");
//    	}
//    	String he="";
//    	if(hours>60) {
//    		he="ERROR";
//    	}
//    	System.out.println(he);

	}

	public static void main(String[] args) {
		printPay(7.50, 35);
		printPay(8.20, 47);
		printPay(10.00, 73);
	}
}
