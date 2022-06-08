package 数学运算技巧;

import java.util.Arrays;

public class _204_计数质数 {
	public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);

        for (int i = 2; i*i < n; i++) {
            if (arr[i]) {
                for (int j = i * i; j < n; j += i) {
                    arr[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                count++;
            }
        }
        return count;
    }
}
