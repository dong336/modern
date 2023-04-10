package test.java8.ch10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex10_2 {
	
	private void topic1() {
		List<Person> people = new ArrayList<>(List.of(
				new Person("kdw", 30),
				new Person("James", 28),
				new Person("Merry", 13),
				new Person("Add", 13)));
		people.sort(Comparator
				.comparing(Person::getAge).reversed()
				.thenComparing(Person::getName));
		
		System.out.println(people);
	}
	
	private void topic3() {
		
	}
	
	public static void main(String[] args) {
		Ex10_2 context = new Ex10_2();
		
		context.topic1();
	}
}

class Person {
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String name;
	private int age;
}