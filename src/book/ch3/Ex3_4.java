package book.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex3_4 {

	static <T, R> List<R> map(List<T> list, Function<T, R> f){
		List<R> result = new ArrayList<>();
		
		list.forEach((T t) -> {
			result.add(f.apply(t));
		});
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> lengths = map(
				List.of("modern", "java", "in", "action"),
				(str) -> str.length());
		
		List<String> strings = Arrays.asList("a", "b", "Z", "D", "C");
//		strings.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		strings.sort(String::compareTo);
		strings.forEach(System.out::println);
	}
}
