package practice;

public class CloudStudyPrac {

	public static void main(String[] args) {
		 // 변수 생성
        String item1 = "한우 꽃등심";
        int price1 = 112500;
        String item2 = "참치 선물팩";
        int price2 = 25500;
        String item3 = "맥스봉 한팩";
        int price3 = 500;
        // 형식에 따른 출력!
        System.out.printf("품명: %-10s 가격: %8d\n", item1, price1);
        System.out.printf("품명: %-10s 가격: %8d\n", item2, price2);
        System.out.printf("품명: %-10s 가격: %8d\n", item3, price3);
        System.out.println();
        
        int don = 8000;
        int kal = 10000;
        int wang = 5000;
        
        int donN = 16;
        int kalN = 8;
        int wangN = 1;
        System.out.printf("%3s x %2d = %6d%n", "돈가스", donN, don*donN);
        System.out.printf("%3s x %2d = %6d%n", "칼국수", kalN, kal*kalN);
        System.out.printf("%3s x %2d = %6d%n", "왕만두", wangN, wang*wangN);
        System.out.println("===================");
        System.out.printf("%2s:%7d", "총합",don*donN+kal*kalN+wang*wangN);
        System.out.println();
        System.out.println();
        
        int tlrmq = 8000;
        int dlf = 160;
        System.out.println(tlrmq*dlf);
        System.out.println();
        
        int euro = 58;
        int dollar = 32;
        
        double euroRate = 1320.48026;
        double dollarRate = 1063.82979;
        
        int s = (int) (euro*euroRate+dollar*dollarRate);
        
        System.out.println(euro+"유로"+"+"+dollar+"달러"+"="+s);
        System.out.println();
        
        int age=0;
        if(age>=18) {
        	System.out.println("성인");
        }else if(age>=13 && age<18) {
        	System.out.println("청소년");	
        }else if(age>=6 && age<13) {
        	System.out.println("어린이");
        }else if(age<=5) {
        	System.out.println("유아");
        }
	}

}
