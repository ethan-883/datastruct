package 数学运算技巧;

public class _172_阶乘后的零 {
	public int trailingZeroes(int n) {
        //n! 最多可以分解出多少个因子 2 和 5
        //主要取决于能分解出几个因子5
        //因为每个偶数都能分解出因子2，因子 2 肯定比因子 5 多得多
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
