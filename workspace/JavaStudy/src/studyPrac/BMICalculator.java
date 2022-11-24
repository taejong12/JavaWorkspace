package studyPrac;

import java.util.Scanner;

//public class Bmi {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("키:");
//		double m = sc.nextDouble();
//		System.out.println("몸무게:");
//		double kg = sc.nextDouble();
//		double bmi = kg/Math.pow(m, 2);
//		System.out.printf("BMI:%.2f%n",bmi);
//		if(30<bmi) {
//			System.out.println("비만 입니다.");
//		} else if(25<=bmi && 30>bmi) {
//			System.out.println("과체중 입니다.");
//		} else if(25>bmi && 18.5<=bmi) {
//			System.out.println("정상 입니다.");
//		} else if(18.5>bmi) {
//			System.out.println("저체중 입니다.");
//		}
//	}

//}

public class BMICalculator {
	public static double calculateBMI(double weight, double tall) {
		//double bmi = weight / Math.pow(tall, 2);
		return weight / Math.pow(tall, 2); //bmi;
	}

	public static void printBMIClassification(double bmi) {
		String result = "";
		if (bmi > 30) {
			result = "비만";
		} else if (bmi >= 25) {
			result = "과체중";
		} else if (bmi >= 18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		System.out.printf("BMI: %.2f %n%s 입니다.",bmi, result);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("몸무게 입력(kg):");
		double weight = input.nextDouble();
		System.out.println("키 입력(m):");
		double tall = input.nextDouble();
		// BMI 지수 계산
		double bmi = calculateBMI(weight, tall);
		//System.out.printf("BMI: %.2f%n",bmi);
		// BMI 지수를 입력하여 비만도 결과 출력
		printBMIClassification(bmi);
		
	}
}