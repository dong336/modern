package book.ch3;

@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}
