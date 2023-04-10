package test.java8.ch4;

import java.util.Comparator;
//import static java.util.Comparator.comparing;
import java.util.List;

public class Ex1 {

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
		
		List<String> threeHighCaloricDishNames = menu.stream()
			.filter(dish -> dish.getCalories() > 500)
			.sorted(Comparator.comparing(Dish::getCalories))
			.map(Dish::getName)
			.limit(4)
			.toList();
		System.out.println(threeHighCaloricDishNames);
	}
}
