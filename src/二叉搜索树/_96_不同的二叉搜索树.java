package 二叉搜索树;

public class _96_不同的二叉搜索树 {
	int[][] memo;

    public int numTrees(int n) {
        //备忘录初始化值为0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }
    

    //计算[low, high]组成的BST个数
    int count(int low, int high) {
        //base case
        if (low > high) {
            return 1;
        }
        if (memo[low][high] != 0) {
            return memo[low][high];
        }

        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            res += left * right;
        }
        //存入备忘录
        memo[low][high] = res;

        return res;
    }
}
