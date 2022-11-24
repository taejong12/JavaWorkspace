package collectionFrameworkPrac;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorRun {

	public static void main(String[] args) {
		// 객체 생성
		System.out.println("객체생성: Vector<E> a = new Vector<>();");
		Vector<String> vec = new Vector<>();
		
		//Arrays.asList
		System.out.println("Arrays.asList():");
		Vector<String> vec2 = new Vector<>(Arrays.asList("사과","오렌지","망고","배"));
		System.out.println(vec2);
		System.out.println("List.of():");
		Vector<String> vec3 = new Vector<>(List.of("사과","오렌지","포도","배"));
		System.out.println(vec3);
		
		//add
		System.out.println("add():");
		vec2.add("귤");
		vec2.addElement("감");
		System.out.println(vec2);
		
		//size
		System.out.println("size():");
		System.out.println(vec2.size());
		
		//capacity
		System.out.println("capacity():");
		System.out.println(vec2.capacity()); // 잡아놓은 저장공간
		
		//remove
		System.out.println("remove():");
		System.out.println(vec2.remove(4));
		System.out.println(vec2);
		System.out.println(vec2.remove("감"));
		System.out.println(vec2);
		
		// for문
		System.out.println("for문:");
		for(int i=0;i<vec2.size();i++) {
			System.out.print(vec2.get(i)+" ");
		}
		System.out.println();
		
		//enhanced for문
		System.out.println("enhanced for문:");
		for(String str:vec2) {
			System.out.print(str+" ");
		}
		System.out.println();
		
		//Iterator
		System.out.println("Iterator:");
		Iterator<String> ite = vec2.iterator();
		while(ite.hasNext()) {
			System.out.print(ite.next()+" ");
		}
		System.out.println();
		
		//contains
		System.out.println("contains():");
		System.out.println(vec2.contains("망고"));
		
		//indexOf
		System.out.println("indexOf():");
		System.out.println(vec2.indexOf("사과"));
		
		//elementAt()
		System.out.println("elementAt():");
		System.out.println(vec2.elementAt(1));
		
		//firstElement() lastElement()
		System.out.println("firstElement(), lastElement():");
		System.out.println(vec2.firstElement());
		System.out.println(vec2.lastElement());
		
		//set()
		System.out.println("set():");
		System.out.println(vec2.set(0, "귤"));
		System.out.println(vec2);
		
		//setElementAt()
		System.out.println("setElementAt:");
		vec2.setElementAt("사과", 2);
		System.out.println(vec2);
		
		//clear() isEmpty()
		System.out.println("clear(), isEmpty():");
		vec2.clear();
		System.out.println(vec2);
		System.out.println(vec2.isEmpty());
		
	}

}
