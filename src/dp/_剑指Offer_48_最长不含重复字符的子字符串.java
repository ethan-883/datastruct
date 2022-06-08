package dp;

import java.util.HashMap;
import java.util.Map;

public class _剑指Offer_48_最长不含重复字符的子字符串 {
	public int lengthOfLongestSubstring(String s) {
        //dp + hashmap
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, temp = 0;
        for (int j = 0; j < s.length(); j++) {
            //拿出上一次的索引
            int i = map.getOrDefault(s.charAt(j), -1);
            //更新hashmap
            map.put(s.charAt(j), j);
            //dp[j - 1] -> dp[j]
            temp = (temp < j - i) ? temp + 1 : j - i;
            //max(dp[j - 1], dp[j])
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
