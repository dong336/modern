package test.java8.ch3;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex3_7 {

	static final String RED = "RED";
	static final String GREEN = "GREEN";
	
	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(
				new Apple(30, GREEN),
				new Apple(5, RED),
				new Apple(100, GREEN),
				new Apple(150, RED),
				new Apple(12, RED)
				);
//		Comparator<Apple> c = Comparator.comparing(Apple::getWeight).reversed();
//		apples.sort((a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
		apples.sort(
				comparing(Apple::getWeight)
				.reversed()
				.thenComparing(Apple::getColor));
		apples.forEach(System.out::println);

		Predicate<Apple> redApple = (a) -> a.getColor().equals(RED);
		Predicate<Apple> notRedApple = redApple.negate();
		Predicate<Apple> redAndHeavyApple = redApple
				.and(a -> a.getWeight() > 100)
				.or(a -> GREEN.equals(a.getColor()));
		/*
		 * 단순한 람다식을 조합해서 복잡한 람다식을 만들 수 있다.
		 */
	}
}
