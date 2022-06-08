package 排序;

import java.util.Random;

import org.junit.Test;

public class 快排 {
	@Test
	public void test() {
		sortArray(new int[]{5,2,3,1});
	}	
	
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
//        int pIndex = new Random().nextInt(right - left + 1) + left;
        int pIndex = left;
        int pivot = nums[pIndex];
        swap(nums, left, pIndex);
        int i = left;
        int j = right;
        while (i < j) {
            //pivot放在左边，先j在i
            //不要用nums[pIndex]作比较，因为nums一直在变
//            while (i < j && nums[j] >= pivot) {
//                j--;
//            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, i);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
	
	//random
//	public void quickSort(int[] nums, int left, int right) {
//		if (left < right) {
//			//基准数
//			int pos = randomPartition(nums, left, right);
//			quickSort(nums, left, pos - 1);
//			quickSort(nums, pos + 1, right);			
//		}
//	}
//	
//	private int randomPartition(int[] nums, int left, int right) {
//		int i = new Random().nextInt(right - left + 1) + left;
//		swap(nums, right, i);
//		return partition(nums, left, right);
//	}
//	
//	private int partition(int[] nums, int left, int right) {
//		int pivot = nums[right];
//		//index小于等于i的都小于pivots
//		int i = left - 1;
//		for (int j = left; j <= right - 1; j++) {
//			if (nums[j] <= pivot) {
//				i++;
//				swap(nums, i, j);
//			}
//		}
//		swap(nums, i + 1, right);
//		return i + 1;
//	}
//	
//	private void swap(int[] nums, int i, int j) {
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//	}	
}
