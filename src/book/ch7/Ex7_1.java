package book.ch7;

import java.util.stream.Stream;

public class Ex7_1 {

	public long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
				.limit(n)
				.reduce(0L, Long::sum);
	}
	
	public long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
				.limit(n)
				.parallel()
				.reduce(0L, Long::sum);				
	}
	
	public long iterativeSum(long n) {
		long result = 0;
		for(long i = 1L; i <= n; i++) result += i;
		return result;
	}
	
	private void topic1() {
		
	}
	
	public static void main(String[] args) {
		Ex7_1 context = new Ex7_1();
		
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println(processors);
	}
}
