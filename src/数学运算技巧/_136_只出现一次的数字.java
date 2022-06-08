package 数学运算技巧;

public class _136_只出现一次的数字 {
	public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
