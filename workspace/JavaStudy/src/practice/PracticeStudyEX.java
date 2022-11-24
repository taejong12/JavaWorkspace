package practice;

public class PracticeStudyEX {

	public static void main(String[] args) {
		//boolean contains(CharSequence s)
		//contains() 함수는 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수이다.
		//대,소문자를 구분한다. 공백도 체크한다
		String a = "write once, run anywhere";
		if (a.contains("wife")) {
			System.out.println("wife");
		} else if (a.contains("once") && !a.contains("run")) {
			System.out.println("once");
		}else if(!a.contains("everywhere")) {
			System.out.println("everywhere");
		}else if(a.contains("anywhere")) {
			System.out.println("anywhere");
		}else {
			System.out.println("none");
		}
	
		int a1=3;
		while(a1<1000) {
			a1+=3;
		}
		System.out.println(a1);
		
		int i=0;
		while(i<5) {
			int j=0;
			while(j<i+1) {
				System.out.print("*");
				j++;
			}
			i++;
			System.out.println();
		}
			
			
//		for(int i=0;i<5;i++) {
//			for(int j=0;j<i+1;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
		
		
	}

}
