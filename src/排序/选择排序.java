package 排序;

public class 选择排序 {
	public int[] selectSort(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			swap(nums, i, minIndex);
		}
		return nums;
	}
	private void swap(int[] nums, int i, int minIndex) {
		int temp = nums[i];
		nums[i] = nums[minIndex];
		nums[minIndex] = temp;
	}
//	贪心，每次都全局最优
//	交换次数最少
}
