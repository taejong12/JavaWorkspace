package control;

public class Loop {

	public static void main(String[] args) {
		// 1~10 숫자의 합
		int num = 1; // 초기값
		int sum = 0; // 합계

		while (num <= 10) {
			sum += num; // sum = sum + num;
			num++;
		}
		System.out.println("합계:" + sum);

		num = 1;
		sum = 0;
		do {
			sum += num;
			num++;

		} while (num <= 10);
		System.out.println("합계:" + sum);

		num = 1;
		sum = 0;
		for (num = 1; num <= 10; num++) {
			sum += num;
		}
		System.out.println("합계:" + sum);

		// 구구단
		for (int dan = 1; dan <= 9; dan++) {
			for (int t = 1; t <= 9; t++) {
				System.out.println(dan + "X" + t + "=" + dan * t);
			}
			System.out.println();
			}
		
		int dan=1;
		
		while(dan<=9) {
			int t=1;
			while(t<=9) {
				System.out.println(dan + "X" + t + "=" + dan * t);
				t++;
			}
			System.out.println();
			dan++;	
		}
		
		num=1;
		sum=0;
		
		for (num=1;num<=100;num++) {
			sum += num;
		}
		System.out.println("합계:"+sum);
		
		for(int i=0;i<10;i++) {
			if(i==4) {
				break;
			}
			System.out.println(i);
		}
		
		for(int i=0;i<10;i++) {
			if(i==4) {
				continue;
			}
			System.out.println(i);
		}
		
		//짝수만 1-100 합계
		int total = 0;
		for(int i=1;i<=100;i++) {
			if(i%2==1) {
				continue;
			}
			total += i;
		}
		System.out.println(total);
		
		//홀수만 1-100 합계
		total = 0;
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				continue;
			}
			total += i;
		}
		System.out.println(total);
		
		//더 적게
		total = 0;
		for(int i=1;i<=100;i+=2) {
			total += i;
		}
		System.out.println(total);
		
		total=0;
		
		for(int i=1;i<=100;i++) {
			if (total>100) {
				break;
			}
			total += i;
			System.out.println(i);
		}
		System.out.println(total);
		
		int sum1 = 0;
		int num1 = 1;
		while(sum1<100) {
			sum1 += num1;
			if(sum1>100) {
				break;
			}
			num1++;
		}
		System.out.println(sum1+" "+num1);
		
		for (dan = 1; dan <= 9; dan++) {
			System.out.println(dan);
			for (int t = 1; t <= 9; t++) {
				if(dan>=5) {
					break;
				}
				System.out.println(dan + "X" + t + "=" + dan * t);
			}
			System.out.println();
			}
		
		out:
		for (dan = 1; dan <= 9; dan++) {
			System.out.println(dan);
			for (int t = 1; t <= 9; t++) {
				if(dan==5) {
					System.out.println();
					continue out;
				}
				System.out.println(dan + "X" + t + "=" + dan * t);
			}
			System.out.println();
			}
		
	}

}
