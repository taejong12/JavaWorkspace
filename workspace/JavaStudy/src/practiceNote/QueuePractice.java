package practiceNote;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {

	public static void main(String[] args) {
		//interface는 객체생성불가, 2가지 방법으로 객체 생성 가능, 자식클래스생성, 익명이너클래스
		//LikedList는 Queue를 상속받기 때문에 객체로 생성 가능
		Queue<String> queue = new LinkedList<>();
		//throws exception add(), remove(), element()
		//returns value offer(), poll(), peek()
		
		//throws 예외 전가
		//System.out.println(queue.element()); 요소가 없을 때 예외처리
		try {
			queue.element();//add(), remove()가 될 수도 있다
		} catch(Exception e) {
			System.out.println("예외처리");
		}
		
		//add() 내용추가
		queue.add("나");
		queue.add("너");
		queue.add("우리");
		
		//element() 살짝 보다
		System.out.println(queue.element());
		System.out.println(queue);
		
		//remove() 뽑아서 본다
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		
		//peek() 살짝 보다 없으면 null값을 리턴해준다
		System.out.println(queue.peek());
		
		//offer() 추가하다
		queue.offer("너");
		queue.offer("나");
		queue.offer("우리");
		System.out.println(queue.peek());
		
		//poll() 뽑아서 본다
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);

	}

}
