package dataInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DataInputProcess {

	public static void main(String[] args) throws IOException {
		
//		int a=System.in.read();
//		System.out.println("키보드인풋 값:"+a);
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String data = br.readLine();
//		System.out.printf("키보드인풋 값: %s %n",data);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력:");
		String str = sc.next();
		System.out.println("정수입력:");
		int i = sc.nextInt();
		
		sc.close();
		
		System.out.printf("키보드인풋 값: %s %d %n",str,i);
		
	}

}
