package iostreamPrac;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedTimeTestRun {

	public static void main(String[] args) {
		File fileOrigin = new File("src\\iostreamPrac\\files\\bear.jpg");
		File copyFile1 = new File("src\\iostreamPrac\\files\\bear_c1.jpg");
		File copyFile2 = new File("src\\iostreamPrac\\files\\bear_c2.jpg");
		
		long t1, t2;
		t1 = System.nanoTime();
		try(InputStream is = new FileInputStream(fileOrigin);
			OutputStream os = new FileOutputStream(copyFile1);){
			int data;
			while((data=is.read())!=-1) {
				os.write(data);
			}
		} catch(IOException e) {e.printStackTrace();}
		t1 = System.nanoTime() - t1;
		System.out.println("버퍼없이 하는 경우: " +t1);
		
		t2 = System.nanoTime();
		try(InputStream is = new FileInputStream(fileOrigin);
			BufferedInputStream bis = new BufferedInputStream(is);
			OutputStream os = new FileOutputStream(copyFile2);
			BufferedOutputStream bos = new BufferedOutputStream(os);){
			int data;
			while((data=bis.read())!=-1) {
				bos.write(data);
			}
		} catch(IOException e) {e.printStackTrace();}
		t2 = System.nanoTime() -t2;
		System.out.println("버퍼를 사용한 경우: " +t2);
		System.out.println(t1/t2);
	}

}
