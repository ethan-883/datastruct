package 剑指offer;

import java.util.Stack;

public class _剑指Offer_31_栈的压入_弹出序列 {
	public boolean validateStackSqquences(int[] pushed, int[] poped) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		for (int num : pushed) {
			stack.push(num);
			while (!stack.isEmpty() && stack.peek() == poped[i]) {
				stack.pop();
				i++;
			}
		}
		return stack.isEmpty();
	}
}
