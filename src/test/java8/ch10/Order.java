package test.java8.ch10;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private String customer;
	private List<Trade> trades = new ArrayList<>();
	
	public double getValue() {
		return trades.stream().mapToDouble(Trade::getValue).sum();
//		return trades.stream().map(Trade::getValue)
//			.reduce(Double::sum).get();  
	}
	public void addTrade(Trade trade) {
		trades.add(trade);
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
}
