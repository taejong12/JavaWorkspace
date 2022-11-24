package websocketChat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ChatingServer")
public class ChatServer {
	private static Set<Session> clients
		= Collections.synchronizedSet(new HashSet<>());
	
	@OnOpen // 클라이언트 접속 시 실행
	public void onOpen(Session session) {
		clients.add(session); // 세션 추가
		System.out.println("웹소켓 연결:" + session.getId());
	}
	
	@OnMessage // 메시지를 받으면 실행
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("메시지 전송: "+session.getId()+":"+message);
		synchronized (clients) {
			for(Session client : clients) { // 모든 클라이언트에 메시지 전달
				if(!client.equals(session)) { // 단, 메시지를 보낸 클리이언트는 제외
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	
	@OnClose // 클라이언트와의 연결이 끊기면 실행
	public void onClose(Session session) {
		clients.remove(session);
		System.out.println("웹소켓 종료: "+session.getId());
	}
	
	@OnError // 에러 발생 시 실행
	public void onError(Throwable e) {
		System.out.println("에러 발생");
		e.printStackTrace();
	}
	
}

//웹소켓 양방향을 맞춰주면 통신이 가능하다(무전기마냥)
//웹소켓채팅()
//어노테이션을 통해서 해당하는 웹소켓을 생성
//웹소켓을 엔드포인트라고 한다
//웹소켓 요청명
//웹소켓을 연동하기 위해서 요청할 때
//채팅서버에 접근하기 위해서 객체를 만든다
//서버 쪽에서 웹소켓을 만들고
//클라이언트에서는 채팅을 하겠다고 시작할 때 우리쪽에도 해당하는 웹소켓을 만들ㅇ준다
//해당하는 아이피 번호와 포트 번호
//소켓명
//통신규약 ws(웹소켓) 통신망
//채팅이랑은 다름
//채팅 동작을 따로 넣은거 뿐