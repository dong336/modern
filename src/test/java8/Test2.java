package test.java8;

public class Test2 {
	public static void main(String[] args) {
		String ss = "1,2,11,3,";
		
		for(var s : ss.split(",")) {
			System.out.println(s);
		}
	}
}
