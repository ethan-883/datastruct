package 剑指offer;

public class _剑指Offer_10_I斐波那契数列 {
	public int fib(int n) {
		int first = 0;
		int second = 1;
		int sum;
		if (n == 0) return 0;
		for (int i = 0; i < n; i++) {
			sum = (first + second) % 1000000007;
			first = second;
			second = sum;
		}
		return second % 1000000007;
	}
}
