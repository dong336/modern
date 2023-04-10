package test.java8.ch5;

import java.util.List;
import java.util.Optional;

public class Q5_6 {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = List.of(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
		// 1
//		transactions.stream()
//			.filter(t -> t.getYear() == 2011)
//			.sorted(Comparator.comparing(Transaction::getValue))
//			.forEach(System.out::println);
		
		// 2
//		transactions.stream()
//			.map(t -> t.getTrader().getCity())
//			.distinct()
//			.forEach(System.out::println);
		
		// 3
//		transactions.stream()
//			.filter(t -> t.getTrader().getCity().equals("Cambridge"))
//			.map(t -> t.getTrader().getName())
//			.distinct()
//			.sorted()
//			.forEach(System.out::println);
			
		// 4
//		transactions.stream()
//			.map(t -> t.getTrader().getName())
//			.distinct()
//			.sorted()
//			.forEach(System.out::println);
		
		// 5
//		transactions.stream()
//			.anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		
		// 6
//		transactions.stream()
//			.filter(t -> t.getTrader().getCity().equals("Cambridge"))
//			.forEach(System.out::println);
		
		// 7
//		transactions.stream()
//			.map(t -> t.getValue())
//			.reduce(Integer::max)
//			.ifPresent(System.out::println);
		
		// 8
//		transactions.stream()
//			.map(t -> t.getValue())
//			.reduce(Integer::min)
//			.ifPresent(System.out::println);
	}
}
