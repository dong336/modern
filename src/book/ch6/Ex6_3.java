package book.ch6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import book.ch4.Dish;

enum CaloricLevel { DIET, NORMAL, FAT }

public class Ex6_3 {
	
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
	
	private void topic0() {
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
				.collect(Collectors.groupingBy(dish -> {
					if(dish.getCalories() <= 400) return CaloricLevel.DIET;
					
					if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
					
					return CaloricLevel.FAT;
				}));
		
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType));
		
		System.out.println(dishesByCaloricLevel);
		System.out.println(dishesByType);
	}
	
	private void topic1() {
		Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
//				.filter(dish -> dish.getCalories() > 500)
//				.collect(Collectors.groupingBy(Dish::getType));
				.collect(Collectors
						.groupingBy(Dish::getType, 
								Collectors.filtering(dish -> dish.getCalories() > 500, 
								Collectors.toList())));
		
		Map<Dish.Type, List<String>> dishNamesByType = menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType, 
								Collectors.mapping(Dish::getName, Collectors.toList())));
				
//		System.out.println(caloricDishesByType);
		System.out.println(dishNamesByType);
	}
	
	private void topic2() {
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
				menu.stream()
				.collect(Collectors
				.groupingBy(Dish::getType, Collectors
						.groupingBy(dish -> {
							if(dish.getCalories() <= 400) return CaloricLevel.DIET;
							if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
							return CaloricLevel.FAT;
						})));
	}
	
	private void topic3() {
		Map<Dish.Type, Long> typesCount = menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType, Collectors
								.counting()));
		System.out.println(typesCount);
		
//		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
//				.collect(Collectors
//				.groupingBy(Dish::getType, Collectors
//						.maxBy(Comparator
//								.comparingInt(Dish::getCalories))));
		Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType, Collectors
								.collectingAndThen(Collectors
										.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricByType);
		
		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType, Collectors
								.summingInt(Dish::getCalories)));
		System.out.println(totalCaloriesByType);
		
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType, Collectors
								.mapping(dish -> {
									if(dish.getCalories() <= 400) return CaloricLevel.DIET;
									if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
									return CaloricLevel.FAT;
								}, Collectors
										.toCollection(HashSet::new))));
		//								.toSet())));
		System.out.println(caloricLevelsByType);
	}
	
	public static void main(String[] args) {
		Ex6_3 context = new Ex6_3();
//		context.topic0();
//		context.topic1();
//		context.topic2();
		context.topic3();
	}
}
