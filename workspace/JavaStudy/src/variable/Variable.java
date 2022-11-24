package variable;

public class Variable {

	public static void main(String[] args) {
		int num = 10;
		System.out.println(num);
		int binNum = 0B1010;
		System.out.println(binNum);
		int octNum = 013;
		System.out.println(octNum);
		int hexNum = 0x1A;
		System.out.println(hexNum);
	    
        //integer 32bit
		int num1 = 0B00000000000000000000000000000101;
		int num2 = 0B11111111111111111111111111111011;
		int sum = num1 + num2;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println("sum:"+sum);
		
		System.out.println("sum:"+num1+num2);
		System.out.println( num1+num2+"결과");
		System.out.print("hello");
		System.out.print("\n");
		System.out.print("world");
		System.out.print("\n");

		String world = "World";
		String java = "Java";
		System.out.printf("Hello, %s, %s, %n", world, java); // %n = \n, println...
		
		
		//변수명 가독성
		int mp;//멤버쉽 포인트
		int membershipPoint;
		
		byte byteData = -128;
		System.out.println(byteData);
		byteData = (byte)128;
		System.out.println(byteData);
		
		int integerNum = 1234567;
		long longNum = 2223456789L;
		
		char ch = 'A';
		System.out.println(ch);
		ch = 66;
		System.out.println(ch);
		int chin = 'A';
		System.out.println(chin);
		
		double doubleNum = 3.14;
		float floatNum = 3.14f;
		System.out.println(doubleNum+" "+floatNum);
		
		final double PI = 3.1419;
//		PI=234; //상수는 재할당 불가
		
		int num3 = binNum;
		System.out.println(num3);
		num3 = (int) longNum;
		System.out.println(num3);
		num3 = (int) floatNum;
		System.out.println(num3);
		doubleNum = floatNum + num3;
		System.out.println(doubleNum);
		
		floatNum = 0.9f;
		num1 = (int) (doubleNum+floatNum);
		num2 = (int)doubleNum + (int)floatNum;
		System.out.println("num1:"+num1+" / num2:"+num2);
		
		var num10 = 10; //int num10 = 10;
		var doubNum = 10.01; //double doubNum = 10.01;
		var str = "우리집"; //String str = "우리집";
		System.out.println(num10+" "+doubNum+" "+str);
		
		int A = 3;
		A += 2;
		System.out.println(A);
		
		
		
		
		
		
		
		
	}

}
