package control;

import java.util.Scanner;

public class LoopPrac {

	public static void main(String[] args) {
		System.out.println(args[0]);
		Scanner scan = new Scanner(System.in);
		System.out.print("입력:");
		int line = scan.nextInt();
		System.out.println(line);
		
		for(int i=0;i<line;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println();
		for(int i=0;i<line;i++) {
			for(int j=0;j<line-i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("");
		
		for(int i=0; i<line; i++) {
			for(int k=1;k<line-i;k++) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i=1; i<=line; i++) {
			for(int k=line-i;k>0;k--) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i=0;i<line;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println("");
		}
		
		for(int i=0;i<line;i++) {
			for(int j=0;j<line-i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		/*int space = line/2;
		int star = 1;
		for(int j=1; j<=line; j++) {
			for(int k=0;k<space;k++) {
				System.out.println(" ");
			}
			for(int 1=0; 1<star; 1++) {
				System.out.println("*");
			}
			if() {
				
			}*/
		}
				
		
	}


