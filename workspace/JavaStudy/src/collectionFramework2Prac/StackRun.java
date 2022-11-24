package collectionFramework2Prac;

import java.util.Iterator;
import java.util.Stack;

public class StackRun {
	public static void main(String[] args) {
		//Stack은 Vector를 상속받는데 Vector가 제네릭 타입이므로 Stack도 제네릭 타입이다
		Stack<String> stack = new Stack<>();
		stack.push("첫번째");
		stack.push("두번째");
		stack.push("세번째");
		stack.push("네번째");
		stack.push("다섯번째");
		System.out.println(stack);

		// peek 맨위 마지막 내용 보기만 했을 뿐 내용이 지워지지는 않는다
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.size());

		// search 순서찾기 위에서부터 알려준다 없으면 -1(indexOf)
		System.out.println(stack.search("세번째"));
		System.out.println(stack.search("다섯번째"));
		stack.push("여섯번째");
		System.out.println(stack.search("다섯번째"));
		System.out.println(stack.search("일곱번째"));
		
		//pop 위에서부터 꺼낸다 stack의 특징
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		System.out.println(stack.empty());

		stack.push("첫번째");
		stack.push("두번째");
		stack.push("세번째");
		stack.push("네번째");
		stack.push("다섯번째");
		Iterator<String> itr = stack.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.println(stack.empty());
	}
}
