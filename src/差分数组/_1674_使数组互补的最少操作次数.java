package 差分数组;

public class _1674_使数组互补的最少操作次数 {
	public int minMoves(int[] nums, int limit) {
        //差分数组
        //如果修改后两个数字的和是 A + B，我们使用的操作数是 0 (没有修改));
        //否则的话，如果修改后两个数字和在 [1 + min(A, B), limit + max(A, B)] 的范围，我们使用的操作数是 1 (只需要修改 A 或者 B 就好);
        //否则的话，如果修改后两个数字和在 [2, 2 * limit] 的范围，我们使用的操作数是 ``2`(两个数字都要修改));
        //res[x]表示互补和为x时需要操作数
        int[] res = new int[2 * limit + 2];
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int A = nums[i], B = nums[len - 1 - i];

            //[2,2*limit]全部+2
            res[2] += 2;
            res[2 * limit + 1] += -2;

            //[1 + min(A,B), limit + max(A, B)] -1
            res[1 + Math.min(A, B)] += -1;
            res[limit + Math.max(A, B) + 1] += 1;

            //[A+B] 再-1
            res[A + B] += -1;
            res[A + B + 1] += 1;
        }
        int min = len, sum = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            sum += res[i];
            if (sum < min) {
                min = sum;
            }
        }
        return min;
    }
}
