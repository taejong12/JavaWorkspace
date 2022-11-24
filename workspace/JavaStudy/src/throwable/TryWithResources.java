package throwable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			//객체 생성
			sc= new Scanner(new File("C:\\workspace\\JavaStudy\\src\\throwable\\input.txt"));
			System.out.println(sc.nextLine());
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(sc != null) {
				sc.close();
			}
		}
	}

}
