package book.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex5_8 {

	public static void main(String[] args) {
		Stream<String> valuess =
				Stream.ofNullable(System.getProperty("home"));
		
		Stream<String> values = 
				Stream.of("config", "home", "user")
					.flatMap(key -> Stream.ofNullable(System.getProperty(key)));
		
		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();
		
//		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
//			.limit(20)
//			.forEach(a -> System.out.println("(" + a[0] + "," + a[1] + ")"));
		
//		IntStream.iterate(0, n -> n < 100, n -> n + 4)
//			.forEach(System.out::println);
		
//		Stream.generate(Math::random)
//			.limit(5)
//			.forEach(System.out::println);
		
		IntStream twos = IntStream.generate(new IntSupplier() {

			@Override
			public int getAsInt() {
				return 2;
			}
			
		});
		
		List<Integer> nums = List.of(1, 2, 3).stream()
				.toList();
	}
}
