package operator;

public class Operator {
	public static void main (String[] args) {
		int num1 = 8, num2 = 4;
		System.out.println("+연산자:"+(num1+num2));
		System.out.println("-연산자:"+(num1-num2));
		System.out.println("*연산자:"+(num1*num2));
		System.out.println("/연산자:"+(num1/num2));
		System.out.println("%연산자:"+(num1%num2));
		
		int num3=7, num4=7, num5=7;
		num3 = num3 - 3;
		num4 -= 3;
		num5 =- 3;
		System.out.println(num3+" "+num4+" "+num5);
		
		int y=0, x=10;
		y=x-- + 5 + --x;
		System.out.println(y+" "+x);
		
		System.out.println(num3 == num4);
		System.out.println(num3 != num4);
		System.out.println(x>y);
		System.out.println(x<=y);
		
		char char1 = 'a';
		char char2 = 'b';
		
		System.out.println(char1>char2);
		
		boolean bool1=true,bool2=false;
		System.out.println(bool1+" "+bool2);
		
		char1 = 'v';
		char2 = 'B';
		boolean result1,result2;
		result1 = (char1>'c')&&(char2<'z');
		result2 = (char1<'A')||(char2>'Z');
		System.out.println("&&result1:"+result1);
		System.out.println("||result2:"+result2);
		System.out.println("!result1:"+!result1);
		System.out.println("!result2:"+!result2);
		
		
		System.out.println(10&7);
		System.out.println(10|7);
		System.out.println(10^7);
		System.out.println(10<<1);
		System.out.println(10>>1);
		System.out.println(7>>1);
		
		//삼항 연산자 = 조건식? 반환값1(참) : 반환값2(거짓)  ()? : ;
		String a = (5>3)? "맞아":"틀려";
		System.out.println(a);
		String b = (5<3)? "맞아":"틀려";
		System.out.println(b);
		System.out.println((9<7)?"T":"F");
		
	}
}
