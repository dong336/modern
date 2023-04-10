package book.ch4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex5_3 {

	public static void main(String[] args) {
		List<Dish> menu = List.of(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 550, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 110, Dish.Type.OTHER),
				new Dish("pizza", true, 750, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH)
		);
		
		List<String> dishNames = menu.stream()
				.map(dish -> dish.getName().length() + "")
				.toList();

		List<String> words = List.of("Hello", "World");
		words.stream()
		.map(word -> word.split(""))
		.distinct()
		.toList();
		
		List<String> uniqueCharacters = words.stream()
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.toList();
		uniqueCharacters.forEach(System.out::println);
	}
}
