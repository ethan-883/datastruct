package dp;

//https://mp.weixin.qq.com/s/zNai1pzXHeB2tQE6AdOXTA
public class _516_最长回文子序列 {
	 public int longestPalindromeSubseq(String s) {
        //在子串s[i..j]中，最长回文子序列的长度为dp[i][j]
        int n = s.length();
        int[][] dp = new int[n][n];
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //反着遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(
                        dp[i + 1][j], dp[i][j - 1]
                    );
                }
            }
        }
        return dp[0][n - 1];
     }
}
