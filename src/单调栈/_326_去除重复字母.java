package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _326_去除重复字母 {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        //标记哪些元素出现在栈中
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                char top = stack.pop();
                visited[top - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        //forEach从栈顶到栈底遍历
        for (Character c : stack) {
            ans.insert(0, c);
        }
        return ans.toString();
    }
}