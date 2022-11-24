package streamPrac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediateOperatorRun {

	public static void main(String[] args) {
		IntStream st1 = IntStream.of(7,5,5,2,1,3,4,6,8,2,4,8,9);
		IntStream st2 = IntStream.of(7,5,5,2,1,3,4,6,8,9,3,5,7);
		
		//
		st1.filter(num->num%2==0).forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//num->num%2==0 홀수 이것도 가능
//		st2.filter(num->num%2!=0).forEach(e->System.out.print(e+" "));
//		System.out.println();
		
		//distinct() 중복제거
//		st2.distinct().filter(num->num%2!=0).forEach(e->System.out.print(e+" "));
//		System.out.println();
		
		st2.distinct().filter(num->num%2!=0).filter(num->num%3==0).
		forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//<R>=return
		Stream<String> st3 = Stream.of("Html","CSS","java","javascript");
		st3.map(str->str.length()).forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//flat 하나로 찍어누른다 하나로 다 포함된 상태로 바꿔준다
		String[] arr= {"I study Html","You love CSS","java like javascript"};
		Stream<String> st4 = Arrays.stream(arr);
		st4.flatMap(str->Stream.of(str.split(" "))).forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//sorted()
		IntStream.of(14,10,21,35,27).sorted().forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//concat 합친다
		Stream<String> st5 = Stream.of("Html","CSS","java","javascript");
		Stream<String> st6 = Stream.of("Html2","CSS2","java2","javascript2");
		Stream.concat(st5, st6).forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//Comparator
		List<String> lang = Arrays.asList("java","c++","scala","go","python");
		
		lang.stream().sorted(Comparator.reverseOrder()).forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//collect 다른 형태로 변환해서 사용 가능하다
		List<String> list = lang.stream().collect(Collectors.toList());
		System.out.println(list);
		
		//peek과 forEach를 다 찍어주고 있다 peek만 썼을 떄는 눈에만 안 보일뿐 돌아가고 있다 
		//출력구문을 돌렸을 때 같이 나온다 그래서 결과창에 2번씩 찍힌다
		//lang.stream().peek(str->System.out.print(str));
		lang.stream().peek(System.out::print).forEach(e->System.out.print(e+" "));
		System.out.println();
		
		int sum = IntStream.of(1,42,12,51,67).peek(System.out::println).sum();
		System.out.println(sum);
		
	}

}
