package 单调栈;

import java.util.Stack;

public class _503_下一个更大元素II {
	public int[] nextGreaterElements(int[] nums) {
        //栈中从上到下严格递增
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;  
        int[] doubleNum = new int[2 * len];
        int[] doubleRes = new int[2 * len];
        for (int i = 0; i < len; i++) {
            doubleNum[i] = nums[i];
            doubleNum[i +len] = nums[i];
        }
        
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= doubleNum[i % len]) {
                stack.pop();
            }
            doubleRes[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(doubleNum[i]);
        }
        //合并res
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = doubleRes[i];
        }
        return res;

    }
}
