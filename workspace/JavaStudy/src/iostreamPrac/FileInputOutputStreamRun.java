package iostreamPrac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputStreamRun {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\TestFile.txt");

		OutputStream os1 = new FileOutputStream(file);
		byte[] barr2 = "InputOutput practice".getBytes();
		os1.write(barr2);
		os1.write('\n');
		os1.flush();
		os1.close();
		
		
		
		InputStream is = new FileInputStream(file);
		
		int data;
		while((data=is.read())!=-1) {
			System.out.println((char)data+" "+is.available()); // 몇개의 바이트가 남아있는지
		}
		is.close();
		
		InputStream is2 = new FileInputStream(file);
		byte[] barr = new byte[23];
		int data2;
		while((data2=is2.read(barr))!=-1) {
			for(int i=0;i<data2;i++) {
				System.out.println((char)barr[i]);
			}
			System.out.println(data2);
		}
		is2.close();

//		InputStream is = null;
//		InputStream is2 = null;
//		try {
//			is = new FileInputStream(file);
//			int data;
//			while ((data = is.read()) != -1) {
//				System.out.println((char) data + " " + is.available()); // 몇개의 바이트가 남아있는지
//			}
//
//			is2 = new FileInputStream(file);
//			byte[] barr = new byte[23];
//			int data2;
//			while ((data2 = is2.read(barr)) != -1) {
//				for (int i = 0; i < data2; i++) {
//					System.out.println((char) barr[i]);
//				}
//				System.out.println(data2);
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				is.close();
//				is2.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		
	}

}
