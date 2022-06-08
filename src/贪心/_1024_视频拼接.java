package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class _1024_视频拼接 {
    public int videoStitching(int[][] clips, int time) {
        //起点升序，相同则终点降序
        //比较起点在区间内的区间，选择终点最大的
        if (clips.length == 0 || time == 0) {
            return 0;
        }

        Arrays.sort(clips, new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) {
                    return 1;
                }
                if (a[0] < b[0]) {
                    return -1;
                }
                if (a[1] > b[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        //选择短视频的个数
        int res = 0;
        
        int curEnd = 0, nextEnd = 0;
        int i = 0, len = clips.length;
        while (i < len && clips[i][0] <= curEnd) {
            //第res个区间中选下一个区间
            while (i < len && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            //找到下一个区间，更新curEnd
            curEnd = nextEnd;
            res++;
            if (curEnd >= time) {
                return res;
            }
        }
        return -1;
    }
}
