package book.ch3;

@FunctionalInterface
public interface Predicate<T> extends java.util.function.Predicate<T>{
	@Override
	boolean test(T t);
}
