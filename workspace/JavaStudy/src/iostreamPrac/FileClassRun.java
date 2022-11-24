package iostreamPrac;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileClassRun {

	public static void main(String[] args) throws IOException {
		String path = "C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		System.out.println(dir.exists());

		File file = new File(path + "\\TestFile.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		System.out.println(file.exists());

		File file2 = new File("C:\\workspace\\JavaStudy\\src\\iostreamPrac\\files\\TestFile.txt");
		File file3 = new File("C:/workspace/JavaStudy/src/iostreamPrac/files/TestFile.txt");
		File file4 = new File("C:" + File.separator + "workspace" + File.separator + "JavaStudy" + File.separator
				+ "src" + File.separator + "iostreamPrac" + File.separator + "files" + File.separator + "TestFile.txt");
		System.out.println(file2.exists() + " " + file2.getAbsolutePath());
		System.out.println(file3.exists() + " " + file3.getAbsolutePath());
		System.out.println(file4.exists() + " " + file4.getAbsolutePath());

		System.out.println(System.getProperty("User.dir"));

		// 상대경로
		File file5 = new File("src/iostreamPrac/files/TextFile.txt");
		File file6 = new File("src/iostreamPrac/files/temp/TextFile2.txt");
		System.out.println(file5.exists() + " " + file5.getAbsolutePath());
		System.out.println(file6.exists() + " " + file6.getAbsolutePath());

		// 디렉토리인지 파일인지 구분 파일이 어디인지
		System.out.println(dir.getName() + " " + dir.isDirectory() + " " + dir.getParent());
		System.out.println(file.getName() + " " + file.isFile() + " " + dir.getParent());
		System.out.println();

		File dir2 = new File(path + "\\temp");
		System.out.println(dir2.mkdir());

		File[] files = dir.listFiles();
		for (File file7 : files) {
			System.out.println(file7.getName() + " " + (file7.isFile() ? ">파일" : ">디렉토리"));
		}

		// Charset.forName() 읽어오는데 읽어오는 방식을 가로안에 있는 타입으로 읽겠다
		Charset cs = Charset.forName("UTF-8");

		// Charset.defaultCharset() 기본설정을 사용할 때
		Charset cs2 = Charset.defaultCharset();
		System.out.println(cs2);

		// Charset.isSupported() 지원여부확인
		System.out.println(Charset.isSupported("EUC-KR"));

		
		
	}

}
