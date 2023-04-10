package book;

import java.util.ArrayList;
import java.util.List;

class Solution {
	
    public List<String> letterCombinations(String digits) {
		String[] combs = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> ret = new ArrayList<>();
    	
		System.out.println(Character.getNumericValue('a'));
		
    	for(int i = 0; i < digits.length(); i++) {
    		
    	}
		
    	return null;
    }
}

public class Test3 {
	public static void main(String[] args) {
		var sol = new Solution();
		
		sol.letterCombinations("234");
	}
}
