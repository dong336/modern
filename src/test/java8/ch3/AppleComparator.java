package test.java8.ch3;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple>{

	@Override
	public int compare(Apple a1, Apple a2) {
		return Integer.compare(a1.getWeight(), a2.getWeight());
	}

}
