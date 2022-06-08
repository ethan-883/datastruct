package 剑指offer;

//贪心算法
public class _剑指Offer_14_I剪绳子 {
	public int cuttingRope(int n) {
		//动态规划dynamic programming
		//用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，
		//也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
		/*int[] dp = new int[n + 1];
		dp[2] = 1;
		for (int i = 3; i < n + 1; i++) {
			for (int j = 2; j < i; j++) {
				//保证内层循环最后的值最大
				//dp[i]要经历变量j的内层循环，所以要和自己max
				dp[i] = Math.max(dp[i],
						Math.max(j * (i - j), j * dp[i - j]));
			}
		}
		return dp[n];*/
		//贪心
		if (n < 4) {
			return n - 1;
		}
		int res = 1;
		while (n > 4) {
			res *= 3;
			n -= 3;
		}
		return res * n;
	}
}
