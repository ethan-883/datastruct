package 剑指offer;

public class _剑指Offer_56_I_数组中数字出现的次数 {
	public int[] singleNumbers(int[] nums) {
        //异或
        //将数据分为2组,使得2个目标数组分别在2组,一对不被分开
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        //div是ret为1的最低位
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
