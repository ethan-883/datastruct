package 回溯;

import java.util.LinkedList;
import java.util.List;

public class _46_全排列 {
	List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    //路径记录在track中,选择列表是不存在于track的元素
    //结束条件是nums中元素都在track中
    void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合法选择
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一次选择树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }
}
