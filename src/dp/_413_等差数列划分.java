package dp;

public class _413_等差数列划分 {
	public int numberOfArithmeticSlices(int[] nums) {
        //以 A[i]A[i] 为终点的等差数列的个数
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int[] dp = new int[len];
        //base case
        dp[0] = 0;
        dp[1] = 0;
        //dp[i] = dp[i - 1] + 1
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        //累加
        int count = 0;
        for (int item : dp) {
            count += item;
        }
        return count;
    }
}
