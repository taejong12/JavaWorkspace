package practiceNote;

import java.util.*;

public class StackPractice {

	public static void main(String[] args) {
		// Stack은 Vector를 상속받는데 Vector가 제네릭 타입이므로 Stack도 제네릭 타입이다
		Stack<String> stack = new Stack<>();
		stack.push("첫번째");
		stack.push("두번째");
		stack.push("세번째");
		stack.push("네번째");
		stack.push("다섯번째");
		System.out.println(stack);
		
		// Stack은 바구니 형태 LIFO
		// peek 맨위 마지막에 들어온 내용을 보기만 할 뿐 내용이 지워지지 않는다
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.size());
		
		// search 순서찾기 위에서부터 알려준다 없으면 -1(indexOf 와 유사) index는 0부터 search는 1부터
		System.out.println(stack.search("세번째"));
		System.out.println(stack.search("다섯번째"));
		stack.push("여섯번째");
		System.out.println(stack.search("다섯번째"));
		System.out.println(stack.search("일곱번째"));
		
		//pop 위에서부터 꺼낸다 stack의 특징
		// pop remove poll... 같은 경우 for문을 돌릴 때 하나씩 빠져나가므로 수가 적어진다 그러므로 앞에 size를 고정하고 들어간다
		int size = stack.size();
		for (int i=0;i<size;i++) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
		System.out.println(stack.empty());
		
	}

}
