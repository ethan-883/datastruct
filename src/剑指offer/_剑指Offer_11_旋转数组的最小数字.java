package 剑指offer;

public class _剑指Offer_11_旋转数组的最小数字 {
	public int minArray(int[] numbers) {
		//顺序比较不合格
		//用二分查找
		int low = 0;
		int high = numbers.length - 1;
		if (numbers[low] < numbers[high]) return numbers[0];
		
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (numbers[mid] < numbers[high]) {
				high = mid;
			} else if (numbers[mid] > numbers[high]) {
				//low = mid 错了
				low = mid + 1;
			} else {
				//high--;
				int x = low;
				for (int k = low + 1; k < high; k++) {
					if (numbers[k] < numbers[x]) {
						x = k;
					}
				}
				return numbers[x];
			}
		}
		return numbers[low];
	}
}
