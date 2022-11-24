package fileUpDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

// 파일을 올려주기 위해서 받은 cos.jar
// 이걸 활용하기 위해
// 만들어서 이용

public class FileUtil {

	// 파일 업로드(multipart/form-data 요청) 처리, 업로드하는 부분 메서드화(UploadProc.jsp)
	public static MultipartRequest uploadFile(HttpServletRequest req, String saveDirectory, int maxPostSize) {
		try {
			// req 서브밑하면 전달하는 객체(이름,제목,카테고리 등) request
			// saveDirectory 어디에 저장할지 정하는 것
			// maxPostSize 최대 사이즈 제한
			// "UTF-8" 인코딩
			return new MultipartRequest(req, saveDirectory, maxPostSize, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
		// 파일을 저장하기 위해서 멀티파트 써야 한다
		// 받아서 처리할 때 리턴
		// 파일 경로에 저장하는건데
		// 우리가 다운받은
		// 특정 경로로 옮겨주는 라이브러리
		// 주고 받을
		// 리퀘트스트
		// 세이브디렉토리
		// maxPostSize
		// 전달하고자 하는 정보는 리퀘스트
		// 그 파일이 어딘지 알려주고
		// 맥스는 제한사항
		// 파일을 옮길 때 인코딩하는 방식 UTF-8
		
		// 서브밑하면 전달하는 객체 리퀘스트
		// 어디에 저장할지 정하는 것
		// 최대 사이즈 제한
		// 인코딩

	}
	
	// 다운로드 jsp(Download.jsp)를 별도로 메서드화해서 만들어 놓으면 다른 곳에서 호출해서 사용하기 편함
			// 기본적으로 리스폰스하고 리퀘스트를 전달받아야 한다
			// 인자가 5개(리퀘스트 리스폰스 올드파일 뉴파일 스토리지)
			// 저장할 디렉토리, 세이브할 파일네임, 오리지널파일네임
			// 해당하는 실제path를 받아야한다
			// 어플리케이션을 자바소스상에서는 호출할 수 없다
			// 리퀘스트 안 쪽에 getServletContext 안쪽에 어플리케이션을 불러올 수 있어서 path를 받을 수 있다
			// 파일 객체를 만드는데 저장된 파일 이름으로 만든다
			// 출력 스트림 아웃 객체를 받은게 없으니 초기화는 안 쓴다
			// 자바에서는 안쓴다
			// 인자들을 파라미터로 전달 받아야 처리할 수 있다
			// Download.jsp에서는 인자값들을 내장객체로 받은 반면 FileUtil.java에서는 인자값들을 파라미터로 받아서 그 부분을 알맞게
			// 수정해야한다
			// page에 국한되어 있던 파일다운로드 jsp를 자바클래서 메서드로 만들어서 다른곳에서 사용할 수 있게 만든 것
			// jsp는 내장객체가 있고 java는 없어서 리퀘스트랑 리스폰스를 받아야 한다

	public static void download(HttpServletRequest req, HttpServletResponse resp, 
			String directory, String sFilename, String oFilename) {
		String saveDirectory = req.getServletContext().getRealPath(directory);

		try {
			// 파일을 찾아 입력 스트림 생성
			File file = new File(saveDirectory, sFilename);
			InputStream inStream = new FileInputStream(file);

			// 한글 파일명 깨짐 방지
			String client = req.getHeader("User-Agent");
			if (client.indexOf("WOW64") == -1) {
				oFilename = new String(oFilename.getBytes("UTF-8"), "ISO-8859-1");
			} else {
				oFilename = new String(oFilename.getBytes("KSC5601"), "ISO-8859-1");
			}

			// 파일 다운로드용 응답 헤더 설정
			resp.reset();
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + oFilename + "\"");
			resp.setHeader("Content-Length", "" + file.length());

			// response 내장 객체로부터 새로운 출력 스트림 생성
			OutputStream outStream = resp.getOutputStream();

			// 출력 스트림에 파일 내용 출력
			byte b[] = new byte[(int) file.length()];
			int readBuffer = 0;
			while ((readBuffer = inStream.read(b)) > 0) {
				outStream.write(b, 0, readBuffer);
			}

			// 입/출력 스트림 닫음
			inStream.close();
			outStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
		}
	}

	//	파일 삭제
	//	명확하게 할 수 있는 인자값을 넘겨준다
	//	해당하는 파일을 삭제할 구체적인 경로를 받아야 한다
	//	해당 디렉토리로 리얼페스를 받아야 한다
	//	리퀘스트를 받아야 해당하는 어플리케이션에서 경로를 받을 수 있다
	//	디렉토리를 받고 해당하는 파일객체(디렉토리+파일구분자+파일이름 값을 받는 파일객체)를 만들고 
	//	객체가 실제로 경로 안에 실제로 있는지를 우선 확인해야 한다
	//	실제로 존재하는지 확인하고 있으면 파일 삭제를 실행

public static void deleteFile(HttpServletRequest req,
		String directory, String filename) {
	
	//	명확하게 할 수 있는 인자값을 넘겨준다
	//	해당하는 파일을 삭제할 구체적인 경로를 받아야 한다
	//	해당 디렉토리로 리얼페스를 받아야 한다
	//	리퀘스트를 받아야 해당하는 어플리케이션에서 경로를 받을 수 있다
	String saveDirectory = req.getServletContext().getRealPath("directory");
	
	//	디렉토리를 받고 해당하는 파일객체(디렉토리+파일구분자+파일이름 값을 받는 파일객체)를 만들고 
	File file = new File(saveDirectory+File.separator+filename);
	
	//	객체가 실제로 경로 안에 실제로 있는지를 우선 확인해야 한다
	//	실제로 존재하는지 확인하고 있으면 파일 삭제를 실행
	if(file.exists()) {
		file.delete();
	}
}

} // 클래스 괄호

//	해당하는 서블릿에서 중요한 부분
//	실제적으로 동작을 구현해주는 것은 서블릿 컨테이너
//	WAS(웹애플리케이션서비스) 안에 서블릿을 작성하면(여러개 작성가능)
//	동작처리는 컨테이너가 해준다
//	서블릿 컨테이너 안에 서블릿을 작성하면 해당하는 동작을 자바 쓰레드 개념으로 판단해서 
//	개별개별로 컨테이너가 별도의 쓰레드로 처리해준다
//	jsp랑 똑같은 처리
//	서블릿은 자바기반(자바소스 안에 태그), jsp는 태그 쪽에 가까운 형태(태그 안에 자바소스)
//	처리를 해준다
//	누군가에게 한다
//	들어오는 리퀘스트에 맞춰서 로드해주고 실행해주고 뒷처리 해줌
//	리퀘스트 리스폰스 통신
//	생성주기 서블릿이 살아있는 동안 관리
//	쓰레드 관리
//	일반적인
//	서블릿이랑 jsp연동
//	거의 모든 동작을 컨테이너가 해줌
//	플레임워크 스프링 등
//	어떤 형태로 들어가도 컨테이너가 해줌
//	알아서 해주는 영역이 점점 많아진다
//	jsp 해당하는 클라이언트가 직접들어온다
//	짜여있는 자바소스 컴파일만 알아서 해주지만
//	거의 모든 동작이 프레임워크이나 컨테이너에서 처리해준다
//	이렇게 하면 된다 정도로 인식하면 된다
//
//	룰이 정해져 있어서 로직만 내가 짜면 된다
//	그 외에 일들은 다 알아서 처리해준다
//	알아서 해주기 까지의 셋팅은 필요하다
//	스트링 스트링 부트
//	스프링 초기 셋팅을 더 축약해준게 스프링 부트
//
//	계속 바뀌는 것에 맞춰서 공부해야 한다
//
//	응용 소프트웨어는 더 그렇다
//
//	편리해지는만큼 변화가 더 빠르다
//
//	서블릿 컨테이너를 통해서 서블릿 동작을 처리해준다
//
//	그걸 바탕으로 외부에 있는 클라이언트가 리퀘스트를 보내는데 리퀘스트를 받는건 기본적으로 서블릿 컨테이너에서 받는다
//	우리가 작성한 서블릿에서 잡아준다
//	서블릿 잡은데서 해당하는 뷰단(jsp)를 호출하고 그에 대한 처리를 리스폰스를 보낸다
//	이런 구조가 만들어지면 서블릿에서 컨트롤러 jsp에서 뷰의 역할을 한다
//	DTO DAO 자바빈은 모델 역할 DAO는 좀 빠져있다 DB랑 연결하기 때문에
//
//	서블릿이 해당하는 모델과 연결하면서 서버에 있는 데이터를 뷰단에 전달해주면 모델2





