package book.ch3;

public class Apple {
	int weight;
	String color;
	public int getWeight() {
		return weight;
	}
	public Apple(int weight) {
		super();
		this.weight = weight;
	}
	public Apple(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}
	public Apple() {
		super();
	}
	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + "]";
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
