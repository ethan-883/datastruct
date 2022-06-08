package 贪心;

public class _55_跳跃游戏 {
	public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int len = nums.length;
        int fastest = 0;
        for (int i = 0; i < len - 1; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            if (fastest <= i) {
                return false;
            }
        }
        return fastest >= len - 1;
    }
}
