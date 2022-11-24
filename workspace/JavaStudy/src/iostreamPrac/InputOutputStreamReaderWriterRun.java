package iostreamPrac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InputOutputStreamReaderWriterRun {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\FileReadWriter.txt");

		InputStream is = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(is);
		OutputStream os = new FileOutputStream(file);
		OutputStreamWriter isw = new OutputStreamWriter(os);

		is.close();
		isr.close();
		os.close();
		isw.close();
		
		OutputStreamWriter osw2 = new OutputStreamWriter(System.out,"UTF-8");
		osw2.write("콘솔 출력을 위한 입력");
		osw2.flush();
		osw2.close();
		
		
	}

}
