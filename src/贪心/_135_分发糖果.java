package 贪心;

import java.util.Arrays;

public class _135_分发糖果 {
	public int candy(int[] ratings) {
        //两次遍历,先全部为1，先从左到右遍历，再从右往左遍历
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        //从左到右
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        //从右往左遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }

        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += res[i];
        }
        return count;
    }
}
