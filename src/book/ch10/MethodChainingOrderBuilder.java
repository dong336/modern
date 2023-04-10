package book.ch10;

public class MethodChainingOrderBuilder {

	public final Order order = new Order();
	
	private MethodChainingOrderBuilder(String customer) {
		order.setCustomer(customer);
	}
	
	public static MethodChainingOrderBuilder forCustomer(String customer) {
		return new MethodChainingOrderBuilder(customer);
	}
	
}
