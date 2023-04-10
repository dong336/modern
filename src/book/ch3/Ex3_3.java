package book.ch3;

import java.util.List;

public class Ex3_3 {

	static <T> void forEach(List<T> list, Consumer<T> c) {
		list.forEach((T t) -> {
			c.accept(t);
		});
	}
	
	public static void main(String[] args) {
		forEach(
				List.of(1, 2, 3, 4, 5), 
				System.out::println
		);
	}
}
