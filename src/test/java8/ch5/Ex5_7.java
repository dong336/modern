package test.java8.ch5;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import test.java8.ch4.Dish;

public class Ex5_7 {

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
		
		menu.stream()
			.mapToInt(Dish::getCalories);
		
		IntStream.rangeClosed(1, 100).boxed()
			.flatMap(a -> 
			IntStream.rangeClosed(a, 100)
				.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
				.mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a*a + b*b)})
			);
		
		int max = menu.stream()
			.mapToInt(Dish::getCalories)
			.max()
			.orElse(0);
		
		
	}
}
