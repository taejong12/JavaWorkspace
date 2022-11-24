package streamPrac;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamMkRun {

	public static void main(String[] args) throws IOException {
		//Stream 메서드를 통해서 생성한다
		//Collection ArrayList 타입이 Integer니까 Stream도 Integer이다
		ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(6,5,4,3,2,1));
		Stream<Integer> streamCollection = alist.stream();
//		streamCollection.forEach(num->System.out.println(num));
		streamCollection.forEach(System.out::print);
		System.out.println();
		
		//Arrays
		String[] sarr = new String[] {"넷","셋","둘","하나"};
		Stream streamArrays = Arrays.stream(sarr);
		streamArrays.forEach(str->System.out.print(str+" "));
		System.out.println();
		
		streamArrays = Arrays.stream(sarr, 1, 3);
		streamArrays.forEach(str->System.out.print(str+" "));
		System.out.println();
		
		//기본형태
		Stream<Double> stream1 = Stream.of(4.3,2.7,1.4,3.7);
		stream1.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		//맨 뒤에 있는 숫자를 포함하지 않는것
		IntStream stream2 = IntStream.range(1, 5);
		stream2.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		//맨 뒤에 숫자까지 포함하는 것
		LongStream stream3 = LongStream.rangeClosed(1, 5);
		stream3.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		//Random은 항상 기본적으로 0부터 1사이값이 나온다
		DoubleStream stream4 = new Random().doubles(3);
		stream4.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		//난수를 발생시켜서 매번 다른 값이 나온다
		int dd = (int)((new Random().nextDouble())*6+1);
		System.out.println(dd);//0-1 곱하기 6을 하게 되면 값의 범위가 0-6까지 바뀐다 1을 더하면 값의 한계가 1-7까지 바뀐다
		
		IntStream stream5 = "StringStream".chars();
		stream5.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		//정규식, 정규표현식 Regular Expression, RegEx
		//스트링은 한번만 사용가능하다 다시 쓰려면 새로운 객체 필요
		Stream<String> stream6 = Pattern.compile(", ").splitAsStream("서울, 대전, 대구, 부산, 울산");
		stream6.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		// \\2번 들어간 이유는 키값으로 바꿔서 인지한다 
		//절대경로 누가봐도 확실한 전체경로
		//상대경로는 기준이 되는 부분에서부터 나머지 부분만 포함 내가 있는 현재 파일을 기준으로 따진다
		//상대경로를 많이 쓴다 같은 경로에 다운을 받지 않으면 에러가 뜨기 때문에
		Stream<String> stream7 = Files.lines(Paths.get("C:\\workspace\\JavaStudy\\src\\streamPrac\\testfile.txt"),Charset.forName("UTF-8"));
		stream7.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		//병렬 parallel Stream
		//나중에 한다
		
		//빈스트림 내용물이 없다 null 대신 사용할 때가 있다
		ArrayList<String> alist2 = new ArrayList<>();
		Stream<String> stream8 = streamOf(alist2);
		stream8.forEach(str->System.out.print(str+" "));
		System.out.println();
		
		//Stream.builder()
//		Stream.Builder<String> builder = Stream.builder();
//		Stream<String> bstream = builder.add("수학").add("물리").add("영어").build();
		Stream<String> bstream = Stream.<String>builder().add("수학").add("물리").add("영어").build();
		bstream.forEach(str->System.out.print(str+" "));
		System.out.println();
		
		//generate() 반복
		Stream<String> gstream = Stream.generate(()->"wow").limit(4);
		gstream.forEach(str->System.out.print(str+" "));
		System.out.println();
		
		//Stream.iterate() 반복
		Stream<Integer> istream = Stream.iterate(100, num->num+2).limit(5);
		istream.forEach(num->System.out.print(num+" "));
		System.out.println();
		
		
	}
	
	public static Stream<String> streamOf(List<String> list){
		return list==null||list.isEmpty()?Stream.empty():list.stream();
	}

}
