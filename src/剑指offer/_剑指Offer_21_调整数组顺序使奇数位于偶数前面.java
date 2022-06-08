package 剑指offer;

public class _剑指Offer_21_调整数组顺序使奇数位于偶数前面 {
	public int[] exchange(int[] nums) {
		//首尾双指针
		/*int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			while (left < right && (nums[left] & 1) == 1) {
				left++;
			}
			while (left < right && (nums[right] & 1) == 0) {
				right--;
			}
			int temp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = temp;		
		}
		return nums;*/
		//快慢指针
		//fast 的作用是向前搜索奇数位置
		//lowl 的作用是指向下一个奇数应当存放的位置
		int low = 0;
		int fast = 0;
		while (fast < nums.length) {
			if ((nums[fast] & 1) == 1) {				
				//swap
				int temp = nums[low];
				nums[low] = nums[fast];
				nums[fast] = temp;
				
				low++;
			}
			fast++;
		}
		return nums;
		
		
		//无脑方法
		/*int[] temp = new int[nums.length];
		int low = 0;
		int high = nums.length - 1;
		int cur = 0;
		while (low <= high) {
			if ((nums[cur] & 1) == 1) {
				temp[low++] = nums[cur];
			} else {
				temp[high--] = nums[cur];
			}
			cur++;
		}
		return temp;*/
	}
}
