package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class _452_用最少数量的箭引爆气球 {
	public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) return 1;
                if (a[1] < b[1]) return -1;
                return 0;
            }
        });
        //最少需要的区间数
        int count = 1;

        int x_end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > x_end) {
                //找下一个选择区间
                count++;
                x_end = point[1];
            }
        }
        return count;
    }
}
