package Top100;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
	//复杂度小于n^2
	//HashMap哈希表
	//找target - x时间复杂度过高
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i= 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}	
}
