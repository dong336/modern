package test.java8.ch6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import test.java8.ch4.Dish;

public class Ex6_4 {

	static List<Dish> menu = Ex6_3.menu;
	
	private void topic0() {
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
				.collect(Collectors
						.partitioningBy(Dish::isVegetarian));
		System.out.println(partitionedMenu.get(true));
		
		List<Dish> vegetarianDishes = menu.stream()
				.filter(Dish::isVegetarian)
				.collect(Collectors.toList());
		System.out.println(vegetarianDishes);
	}
	
	private void topic1() {
		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
				.collect(Collectors
						.partitioningBy(Dish::isVegetarian, Collectors
								.groupingBy(Dish::getType)));
		System.out.println(vegetarianDishesByType);
	
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
				.collect(Collectors.
						partitioningBy(Dish::isVegetarian, Collectors.
								collectingAndThen(Collectors
										.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricPartitionedByVegetarian);
	}
	
	private void quiz2() {
		Map<Boolean, Map<Boolean, List<Dish>>> data1 = menu.stream()
				.collect(Collectors
						.partitioningBy(Dish::isVegetarian, Collectors
								.partitioningBy(d -> d.getCalories() > 500)));
		
		Map<Boolean, Long> data2 = menu.stream()
				.collect(Collectors
						.partitioningBy(Dish::isVegetarian, Collectors
								.counting()));
	}
	
	public boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt(candidate);
		return IntStream.rangeClosed(2, candidate)
				.takeWhile(i -> i <= candidateRoot)
				.noneMatch(i -> candidate % i == 0);
	}
	
	public Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
				.collect(Collectors
						.partitioningBy(candidate -> isPrime(candidate)));
	}
	
	private void topic2() {
		System.out.println(partitionPrimes(40));
	}
	
	public static void main(String[] args) {
		Ex6_4 context = new Ex6_4();
		
//		context.topic0();
//		context.topic1();
		context.topic2();
	}
}
