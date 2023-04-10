package baeldung;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Creation {

	private void ch2_1() {
		List<String> list = List.of("apple", "banana", "orange");
		// 요소가 없는 스트림에 대해 null을 반환하지 않도록 생성 시 empty() 메서드를 자주 사용합니다.
		Stream<String> streamEmpty = streamOf(list);
		
		streamEmpty.forEach(System.out::println);
	}
	
	private Stream<String> streamOf(List<String> list) {
		return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}

	private void ch2_2() {
		// 모든 유형의 Collection(Collection, List, Set) 스트림을 생성할 수 있습니다.
		Map<String, Object> map = Map.ofEntries(
				Map.entry("a", "apple"),
				Map.entry("b", "banana"),
				Map.entry("o", "orange")
				);
		Set<Map.Entry<String, Object>> entries = map.entrySet();
		Stream<Entry<String, Object>> streamSet = map.entrySet().stream();
		
		streamSet.forEach((e) -> System.out.println(e.getKey() + "/" + e.getValue()));
	}
	
	private void ch2_3() {
		// 기존 배열 또는 배열 일부에서 스트림을 만들 수도 있습니다.
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		streamOfArrayFull.forEach(System.out::println);
		streamOfArrayPart.forEach(System.out::println);
	}
	
	private void ch2_4() {
		// 빌더를 사용하는 경우 구문 오른쪽에 원하는 유형을 추가로 지정
		Stream<String> streamBuilder =
				  Stream.<String>builder().add("a").add("b").add("c").build();
		
		streamBuilder.forEach(System.out::println);
	}
	
	private void ch2_5() {
		// 결과 스트림이 무한하므로 개발자는 원하는 크기를 지정해야 합니다. 그렇지 않으면 generate() 메서드가 메모리 제한에 도달할 때까지 작동합니다
		Stream<String> streamGenerated =
				  Stream.generate(() -> "element").limit(10);
		
		streamGenerated.forEach(System.out::println);
	}
	
	private void ch2_6() {
		// 무한 스트림을 생성하는 또 다른 방법은 iterate() 메서드를 사용하는 것입니다.
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		
		streamIterated.forEach(System.out::println);
	}

	private void ch2_7() {
		// 기본 유형 스트림을 사용하면 불필요한 자동 박싱이 줄어들어 생산성이 향상됩니다.
		IntStream intStream = IntStream.range(1, 3);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		
		Random random = new Random();
		DoubleStream doubleStream = random.doubles(3);
		
		doubleStream.forEach(System.out::println);
		DoubleStream.generate(() -> 1.2d).limit(3).forEach(System.out::println);
	}
	
	private void ch2_8() {
		// JDK에는 CharStream에 대한 인터페이스가 없으므로 대신 IntStream을 사용하여 문자 스트림을 나타냅니다.
		"abc".chars().forEach(System.out::println);

		Stream<String> streamString = Pattern.compile(", ").splitAsStream("aaeebbe, eccee, dde, e");
		
		streamString.forEach(System.out::println);
	}
	
	private void ch2_9() {
		// 텍스트 파일의 Stream<String>을 생성할 수 있습니다. 텍스트의 모든 줄은 스트림의 요소가 됩니다.
		try {			
			Path path = Paths.get("C:\\Users\\ncgn\\Downloads\\file.txt");
			Stream<String> streamOfStrings = Files.lines(path);
			Stream<String> streamWithCharset = 
			  Files.lines(path, Charset.forName("UTF-8"));
			
			streamOfStrings.forEach(System.out::println);
			streamWithCharset.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ch3() {
		// Java 8 스트림은 재사용할 수 없다는 점을 기억하는 것이 매우 중요합니다.
		Stream<String> stream = 
				  Stream.of("a", "b", "c").filter(element -> element.contains("b"));
		Optional<String> anyElement = stream.findAny();
		
		Optional<String> firstElement = stream.findFirst();
		
		// 요소를 저장하는 것이 아니라 함수형 스타일로 소스에 유한한 작업 시퀀스를 적용하도록 스트림을 설계했습니다.
		List<String> elements =
				  Stream.of("a", "b", "c").filter(element -> element.contains("b"))
				    .collect(Collectors.toList());
		Optional<String> anyElement_ = elements.stream().findAny();
		Optional<String> firstElement_ = elements.stream().findFirst();
	}
	
	private void ch4() {
		// 중간 작업은 수정된 새 스트림을 반환합니다.
		Stream.of("abcd", "bbcd", "cbcd").skip(1)
				.forEach(System.out::println);
		
		// 둘 이상의 수정이 필요한 경우 중간 작업을 연결할 수 있습니다.
		Stream.of("abcd", "bbcd", "cbcd").skip(1).skip(1).map(element -> element.substring(0, 3))
				.forEach(System.out::println);
		
		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
		long size = list.stream().skip(1)
				.map(element -> element.substring(0, 3)).sorted().count();
	}
	
	private long counter;
	 
	private void wasCalled() {
	    counter++;
	}
	
	private void ch5() {
		// 중간 작업은 게으르다. 즉, 터미널 작업 실행에 필요한 경우에만 호출됩니다.
		// 따라서 이 특정 예에서 지연 호출을 통해 filter()와 map()에 각각 하나씩 두 개의 메서드 호출을 피할 수 있습니다.
		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
//		Optional<String> stream =
				list.stream().filter(element -> {
		    System.out.println(element + ": filter() was called");
		    return element.contains("2");
		}).map(element -> {
			System.out.println(element + ": map() was called");
		    return element.toUpperCase();
		})
//				.forEach(System.out::println);
				.findFirst();
	}
	
	private void ch6() {
		int[] total = new int[1];
		Runnable r = () -> total[0]++;
		r.run();
	}
	
	public static void main(String[] args) {
		var context = new Creation();
		
//		context.ch2_1();
//		context.ch2_2();
//		context.ch2_3();
//		context.ch2_4();
//		context.ch2_5();
//		context.ch2_6();
//		context.ch2_7();
//		context.ch2_8();
//		context.ch2_9();
//		context.ch3();
//		context.ch4();
		context.ch5();
//		context.ch6();
	}
}
