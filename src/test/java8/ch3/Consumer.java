package test.java8.ch3;

@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}
