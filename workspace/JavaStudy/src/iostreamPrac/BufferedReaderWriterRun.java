package iostreamPrac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BufferedReaderWriterRun {

	public static void main(String[] args) {
		File file = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\FileReadWriter.txt");

		// 캐릭터단위 추상클래스라서 자식 클래스를 통해 객체를 생성 input output는 바이트 단위
		try (Writer writer = new FileWriter(file);
				Reader reader = new FileReader(file);
				BufferedWriter bw = new BufferedWriter(writer);
				BufferedReader br = new BufferedReader(reader);) {
			bw.write("Korea fighting\n".toCharArray());
			bw.write(123); //{
			bw.write("come to my home", 3, 8);
			bw.flush();

			String data;
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
