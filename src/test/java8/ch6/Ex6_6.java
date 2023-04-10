package test.java8.ch6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import test.java8.ch4.Dish;

public class Ex6_6 {

	static List<Dish> menu = Ex6_3.menu;
	
	public boolean isPrime(List<Integer> primes, int candidate) {
		int candidateRoot = (int) Math.sqrt(candidate);
		return primes.stream()
					 .takeWhile(i -> i <= candidateRoot)
					 .noneMatch(i -> candidate % i == 0);
	}
	
	private void topic0() {
		
	}
	
	public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
//		return IntStream.rangeClosed(2, n).boxed()
//				.collect(new PrimeNumbersCollector());
		return IntStream.rangeClosed(2, n).boxed()
				.collect(
						() -> new HashMap<Boolean, List<Integer>>() {
							private static final long serialVersionUID = 1L;
							{
								put(true, new ArrayList<Integer>());
								put(false, new ArrayList<Integer>());
							}
						},
						(acc, candidate) ->  {
							acc.get(isPrime(acc.get(true), candidate))
								.add(candidate);
						},
						(map1, map2) -> {
							map1.get(true).addAll(map2.get(true));
							map1.get(false).addAll(map2.get(false));
						});
	}
	
	public static void main(String[] args) {
		Ex6_6 context = new Ex6_6();
		
		IntStream.rangeClosed(1, 20)
			.filter(n -> n % 2 == 0)
			.takeWhile(n -> n < 10)
			.forEach(System.out::println);
		
		List<String> nums = Stream.of("one", "two", "three", "four")
		  .filter(e -> e.length() > 3)
		  .peek(e -> System.out.println("Filtered value: " + e))
		  .map(String::toUpperCase)
		  .peek(e -> System.out.println("Mapped value: " + e))
		  .collect(Collectors.toList());
	}
}
