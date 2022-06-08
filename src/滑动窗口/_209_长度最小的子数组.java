package 滑动窗口;

public class _209_长度最小的子数组 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        //滑动窗口
        int len = nums.length;
        int left = 0;
        int right = 0;
        int min = len + 1;
        int sum = nums[0];

        while (left <= right && right < len) {
            if (sum < target) {
                right++;
                if (right >= len) {
                    break;
                }
                sum += nums[right];
            } else {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (min == len + 1) ? 0 : min;
    }
}
