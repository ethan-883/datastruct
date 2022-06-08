package 排序;

public class 插入排序 {
	public int[] insertSort(int[] nums) {
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			int j = i;
			int temp = nums[i];
			while (j > 0 && nums[j - 1] > temp) {
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = temp;
		}
		return nums;
	}
}
