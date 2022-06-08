package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _15_三数之和 {
	public static void main(String[] args) {

	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new LinkedList<>();
		int len = nums.length;
		int sum;
		for (int i = 0; i < len - 2; ++i) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = len - 1;
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					while (j < k && nums[j] == nums[++j]);
				} else if (sum > 0) {
					while (j < k && nums[k] == nums[--k]);
				} else {
					ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
					while (j < k && nums[j] == nums[++j]);
					while (j < k && nums[k] == nums[--k]);
				}
			}
		}
		return ans;
	}
}
