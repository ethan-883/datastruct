package dp;

import java.util.Arrays;
import java.util.Comparator;

public class _354_俄罗斯套娃信封问题 {
	public int maxEnvelopes(int[][] envelopes) {
        //先w升序排序，相同时h降序排序，对h求最长子序列
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
        	public int compare(int[] a, int[] b) {
        		return a[0] == b[0] ?
        				b[1] - a[1] : a[0] - b[0];
        	}
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
        	height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
	private int lengthOfLIS(int[] nums) {
		int res = 0, len = nums.length;
		int[] dp = new int[len];
		Arrays.fill(dp, 0);
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		for (int i = 0; i < len; i++) {
			res = Math.max(res, dp[i]);
		}		
		return res;
	}
}
