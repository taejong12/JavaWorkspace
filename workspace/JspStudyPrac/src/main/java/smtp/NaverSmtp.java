package smtp;

import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// 네이버 SMTP 서버를 통해 이메일을 전송하는 클래스
public class NaverSmtp {
	private final Properties serverInfo; // 서버 정보
	private final Authenticator auth; // 인증 정보

	// 자바빈즈
	public NaverSmtp() {
		
		//네이버 SMTP 서버 접속 정보
		serverInfo = new Properties();
		serverInfo.put("mail.smtp.host", "smtp.naver.com");
		serverInfo.put("mail.smtp.port", "465");
		serverInfo.put("mail.smtp.auth", "true");
		serverInfo.put("mail.smtp.starttls.enable", "true");
		serverInfo.put("mail.smtp.starttls.required", "true");
		serverInfo.put("mail.smtp.ssl.enable", "true");
		serverInfo.put("mail.smtp.ssl.trust", "smtp.naver.com");
		serverInfo.put("mail.smtp.ssl.protocols", "TLSv1.2");
		serverInfo.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	
		
		// 사용자 인증 정보
		auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dbxowhdsla12", "");
			}
			
		};
	}
	
	//이메일 샌딩이 핵심이다
	//Session session = Session.getInstance(serverInfo, auth);
	//보내는 것에 대한 세션을 생성해야 한다
	//겟인스턴스 두개의 값을 받아야 한다
	//정보를 담기 위한 셋팅 뒤에는 인증처리를 해줘야 한다
	//인증 정보를 받아줄 객체를 생성(auth)
	//앞쪽에는 셋팅정보 뒤에는 인증정보(serverInfo, auth);
	
	// 주어진 메일 내용을 네이버 SMTP 서버를 통해 전송합니다.
	public void emailSending(Map<String, String> mailInfo) throws MessagingException {
		
		// 1. 세션 생성
		Session session = Session.getInstance(serverInfo, auth);
		session.setDebug(true);
		
		// 2. 메시지 작성
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(mailInfo.get("from"))); // 보내는 사람
		msg.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(mailInfo.get("to"))); // 받는 사람
		msg.setSubject(mailInfo.get("subject")); // 제목
		msg.setContent(mailInfo.get("content"), mailInfo.get("format")); // 내용
		
		// 3. 전송
		Transport.send(msg);
		System.out.println("message sent");
	}
}

//smtp 
//요즘에는 이런식으로 사용하지 않는다
//인증구조 보안성 문제
//메일 서버 api를 요청 받으면서 인증키를 받으면서 활용한다
//메일을 운영하는 곳의 서버에서 api를 받아서 사용


