package book.ch6;

public class CollectorHarness {

	public static void main(String[] args) {
		long fastest = Long.MAX_VALUE;
		int num = 1_000_000;
		Ex6_6 ex6 = new Ex6_6();
		Ex6_4 ex4 = new Ex6_4();
		
//		for(int i = 0; i < 10; i++) {
//			long start = System.nanoTime();
//			ex4.partitionPrimes(num);
//			long duration = (System.nanoTime() - start) / 1_000_000;
//			if(duration < fastest) fastest = duration;
//		}
//		System.out.println("Advanced before : fastest execution done in " + fastest + " msecs");

		for(int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			ex6.partitionPrimesWithCustomCollector(num);
			long duration = (System.nanoTime() - start) / 1_000_000;
			if(duration < fastest) fastest = duration;
		}
		System.out.println("Advanced after  : fastest execution done in " + fastest + " msecs");
	}
}
