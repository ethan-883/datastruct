package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        Set<Character> set = new HashSet<>(); 
        int len = s.length();
        int right = -1, ans = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}