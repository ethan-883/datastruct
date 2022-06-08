package 笔试;

import java.util.Stack;

public class _227_基本计算器_II {
	//加上()
	public int solve (String s) {
        // write code here
        s = s.trim();
        char[] arr = s.toCharArray();
        char sign = '+';
        int num = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            if (Character.isDigit(arr[i])) {
                num = num * 10 + arr[i] - '0';
            } else if (arr[i] == '(') {
                int count = 1;
                int j = i + 1;
                while (count > 0) {
                    if (arr[j] == '(') {
                        count++;
                    } else if (arr[j] == ')') {
                        count--;
                    }
                    j++;
                }
                num = solve(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(arr[i]) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = arr[i];
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
	
}
