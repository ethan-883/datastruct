package 数学运算技巧;

public class _191_位1的个数 {
	public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
