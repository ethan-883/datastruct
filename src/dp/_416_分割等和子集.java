package dp;

public class _416_分割等和子集 {
	public boolean canPartition(int[] nums) {
        //dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时
        //若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int len = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        //base case
        for(int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                //第 i 个物品的重量应该是nums[i-1]
                if (j - nums[i - 1] < 0) {
                    //容量不足
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][sum];
    }
}
