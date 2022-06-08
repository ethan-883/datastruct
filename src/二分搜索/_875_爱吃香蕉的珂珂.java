package 二分搜索;

public class _875_爱吃香蕉的珂珂 {
	public int minEatingSpeed(int[] piles, int h) {
        //左侧边界的二分搜索
        int left = 1;
        int right = 1000_000_000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int needTime = needTime(piles, mid);
            if (needTime == h) {
                right = mid;
            } else if (needTime > h) {
                //k小了
                left = mid + 1;
            } else if (needTime < h) {
                //k大了
                right = mid;
            }
        }
        return left;
    }

    private int needTime (int[] piles, int k) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] / k;
            if (piles[i] % k > 0) {
                time++;
            }
        }
        return time;
    }
}
