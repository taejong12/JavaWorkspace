package collectionFramework2Prac;

import java.util.*;

public class QueueRun {
	public static void main(String[] args) {
		// interface 객체생성불가, 그래서 2가지 방법 사용 자식클래스생성, 익명이너클래스
		Queue<String> queue = new LinkedList<>();
//		System.out.println(queue.element());
		try {
			queue.element();
		} catch(NoSuchElementException e){
			System.out.println("요소없음");
		}
		
		//add()
		queue.add("나");
		queue.add("너");
		queue.add("우리");
		
		//element()
		System.out.println(queue.element());
		System.out.println(queue);
		
		//remove()
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue);
		try {
			queue.remove();
		} catch(NoSuchElementException e){
			System.out.println("요소없음");
		}
		
		//peek()
		System.out.println(queue.peek());
		
		//offer()
		queue.offer("너");
		queue.offer("나");
		queue.offer("우리");
		System.out.println(queue.peek());
		
		//poll()
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		
	}
}
