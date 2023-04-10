package test.java8.ch3;

@FunctionalInterface
public interface TriFunction<R, A, B, C> {
	R apply(A a, B b, C c);
}
