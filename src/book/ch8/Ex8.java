package book.ch8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Ex8 {

	static List<String> referenceCodes = new ArrayList<>(List.of(
			"s", "apple", "cat", "x", "dragon"));
	static Map<String, String> favoriteMovies = new HashMap<>(Map.ofEntries(
			Map.entry("Raphael", "Star Wars"),
			Map.entry("Cristina", "Matrix"),
			Map.entry("Olivia", "James Bond")));
	
	private void topic2() {
		// 새로운 collection 생성
		referenceCodes.stream()
				.map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
				.peek(System.out::println)
				.collect(Collectors.toList());
		System.out.println(referenceCodes);

		// iterator 사용
		ListIterator<String> itr = referenceCodes.listIterator();
		
		while(itr.hasNext()) {
			String code = itr.next();
			itr.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
		}
		System.out.println(referenceCodes);
		
		// 자바 8 이후
		referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));
		System.out.println(referenceCodes);
	}
	
	private void topic3() {
		Map<String, Object> y = Map.ofEntries(
			Map.entry("a", "a1"),
			Map.entry("b", "b1"),
			Map.entry("c", "c1")
		);
		y.forEach((a, b) -> System.out.println("" + a + b));
		favoriteMovies.entrySet().stream()
			.sorted(Entry.comparingByKey())
			.forEachOrdered(System.out::println);
		System.out.println(favoriteMovies.getOrDefault("Thibaut", "Matrix"));
 	
		favoriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
		favoriteMovies.entrySet().stream()
			.map(e -> e.setValue(e.getValue().toLowerCase()))
			.forEach(System.out::println);
	
		Map<String, String> family = new HashMap<>(Map.ofEntries(Map.entry("Cristina", "Iron man")));
//		favoriteMovies.putAll(family);
		
		favoriteMovies.forEach((k, v) -> 
				family.merge(k, v, (movie1, movie2) -> movie1 + "&" + movie2));
		System.out.println(family);
		
		Map<String, Long> moviesToCount = new HashMap<>();
		String movieName = "JamesBond";
		Long count = moviesToCount.get(movieName);
		if(count == null) {
			moviesToCount.put(movieName, 1L);
		} else {
			moviesToCount.put(movieName, count + 1);
		}
		
		
	}

	private void quiz1() {
		Map<String, Integer> movies = new HashMap<>(Map.ofEntries(
				Map.entry("JamesBond", 20),
				Map.entry("Matrix", 15),
				Map.entry("Harry Potter", 5)));
		
		// 자바 8 이전
//		var itr = movies.entrySet().iterator();
//		
//		while(itr.hasNext()) {
//			var entry = itr.next();
//			if(entry.getValue() < 10)
//				itr.remove();
//		}
		
		movies.entrySet().removeIf(entry -> entry.getValue() < 10);
		
		System.out.println(movies);
	}
	
	public static void main(String[] args) {
		Ex8 context = new Ex8();
		
//		context.topic2();
//		context.topic3();
		context.quiz1();
	}
}
