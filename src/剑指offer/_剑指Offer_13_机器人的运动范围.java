package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class _剑指Offer_13_机器人的运动范围 {	
	public int movingCount(int m, int n, int k) {
		if (k == 0) {
			return 1;
		}
		
		boolean[][] vis = new boolean[m][n];
		int ans = 1;
		vis[0][0] = true;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if ((i == 0 && j == 0) || sums(i) + sums(j) > k) {
					continue;
				}
				if (i - 1 >= 0) {
					vis[i][j] |= vis[i - 1][j];
				}
				if (j - 1 >= 0) {
					vis[i][j] |= vis[i][j - 1];
				}
				ans += vis[i][j] ? 1 : 0;
			}
		}
		return ans;
		
	}
	
	
	int sums(int x) {
		int s = 0;
		while (x != 0) {
			s += x % 10;
			x = x / 10;
		}
		return s;
	}
}
