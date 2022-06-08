package 二分搜索;

public class _410_分割数组的最大值 {
	public int splitArray(int[] nums, int m) {
        int low = getMax(nums), high = getSum(nums);
        while (low < high) {
            int mid = low + (high - low) / 2;
            int n = split(nums, mid);
            if (n == m) {
                high = mid;
            } else if (n < m) {
                //max大了
                high = mid;
            } else if (n > m) {
                //max小了
                low = mid + 1;
            }

        }
        
        for (int max = low; max <= high; max++) {
            int n = split(nums, max);
            if (n <= m) {
                return max;
            }
        }
        return -1;
    }

    //split计算nums在最大值确定时，最少需要的m
    private int split(int[] nums, int max) {
        //至少分割的子数组数量
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > max) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count;
    }

    private int getMax(int[] nums) {
        int max = 0;
        for (int item : nums) {
            max = Math.max(item, max);
        }  
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        return sum;
    }
}
