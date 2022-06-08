package 排序;

import java.util.Arrays;

public class _剑指Offer_45_把数组排成最小的数 {
    public String minNumber(int[] nums) {
        //x+y>y+x, 则x “大于” y
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // Arrays.sort(strs, new Comparator<String>() {
        //     @Override
        //     public int compare(String x, String y) {
        //         return (x + y).compareTo(y + x);
        //     }
        // });

        // Arrays.sort(strs, (x, y) -> {
        //     return (x + y).compareTo(y + x);
        // });

        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}
