package 单调栈;

import java.util.Arrays;
import java.util.Stack;

//https://www.nowcoder.com/questionTerminal/58ae39f4436b44d9836fc89542d67f71
public class 逛街 {
	public int[] findBuilding(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int len = heights.length;
		int[] res = new int[len];
		Arrays.fill(res, 1);
		//向左看
		////只要当前楼大于等于前面遍历过的楼，就把前面的矮楼丢掉，因为我站在该楼右边是看不到的
		for (int i = 0; i < len - 1; i++) {
			while (!stack.isEmpty() && heights[i] >= stack.peek()) {
				stack.pop();
			}
			stack.push(heights[i]);
			//这里i+1才是核心，因为我已经通过while循环把比当前楼矮的都去掉了，所以栈里剩下的都比当前楼高
            //也就是说当我站在该楼的右边一栋楼，栈里的楼我都能看到
			res[i+1] += stack.size();
		}
		//向右看
		//清空stack
		while (!stack.isEmpty()) {
			stack.pop();
		}
		for (int i = len - 1; i > 0; i--) {
			while (!stack.isEmpty() && heights[i] >= stack.peek()) {
				stack.pop();
			}
			stack.push(heights[i]);
			res[i-1] += stack.size();
		}
		return res;
	}
}
