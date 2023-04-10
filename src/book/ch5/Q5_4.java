package book.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import book.ch4.Dish;

public class Q5_4 {

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
		
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree =
				someNumbers.stream()
				.map(n -> n*n)
				.filter(n -> n % 3 == 0)
				.findFirst();
		firstSquareDivisibleByThree.ifPresent(System.out::println);
	}
}
