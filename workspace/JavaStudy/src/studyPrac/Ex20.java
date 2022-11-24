package studyPrac;

import java.util.Scanner;

public class Ex20 {

	public static void main(String[] args) {
//		String[] str= {"A","E","I","O","U"};
//		
//		for (int i = 0; i < str.length(); i++) {
//		    switch (str.charAt(i)) {
//		    case 'a':
//		    	break;
//		    case 'e':
//		        ...
//		        break;
//		    default:
//		        ...
//		        break;
//		    }
//		}

		String in;
		int con = 0; // consonants 자음
		int vow = 0; // vowels 모음
		System.out.println("글자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		in = sc.nextLine();
		String check = in.toLowerCase();
		for (int i = 0; i < check.length(); i++) {
			char c = check.charAt(i);
			if (c >= 'a' && c <= 'z') {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vow++;
				} else {
					con++;
				}
			}
		}
		System.out.println("자음개수는 "+con+"개 이고, 모음개수"+vow+"개 이다.");
	}

}
