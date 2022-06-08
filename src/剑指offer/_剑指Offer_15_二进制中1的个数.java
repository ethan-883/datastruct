package 剑指offer;

public class _剑指Offer_15_二进制中1的个数 {
	public static int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
			res += n & 1;
			n >>>= 1;
		}
		return res;
		//n&(n-1)
		/*int ret = 0;
		while (n != 0) {
			n &= n - 1;
			ret++;
		}
		return ret;*/
	}
}
