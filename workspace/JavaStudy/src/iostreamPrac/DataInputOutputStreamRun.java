package iostreamPrac;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamRun {

	public static void main(String[] args) {
		//보조 계열
		//보조 스트림은 섞어서 쓸 수도 있다.
		//바이트 단위
		File file = new File("src\\iostreamPrac\\files\\file.data");
		try (FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataInputStream dis = new DataInputStream(bis);
				DataOutputStream dos = new DataOutputStream(bos);) {
			dos.writeInt(99);
			dos.writeDouble(11.12);
			dos.writeChar('A');
			dos.writeUTF("우리나라");
			dos.flush();
			
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
