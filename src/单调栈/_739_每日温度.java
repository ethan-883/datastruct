package 单调栈;

import java.util.Stack;

public class _739_每日温度 {
	public int[] dailyTemperatures(int[] temperatures) {
        //stack放索引
        //数组左边对应栈顶，右边对应栈底
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && 
                temperatures[stack.peek()] <= temperatures[i]) {
                    //栈顶（右边）小于等于当前
                    stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
