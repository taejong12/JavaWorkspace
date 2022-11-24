package iostreamPrac;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReadWriterRun {

	public static void main(String[] args) {
		File file = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\FileReadWriter.txt");

		// 캐릭터단위 추상클래스라서 자식 클래스를 통해 객체를 생성  input output는 바이트 단위
		try (Writer writer = new FileWriter(file); Reader reader = new FileReader(file);) {
			writer.write("Korea fighting\n".toCharArray());
			writer.write(123);
			writer.write("come to my home", 2, 3);
			writer.flush();
			
			int data;
			while((data=reader.read())!=-1) {
				System.out.println((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
