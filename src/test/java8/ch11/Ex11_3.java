package test.java8.ch11;

import java.util.Optional;
import java.util.stream.Stream;

public class Ex11_3 {

	private String getString() {
		System.out.println("Why?");
		return "baeldung";
	}
	
	private void topic2() {
		String name = null;
		String nameElse = Optional.ofNullable(name)       // ofNullable을 통과하더라도 orElse 까지 실행한다	
				.orElse(getString());
		System.out.println("====");
		String nameElseGet = Optional.ofNullable(name)    // ofNullable을 통과하면 orElseGet 을 하지 않는다 	 
				.orElseGet(this::getString);
		System.out.println(nameElse);
		System.out.println(nameElseGet);
	}
	
	private void topic3() {
		Optional<String> optional = Optional.of("Hello, World!");
		Stream<String> stream = optional.stream();
		
//		int[] numbers = {1, 2, 3, 4, 5};
//		
//		String result = Arrays.stream(numbers)
//			.mapToObj(Integer::toString)
//			.collect(Collectors.joining(", "));
//		System.out.println(result);
		
//		Map<String, Object> books = new HashMap<>(Map.ofEntries(
//				Map.entry("978-0201633610", "Design patterns : elements of reusable object-oriented software"),
//				Map.entry("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming"),
//				Map.entry("978-1617292000", "Java 9 in Action: Lambdas, Streams, and functional-style programming"),
//				Map.entry("978-0134685991", "Effective Java")
//		));
//		
//		Map<String, Object> want = books.entrySet().stream()
//			.filter(e -> {
//				String book = (String) Optional.of(e.getValue()).get();
//				
//				return book.matches("(.*)Lambdas(.*)");
//			})
//			.collect(Collectors.toMap((e) -> e.getKey() + "_1", Function.identity()));
//		System.out.println(want);
		
//		"Hello?".chars()
//				.parallel()
//				.forEach(c -> System.out.print((char)c));
		
//		Stream.<Dish>builder()
//				.add(new Dish("Tuna", false, 700, Type.FISH))				
//				.add(new Dish("Burger", false, 720, Type.MEAT))
//				.add(new Dish("Sandwich", false, 600, Type.MEAT))
//				.build()
//				.filter(dish -> dish.getCalories() > 610)
//				.map(dish -> dish.getName())
//				.peek(System.out::println)
//				.toList();
				
			
//		Optional<Integer> amount = Optional.of(i)
//				.filter(amt -> amt > 500);
//		System.out.println(amount.get());
	}
	
	public static void main(String[] args) {
		var context = new Ex11_3();
		
		context.topic2();
	}
}
