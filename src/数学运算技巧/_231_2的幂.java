package 数学运算技巧;

public class _231_2的幂 {
	public boolean isPowerOfTwo(int n) {
        //二进制中只有一个1
        if (n <= 0) return false;
        return (n &= (n - 1)) == 0;
    }
}
