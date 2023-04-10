package test.java8.ch6;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import test.java8.ch4.Dish;

public class Ex6_2 {
	static List<Dish> menu = List.of(
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
	
	private void topic1() {
		Comparator<Dish> dishCaloriesComparator = 
				Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCaloriesDish = menu.stream()
				.collect(Collectors.maxBy(dishCaloriesComparator));
		
		mostCaloriesDish.ifPresent(System.out::println);
	}
	
	private void topic2() {
		IntSummaryStatistics menuStatistics = menu.stream()
				.collect(Collectors.summarizingInt(Dish::getCalories));
		
		System.out.println(menuStatistics);
	}
	
	private void topic3() {
		String shortMenu = menu.stream()
				.map(Dish::getName)
				.collect(Collectors.joining(", "));
		
		System.out.println(shortMenu);
	}
	
	private void topic4() {
//		int totalCalories = menu.stream()
//				.collect(Collectors
//						.reducing(0, Dish::getCalories, Integer::sum));

//		int totalCalories = menu.stream()
//				.map(Dish::getCalories)
//				.reduce(Integer::sum)
//				.orElse(0);
		// IntStream 으로 자동 언박싱을 하지 않는다
		int totalCalories = menu.stream()
				.mapToInt(Dish::getCalories)
				.sum();
		
		long count = menu.stream()
				.map(Dish::getCalories)
				.collect(Collectors
						.reducing(0L, e -> 1L, Long::sum));
		
		System.out.println(totalCalories);
		System.out.println(count);
	}
	
	private void quiz1() {
		String shortMenu = menu.stream()
				.map(Dish::getName)
				.collect(Collectors.joining());
//				.map(Dish::getName)
//				.collect(Collectors.reducing((s1, s2) -> s1 + s2)).get();
//				.collect(Collectors.reducing((d1, d2) -> d1.getName() + d2.getName()));
//				.collect(Collectors.reducing("", Dish::getName, (s1, s2) -> s1 + s2));
	}
	
	public static void main(String[] args) {
		Ex6_2 context = new Ex6_2();
//		context.topic1();
//		context.topic2();
//		context.topic3();
//		context.topic4();
	}
}
