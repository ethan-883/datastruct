package dp;

public class _70_爬楼梯 {
	public int climbStairs(int n) {
        //一维dp
		//dp[n]到n阶的方法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
