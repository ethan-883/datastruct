package 贪心;

public class _45_跳跃游戏II {
	public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //count jump
        int count = 0;
        int len = nums.length;
        int curEnd = 0, farthest = 0;
        for (int i = 0; i < len - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (curEnd == i) {
                count++;
                curEnd = farthest;
            }
        }
        return count;
    }
}
