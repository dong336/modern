package test.java8.ch5;

import java.util.Arrays;
import java.util.List;

public class Q5_2 {

	public static void main(String[] args) {
		List<Integer> integers = List.of(1, 2, 3, 4, 5);
		
		List<Integer> squares = integers.stream()
				.map(n -> n*n)
				.toList();
		
//		squares.forEach(System.out::println);
		
		List<Integer> nums1 = List.of(1, 2, 3);
		List<Integer> nums2 = List.of(3, 4);
		List<int[]> pairs = nums1.stream()
				.flatMap(i -> nums2.stream().map(j -> new int[] {i, j}))
				.toList();
		
		String[][] namesArray = new String[][]{
	        {"kim", "taeng"}, {"mad", "play"}};

		// flatMap
	    var arr =
		Arrays.stream(namesArray)
		        .flatMap(Arrays::stream)
		        .filter(name -> name.equals("taeng")).toString();
//		        .forEach(System.out::println);
		// map
		Arrays.stream(namesArray)
		        .map(inner -> Arrays.stream(inner))
		        .forEach(names -> names.filter(name -> name.equals("taeng"))
		            .forEach(System.out::println));
	}
}
