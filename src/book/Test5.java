package book;

import java.util.HashMap;
import java.util.Map;

public class Test5 {

	public static void main(String[] args) {
		Map<String, Object> m = new HashMap<>();
		
		m.put("5-5", "5-5");
		m.get("5-5");
		
		System.out.println(m.get("5-5"));
	}
}
