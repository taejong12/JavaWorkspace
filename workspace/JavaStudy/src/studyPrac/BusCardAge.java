package studyPrac;

import java.util.Scanner;

public class BusCardAge {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("나이 입력:");
//		int age = sc.nextInt();
//        if(age>=18) {
//        	System.out.println("성인");
//        }else if(age>=13 && age<18) {
//        	System.out.println("청소년");	
//        }else if(age>=6 && age<13) {
//        	System.out.println("어린이");
//        }else if(age<=5 && age>=0) {
//        	System.out.println("유아");
//        }
		Scanner sc = new Scanner(System.in);
		System.out.println("만 나이 입력:");
		int age = sc.nextInt();
		String role = getRole(age);
		System.out.println(role);
	}
	
	private static String getRole(int age) {
		String role ="";
		if(age>=18) {
			role="성인";
		}else if(age>=13) {
			role="청소년";
		}else if(age>=6) {
			role="어린이";
		}else if(age>=0) {
			role="유아";
		}else {
			role="미친분";
		}
		return role;
	}

}
