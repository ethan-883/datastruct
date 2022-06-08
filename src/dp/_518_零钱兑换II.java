package dp;

public class _518_零钱兑换II {
	public int change(int amount, int[] coins) {
        int n = coins.length;
        //前i个物品，当背包容量为j时，有dp[i][j]种方法装满背包
        //若只使用 coins 中的前i个硬币的面值，若想凑出金额j,有 dp[i][j] 种凑法
        int[][] dp = new int[n + 1][amount + 1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + 
                            dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
