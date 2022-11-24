package streamPrac;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminallOperatorRun {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 8, 9, 10 };

		// count 갯수세기
		long count = Arrays.stream(arr).count();

		// sum 합 더하기
		long sum = Arrays.stream(arr).sum();
		System.out.println(count + " " + sum);

		OptionalInt min = Arrays.stream(arr).min();
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println(min.getAsInt() + " " + max.getAsInt());

		// ifPresent 값이 있으면 뒤에걸 실행하겠다
		// 앞에 평균값이 있으면 실행하겠다
		Arrays.stream(arr).average().ifPresent(System.out::print);
		System.out.println();

		// reduce는 2가지 값을 받는다
		// 해당하는 스트링 값이 나와있으면 차츰차츰 특정 펑션으로 계산하고 결과값이 나오면 그 다음것이랑 이어나간다
		// reduce 내부에 있는 값을 하나씩 처리해나간다 특정한 함수를 제공한다
//		Arrays.stream(arr).reduce((x,y)->Integer.sum(x, y));
		Arrays.stream(arr).reduce(Integer::sum).ifPresent(System.out::print);
		System.out.println();

		// reduce 앞에 결과값이 OptionalInt가 아니라서 ifPresent를 쓰지 못한다
		System.out.println(Arrays.stream(arr).reduce(20, Integer::sum));

		Arrays.stream(arr).reduce((x, y) -> x - y).ifPresent(System.out::println);

		// findFirst 첫번째 값 찾기
		Arrays.stream(arr).sorted().findFirst().ifPresent(System.out::println);

		// 아무거나 찾겠다 스트림이 비어있는지 확인하기 위해서 사용
		Arrays.stream(arr).sorted().findAny().ifPresent(System.out::println);

		String[] sarr = { "apple", "apple1", "orange", "orange2", "lemon", "banana" };
		Arrays.stream(sarr).filter(str -> str.startsWith("a")).findAny().ifPresent(System.out::println);
		Arrays.stream(sarr).filter(str -> str.startsWith("a")).findFirst().ifPresent(System.out::println);

		Optional<String> ele = Arrays.stream(sarr).findAny();
		System.out.println(ele.get());

		// 조건에 합당하는 애들을 어떻게 진행할거냐
		// anyMatch 조건에 맞는게 하나라도 있으면 true
		System.out.println(Arrays.stream(arr).anyMatch(num -> num > 8));

		// allMatch 조건에 다 맞아야 true
		System.out.println(Arrays.stream(arr).allMatch(num -> num < 20));

		// noneMatch 조건에 맞는게 하나도 없어야 한다
		System.out.println(Arrays.stream(arr).noneMatch(num -> num > 20));

		System.out.println(Arrays.stream(arr).count());
		System.out.println(Arrays.stream(arr).max().getAsInt());
		System.out.println(Arrays.stream(arr).min().getAsInt());

		// collect 배열이나 컬렉션 계열로 바꿔주는 것 toArray() toList() toSet() toMap()
		// 배열 컬렉션 변환: toArray(), toList(), toSet(), toMap()
		// 통계 연산: counting(), maxBy(), minBy(), summingInt(), averaginhInt()...
		// 요소를 처리: reducing(), joining()
		// 그룹, 분할: groupingBy(), partitionBy()
		Stream<String> streamEx = Stream.of("나","너","우리","당신");
		List<String> list = streamEx.collect(Collectors.toList());
		System.out.println(list);
		
		//joining 작업물들을 연결시켜주는것
		System.out.println(Arrays.stream(sarr).collect(Collectors.joining()));
		
		System.out.println(Arrays.stream(sarr).collect(Collectors.joining(",","[","]")));
		
//		System.out.println(Arrays.stream(sarr).collect(Collectors.averagingInt()));
		List<Integer> nums = Arrays.asList(1,2,5,6,87,2);
		
		//averagingInt 평균값
		Double ave = nums.stream().collect(Collectors.averagingInt(Integer::intValue));
		
		//타입 변환하는 것 boxed
		Integer summing = Arrays.stream(arr).boxed().collect(Collectors.summingInt(num->num));
		System.out.println(ave+" "+summing);
		
		//summingInt 합
		Integer summing1 = nums.stream().collect(Collectors.summingInt(num->num));
		System.out.println(summing1);
		
		Stream<String> s = Stream.of("2","3","4");
		double res = s.collect(Collectors.averagingInt(num->Integer.parseInt(num)));
		System.out.println(res);
		
		List<String> list2 = Stream.of("test1", "test2").collect(Collectors.collectingAndThen(Collectors.toList(), 
				Collections::<String> unmodifiableList));
		System.out.println(list2);
		
		Stream<Integer> stream = Stream.of(25,50,75,100,125,150);
		Map<Boolean,List<Integer>> m =stream.collect(Collectors.partitioningBy(a->a==50));
		System.out.println(m);
		System.out.println(m.get(false));
		
		Stream<Integer> stream2 = Stream.of(25,50,75,100,125,150);
		Map<Boolean,List<Integer>> m2 =stream2.collect(Collectors.groupingBy(a->a>50));
		System.out.println(m2);
		
		
	}

}
