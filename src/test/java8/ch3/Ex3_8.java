package test.java8.ch3;

import java.util.function.Function;
 
public class Ex3_8 {
	
	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
	}
}
