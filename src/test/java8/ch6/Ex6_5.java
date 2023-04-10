package test.java8.ch6;

import java.util.ArrayList;
import java.util.List;

import test.java8.ch4.Dish;

public class Ex6_5 {

	static List<Dish> menu = Ex6_3.menu;
	
	private void topic0() {
				
	}
	
	private void topic1() {
		
	}
	
	private void topic2() {
		List<Dish> dishes = menu.stream()
				.collect(
						ArrayList::new,	// 발행
						List::add,		// 누적
						List::addAll);	// 합침
	}
	
	public static void main(String[] args) {
		Ex6_5 context = new Ex6_5();
	}
}
