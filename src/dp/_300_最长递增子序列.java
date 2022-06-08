package dp;

public class _300_最长递增子序列 {
	public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int maxans = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
            	if (nums[i] > nums[j]) {
            		dp[i] = Math.max(dp[i], dp[j] + 1);
            	}
            }
            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }
}
