package iostreamPrac;

import java.io.IOException;

public class StandardIORun {

	public static void main(String[] args) {
		System.out.println("영문자 하나만 누르고 엔터");
		int i=0;
		try {
			while((i=System.in.read())!='\n') {	
				System.out.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
