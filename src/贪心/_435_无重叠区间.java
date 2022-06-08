package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class _435_无重叠区间 {
	public int eraseOverlapIntervals(int[][] intervals) {
        //算出这些区间中最多有几个互不相交的区间。
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        //至少一个区间不相交
        int count = 1;
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
