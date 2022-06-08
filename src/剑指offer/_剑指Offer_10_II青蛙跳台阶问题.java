package 剑指offer;

public class _剑指Offer_10_II青蛙跳台阶问题 {
	public int numWays(int n) {
		int first = 0;
		int second = 1;
		int sum;
		if (n == 0) return 1;
		for (int i = 0; i < n; i++) {
			sum = (first + second) % 1000000007;
			first = second;
			second = sum;
		}
		return second % 1000000007;
	}
}
