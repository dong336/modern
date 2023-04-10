package book.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class Ex3_6 {

	boolean startsWithNumber(String str) {
		return Character.isDigit(str.charAt(0));
	}
	
	boolean isValidName(String str) {
		return Character.isUpperCase(str.charAt(0));
	}
	
	static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> results = new ArrayList<>();
		
		for(T t : list) {
			if(p.test(t))
				results.add(t);
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		ToIntFunction<String> strToInt1 = (s) -> Integer.parseInt(s);
		ToIntFunction<String> strToInt2 = Integer::parseInt;

		BiPredicate<List<String>, String> contains1 = (l, e) -> l.contains(e);
		BiPredicate<List<String>, String> contains2 = List::contains;
		
		Ex3_6 obj = new Ex3_6();
		List<String> words = List.of("sss", "HELLO", "4bb", "5ww");
		
		List<String> filtered = filter(words, (word) -> obj.isValidName(word));
		filter(words, obj::isValidName);
//		filtered.forEach(System.out::println);
		
		Predicate<String> startsWithNumber1 = (s) -> obj.startsWithNumber(s);
		Predicate<String> startsWithNumber2 = obj::startsWithNumber;
		
		List<String> startsNumbers = words.stream()
				.filter(obj::startsWithNumber)
				.toList();
		startsNumbers.forEach(System.out::println);
		
		Supplier<Apple> c1 = Apple::new;
		Apple a1 = c1.get();
		
		Function<Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(555);
		
		BiFunction<Integer, String, Apple> c3 = Apple::new;
		Apple a3 = c3.apply(6666, "green");
		
		List<Integer> weights = List.of(5, 4, 1, 3, 6);
		List<Apple> apples = Ex3_4.map(weights, Apple::new);
		apples.forEach(System.out::println);
	}
}
