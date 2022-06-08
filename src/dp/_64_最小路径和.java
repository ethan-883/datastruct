package dp;

import java.util.Arrays;

public class _64_最小路径和 {
	int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, m - 1, n - 1);
    }
    //从(0,0)到(i,j)的最下路径和
    private int dp(int[][] grid, int i, int j) {
        //base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        //索引出界返回INT_MAX
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        memo[i][j] = Math.min(
            dp(grid, i - 1, j),
            dp(grid, i, j - 1)
        ) + grid[i][j];
        return memo[i][j];
    }
}
