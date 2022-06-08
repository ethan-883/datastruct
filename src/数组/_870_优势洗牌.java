package 数组;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _870_优势洗牌 {
	public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //nums2降序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
            (int[] pair1, int[] pair2) -> {
                //comparator返回正数不调整顺序，负数调整顺序
                return pair2[1] - pair1[1];
            }
        );

        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0, right = n - 1;
        int res[] = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left--;
            }
        }
        return res;
    }
}
