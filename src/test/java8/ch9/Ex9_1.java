package test.java8.ch9;

import java.util.List;
import java.util.stream.Stream;

public class Ex9_1 {

	private void topic2() {
		List.of(1, 2, 3, 4 , 5, 199, -1).forEach(null);
		Stream.of(1, 2, 3, 4 , 5, 199, -1).forEach(null);
	}
	
	public static void main(String[] args) {
		Ex9_1 context = new Ex9_1();
		
		context.topic2();
		 
	}
} 
