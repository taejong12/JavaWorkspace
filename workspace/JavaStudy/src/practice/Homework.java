package practice;

public class Homework {

	public static void main(String[] args) {

		int score = 72;

		if (80 <= score && score < 90) {
			System.out.println("B학점");
		} else if (score >= 90) {
			System.out.println("A학점");
		} else if (70 <= score && score < 80) {
			System.out.println("C학점");
		} else {
			System.out.println("F학점");
		}
		System.out.println();
		
		switch (score/10) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("F학점");
		}
		System.out.println();
		
		for(int i=0; ;i++) {
			if(i%2==1)continue;
			if(i>10)break;
			System.out.println(i);
		}
		System.out.println();
		
		int k=10;
		while(k>0) {
			System.out.println(k);
			k-=2;
		}
		System.out.println();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				if(i==2) {
					continue;
				}
				if(j==1) {
					break;
				}
				System.out.println("A");
			}
		}
		System.out.println();
		
		out:
		for(int i=0; i<10; i++) {
			for(int j=0; j<5; j++) {
				if(i==3 && j==2){
					break out;
				}
				System.out.println(i+", "+j);
			}
		}
		System.out.println();
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<5; j++) {
				if(i==3 && j==2){
					i=100;
					break;
				}
				System.out.println(i+", "+j);
			}
		}
		System.out.println();
		
		boolean breakOut = false;
		for(int i=0; i<10; i++) {
			for(int j=0; j<5; j++) {
				if(i==3 && j==2){
					breakOut=true;
					break;
				}
				System.out.println(i+", "+j);
			}
			if(breakOut)break;
		}
		System.out.println();
		
		int num1 = 45, num2 =100;
		
		if(num1>num2) {
			System.out.println("num1이 크다");
		}
		else{
			System.out.println("num2가 크다");
		}
		System.out.println();
		
		if(num1>num2) {
			System.out.println(num1);
		}
		else{
			System.out.println(num2);
		}
		System.out.println(Math.max(num1,num2));
		
		System.out.println();
		
		int num3 = -23;
		if(num3>0) {
			
			if(num3%2==1) {
				System.out.println("양수 홀수");
			}
			else if(num3%2==0){
				System.out.println("양수 짝수");
			}
		}
		else if(num3<0){
			
			if(num3%2==-1) {
				System.out.println("음수 홀수");
			}
			else if(num3%2==0){
				System.out.println("음수 짝수");
			}
		}
		else {
			System.out.println("0");
		}
		
		int chkNum = num3;
		int chkNumA = chkNum%2;
		System.out.println(chkNum+" "+chkNumA);
		
		if(chkNum>0 && chkNumA==0) {
			System.out.println("양수이면서 짝수");
		}else if(chkNum>0 && chkNumA==1) {
			System.out.println("양수이면서 홀수");
		}else if(chkNum<0 && chkNumA==0) {
			System.out.println("음수이면서 짝수");
		}else if(chkNum<0 && chkNumA==-1) {
			System.out.println("음수이면서 홀수");
		}else {
			System.out.println("0");
		}
		
	}
}
