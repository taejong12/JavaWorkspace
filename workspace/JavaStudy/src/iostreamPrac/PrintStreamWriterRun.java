package iostreamPrac;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamWriterRun {

	public static void main(String[] args) {
		// 출력만 있다 출력전용
		File psf = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\PrintStream.txt");
		File pwf = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\PrintWriter.txt");

		try (
				// 1 파일
				// PrintStream ps = new PrintStream(psf)

				// 2 파일 -> outputStream
				OutputStream os = new FileOutputStream(psf);
				PrintStream ps = new PrintStream(os);

				// 3 콘솔
				PrintStream ps2 = new PrintStream(System.out);

		) {
			ps.println(10.9);
			ps.print(10 + "년" + 9 + "개월 \n");
			ps.printf("%s", "우리나라");
			ps.println();
			
			ps2.println(10.9);
			ps2.print(10 + "년" + 9 + "개월 \n");
			ps2.printf("%s", "우리나라");
			ps2.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		try(
				//1 파일
				//PrintWriter pw = new PrintWriter(pwf);
				
				//2 OutputStream
				OutputStream os = new FileOutputStream(psf);
				PrintWriter pw = new PrintWriter(pwf);
				
				//3 Writer
				PrintWriter pw2 = new PrintWriter(new FileWriter(pwf));
				
				//4 console
				PrintWriter pw3 = new PrintWriter(System.out,true);
				
				)
		{
			pw.println(10.9);
			pw.print(10 + "년" + 9 + "개월 \n");
			pw.printf("%s", "우리나라");
			pw.println();
			
			pw2.println(10.9);
			pw2.print(10 + "년" + 9 + "개월 \n");
			pw2.printf("%s", "우리나라");
			pw2.println();
			
		}catch(IOException e) {
			
		}
	}

}
