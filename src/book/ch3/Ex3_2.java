package book.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex3_2 {
	
	static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> results = new ArrayList<>();
		
		for(T t : list) {
			if(p.test(t))
				results.add(t);
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		Predicate<String> nonEmptyStringPredicate = (s) -> !s.isEmpty();
		List<String> listOfStrings = List.of(
				"HI?",
				"APPLE",
				"MASH",
				"",
				"CAT",
				"",
				"PP"
				);
		
		List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
		nonEmpty.forEach((String s) -> {
			System.out.println(s);
		});
	}
}
