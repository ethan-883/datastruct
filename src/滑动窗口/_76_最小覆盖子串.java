package 滑动窗口;

import java.util.HashMap;

public class _76_最小覆盖子串 {
	public static void main(String[] args) {
		String s = "sdf";
		String t = "sdf";
		System.out.println(minWindow(s, t));
	}
	
	private static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        //左闭右开[)
        int left = 0, right = 0;
        //valid表示窗口中满足need条件的字符个数
        int valid  = 0;
        int start = 0, len = Integer.MAX_VALUE;
        char[] tArray = t.toCharArray();
        char[] sAaary = s.toCharArray();

        for (char key : tArray) {
            need.put(key, need.getOrDefault(key, 0) + 1);
        }

        while (right < sAaary.length) {
            char c = sAaary[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }
            //判断左侧窗口是否需要缩小
            while (valid  == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = sAaary[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d)) {
                        valid --;
                    }
                    if (window.get(d) == 1) {
                        window.remove(d);
                    } else {
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
        }
        return (len == Integer.MAX_VALUE) ? "" : s.substring(start, start+len);
    }
}
