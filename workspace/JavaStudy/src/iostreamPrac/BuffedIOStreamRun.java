package iostreamPrac;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BuffedIOStreamRun {

	public static void main(String[] args) {
		//Buffered 값이 들어오고 나갈 때 저장했다가 나간다 시간적인 이점이 있는가
		File file = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\BufferedFile.txt");
		File file2 = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\BufferedOutFile.txt");
		try (FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(file2);
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			// 사용
			int i;
			while((i=bis.read())!=-1) {
				bos.write(i);
			}
		} catch (IOException e) {
			// 예외처리
			e.printStackTrace();
		}
	}

}
