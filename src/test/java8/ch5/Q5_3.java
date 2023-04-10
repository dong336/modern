package test.java8.ch5;

import java.util.List;

public class Q5_3 {

	public static void main(String[] args) {
		List<String> input = List.of(
				"Deer", "Bear", "River",
				"Car", "Car", "River",
				"Deer", "Car", "Bear");
		
		int sum = input.parallelStream()
			.distinct()
			.map(w -> 1)
			.reduce(0, Integer::sum);
		System.out.println(sum);
	}
}
