package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode-cn.com/problems/valid-parentheses/
public class _20_有效的括号{
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		Map<Character, Character> table = new HashMap<>();
		table.put('(',')');
		table.put('[',']');
		table.put('{','}');
		
		for (int i = 0; i < chars.length; i++) {
			if (table.containsKey(chars[i])) {
				stack.push(chars[i]);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (table.get(stack.pop()) != chars[i]) {
					return false;
				}
			}		
		}
		
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
