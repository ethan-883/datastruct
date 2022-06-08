package 排序;

public class 归并排序 {
	public int[] sortArray(int[] nums) {
		int len = nums.length;
		int[] temp = new int[len];
		mergeSort(nums, 0, len -1, temp);
		return nums;
	}
	//对nums[left, right]归并排序，全局用一份辅助数组temp
	private void mergeSort(int[] nums, int left, int right, int[] temp) {
		int mid = left + (right - left) / 2;
		mergeSort(nums, left, mid, temp);
		mergeSort(nums, mid + 1, right, temp);
		//本身有序
		if (nums[mid] <= nums[mid + 1]) {
			return;
		}
		mergeOfTwoSortedArray(nums, left, mid, right, temp);
	}
	//先把nums复制到temp，再合并回去
	private void mergeOfTwoSortedArray(int[] nums, int left, int mid,
			int right, int[] temp) {
		System.arraycopy(nums, left, temp, left, right + 1 - left);
		
		int i = left, j = mid + 1;
		for (int k = left; k <= right; k++) {
			if (i == mid + 1) {
				nums[k] = temp[j];
				j++;
			} else if (j == right + 1) {
				nums[k] = temp[i];
				i++;
			} else if (temp[i] <= temp[j]) {
				//<=稳定 <不稳定
				nums[k] = nums[i];
				i++;
			} else {
				nums[k] = nums[j];
				j++;
			}
		}
	}
}
