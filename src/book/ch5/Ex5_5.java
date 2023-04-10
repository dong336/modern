package book.ch5;

import java.util.List;
import java.util.Optional;

public class Ex5_5 {

	public static void main(String[] args) {
		List<Integer> nums = List.of(4, 5, 3, 9, 7);
		
		Optional<Integer> sum = nums.stream()
				.reduce(Integer::min);
		
		sum.ifPresent(System.out::println);
	}
}
