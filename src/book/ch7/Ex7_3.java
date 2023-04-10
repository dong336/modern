package book.ch7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ex7_3 {

	public int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for(char c : s.toCharArray()) {
			if(Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if(lastSpace) counter++;
				lastSpace = false;
			}
		}
		return counter;
	}
		
	private int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
													WordCounter::accumulate,
													WordCounter::combine);
		return wordCounter.getCounter();
	}
	
	private void topic2() {
		final String SENTENCE = 
				"Nel  mezzo del cammin di nostra vita " +
				"mi   ritrovai in una selva oscura" +
				"ch   la dritta via era smrrita  ";
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		System.out.println("Found " + countWords(stream.parallel()) + " words");
	}
	
	private void test() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> m1 = new HashMap<>();
		m1.put("a", "ab1"); m1.put("b", "cd1"); m1.put("c", "ef1");
		
		Map<String, Object> m2 = new HashMap<>();
		m2.put("a", "ab2"); m2.put("b", "cd2"); m2.put("c", "ef2");
		
		Map<String, Object> m3 = new HashMap<>();
		m3.put("a", "ab3"); m3.put("b", "cd3"); m3.put("c", "ef3");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		list.stream()
			.map(map -> {
				String a = new StringBuilder((String) map.get("a")).reverse().toString();
				String c = new StringBuilder((String) map.get("c")).reverse().toString();
				
				map.put("a", a);
				map.put("c", c);
				
				return map;
			})
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		Ex7_3 context = new Ex7_3();
		
		context.topic2();
	}
}
