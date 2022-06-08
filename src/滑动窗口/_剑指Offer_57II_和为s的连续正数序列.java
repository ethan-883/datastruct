package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class _剑指Offer_57II_和为s的连续正数序列 {
	public int[][] findContinuousSequence(int target) {
        //双指针(滑动窗口)
        int left = 1;
        int right = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if (sum == target) {
                int[] ans = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    ans[i - left] = i;
                }
                res.add(ans);
            }
            if (sum >= target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][]);
        // return res.toArray(new int[0][0]);
        // return res.toArray(new int[res.size()][]);
    }
}
